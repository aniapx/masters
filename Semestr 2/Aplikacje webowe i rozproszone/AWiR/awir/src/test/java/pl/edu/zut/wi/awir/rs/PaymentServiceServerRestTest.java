package pl.edu.zut.wi.awir.rs;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import pl.edu.zut.wi.awir.ws.client.Account;
import pl.edu.zut.wi.awir.ws.client.AcctIdentNameType;
import pl.edu.zut.wi.awir.ws.client.AcctIdentType;
import pl.edu.zut.wi.awir.ws.client.Add.PaymentAddRequest;
import pl.edu.zut.wi.awir.ws.client.AmountType;
import pl.edu.zut.wi.awir.ws.client.FIIdentNameType;
import pl.edu.zut.wi.awir.ws.client.FIIdentType;
import pl.edu.zut.wi.awir.ws.client.FinancialInstitution;
import pl.edu.zut.wi.awir.ws.client.Header;
import pl.edu.zut.wi.awir.ws.client.PaymentDocument;
import pl.edu.zut.wi.awir.ws.client.PaymentHeader;
import pl.edu.zut.wi.awir.ws.client.PaymentLineItem;
import pl.edu.zut.wi.awir.ws.client.RemittanceInformation;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;

import static java.text.MessageFormat.format;
import static org.junit.jupiter.api.Assertions.fail;

@Slf4j
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class PaymentServiceServerRestTest {
	private static final String PAYMENT_ADD_URL = "http://localhost:8080/payment/";

	private static PaymentAddRequest paymentAddRequest;

	@BeforeAll
	public static void setUpBeforeClass() {
		paymentAddRequest = new PaymentAddRequest();
		final Header header = new Header();
		paymentAddRequest.setHeader(header);
		final PaymentDocument paymentDocument = new PaymentDocument();
		paymentAddRequest.setPaymentDocument(paymentDocument);

		header.setIssueDateTime(format("{0,date,yyyy-MM-dd'T'HH:mm:ss}", new Date()));
		header.setDocumentIdentifier("AB0123456789");
		header.setSenderIdentifier("WI ZUT");
		header.setReceiverIdentifier("NBP");

		final PaymentHeader paymentHeader = new PaymentHeader();
		paymentDocument.setPaymentHeader(paymentHeader);
		final PaymentLineItem paymentLineItem = new PaymentLineItem();
		paymentDocument.getPaymentLineItem().add(paymentLineItem);

		paymentHeader.setPaymentIdentifier("ID9876556789");
		final Account account = new Account();
		paymentHeader.setPayorAccount(account);
		final AcctIdentType acctIdentType = new AcctIdentType();
		account.setAccountIdentifier(acctIdentType);
		acctIdentType.setIdentificationSchemeName(AcctIdentNameType.IBAN);
		final FinancialInstitution payorFinancialInstitution = new FinancialInstitution();
		paymentHeader.setPayorFinancialInstitution(payorFinancialInstitution);
		final FIIdentType fIIdentType = new FIIdentType();
		payorFinancialInstitution.setFIIdentifier(fIIdentType);
		fIIdentType.setIdentificationSchemeName(FIIdentNameType.BIC);

		paymentLineItem.setTransactionIdentifier("TR1234567890");
		final AmountType amountType = new AmountType();
		paymentLineItem.setOrderedAmount(amountType);
		amountType.setAmountCurrencyIdentificationCode("PLN");
		amountType.setValue(new BigDecimal("1000.01"));

		final FinancialInstitution payeeFinancialInstitution = new FinancialInstitution();
		paymentLineItem.setPayeeFinancialInstitution(payeeFinancialInstitution);
		final FIIdentType fIIdentType2 = new FIIdentType();
		payeeFinancialInstitution.setFIIdentifier(fIIdentType2);
		fIIdentType2.setIdentificationSchemeName(FIIdentNameType.BIC);

		final RemittanceInformation remittanceInformation = new RemittanceInformation();
		paymentLineItem.setRemittanceInformation(remittanceInformation);
	}

	@Test
	public void testAddSuccess() {
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		final HttpEntity<PaymentAddRequest> httpEntity = new HttpEntity<>(paymentAddRequest, httpHeaders);

		try {
			final ResponseEntity<String> responseEntity = new RestTemplate()
					.exchange(PAYMENT_ADD_URL + "test", HttpMethod.POST, httpEntity, String.class);
			log.info("HTTP::={}, BODY::={}", responseEntity.getStatusCode(), responseEntity.getBody());
		} catch (RestClientResponseException cause) {
			log.error("HTTP::={}", cause.getRawStatusCode());
			fail();
		} catch (RestClientException cause) {
			// no response payload
			log.error("Response error");
			fail();
		}
	}

	@Test
	public void testAddUnauthorized() {
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		final HttpEntity<PaymentAddRequest> httpEntity = new HttpEntity<>(paymentAddRequest, httpHeaders);

		try {
			final ResponseEntity<String> responseEntity = new RestTemplate()
					.exchange(PAYMENT_ADD_URL + "error", HttpMethod.POST, httpEntity, String.class);
			log.info("HTTP::={}, BODY::={}", responseEntity.getStatusCode(), responseEntity.getBody());
		} catch (RestClientResponseException cause) {
			log.error("HTTP::={}", cause.getRawStatusCode());
			if (cause.getRawStatusCode() != HttpStatus.UNAUTHORIZED.value()) {
				fail();
			}
		} catch (RestClientException cause) {
			// no response payload
			log.error("Response error");
			fail();
		}
	}
}

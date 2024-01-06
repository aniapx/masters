package pl.edu.zut.wi.awir.ws;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import pl.edu.zut.wi.awir.ws.client.Account;
import pl.edu.zut.wi.awir.ws.client.AcctIdentNameType;
import pl.edu.zut.wi.awir.ws.client.AcctIdentType;
import pl.edu.zut.wi.awir.ws.client.Add.PaymentAddRequest;
import pl.edu.zut.wi.awir.ws.client.AddResponse.Return;
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

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class PaymentServiceServerSoapTest {
	private final PaymentServiceClient paymentServiceClient;

	@Test
	public void testAdd() {
		final PaymentAddRequest paymentAddRequest = new PaymentAddRequest();
		final Header header = new Header();
		paymentAddRequest.setHeader(header);
		final PaymentDocument paymentDocument = new PaymentDocument();
		paymentAddRequest.setPaymentDocument(paymentDocument);

		header.setIssueDateTime(MessageFormat.format("{0,date,yyyy-MM-dd'T'HH:mm:ss}", new Date()));
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

		final Return paymentAddResponse = paymentServiceClient.add("***base64-secret***", paymentAddRequest);

		assertThat(paymentAddResponse).isNotNull();
		assertThat(paymentAddResponse.getHeader()).isNotNull();
		assertThat(paymentAddResponse.getHeader().getDocumentIdentifier()).isEqualTo("AB1234567890");
	}
}

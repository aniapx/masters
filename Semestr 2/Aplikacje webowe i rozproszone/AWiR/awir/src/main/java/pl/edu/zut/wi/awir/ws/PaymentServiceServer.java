package pl.edu.zut.wi.awir.ws;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.stereotype.Service;
import pl.edu.zut.wi.awir.ws.server.Header;
import pl.edu.zut.wi.awir.ws.server.PaymentAddRequest;
import pl.edu.zut.wi.awir.ws.server.PaymentAddResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

@Slf4j
@Service
@WebService(serviceName = "PaymentService", targetNamespace = "http://www.wi.zut.edu.pl/service/payment/v1.0")
public class PaymentServiceServer {
	@WebMethod(operationName = "Add")
	public PaymentAddResponse add(@XmlElement(required = true) @WebParam(name = "secret") final String secret, @XmlElement(required = true) @WebParam(name = "paymentAddRequest") final PaymentAddRequest request) {

		//TODO: zgodnie z instrukcją

		log.info("<<RECEIVED SECRET>>: {}", secret);
		log.info("<<RECEIVED DOCUMENT>>: {}", new ReflectionToStringBuilder(request, new MultilineRecursiveToStringStyle()));

		final Header header = new Header();
		header.setDocumentIdentifier("AB1234567890");

		final PaymentAddResponse response = new PaymentAddResponse();
		response.setHeader(header);
		return response;
	}
}

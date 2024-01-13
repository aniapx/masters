package pl.edu.zut.wi.awir.ws;

import org.springframework.stereotype.Service;
import pl.edu.zut.wi.awir.ws.client.Add.PaymentAddRequest;
import pl.edu.zut.wi.awir.ws.client.AddResponse.Return;
import pl.edu.zut.wi.awir.ws.client.PaymentService_Service;

import javax.validation.constraints.NotNull;

@Service
public class PaymentServiceClient {
	private final pl.edu.zut.wi.awir.ws.client.PaymentService port;

	public PaymentServiceClient() {
		final PaymentService_Service service = new PaymentService_Service();
		port = service.getPaymentServicePort();
	}

	public Return add(@NotNull final String secret, final PaymentAddRequest paymentAddRequest) {
		return port.add(secret, paymentAddRequest);
	}
}

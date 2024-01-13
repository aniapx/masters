package pl.szaqku.awir.payment.service;

import pl.szaqku.awir.payment.model.PaymentAddRequest;
import pl.szaqku.awir.payment.model.PaymentAddResponse;

public interface PaymentService {

    PaymentAddResponse getPaymentDocument(PaymentAddRequest request);

}

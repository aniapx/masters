package pl.szaqku.awir.payment.service;

import lombok.extern.slf4j.Slf4j;
import org.jeasy.random.EasyRandom;
import org.springframework.stereotype.Service;
import pl.szaqku.awir.payment.model.PaymentAddRequest;
import pl.szaqku.awir.payment.model.PaymentAddResponse;
import pl.szaqku.awir.payment.model.PaymentDocument;

@Slf4j
@Service
public class SimplePaymentService implements PaymentService {

    @Override
    public PaymentAddResponse getPaymentDocument(PaymentAddRequest request) {
        var paymentDocument = new EasyRandom().nextObject(PaymentDocument.class);
        var response = new PaymentAddResponse();
        response.getContent().add(paymentDocument);

        return response;
    }

}

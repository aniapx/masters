package pl.szaqku.awir.payment.controller.rest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.szaqku.awir.auth.exception.SecurityException;
import pl.szaqku.awir.auth.service.impl.SingleUseAuthorizationService;
import pl.szaqku.awir.payment.model.*;
import pl.szaqku.awir.payment.service.PaymentService;

import static pl.szaqku.awir.auth.util.TokenUtil.decodeToken;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class PaymentController {

    private final SingleUseAuthorizationService singleUseAuthorizationService;
    private final PaymentService paymentService;

    @PostMapping("/payments")
    public PaymentAddResponse addPayment(@RequestBody PaymentAddRequest request, @RequestHeader(value = "Authorization", required = false) String authorizationToken) {
        try {
            singleUseAuthorizationService.authorize(decodeToken(authorizationToken));
        } catch (SecurityException e) {
            var response = new PaymentAddResponse();
            var status = new DocumentStatus();
            status.setStatusCode("Authorization error.");
            status.setSeverity(SeverityCode.ERROR);
            response.getContent().add(status);

            return response;
        }

        var response = paymentService.getPaymentDocument(request);

        response.getContent().stream()
            .filter(o -> o instanceof PaymentDocument)
            .map(o -> (PaymentDocument) o)
            .limit(1)
            .flatMap(o -> o.getPaymentLineItem().stream())
            .limit(3)
            .forEachOrdered(i -> log.info("{}", i.getCardIdentifier().getCardIdent()));

        return response;
    }
}

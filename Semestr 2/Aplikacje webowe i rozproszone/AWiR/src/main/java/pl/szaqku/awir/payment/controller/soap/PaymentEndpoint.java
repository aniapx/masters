package pl.szaqku.awir.payment.controller.soap;

import lombok.extern.slf4j.Slf4j;
import org.jeasy.random.EasyRandom;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import pl.szaqku.awir.auth.exception.SecurityException;
import pl.szaqku.awir.auth.service.AuthorizationService;
import pl.szaqku.awir.payment.model.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.stream.Stream;

import static pl.szaqku.awir.auth.util.TokenUtil.decodeToken;

@Slf4j
@Endpoint
public class PaymentEndpoint {
    public static final String NAMESPACE_URI = "http://services.szaqku.pl";

    private final AuthorizationService authorizationService;

    public PaymentEndpoint(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "PaymentAddRequest")
    @ResponsePayload
    public PaymentAddResponse paymentAdd(@RequestPayload PaymentAddRequest request, MessageContext wsseSecurityHeader) {
        var token = extractToken(wsseSecurityHeader);
        try {
            authorizationService.authorize(token);
        } catch (SecurityException e) {
            var response = new PaymentAddResponse();
            var status = new DocumentStatus();
            status.setStatusCode("Authorization error.");
            status.setSeverity(SeverityCode.ERROR);
            response.getContent().add(status);
            return response;
        }

        var response = new PaymentAddResponse();
        var payment = new EasyRandom().nextObject(PaymentDocument.class);
        response.getContent().add(payment);

        response.getContent().stream()
            .filter(o -> o instanceof PaymentDocument)
            .map(o -> (PaymentDocument) o)
            .limit(1)
            .flatMap(o -> o.getPaymentLineItem().stream())
            .limit(3)
            .forEachOrdered(i -> log.info("{}", i.getCardIdentifier().getCardIdent()));

        return response;
    }

    private String extractToken(MessageContext wsseSecurityHeader) {
        if (wsseSecurityHeader.getRequest() instanceof SaajSoapMessage
        ) {
            var headers = ((SaajSoapMessage) wsseSecurityHeader.getRequest()).getSaajMessage().getMimeHeaders();
            var authHeaders = headers.getHeader("Authorization");
            return authHeaders != null ? decodeToken(authHeaders[0]) : null;
        }
        return null;
    }
}

package pl.edu.zut.wi.awir.rs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.zut.wi.awir.ws.server.PaymentAddRequest;
import pl.edu.zut.wi.awir.ws.server.PaymentAddResponse;

import java.nio.file.AccessDeniedException;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {
	@ExceptionHandler({AccessDeniedException.class})
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public PaymentAddResponse handleRunException(Exception exception) {
		return new PaymentAddResponse();
	}

	@Operation(summary = "Zlecenie płatności", description = "Operacja zlecania transakcji płatniczych dla banku.")
	@ApiResponses({@ApiResponse(responseCode = "200",
			description = "Poprawne zlecenie płatności.",
			content = {@Content(mediaType = "application/json", schema = @Schema(implementation = PaymentAddResponse.class))}),
			@ApiResponse(responseCode = "401",
					description = "Błąd przekazanego access tokena.",
					content = {@Content(mediaType = "application/json", schema = @Schema(implementation = PaymentAddResponse.class))}
			)}
	)
	@PostMapping(value = "/{secret}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public PaymentAddResponse add(@Parameter(required = true, description = "Access token.", schema = @Schema(implementation = String.class, example = "aaAjTjYG*76$7")) @PathVariable("secret") final String secret,
								  @Parameter(required = true, description = "Dokument zlecenia płatniczego.", schema = @Schema(implementation = PaymentAddRequest.class)) @RequestBody final PaymentAddRequest paymentAddRequest) throws AccessDeniedException {
		log.info("SECRET::={}", secret);

		if (StringUtils.equalsIgnoreCase("error", secret)) {
			throw new AccessDeniedException("Niepoprawny secret");
		}

		log.info("<<RECEIVED SECRET>>: {}", secret);
		log.info("<<RECEIVED DOCUMENT>>: {}", new ReflectionToStringBuilder(paymentAddRequest, new MultilineRecursiveToStringStyle()));

		return new PaymentAddResponse();
	}
}

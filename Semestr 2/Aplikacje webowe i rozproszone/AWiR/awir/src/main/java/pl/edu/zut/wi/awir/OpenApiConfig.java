package pl.edu.zut.wi.awir;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <a href="http://localhost:8080/swagger-ui.html">http://localhost:8080/swagger-ui.html</a>
 */
@OpenAPIDefinition(
		info = @Info(title = "API AWiR",
				version = "1.0.0",
				description = "ReST API kursu Aplikacje Webowe i Rozproszone",
				license = @License(name = "©2023 Copyright WI ZUT", url = "https://wi.zut.edu.pl"),
				contact = @Contact(name = "Krzysztof Kraska", email = "kkraska@zut.edu.pl")
		),
		servers = {
				@Server(description = "DEV basePath", url = "http://localhost:8080/"),
				@Server(description = "TE basePath", url = "http://tst-wi.zut.edu.pl:8080/"),
				@Server(description = "PROD basePath", url = "http://wi.zut.edu.pl:8080/")
		}
)
@Configuration
public class OpenApiConfig {
	@Bean
	public GroupedOpenApi systemOpenApi() {
		final String[] paths = {"/**"};
		return GroupedOpenApi.builder().group("v1").pathsToMatch(paths).build();
	}
}

package pl.szaqku.awir.payment.config;

//import org.apache.cxf.Bus;
//import org.apache.cxf.jaxws.EndpointImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.xml.xsd.XsdSchemaCollection;
import org.springframework.xml.xsd.commons.CommonsXsdSchema;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;
import pl.szaqku.awir.payment.controller.soap.PaymentEndpoint;

import java.io.IOException;

@EnableWs
@Configuration
public class WebServiceConfig {

    @Autowired
    ResourcePatternResolver resourceResolver;

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "payments")
    public DefaultWsdl11Definition paymentsWsdl11Definition(@Qualifier("paymentsSchema") XsdSchemaCollection countriesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("PaymentsPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace(PaymentEndpoint.NAMESPACE_URI);
        wsdl11Definition.setSchemaCollection(countriesSchema);
        return wsdl11Definition;
    }

    @Bean("paymentsSchema")
    public XsdSchemaCollection paymentsSchema() throws IOException {
        var response = new CommonsXsdSchemaCollection(
            resourceResolver.getResources("classpath:schema/PaymentAdd*.xsd")
        );
        response.setInline(true);
        return response;
    }
}
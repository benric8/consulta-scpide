package pe.gob.pj.cspide.infraestructure.client;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import pe.gob.pj.cspide.domain.utils.ProjectProperties;

@Configuration
public class RestTemplateConfig {
	
	@Bean
    public RestTemplate restTemplate() throws IOException {
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());
        
        restTemplate.getMessageConverters().add(new Jaxb2RootElementHttpMessageConverter());
        return restTemplate;
    }

    private ClientHttpRequestFactory clientHttpRequestFactory() throws IOException {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(ProjectProperties.getTimeoutClientApiConectionSegundos()*1000);
        factory.setReadTimeout(ProjectProperties.getTimeoutClientApiReadSegundos()*1000);
        return factory;
    }
}

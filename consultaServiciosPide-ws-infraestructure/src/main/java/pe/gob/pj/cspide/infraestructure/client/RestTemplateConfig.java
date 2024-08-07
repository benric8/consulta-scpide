package pe.gob.pj.cspide.infraestructure.client;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import pe.gob.pj.cspide.domain.utils.ProjectProperties;
import java.net.Proxy;
import java.net.InetSocketAddress;

@Configuration
public class RestTemplateConfig {
	
	@Bean
    public RestTemplate restTemplate() throws IOException {
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());
		//MappingJackson2XmlHttpMessageConverter xmlConverter = new MappingJackson2XmlHttpMessageConverter();
        //xmlConverter.setObjectMapper(new XmlMapper());
        //restTemplate.getMessageConverters().add(xmlConverter);
        return restTemplate;
    }

    private ClientHttpRequestFactory clientHttpRequestFactory() throws IOException {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(ProjectProperties.getTimeoutClientApiConectionSegundos()*1000);
        factory.setReadTimeout(ProjectProperties.getTimeoutClientApiReadSegundos()*1000);
        
        
        // Remover para produccion - Configuración del proxy 
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxygob4.pj.gob.pe", 3128));
        factory.setProxy(proxy);
        
        return factory;
    }
}

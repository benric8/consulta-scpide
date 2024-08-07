package pe.gob.pj.cspide.infraestructure.client.services;


import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;
import pe.gob.pj.cspide.infraestructure.client.response.SunatDatosPrincipales;
import pe.gob.pj.cspide.infraestructure.client.response.SunatGetDatosPrincipalesResponse;

@Slf4j
@Service("sunatClient")
public class SunatClientImpl implements SunatClient {
	
	@Autowired
    private RestTemplate restTemplate;

	@Override
	public SunatDatosPrincipales obtenerDatosPrincipales(String cuo, String ruc) throws Exception {
		
		SunatGetDatosPrincipalesResponse response = null;
		String xmlString = "";
		String url = "https://ws3.pide.gob.pe/Rest/Sunat/DatosPrincipales";
		
		UriComponentsBuilder builderUrl = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("numruc", ruc);
		try {
			
			ResponseEntity<String> responseEntity = restTemplate.getForEntity(builderUrl.toUriString(),String.class);
			if(responseEntity!=null) {
				xmlString=responseEntity.getBody();
				
				// Crear el contexto JAXB
	            JAXBContext jaxbContext = JAXBContext.newInstance(SunatGetDatosPrincipalesResponse.class);
	            
	            // Crear el Unmarshaller
	            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
	            
	            // XML de ejemplo
	           
	            
	            // Deserializar el XML a un objeto Java
	            response= (SunatGetDatosPrincipalesResponse) unmarshaller.unmarshal(new StringReader(xmlString));
	            
	            
			}
		} catch (Exception e) {
			throw e;
		}
		return response.getBody().getMultiRef();
	}

}

package pe.gob.pj.cspide.infraestructure.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import pe.gob.pj.cspide.infraestructure.client.response.SunatGetDatosPrincipalesResponse;

@Service("sunatClient")
public class SunatClientImpl implements SunatClient {
	
	@Autowired
    private RestTemplate restTemplate;

	@Override
	public SunatGetDatosPrincipalesResponse obtenerDatosPrincipales(String cuo, String ruc) throws Exception {
		
		SunatGetDatosPrincipalesResponse response = null;
		String url = "https://ws3.pide.gob.pe/Rest/Sunat/DatosPrincipales";
		
		UriComponentsBuilder builderUrl = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("numruc", ruc);
		try {
			
			ResponseEntity<SunatGetDatosPrincipalesResponse> responseEntity = restTemplate.getForEntity(builderUrl.toUriString(), SunatGetDatosPrincipalesResponse.class);
			if(responseEntity!=null) {
				response=responseEntity.getBody();
			}
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

}

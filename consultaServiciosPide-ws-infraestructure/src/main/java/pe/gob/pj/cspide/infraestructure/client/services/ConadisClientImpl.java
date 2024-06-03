package pe.gob.pj.cspide.infraestructure.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import pe.gob.pj.cspide.domain.exceptions.ErrorException;
import pe.gob.pj.cspide.domain.utils.ProjectConstants;
import pe.gob.pj.cspide.domain.utils.ProjectProperties;
import pe.gob.pj.cspide.infraestructure.client.response.ConadisBuscarPesonaBodyResponse;

@Service("conadisClient")
public class ConadisClientImpl implements ConadisClient{

	@Autowired
    private RestTemplate restTemplate;
	
	@Override
	public ConadisBuscarPesonaBodyResponse buscarPersonaDiscapacidad(String cuo, String numeroDocumentoIdentidad)
			throws Exception {
		ConadisBuscarPesonaBodyResponse response = null;
		String url = ProjectProperties.getServicioConadisUrl() + "/PDiscapacidad";
		
		UriComponentsBuilder builderUrl = UriComponentsBuilder.fromUriString(url)
                .queryParam("out", ProjectConstants.FormatoRespuesta.JSON)
                .queryParam("Username", ProjectProperties.getServicioConadisUsuario())
                .queryParam("Password", ProjectProperties.getServicioConadisClave())
        		.queryParam("DocNumber", numeroDocumentoIdentidad);
		try {
			ResponseEntity<ConadisBuscarPesonaBodyResponse> responseEntity = restTemplate.getForEntity(builderUrl.toUriString(), ConadisBuscarPesonaBodyResponse.class);
			builderUrl.queryParam("Password", ProjectConstants.CLAVE_PIDE_PROPERTIES);
//			log.info("{} Se consumio el endpoint : {}", cuo, builderUrl.toUriString());
			if (responseEntity.getStatusCodeValue() == HttpStatus.OK.value()) {
				response = responseEntity.getBody();
			} else {
				throw new ErrorException(ProjectConstants.Error.CE013, 
						ProjectConstants.Error.XERROR + ProjectConstants.Proceso.CONADIS_BUSCAR_PERSONA_DISCAPACIDAD +	ProjectConstants.Error.XE013 + url,
						"endpoint retorno status "+responseEntity.getStatusCodeValue(), null);
			}
			
		} catch (Exception e) {
			throw new ErrorException(ProjectConstants.Error.CE013, 
					ProjectConstants.Error.XERROR + ProjectConstants.Proceso.CONADIS_BUSCAR_PERSONA_DISCAPACIDAD +	ProjectConstants.Error.XE013 + url,
					e.getMessage(), e);
		}
		return response;
	}

}

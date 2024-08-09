package pe.gob.pj.cspide.infraestructure.client.services;


import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;
import pe.gob.pj.cspide.domain.exceptions.ErrorException;
import pe.gob.pj.cspide.domain.utils.ProjectConstants;
import pe.gob.pj.cspide.domain.utils.ProjectProperties;
import pe.gob.pj.cspide.infraestructure.client.response.SunatDatosPrincipales;
import pe.gob.pj.cspide.infraestructure.client.response.SunatDatosPrincipalesResponse;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDatosSecundarios;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDatosSecundariosResponse;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDatosT1144;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDatosT1144Response;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDatosT362;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDatosT362Response;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDomicilioLegal;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDomicilioLegalResponse;

@Slf4j
@Service("sunatClient")
public class SunatClientImpl implements SunatClient {
	
	@Autowired
    private RestTemplate restTemplate;

	@Override
	public SunatDatosPrincipales obtenerDatosPrincipales(String cuo, String ruc) throws Exception {
		
		SunatDatosPrincipalesResponse response = null;
		String xmlString = "";
		String url = ProjectProperties.getServicioSunatUrl()+ProjectConstants.SunatServices.SUNAT_GET_DATOS_PRINCIPALES;
		
		UriComponentsBuilder builderUrl = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("numruc", ruc);
		try {
			
			ResponseEntity<String> responseEntity = restTemplate.getForEntity(builderUrl.toUriString(),String.class);
			if(responseEntity.getStatusCodeValue()==HttpStatus.OK.value()) {
				xmlString=responseEntity.getBody();
	            JAXBContext jaxbContext = JAXBContext.newInstance(SunatDatosPrincipalesResponse.class);
	            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
	            response= (SunatDatosPrincipalesResponse) unmarshaller.unmarshal(new StringReader(xmlString));
			}else {
				throw new ErrorException(ProjectConstants.Error.CE013, ProjectConstants.Error.XERROR + ProjectConstants.Proceso.SUNAT_GET_DATOS_PRINCIPALES +	ProjectConstants.Error.XE013 + url,
						"endpoint retorno status "+responseEntity.getStatusCodeValue(), null);
			}
		} catch (Exception e) {
			throw new ErrorException(ProjectConstants.Error.CE013, 
					ProjectConstants.Error.XERROR + ProjectConstants.Proceso.SUNAT_GET_DATOS_PRINCIPALES+	ProjectConstants.Error.XE013 + url,
					e.getMessage(), e);
		}
		return response.getBody().getMultiRef();
	}

	@Override
	public SunatDatosSecundarios obtenerDatosSecundarios(String cuo, String ruc) throws Exception {
		SunatDatosSecundariosResponse response = null;
		String xmlString = "";
		String url = ProjectProperties.getServicioSunatUrl()+ProjectConstants.SunatServices.SUNAT_GET_DATOS_SECUNDARIOS;
		
		UriComponentsBuilder builderUrl = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("numruc", ruc);
		try {
			
			ResponseEntity<String> responseEntity = restTemplate.getForEntity(builderUrl.toUriString(),String.class);
			if(responseEntity.getStatusCodeValue()==HttpStatus.OK.value()) {
				xmlString=responseEntity.getBody();
	            JAXBContext jaxbContext = JAXBContext.newInstance(SunatDatosSecundariosResponse.class);
	            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
	            response= (SunatDatosSecundariosResponse) unmarshaller.unmarshal(new StringReader(xmlString));
			}else {
				throw new ErrorException(ProjectConstants.Error.CE013, ProjectConstants.Error.XERROR + ProjectConstants.Proceso.SUNAT_GET_DATOS_SECUNDARIOS +	ProjectConstants.Error.XE013 + url,
						"endpoint retorno status "+responseEntity.getStatusCodeValue(), null);
			}
		} catch (Exception e) {
			throw new ErrorException(ProjectConstants.Error.CE013, 
					ProjectConstants.Error.XERROR + ProjectConstants.Proceso.SUNAT_GET_DATOS_SECUNDARIOS+	ProjectConstants.Error.XE013 + url,
					e.getMessage(), e);
		}
		return response.getBody().getMultiRef();
	}

	@Override
	public SunatDatosT1144 obtenerDatosT1144(String cuo, String ruc) throws Exception {
		SunatDatosT1144Response response = null;
		String xmlString = "";
		String url = ProjectProperties.getServicioSunatUrl()+ProjectConstants.SunatServices.SUNAT_GET_DATOS_T1144;
		
		UriComponentsBuilder builderUrl = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("numruc", ruc);
		try {
			
			ResponseEntity<String> responseEntity = restTemplate.getForEntity(builderUrl.toUriString(),String.class);
			if(responseEntity.getStatusCodeValue()==HttpStatus.OK.value()) {
				xmlString=responseEntity.getBody();
	            JAXBContext jaxbContext = JAXBContext.newInstance(SunatDatosT1144Response.class);
	            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
	            response= (SunatDatosT1144Response) unmarshaller.unmarshal(new StringReader(xmlString));
			}else {
				throw new ErrorException(ProjectConstants.Error.CE013, ProjectConstants.Error.XERROR + ProjectConstants.Proceso.SUNAT_GET_DATOS_T1144 +	ProjectConstants.Error.XE013 + url,
						"endpoint retorno status "+responseEntity.getStatusCodeValue(), null);
			}
		} catch (Exception e) {
			throw new ErrorException(ProjectConstants.Error.CE013, 
					ProjectConstants.Error.XERROR + ProjectConstants.Proceso.SUNAT_GET_DATOS_T1144+	ProjectConstants.Error.XE013 + url,
					e.getMessage(), e);
		}
		return response.getBody().getMultiRef();
	}

	@Override
	public List<SunatDatosT362> obtenerDatosT362(String cuo, String ruc) throws Exception {
		SunatDatosT362Response response = null;
		String xmlString = "";
		String url = ProjectProperties.getServicioSunatUrl()+ProjectConstants.SunatServices.SUNAT_GET_DATOS_T362;
		
		UriComponentsBuilder builderUrl = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("numruc", ruc);
		try {
			
			ResponseEntity<String> responseEntity = restTemplate.getForEntity(builderUrl.toUriString(),String.class);
			if(responseEntity.getStatusCodeValue()==HttpStatus.OK.value()) {
				xmlString=responseEntity.getBody();
	            JAXBContext jaxbContext = JAXBContext.newInstance(SunatDatosT362Response.class);
	            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
	            response= (SunatDatosT362Response) unmarshaller.unmarshal(new StringReader(xmlString));
			}else {
				throw new ErrorException(ProjectConstants.Error.CE013, ProjectConstants.Error.XERROR + ProjectConstants.Proceso.SUNAT_GET_DATOS_T362 +	ProjectConstants.Error.XE013 + url,
						"endpoint retorno status "+responseEntity.getStatusCodeValue(), null);
			}
		} catch (Exception e) {
			throw new ErrorException(ProjectConstants.Error.CE013, 
					ProjectConstants.Error.XERROR + ProjectConstants.Proceso.SUNAT_GET_DATOS_T362+	ProjectConstants.Error.XE013 + url,
					e.getMessage(), e);
		}
		return response.getBody().getMultiRef();
	}

	@Override
	public SunatDomicilioLegal obtenerDomicilioLegal(String cuo, String ruc) throws Exception {
		SunatDomicilioLegalResponse response = null;
		String xmlString = "";
		String url = ProjectProperties.getServicioSunatUrl()+ProjectConstants.SunatServices.SUNAT_GET_DOMICILIO_LEGAL;
		
		UriComponentsBuilder builderUrl = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("numruc", ruc);
		try {
			
			ResponseEntity<String> responseEntity = restTemplate.getForEntity(builderUrl.toUriString(),String.class);
			if(responseEntity.getStatusCodeValue()==HttpStatus.OK.value()) {
				xmlString=responseEntity.getBody();
	            JAXBContext jaxbContext = JAXBContext.newInstance(SunatDomicilioLegalResponse.class);
	            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
	            response= (SunatDomicilioLegalResponse) unmarshaller.unmarshal(new StringReader(xmlString));
			}else {
				throw new ErrorException(ProjectConstants.Error.CE013, ProjectConstants.Error.XERROR + ProjectConstants.Proceso.SUNAT_GET_DOMICILIO_LEGAL +	ProjectConstants.Error.XE013 + url,
						"endpoint retorno status "+responseEntity.getStatusCodeValue(), null);
			}
		} catch (Exception e) {
			throw new ErrorException(ProjectConstants.Error.CE013, 
					ProjectConstants.Error.XERROR + ProjectConstants.Proceso.SUNAT_GET_DOMICILIO_LEGAL+	ProjectConstants.Error.XE013 + url,
					e.getMessage(), e);
		}
		return response.getBody().getGetDomicilioLegalResponse();
	}

}

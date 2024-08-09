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
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDatosPrincipales;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDatosPrincipalesResponse;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDatosSecundarios;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDatosSecundariosResponse;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDatosT1144;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDatosT1144Response;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDatosT362;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDatosT362Response;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDomicilioLegal;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDomicilioLegalResponse;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatEstAnexosT1150Response;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatEstablecimientosAnexos;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatEstablecimientosAnexosResponse;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatEstablecimientosAnexosT1150;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatRazonSocial;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatRazonSocialResponse;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatRepresentatesLegales;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatRepresentatesLegalesResponse;

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

	@Override
	public List<SunatEstablecimientosAnexos> obtenerEstablecimientosAnexos(String cuo, String ruc) throws Exception {
		SunatEstablecimientosAnexosResponse response = null;
		String xmlString = "";
		String url = ProjectProperties.getServicioSunatUrl()+ProjectConstants.SunatServices.SUNAT_GET_ESTABLECIMIENTOS_ANEXOS;
		
		UriComponentsBuilder builderUrl = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("numruc", ruc);
		try {
			
			ResponseEntity<String> responseEntity = restTemplate.getForEntity(builderUrl.toUriString(),String.class);
			if(responseEntity.getStatusCodeValue()==HttpStatus.OK.value()) {
				xmlString=responseEntity.getBody();
	            JAXBContext jaxbContext = JAXBContext.newInstance(SunatEstablecimientosAnexosResponse.class);
	            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
	            response= (SunatEstablecimientosAnexosResponse) unmarshaller.unmarshal(new StringReader(xmlString));
			}else {
				throw new ErrorException(ProjectConstants.Error.CE013, ProjectConstants.Error.XERROR + ProjectConstants.Proceso.SUNAT_GET_ESTABLECIMIENTOS_ANEXOS +	ProjectConstants.Error.XE013 + url,
						"endpoint retorno status "+responseEntity.getStatusCodeValue(), null);
			}
		} catch (Exception e) {
			throw new ErrorException(ProjectConstants.Error.CE013, 
					ProjectConstants.Error.XERROR + ProjectConstants.Proceso.SUNAT_GET_ESTABLECIMIENTOS_ANEXOS+	ProjectConstants.Error.XE013 + url,
					e.getMessage(), e);
		}
		return response.getBody().getMultiRef();
	}

	@Override
	public List<SunatEstablecimientosAnexosT1150> obtenerEstablecimientosAnexosT1150(String cuo, String ruc) throws ErrorException{
		SunatEstAnexosT1150Response response = null;
		String xmlString = "";
		String url = ProjectProperties.getServicioSunatUrl()+ProjectConstants.SunatServices.SUNAT_GET_EST_ANEXOS_T1150;
		
		UriComponentsBuilder builderUrl = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("numruc", ruc);
		try {
			
			ResponseEntity<String> responseEntity = restTemplate.getForEntity(builderUrl.toUriString(),String.class);
			if(responseEntity.getStatusCodeValue()==HttpStatus.OK.value()) {
				xmlString=responseEntity.getBody();
	            JAXBContext jaxbContext = JAXBContext.newInstance(SunatEstAnexosT1150Response.class);
	            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
	            response= (SunatEstAnexosT1150Response) unmarshaller.unmarshal(new StringReader(xmlString));
			}else {
				throw new ErrorException(ProjectConstants.Error.CE013, ProjectConstants.Error.XERROR + ProjectConstants.Proceso.SUNAT_GET_EST_ANEXOS_T1150 +	ProjectConstants.Error.XE013 + url,
						"endpoint retorno status "+responseEntity.getStatusCodeValue(), null);
			}
		} catch (Exception e) {
			throw new ErrorException(ProjectConstants.Error.CE013, 
					ProjectConstants.Error.XERROR + ProjectConstants.Proceso.SUNAT_GET_EST_ANEXOS_T1150+	ProjectConstants.Error.XE013 + url,
					e.getMessage(), e);
		}
		return response.getBody().getMultiRef();
	}

	@Override
	public List<SunatRepresentatesLegales> obtenerRepresentatesLegales(String cuo, String ruc) throws Exception {
		SunatRepresentatesLegalesResponse response = null;
		String xmlString = "";
		String url = ProjectProperties.getServicioSunatUrl()+ProjectConstants.SunatServices.SUNAT_GET_REP_LEGALES;
		
		UriComponentsBuilder builderUrl = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("numruc", ruc);
		try {
			
			ResponseEntity<String> responseEntity = restTemplate.getForEntity(builderUrl.toUriString(),String.class);
			if(responseEntity.getStatusCodeValue()==HttpStatus.OK.value()) {
				xmlString=responseEntity.getBody();
	            JAXBContext jaxbContext = JAXBContext.newInstance(SunatRepresentatesLegalesResponse.class);
	            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
	            response= (SunatRepresentatesLegalesResponse) unmarshaller.unmarshal(new StringReader(xmlString));
			}else {
				throw new ErrorException(ProjectConstants.Error.CE013, ProjectConstants.Error.XERROR + ProjectConstants.Proceso.SUNAT_GET_REP_LEGALES +	ProjectConstants.Error.XE013 + url,
						"endpoint retorno status "+responseEntity.getStatusCodeValue(), null);
			}
		} catch (Exception e) {
			throw new ErrorException(ProjectConstants.Error.CE013, 
					ProjectConstants.Error.XERROR + ProjectConstants.Proceso.SUNAT_GET_REP_LEGALES+	ProjectConstants.Error.XE013 + url,
					e.getMessage(), e);
		}
		return response.getBody().getMultiRef();
	}

	@Override
	public List<SunatRazonSocial> BuscarPorRazonSocial(String cuo, String rsocial) throws Exception {
		SunatRazonSocialResponse response = null;
		String xmlString = "";
		String url = ProjectProperties.getServicioSunatUrl()+ProjectConstants.SunatServices.SUNAT_BUSCAR_RAZON_SOCIAL;
		
		UriComponentsBuilder builderUrl = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("RSocial", rsocial);
		try {
			
			ResponseEntity<String> responseEntity = restTemplate.getForEntity(builderUrl.toUriString(),String.class);
			if(responseEntity.getStatusCodeValue()==HttpStatus.OK.value()) {
				xmlString=responseEntity.getBody();
	            JAXBContext jaxbContext = JAXBContext.newInstance(SunatRazonSocialResponse.class);
	            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
	            response= (SunatRazonSocialResponse) unmarshaller.unmarshal(new StringReader(xmlString));
			}else {
				throw new ErrorException(ProjectConstants.Error.CE013, ProjectConstants.Error.XERROR + ProjectConstants.Proceso.SUNAT_BUSCAR_RAZON_SOCIAL +	ProjectConstants.Error.XE013 + url,
						"endpoint retorno status "+responseEntity.getStatusCodeValue(), null);
			}
		} catch (Exception e) {
			throw new ErrorException(ProjectConstants.Error.CE013, 
					ProjectConstants.Error.XERROR + ProjectConstants.Proceso.SUNAT_BUSCAR_RAZON_SOCIAL+	ProjectConstants.Error.XE013 + url,
					e.getMessage(), e);
		}
		return response.getBody().getMultiRef();
	}

}

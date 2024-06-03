package pe.gob.pj.cspide.infraestructure.client.services;

import java.util.Objects;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import pe.gob.pj.cspide.domain.exceptions.ErrorException;
import pe.gob.pj.cspide.domain.model.client.reniec.PersonaConsultadaReniec;
import pe.gob.pj.cspide.domain.model.client.reniec.RespuestaActualizacionCredenciales;
import pe.gob.pj.cspide.domain.port.client.ReniecClient;
import pe.gob.pj.cspide.domain.utils.ProjectConstants;
import pe.gob.pj.cspide.domain.utils.ProjectProperties;
import pe.gob.pj.cspide.infraestructure.client.response.ReniecActualizarUsuarioBodyResponse;
import pe.gob.pj.cspide.infraestructure.client.response.ReniecBuscarPersonaDniBodyResponse;

@Service("reniecClient")
public class ReniecClientImpl implements ReniecClient {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public PersonaConsultadaReniec buscarPersonaPorDni(String cuo, String documentoConsultado, Set<String> credenciales) throws Exception {

		PersonaConsultadaReniec personaConsultadaReniec = null;
		ReniecBuscarPersonaDniBodyResponse response = null;
		String url = ProjectProperties.getServicioReniecUrl() + "/Consultar";
		
		int codigoStatus = 0;
		for(String credencial : credenciales) {
			String[] aplicativoCredenciales = credencial.split("@");
			UriComponentsBuilder builderUrl = UriComponentsBuilder.fromUriString(url)
					.queryParam("out", ProjectConstants.FormatoRespuesta.JSON)
					.queryParam("nuRucUsuario", ProjectProperties.getServicioReniecClienteRuc())
					.queryParam("nuDniUsuario", aplicativoCredenciales[0])
					.queryParam("password", aplicativoCredenciales[1])
					.queryParam("nuDniConsulta", documentoConsultado);
			try {
				ResponseEntity<ReniecBuscarPersonaDniBodyResponse> responseEntity = restTemplate
						.getForEntity(builderUrl.toUriString(), ReniecBuscarPersonaDniBodyResponse.class);
				builderUrl.queryParam("password", ProjectConstants.CLAVE_PIDE_PROPERTIES);
//				log.info("{} Se consumio el endpoint : {}", cuo, builderUrl.toUriString());
				codigoStatus = responseEntity.getStatusCodeValue();
				if (codigoStatus == HttpStatus.OK.value()) {
					response = responseEntity.getBody();
				}
			} catch (Exception e) {
				throw new ErrorException(ProjectConstants.Error.CE013, ProjectConstants.Error.XERROR
						+ ProjectConstants.Proceso.RENIEC_BUSCAR_PERSONA_POR_DNI + ProjectConstants.Error.XE013 + url,
						e.getMessage(), e);
			}
//			log.info("{} Codigo de respuesta del servicio pide : {}", cuo, response.getConsultarResponse().getResult().getCodigoResultado());
			if (ProjectConstants.Error.CEXITO
					.equals(response.getConsultarResponse().getResult().getCodigoResultado())) {
				personaConsultadaReniec = new PersonaConsultadaReniec();
				BeanUtils.copyProperties(response.getConsultarResponse().getResult().getDatosPersona(),
						personaConsultadaReniec);
				break;
			}
		}
		
		if(codigoStatus != HttpStatus.OK.value()) {
			throw new ErrorException(ProjectConstants.Error.CE013,
					ProjectConstants.Error.XERROR + ProjectConstants.Proceso.RENIEC_BUSCAR_PERSONA_POR_DNI
							+ ProjectConstants.Error.XE013 + url,
					"endpoint retorno status " + codigoStatus, null);
		}
		
		if(Objects.isNull(personaConsultadaReniec)) {
			if("1001".equals(response.getConsultarResponse().getResult().getCodigoResultado())) {
				throw new ErrorException(ProjectConstants.Error.CN001, ProjectConstants.Error.XERROR
						+ ProjectConstants.Proceso.RENIEC_BUSCAR_PERSONA_POR_DNI + ProjectConstants.Error.XN001);
			}
			if("1003".equals(response.getConsultarResponse().getResult().getCodigoResultado())){
				throw new ErrorException(ProjectConstants.Error.CN003, ProjectConstants.Error.XERROR
						+ ProjectConstants.Proceso.RENIEC_BUSCAR_PERSONA_POR_DNI + ProjectConstants.Error.XN003);
			}
			throw new ErrorException(ProjectConstants.Error.CN004, ProjectConstants.Error.XERROR
					+ ProjectConstants.Proceso.RENIEC_BUSCAR_PERSONA_POR_DNI + ProjectConstants.Error.XN004);
		}
		
		return personaConsultadaReniec;
	}

	@Override
	public RespuestaActualizacionCredenciales actualizarUsuario(String cuo, String documentoUsuario,
			String credencialNueva, String credencialAnterior) throws Exception {
		RespuestaActualizacionCredenciales respuestaReniec = new RespuestaActualizacionCredenciales();
		ReniecActualizarUsuarioBodyResponse response = null;
		String url = ProjectProperties.getServicioReniecUrl() + "/ActualizarCredencial";

		UriComponentsBuilder builderUrl = UriComponentsBuilder.fromUriString(url)
				.queryParam("out", ProjectConstants.FormatoRespuesta.JSON)
				.queryParam("nuRuc", ProjectProperties.getServicioReniecClienteRuc())
				.queryParam("nuDni", documentoUsuario)
				.queryParam("credencialAnterior", credencialAnterior)
				.queryParam("credencialNueva", credencialNueva);
		try {
			ResponseEntity<ReniecActualizarUsuarioBodyResponse> responseEntity = restTemplate
					.getForEntity(builderUrl.toUriString(), ReniecActualizarUsuarioBodyResponse.class);
			builderUrl.queryParam("credencialNueva", ProjectConstants.CLAVE_PIDE_PROPERTIES);
//			log.info("{} Se consumio el endpoint : {}", cuo, builderUrl.toUriString());
			if (responseEntity.getStatusCodeValue() == HttpStatus.OK.value()) {
				response = responseEntity.getBody();
				BeanUtils.copyProperties(response.getConsultarResponse().getResult(), respuestaReniec);
			} else {
				throw new ErrorException(ProjectConstants.Error.CE013,
						ProjectConstants.Error.XERROR + ProjectConstants.Proceso.RENIEC_ACTUALIZAR_USUARIO
								+ ProjectConstants.Error.XE013 + url,
						"endpoint retorno status " + responseEntity.getStatusCodeValue(), null);
			}

		} catch (Exception e) {
			throw new ErrorException(
					ProjectConstants.Error.CE013, ProjectConstants.Error.XERROR
							+ ProjectConstants.Proceso.RENIEC_ACTUALIZAR_USUARIO + ProjectConstants.Error.XE013 + url,
					e.getMessage(), e);
		}
		return respuestaReniec;
	}

}

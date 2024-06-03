package pe.gob.pj.cspide.infraestructure.rest.adapter;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import pe.gob.pj.cspide.domain.exceptions.ErrorException;
import pe.gob.pj.cspide.domain.model.auditoriageneral.AuditoriaAplicativos;
import pe.gob.pj.cspide.domain.model.client.reniec.PersonaConsultadaReniec;
import pe.gob.pj.cspide.domain.model.client.reniec.RespuestaActualizacionCredenciales;
import pe.gob.pj.cspide.domain.port.usecase.AuditoriaGeneralUseCasePort;
import pe.gob.pj.cspide.domain.port.usecase.ConsultaUseCasePort;
import pe.gob.pj.cspide.domain.utils.ProjectConstants;
import pe.gob.pj.cspide.domain.utils.ProjectUtils;
import pe.gob.pj.cspide.infraestructure.mapper.AuditoriaGeneralMapper;
import pe.gob.pj.cspide.infraestructure.rest.adapter.request.ActualizarCrendencialesUsuarioRequest;
import pe.gob.pj.cspide.infraestructure.rest.adapter.request.ConsultarPersonaReniecRequest;
import pe.gob.pj.cspide.infraestructure.rest.response.GlobalResponse;

@Slf4j
@RestController
public class ConsultarReniecController implements ConsultarReniec, Serializable {

	private static final long serialVersionUID = 1L;

	final ConsultaUseCasePort consultaUseCasePort;

	final AuditoriaGeneralUseCasePort auditoriaGeneralUseCasePort;

	@Autowired
	private AuditoriaGeneralMapper auditoriaGeneralMapper;

	public ConsultarReniecController(ConsultaUseCasePort consultaUseCasePort,
			AuditoriaGeneralUseCasePort auditoriaGeneralUseCasePort) {
		this.consultaUseCasePort = consultaUseCasePort;
		this.auditoriaGeneralUseCasePort = auditoriaGeneralUseCasePort;
	}

	@PostMapping(value = "buscar/persona-dni")
	public ResponseEntity<GlobalResponse> buscarPersonaDni(String cuo, String ips, String usuauth, String uri,
			String params, String herramienta, ConsultarPersonaReniecRequest request) {
		GlobalResponse res = new GlobalResponse();
		res.setCodigoOperacion(cuo.substring(1, cuo.length() - 1));

		try {
			long inicio = System.currentTimeMillis();
			PersonaConsultadaReniec data = consultaUseCasePort.consultarPersonaPorDni(cuo,
					request.getNumeroDocumentoIdentidad(), request.getCodigoAplicativo());
			res.setCodigo(ProjectConstants.Error.CEXITO);
			res.setDescripcion(ProjectConstants.Error.XEXITO);
			res.setData(data);
			long fin = System.currentTimeMillis();
			AuditoriaAplicativos auditoriaAplicativos = auditoriaGeneralMapper.toAuditoriaAplicativos(
					request.getAuditoria(), cuo, ips, usuauth, uri, params, herramienta, res.getCodigo(),
					res.getDescripcion(), fin - inicio);
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonString = objectMapper.writeValueAsString(request);
			auditoriaAplicativos.setPeticionBody(jsonString);
			auditoriaGeneralUseCasePort.crear(cuo, auditoriaAplicativos);
		} catch (ErrorException e) {
			handleException(cuo, e, res);
		} catch (Exception e) {
			handleException(cuo,
					new ErrorException(ProjectConstants.Error.CE000, ProjectConstants.Error.XERROR
							+ ProjectConstants.Proceso.RENIEC_BUSCAR_PERSONA_POR_DNI + ProjectConstants.Error.XE000,
							e.getMessage(), e.getCause()),
					res);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType
				.parseMediaType(!ProjectConstants.FormatoRespuesta.XML.equalsIgnoreCase(request.getFormatoRespuesta())
						? MediaType.APPLICATION_JSON_VALUE
						: MediaType.APPLICATION_XML_VALUE));
		return new ResponseEntity<>(res, headers, HttpStatus.OK);
	}

	@PostMapping(value = "actualizar/credencial-usuario")
	public ResponseEntity<GlobalResponse> actualizarCredencialUsuario(String cuo, String ips, String usuauth,
			String uri, String params, String herramienta, ActualizarCrendencialesUsuarioRequest request) {
		GlobalResponse res = new GlobalResponse();
		res.setCodigoOperacion(cuo.substring(1, cuo.length() - 1));

		try {
			long inicio = System.currentTimeMillis();
			RespuestaActualizacionCredenciales data = consultaUseCasePort.actualizarUsuario(cuo,
					request.getDocumentoIdentidadUsuario(), request.getCredencialNueva(),
					request.getCredencialAnterior());
			res.setCodigo(ProjectConstants.Error.CEXITO);
			res.setDescripcion(ProjectConstants.Error.XEXITO);
			res.setData(data);
			long fin = System.currentTimeMillis();
			AuditoriaAplicativos auditoriaAplicativos = auditoriaGeneralMapper.toAuditoriaAplicativos(
					request.getAuditoria(), cuo, ips, usuauth, uri, params, herramienta, res.getCodigo(),
					res.getDescripcion(), fin - inicio);
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonString = objectMapper.writeValueAsString(request);
			auditoriaAplicativos.setPeticionBody(jsonString);
			auditoriaGeneralUseCasePort.crear(cuo, auditoriaAplicativos);
		} catch (ErrorException e) {
			handleException(cuo, e, res);
		} catch (Exception e) {
			handleException(cuo,
					new ErrorException(
							ProjectConstants.Error.CE000, ProjectConstants.Error.XERROR
									+ ProjectConstants.Proceso.RENIEC_ACTUALIZAR_USUARIO + ProjectConstants.Error.XE000,
							e.getMessage(), e.getCause()),
					res);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType
				.parseMediaType(!ProjectConstants.FormatoRespuesta.XML.equalsIgnoreCase(request.getFormatoRespuesta())
						? MediaType.APPLICATION_JSON_VALUE
						: MediaType.APPLICATION_XML_VALUE));
		return new ResponseEntity<>(res, headers, HttpStatus.OK);
	}

	private void handleException(String cuo, ErrorException e, GlobalResponse res) {
		res.setCodigo(e.getCodigo());
		res.setDescripcion(e.getDescripcion());
		log.error("{} {} | {} | {} | {} | {} | {}", cuo, ProjectConstants.Error.TRAZA_LOG, res.getCodigo(),
				res.getDescripcion(), ProjectUtils.obtenerClaseMetodoLineaException(e), e.getMessage(),
				ProjectUtils.obtenerCausaException(e));
	}

}

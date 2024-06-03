package pe.gob.pj.cspide.infraestructure.rest.adapter;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.pj.cspide.domain.utils.ProjectConstants;
import pe.gob.pj.cspide.infraestructure.rest.adapter.request.ActualizarCrendencialesUsuarioRequest;
import pe.gob.pj.cspide.infraestructure.rest.adapter.request.ConsultarPersonaReniecRequest;
import pe.gob.pj.cspide.infraestructure.rest.response.GlobalResponse;

@RestController
@RequestMapping(value="reniec", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public interface ConsultarReniec {

	@PostMapping(value="buscar/persona-dni")
	public ResponseEntity<GlobalResponse> buscarPersonaDni(@RequestAttribute(name=ProjectConstants.AUD_CUO) String cuo,
			@RequestAttribute(name = ProjectConstants.AUD_IPS) String ips,
			@RequestAttribute(name = ProjectConstants.AUD_USUARIO) String usuauth,
			@RequestAttribute(name = ProjectConstants.AUD_URI) String uri,
			@RequestAttribute(name = ProjectConstants.AUD_PARAMS) String params,
			@RequestAttribute(name = ProjectConstants.AUD_HERRAMIENTA) String herramienta,
			@Valid @RequestBody ConsultarPersonaReniecRequest request);
	
	@PostMapping(value="actualizar/credencial-usuario")
	public ResponseEntity<GlobalResponse> actualizarCredencialUsuario(@RequestAttribute(name=ProjectConstants.AUD_CUO) String cuo,
			@RequestAttribute(name = ProjectConstants.AUD_IPS) String ips,
			@RequestAttribute(name = ProjectConstants.AUD_USUARIO) String usuauth,
			@RequestAttribute(name = ProjectConstants.AUD_URI) String uri,
			@RequestAttribute(name = ProjectConstants.AUD_PARAMS) String params,
			@RequestAttribute(name = ProjectConstants.AUD_HERRAMIENTA) String herramienta,
			@Valid @RequestBody ActualizarCrendencialesUsuarioRequest request);
	
}

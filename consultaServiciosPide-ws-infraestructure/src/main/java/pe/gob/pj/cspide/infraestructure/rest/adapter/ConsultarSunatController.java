package pe.gob.pj.cspide.infraestructure.rest.adapter;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pe.gob.pj.cspide.domain.exceptions.ErrorException;
import pe.gob.pj.cspide.domain.utils.ProjectConstants;
import pe.gob.pj.cspide.domain.utils.ProjectUtils;
import pe.gob.pj.cspide.infraestructure.client.response.SunatDatosPrincipales;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDatosSecundarios;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDatosT1144;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDatosT362;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDomicilioLegal;
import pe.gob.pj.cspide.infraestructure.client.services.SunatClient;
import pe.gob.pj.cspide.infraestructure.rest.response.GlobalResponse;

@Slf4j
@RestController
@RequestMapping(value="sunat"  ,produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class ConsultarSunatController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	@Qualifier("sunatClient")
	private SunatClient clientSunat;
	
	@GetMapping(value="datos-principales")
	public ResponseEntity<GlobalResponse> obtenerDatosPrincipales(@RequestAttribute(name=ProjectConstants.AUD_CUO) String cuo,
			@RequestParam(name = "formatoRespuesta", defaultValue = "json", required = false) String formatoRespuesta,
			@RequestParam(name = "numruc") String numeroRuc){
		GlobalResponse res =  new GlobalResponse();
		res.setCodigoOperacion(cuo);
		try {
			SunatDatosPrincipales datosPrincipales = clientSunat.obtenerDatosPrincipales(cuo, numeroRuc);
			res.setCodigo(ProjectConstants.Error.CEXITO);
			res.setDescripcion(ProjectConstants.Error.XEXITO);
			res.setData(datosPrincipales);
		}catch (ErrorException e) {
			handleException(cuo, e, res);
		} catch (Exception e) {
			handleException(cuo, new ErrorException(ProjectConstants.Error.CE000, 
			        ProjectConstants.Error.XERROR + ProjectConstants.Proceso.SUNAT_GET_DATOS_PRINCIPALES + ProjectConstants.Error.XE000,
			        e.getMessage(),
			        e.getCause()), res);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType(!ProjectConstants.FormatoRespuesta.XML.equalsIgnoreCase(formatoRespuesta) ? MediaType.APPLICATION_JSON_VALUE : MediaType.APPLICATION_XML_VALUE));
		return new ResponseEntity<>(res, headers, HttpStatus.OK);
	}
	
	@GetMapping(value="datos-secundarios")
	public ResponseEntity<GlobalResponse> obtenerDatosSecundarios(@RequestAttribute(name=ProjectConstants.AUD_CUO) String cuo,
			@RequestParam(name = "formatoRespuesta", defaultValue = "json", required = false) String formatoRespuesta,
			@RequestParam(name = "numruc") String numeroRuc){
		GlobalResponse res =  new GlobalResponse();
		res.setCodigoOperacion(cuo);
		try {
			SunatDatosSecundarios datosSecundarios = clientSunat.obtenerDatosSecundarios(cuo, numeroRuc);
			res.setCodigo(ProjectConstants.Error.CEXITO);
			res.setDescripcion(ProjectConstants.Error.XEXITO);
			res.setData(datosSecundarios);
		}catch (ErrorException e) {
			handleException(cuo, e, res);
		} catch (Exception e) {
			handleException(cuo, new ErrorException(ProjectConstants.Error.CE000, 
			        ProjectConstants.Error.XERROR + ProjectConstants.Proceso.SUNAT_GET_DATOS_SECUNDARIOS + ProjectConstants.Error.XE000,
			        e.getMessage(),
			        e.getCause()), res);
		}
			
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType(!ProjectConstants.FormatoRespuesta.XML.equalsIgnoreCase(formatoRespuesta) ? MediaType.APPLICATION_JSON_VALUE : MediaType.APPLICATION_XML_VALUE));
		return new ResponseEntity<>(res, headers, HttpStatus.OK);
	}
	
	@GetMapping(value="datos-t1144")
	public ResponseEntity<GlobalResponse> obtenerDatost1144(@RequestAttribute(name=ProjectConstants.AUD_CUO) String cuo,
			@RequestParam(name = "formatoRespuesta", defaultValue = "json", required = false) String formatoRespuesta,
			@RequestParam(name = "numruc") String numeroRuc){
		GlobalResponse res =  new GlobalResponse();
		res.setCodigoOperacion(cuo);
		try {
			SunatDatosT1144 datosSecundarios = clientSunat.obtenerDatosT1144(cuo, numeroRuc);
			res.setCodigo(ProjectConstants.Error.CEXITO);
			res.setDescripcion(ProjectConstants.Error.XEXITO);
			res.setData(datosSecundarios);
		}catch (ErrorException e) {
			handleException(cuo, e, res);
		} catch (Exception e) {
			handleException(cuo, new ErrorException(ProjectConstants.Error.CE000, 
			        ProjectConstants.Error.XERROR + ProjectConstants.Proceso.SUNAT_GET_DATOS_SECUNDARIOS + ProjectConstants.Error.XE000,
			        e.getMessage(),
			        e.getCause()), res);
		}
			
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType(!ProjectConstants.FormatoRespuesta.XML.equalsIgnoreCase(formatoRespuesta) ? MediaType.APPLICATION_JSON_VALUE : MediaType.APPLICATION_XML_VALUE));
		return new ResponseEntity<>(res, headers, HttpStatus.OK);
	}
	
	@GetMapping(value="datos-t362")
	public ResponseEntity<GlobalResponse> obtenerDatost362(@RequestAttribute(name=ProjectConstants.AUD_CUO) String cuo,
			@RequestParam(name = "formatoRespuesta", defaultValue = "json", required = false) String formatoRespuesta,
			@RequestParam(name = "numruc") String numeroRuc){
		GlobalResponse res =  new GlobalResponse();
		res.setCodigoOperacion(cuo);
		try {
			List<SunatDatosT362> datosSecundarios = clientSunat.obtenerDatosT362(cuo, numeroRuc);
			res.setCodigo(ProjectConstants.Error.CEXITO);
			res.setDescripcion(ProjectConstants.Error.XEXITO);
			res.setData(datosSecundarios);
		}catch (ErrorException e) {
			handleException(cuo, e, res);
		} catch (Exception e) {
			handleException(cuo, new ErrorException(ProjectConstants.Error.CE000, 
			        ProjectConstants.Error.XERROR + ProjectConstants.Proceso.SUNAT_GET_DATOS_SECUNDARIOS + ProjectConstants.Error.XE000,
			        e.getMessage(),
			        e.getCause()), res);
		}
			
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType(!ProjectConstants.FormatoRespuesta.XML.equalsIgnoreCase(formatoRespuesta) ? MediaType.APPLICATION_JSON_VALUE : MediaType.APPLICATION_XML_VALUE));
		return new ResponseEntity<>(res, headers, HttpStatus.OK);
	}
	
	@GetMapping(value="domicilio-legal")
	public ResponseEntity<GlobalResponse> obtenerDomicilioLegal(@RequestAttribute(name=ProjectConstants.AUD_CUO) String cuo,
			@RequestParam(name = "formatoRespuesta", defaultValue = "json", required = false) String formatoRespuesta,
			@RequestParam(name = "numruc") String numeroRuc){
		GlobalResponse res =  new GlobalResponse();
		res.setCodigoOperacion(cuo);
		try {
			SunatDomicilioLegal domicilioLegal = clientSunat.obtenerDomicilioLegal(cuo, numeroRuc);
			res.setCodigo(ProjectConstants.Error.CEXITO);
			res.setDescripcion(ProjectConstants.Error.XEXITO);
			res.setData(domicilioLegal);
		}catch (ErrorException e) {
			handleException(cuo, e, res);
		} catch (Exception e) {
			handleException(cuo, new ErrorException(ProjectConstants.Error.CE000, 
			        ProjectConstants.Error.XERROR + ProjectConstants.Proceso.SUNAT_GET_DOMICILIO_LEGAL + ProjectConstants.Error.XE000,
			        e.getMessage(),
			        e.getCause()), res);
		}
			
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType(!ProjectConstants.FormatoRespuesta.XML.equalsIgnoreCase(formatoRespuesta) ? MediaType.APPLICATION_JSON_VALUE : MediaType.APPLICATION_XML_VALUE));
		return new ResponseEntity<>(res, headers, HttpStatus.OK);
	}
	
	
	
	private void handleException(String cuo, ErrorException e, GlobalResponse res) {
	    res.setCodigo(e.getCodigo());
	    res.setDescripcion(e.getDescripcion());
	    log.error("{} {} | {} | {} | {} | {} | {}", cuo, ProjectConstants.Error.TRAZA_LOG, res.getCodigo(), res.getDescripcion(), ProjectUtils.obtenerClaseMetodoLineaException(e), e.getMessage(), ProjectUtils.obtenerCausaException(e));
	}
}

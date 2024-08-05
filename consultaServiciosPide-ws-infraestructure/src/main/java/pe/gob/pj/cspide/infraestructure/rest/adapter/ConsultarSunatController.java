package pe.gob.pj.cspide.infraestructure.rest.adapter;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.pj.cspide.domain.utils.ProjectConstants;
import pe.gob.pj.cspide.infraestructure.client.response.SunatGetDatosPrincipalesResponse;
import pe.gob.pj.cspide.infraestructure.client.services.SunatClient;
import pe.gob.pj.cspide.infraestructure.rest.response.GlobalResponse;

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
	public ResponseEntity<GlobalResponse> obtenerDatosPrincipales(@RequestAttribute(name=ProjectConstants.AUD_CUO) String cuo,@RequestParam(name = "numruc") String numeroRuc){
		GlobalResponse res =  new GlobalResponse();
		res.setCodigoOperacion(cuo);
		try {
			SunatGetDatosPrincipalesResponse datosPrincipales = clientSunat.obtenerDatosPrincipales(cuo, numeroRuc);
			res.setCodigo(ProjectConstants.Error.CEXITO);
			res.setDescripcion(ProjectConstants.Error.XEXITO);
			res.setData(datosPrincipales);
		}catch(Exception e) {
			res.setCodigo("ERROR");
			res.setDescripcion("Ocurrioi un error al consultar los datos principales");
		}
			
		return new ResponseEntity<GlobalResponse>(res,HttpStatus.OK);
	}
}

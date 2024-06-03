package pe.gob.pj.cspide.infraestructure.client.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import pe.gob.pj.cspide.infraestructure.client.dtos.ReniecPersonaDniDto;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReniecServicioResultResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("coResultado")
	String codigoResultado;
	@JsonProperty("deResultado")
	String descripcionResultado;
	@JsonProperty(value="datosPersona",required = false)
	private ReniecPersonaDniDto datosPersona;

}

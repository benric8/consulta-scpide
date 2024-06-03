package pe.gob.pj.cspide.infraestructure.client.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReniecActualizarUsuarioBodyResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("actualizarcredencialResponse")
	ReniecServicioResponse consultarResponse;
	
}

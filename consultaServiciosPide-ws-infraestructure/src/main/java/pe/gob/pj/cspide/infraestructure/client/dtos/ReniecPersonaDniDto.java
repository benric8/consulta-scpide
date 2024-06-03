package pe.gob.pj.cspide.infraestructure.client.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReniecPersonaDniDto {
	
	@JsonProperty("apPrimer")
	String primerApellido;
	
	@JsonProperty("apSegundo")
	String segundoApellido;
	
	@JsonProperty("prenombres")
	String nombres;
	
	@JsonProperty("estadoCivil")
	String estadoCivil;
	
	@JsonProperty("foto")
	String fotoB64;
	
	@JsonProperty("ubigeo")
	String ubigeo;
	
	@JsonProperty("direccion")
	String direccion;
	
	@JsonProperty("restriccion")
	String restriccion;

}

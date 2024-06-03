package pe.gob.pj.cspide.domain.model.client.reniec;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonaConsultadaReniec {

	String primerApellido;
	String segundoApellido;
	String nombres;
	String estadoCivil;
	String fotoB64;
	String ubigeo;
	String direccion;
	String restriccion;
	
}

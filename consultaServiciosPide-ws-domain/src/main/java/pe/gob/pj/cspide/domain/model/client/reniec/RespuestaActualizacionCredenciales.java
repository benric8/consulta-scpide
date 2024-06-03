package pe.gob.pj.cspide.domain.model.client.reniec;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RespuestaActualizacionCredenciales {
	String codigoResultado;
	String descripcionResultado;
}

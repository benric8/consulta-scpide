package pe.gob.pj.cspide.infraestructure.rest.adapter.request;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import pe.gob.pj.cspide.domain.utils.ProjectConstants;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConsultarPersonaReniecRequest {

	@JsonProperty("formatoRespuesta")
	String formatoRespuesta;
	
	@Pattern(regexp = ProjectConstants.Pattern.NUMBER, message = "El parámetro numeroDocumentoIdentidad no tiene formato valido.")
	@NotBlank(message = "El parámetro numeroDocumentoIdentidad no puede tener un valor vacio.")
	@Length(min = 8, max = 8, message = "El parámetro numeroDocumentoIdentidad tiene un tamaño no valido [min=1,max=8].") 
	@JsonProperty("numeroDocumentoIdentidad")
	String numeroDocumentoIdentidad;

	@NotNull(message = "El parámetro motivo es requerido no puede ser nulo.")
	@NotBlank(message = "El parámetro motivo es requerido no puede ser vacío.")
	@JsonProperty("motivo")
	String motivo;

	@NotNull(message = "El parámetro codigoAplicativo es requerido no puede ser nulo.")
	@NotBlank(message = "El parámetro codigoAplicativo es requerido no puede ser vacío.")
	@JsonProperty("codigoAplicativo")
	String codigoAplicativo;

	@Valid
	@NotNull(message = "El auditoria es requerido no puede ser null")
	@JsonProperty("auditoria")
	AuditoriaRequest auditoria;
	
}

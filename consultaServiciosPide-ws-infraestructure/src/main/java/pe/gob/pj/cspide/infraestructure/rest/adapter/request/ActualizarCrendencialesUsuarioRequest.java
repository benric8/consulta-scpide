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
public class ActualizarCrendencialesUsuarioRequest {
	
	@JsonProperty("formatoRespuesta")
	String formatoRespuesta;

	@NotNull(message = "El parámetro credencialAnterior es requerido no puede ser nulo.")
	@NotBlank(message = "El parámetro credencialAnterior es requerido no puede ser vacío.")
	@JsonProperty("credencialAnterior")
	String credencialAnterior;

	@NotNull(message = "El parámetro credencialNueva es requerido no puede ser nulo.")
	@NotBlank(message = "El parámetro credencialNueva es requerido no puede ser vacío.")
	@JsonProperty("credencialNueva")
	String credencialNueva;

	@Pattern(regexp = ProjectConstants.Pattern.NUMBER, message = "El parámetro documentoIdentidadUsuario no tiene formato valido.")
	@NotBlank(message = "El parámetro documentoIdentidadUsuario no puede tener un valor vacio.")
	@Length(min = 8, max = 11, message = "El parámetro documentoIdentidadUsuario tiene un tamaño no valido [min=8,max=11].")
	@JsonProperty("documentoIdentidadUsuario")
	String documentoIdentidadUsuario;

	@Valid
	@NotNull(message = "El auditoria es requerido no puede ser null")
	@JsonProperty("auditoria")
	AuditoriaRequest auditoria;

}

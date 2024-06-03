package pe.gob.pj.cspide.domain.port.usecase;

import pe.gob.pj.cspide.domain.model.client.reniec.PersonaConsultadaReniec;
import pe.gob.pj.cspide.domain.model.client.reniec.RespuestaActualizacionCredenciales;

public interface ConsultaUseCasePort {

	public PersonaConsultadaReniec consultarPersonaPorDni(String cuo, String documentoConsultado,
			String codigoAplicativo) throws Exception;

	public RespuestaActualizacionCredenciales actualizarUsuario(String cuo, String documentoUsuario,
			String credencialNueva, String credenciaAnterior) throws Exception;

}

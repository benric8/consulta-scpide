package pe.gob.pj.cspide.domain.port.client;

import java.util.Set;

import pe.gob.pj.cspide.domain.model.client.reniec.PersonaConsultadaReniec;
import pe.gob.pj.cspide.domain.model.client.reniec.RespuestaActualizacionCredenciales;

public interface ReniecClient {

	public PersonaConsultadaReniec buscarPersonaPorDni(String cuo, String documentoConsultado, Set<String> credenciales)
			throws Exception;

	public RespuestaActualizacionCredenciales actualizarUsuario(String cuo, String documentoUsuario,
			String credencialNueva, String credenciaAnterior) throws Exception;

}

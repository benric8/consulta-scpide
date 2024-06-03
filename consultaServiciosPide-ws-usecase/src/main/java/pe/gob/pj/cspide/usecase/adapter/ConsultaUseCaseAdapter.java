package pe.gob.pj.cspide.usecase.adapter;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import pe.gob.pj.cspide.domain.exceptions.ErrorException;
import pe.gob.pj.cspide.domain.model.client.reniec.PersonaConsultadaReniec;
import pe.gob.pj.cspide.domain.model.client.reniec.RespuestaActualizacionCredenciales;
import pe.gob.pj.cspide.domain.port.client.ReniecClient;
import pe.gob.pj.cspide.domain.port.usecase.ConsultaUseCasePort;
import pe.gob.pj.cspide.domain.utils.ProjectConstants;
import pe.gob.pj.cspide.domain.utils.ProjectProperties;

@Service("consultaUseCasePort")
public class ConsultaUseCaseAdapter implements ConsultaUseCasePort {

	final ReniecClient reniecClient;

	public ConsultaUseCaseAdapter(ReniecClient reniecClient) {
		this.reniecClient = reniecClient;
	}

	@Override
	public PersonaConsultadaReniec consultarPersonaPorDni(String cuo, String documentoConsultado,
			String codigoAplicativo) throws Exception {
		PersonaConsultadaReniec personaConsultadaReniec = null;
//		String usuario = "", clave = "";
//		for (String aplicativo : ProjectProperties.getServicioReniecClienteAplicativos().split("\\|")) {
//			if (aplicativo.contains(codigoAplicativo)) {
//				aprobacionConsumo = true;
//				String[] aplicativoCredenciales = aplicativo.split("@");
//				usuario = aplicativoCredenciales[1];
//				clave = aplicativoCredenciales[2];
//			}
//		}
		Set<String> credenciales = obtenerCedenciales(codigoAplicativo);
		if (credenciales.isEmpty()) {
			throw new ErrorException(ProjectConstants.Error.CN002, ProjectConstants.Error.XERROR
					+ ProjectConstants.Proceso.RENIEC_BUSCAR_PERSONA_POR_DNI + ProjectConstants.Error.XN002);

		}
		personaConsultadaReniec = reniecClient.buscarPersonaPorDni(cuo, documentoConsultado, credenciales);
		return personaConsultadaReniec;
	}

	@Override
	public RespuestaActualizacionCredenciales actualizarUsuario(String cuo, String documentoUsuario,
			String credencialNueva, String credenciaAnterior) throws Exception {
		return reniecClient.actualizarUsuario(cuo, documentoUsuario, credencialNueva, credenciaAnterior);
	}
	
	private Set<String> obtenerCedenciales(String codigoAplicativo){
		Set<String> usuarios = new LinkedHashSet<String>();
		for (String datosAplicativo : ProjectProperties.getServicioReniecClienteAplicativos().split("\\|")) {
			if (datosAplicativo.contains(codigoAplicativo)) {
				String[] aplicativoCredenciales = datosAplicativo.split(ProjectConstants.CARACTER_CREDENCIALES);
				usuarios.add(aplicativoCredenciales[1].concat(ProjectConstants.CARACTER_CREDENCIALES).concat(aplicativoCredenciales[2]));
			}
		}
		return usuarios;
	}

}

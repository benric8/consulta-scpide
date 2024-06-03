package pe.gob.pj.cspide.infraestructure.client.services;

import pe.gob.pj.cspide.infraestructure.client.response.ConadisBuscarPesonaBodyResponse;

public interface ConadisClient {
	public ConadisBuscarPesonaBodyResponse buscarPersonaDiscapacidad(String cuo, String numeroDocumentoIdentidad) throws Exception;
}

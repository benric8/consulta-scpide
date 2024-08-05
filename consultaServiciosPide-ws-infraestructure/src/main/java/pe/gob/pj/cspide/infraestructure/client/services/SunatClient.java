package pe.gob.pj.cspide.infraestructure.client.services;

import pe.gob.pj.cspide.infraestructure.client.response.SunatGetDatosPrincipalesResponse;

public interface SunatClient {
	public SunatGetDatosPrincipalesResponse obtenerDatosPrincipales(String cuo,String ruc) throws Exception;

}

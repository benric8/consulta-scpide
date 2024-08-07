package pe.gob.pj.cspide.infraestructure.client.services;

import pe.gob.pj.cspide.infraestructure.client.response.SunatDatosPrincipales;

public interface SunatClient {
	public SunatDatosPrincipales obtenerDatosPrincipales(String cuo,String ruc) throws Exception;

}

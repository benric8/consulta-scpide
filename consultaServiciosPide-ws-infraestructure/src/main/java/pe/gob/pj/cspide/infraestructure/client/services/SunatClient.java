package pe.gob.pj.cspide.infraestructure.client.services;

import java.util.List;

import pe.gob.pj.cspide.infraestructure.client.response.SunatDatosPrincipales;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDatosSecundarios;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDatosT1144;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDatosT362;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDomicilioLegal;

public interface SunatClient {
	public SunatDatosPrincipales obtenerDatosPrincipales(String cuo,String ruc) throws Exception;
	public SunatDatosSecundarios obtenerDatosSecundarios(String cuo,String ruc) throws Exception;
	public SunatDatosT1144 obtenerDatosT1144(String cuo,String ruc) throws Exception;
	public List<SunatDatosT362> obtenerDatosT362(String cuo,String ruc) throws Exception;
	public SunatDomicilioLegal obtenerDomicilioLegal(String cuo, String ruc) throws Exception;

}

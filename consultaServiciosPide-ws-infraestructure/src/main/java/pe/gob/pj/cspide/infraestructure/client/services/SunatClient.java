package pe.gob.pj.cspide.infraestructure.client.services;

import java.util.List;

import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDatosPrincipales;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDatosSecundarios;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDatosT1144;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDatosT362;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatDomicilioLegal;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatEstablecimientosAnexos;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatEstablecimientosAnexosT1150;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatRazonSocial;
import pe.gob.pj.cspide.infraestructure.client.response.sunat.SunatRepresentatesLegales;

public interface SunatClient {
	public SunatDatosPrincipales obtenerDatosPrincipales(String cuo,String ruc) throws Exception;
	public SunatDatosSecundarios obtenerDatosSecundarios(String cuo,String ruc) throws Exception;
	public SunatDatosT1144 obtenerDatosT1144(String cuo,String ruc) throws Exception;
	public List<SunatDatosT362> obtenerDatosT362(String cuo,String ruc) throws Exception;
	public SunatDomicilioLegal obtenerDomicilioLegal(String cuo, String ruc) throws Exception;
	public List<SunatEstablecimientosAnexos> obtenerEstablecimientosAnexos(String cuo,String ruc) throws Exception;
	public List<SunatEstablecimientosAnexosT1150> obtenerEstablecimientosAnexosT1150(String cuo,String ruc) throws Exception;
	public List<SunatRepresentatesLegales> obtenerRepresentatesLegales(String cuo,String ruc) throws Exception;
	public List<SunatRazonSocial> BuscarPorRazonSocial(String cuo,String rsocial) throws Exception;

}

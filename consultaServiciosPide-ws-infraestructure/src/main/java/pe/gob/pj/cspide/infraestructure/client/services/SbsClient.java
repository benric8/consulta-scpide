package pe.gob.pj.cspide.infraestructure.client.services;

import pe.gob.pj.cspide.infraestructure.client.response.SbsConsultarTipoCambioCodMonedaBodyResponse;

public interface SbsClient {
    public SbsConsultarTipoCambioCodMonedaBodyResponse consultarTipoCambioPorFechaYCodMoneda(String cuo, String fecha, String codMoneda) throws Exception;
}

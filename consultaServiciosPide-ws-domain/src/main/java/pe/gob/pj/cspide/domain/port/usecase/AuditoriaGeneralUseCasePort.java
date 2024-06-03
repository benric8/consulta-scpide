package pe.gob.pj.cspide.domain.port.usecase;

import pe.gob.pj.cspide.domain.model.auditoriageneral.AuditoriaAplicativos;

public interface AuditoriaGeneralUseCasePort {
	public void crear(String cuo, AuditoriaAplicativos auditoriaApllicativos);
}

package pe.gob.pj.cspide.domain.port.repository;

import pe.gob.pj.cspide.domain.model.auditoriageneral.AuditoriaAplicativos;

public interface AuditoriaGeneralRepositoryPort {
	public void crear(AuditoriaAplicativos auditoriaAplicativos) throws Exception;
}

package pe.gob.pj.cspide.usecase.adapter;

import java.sql.SQLException;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.pj.cspide.domain.model.auditoriageneral.AuditoriaAplicativos;
import pe.gob.pj.cspide.domain.port.repository.AuditoriaGeneralRepositoryPort;
import pe.gob.pj.cspide.domain.port.usecase.AuditoriaGeneralUseCasePort;
import pe.gob.pj.cspide.domain.utils.ProjectUtils;


@Service("auditoriaGeneralUseCasePort")
public class AuditoriaGeneralUseCaseAdapter implements AuditoriaGeneralUseCasePort{
	
	public AuditoriaGeneralRepositoryPort auditoriaGeneralRepositoryPort;
	
	public AuditoriaGeneralUseCaseAdapter(AuditoriaGeneralRepositoryPort auditoriaGeneralRepositoryPort) {
		this.auditoriaGeneralRepositoryPort = auditoriaGeneralRepositoryPort;
	}

	@Async("poolTaskConsultaServiciosPide")
	@Override
	@Transactional(transactionManager = "txManagerAuditoriaGeneral", propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = { Exception.class, SQLException.class})
	public void crear(String cuo, AuditoriaAplicativos auditoriaAplicativos){
		try {
			this.auditoriaGeneralRepositoryPort.crear(auditoriaAplicativos);
		} catch (Exception e) {
			ProjectUtils.handleException(cuo, e, "auditoria_general", "No se registro auditoria general.");
		}
	}

}

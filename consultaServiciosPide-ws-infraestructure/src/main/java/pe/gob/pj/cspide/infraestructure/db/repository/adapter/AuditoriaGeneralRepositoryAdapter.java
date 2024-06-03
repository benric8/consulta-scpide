package pe.gob.pj.cspide.infraestructure.db.repository.adapter;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import pe.gob.pj.cspide.domain.model.auditoriageneral.AuditoriaAplicativos;
import pe.gob.pj.cspide.domain.port.repository.AuditoriaGeneralRepositoryPort;
import pe.gob.pj.cspide.infraestructure.db.entity.auditoriageneral.MovAuditoriaAplicativos;
import pe.gob.pj.cspide.infraestructure.mapper.AuditoriaGeneralMapper;

@Component("auditoriaGeneralRepositoryPort")
public class AuditoriaGeneralRepositoryAdapter implements AuditoriaGeneralRepositoryPort {

	@Autowired
	@Qualifier("sessionAuditoriaGeneral")
	private SessionFactory sessionFactory;

	@Autowired
	AuditoriaGeneralMapper auditoriaGeneralMapper;

	@Override
	public void crear(AuditoriaAplicativos auditoriaAplicativos) throws Exception {
		MovAuditoriaAplicativos mov = auditoriaGeneralMapper.toMovAuditoriaAplicativos(auditoriaAplicativos);
		this.sessionFactory.getCurrentSession().save(mov);
	}

}

package pe.gob.pj.cspide.infraestructure.db;

import java.io.IOException;
import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import pe.gob.pj.cspide.domain.utils.ProjectProperties;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

	
	private static Properties getHibernatePropertiesPostgresql() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
		hibernateProperties.put("hibernate.show_sql", false);
		hibernateProperties.put("hibernate.format_sql", true);
		hibernateProperties.put("hibernate.current_session_context_class", "org.springframework.orm.hibernate5.SpringSessionContext");
	    hibernateProperties.put("hibernate.connection.release_mode", "AFTER_TRANSACTION");
		return hibernateProperties;
	}
	
	/* Creación de conexión con base de datos seguridad */
	@Bean(name = "cxSeguridadDS")
	public DataSource jndiConexionSeguridad() throws IllegalArgumentException, NamingException {
		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
		bean.setJndiName("java:jboss/datasources/consultaServiciosPideWSSeguridad");
		bean.setProxyInterface(DataSource.class);
		bean.setLookupOnStartup(false);
		bean.setCache(true);
		bean.afterPropertiesSet();
		return (DataSource) bean.getObject();
	}	
		
	@Bean(name = "sessionSeguridad")
	public SessionFactory getSessionFactorySeguridad(@Qualifier("cxSeguridadDS") DataSource seguridadDS) throws IOException {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setPackagesToScan("pe.gob.pj.cspide.infraestructure.db.entity.security");
		sessionFactoryBean.setHibernateProperties(getHibernatePropertiesPostgresql());
		sessionFactoryBean.setDataSource(seguridadDS);
		sessionFactoryBean.afterPropertiesSet();
		return sessionFactoryBean.getObject();
	}

	@Bean(name = "txManagerSeguridad")
	public HibernateTransactionManager getTransactionManagerSeguridad(@Qualifier("sessionSeguridad") SessionFactory sessionSeguridad) throws IOException {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionSeguridad);
		transactionManager.setDefaultTimeout(ProjectProperties.getTimeoutBdTransactionSegundos());
		return transactionManager;
	}
	
	/* Creación de conexión con base de datos AUDITORIA_GENERAL */
	@Bean(name = "cxAuditoriaGeneralDS")
	public DataSource jndiConexionAuditoriaGeneral() throws IllegalArgumentException, NamingException {
		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
		bean.setJndiName("java:jboss/datasources/consultaServiciosPideWSAuditoriaGeneral");
		bean.setProxyInterface(DataSource.class);
		bean.setLookupOnStartup(false);
		bean.setCache(true);
		bean.afterPropertiesSet();
		return (DataSource) bean.getObject();
	}	
		
	@Bean(name = "sessionAuditoriaGeneral")
	public SessionFactory getSessionFactoryAuditoriaGeneral(@Qualifier("cxAuditoriaGeneralDS") DataSource seguridadDS) throws IOException {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setPackagesToScan("pe.gob.pj.cspide.infraestructure.db.entity.auditoriageneral");
		sessionFactoryBean.setHibernateProperties(getHibernatePropertiesPostgresql());
		sessionFactoryBean.setDataSource(seguridadDS);
		sessionFactoryBean.afterPropertiesSet();
		return sessionFactoryBean.getObject();
	}

	@Bean(name = "txManagerAuditoriaGeneral")
	public HibernateTransactionManager getTransactionManagerAuditoriaGeneral(@Qualifier("sessionAuditoriaGeneral") SessionFactory sessionAuditoriaGeneral) throws IOException {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionAuditoriaGeneral);
		transactionManager.setDefaultTimeout(ProjectProperties.getTimeoutBdTransactionSegundos());
		return transactionManager;
	}
	
}

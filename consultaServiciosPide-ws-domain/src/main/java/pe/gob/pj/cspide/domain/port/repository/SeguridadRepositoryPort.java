package pe.gob.pj.cspide.domain.port.repository;

import java.util.List;

import pe.gob.pj.cspide.domain.model.seguridad.Rol;
import pe.gob.pj.cspide.domain.model.seguridad.Usuario;

public interface SeguridadRepositoryPort {
	public String autenticarUsuario(String cuo, String codigoCliente, String codigoRol, String usuario, String clave) throws Exception;
	public Usuario recuperaInfoUsuario(String cuo, String id) throws Exception;
	public List<Rol> recuperarRoles(String cuo, String id) throws Exception;
	public String validarAccesoMetodo(String cuo, String usuario, String rol, String operacion) throws Exception;
}

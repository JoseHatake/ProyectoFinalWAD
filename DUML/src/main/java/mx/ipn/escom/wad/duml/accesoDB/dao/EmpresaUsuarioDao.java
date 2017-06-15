package mx.ipn.escom.wad.duml.accesoDB.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.wad.duml.accesoDB.mapeo.EmpresaUsuario;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.EmpresaUsuarioId;

@Service("empresaUsuarioDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class EmpresaUsuarioDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public EmpresaUsuario save(EmpresaUsuario empresaUsuario){
		sessionFactory.getCurrentSession().save(empresaUsuario);
		return empresaUsuario;
	}
	
	public EmpresaUsuario update(EmpresaUsuario empresaUsuario){
		sessionFactory.getCurrentSession().merge(empresaUsuario);
		sessionFactory.getCurrentSession().update(empresaUsuario);
		return empresaUsuario;
	}
	
	public void delete(EmpresaUsuarioId id){
		EmpresaUsuario empresaUsuario = this.findById(id);
		sessionFactory.getCurrentSession().delete(empresaUsuario);
	}
	
	public EmpresaUsuario findById(EmpresaUsuarioId id){
		return sessionFactory.getCurrentSession().load(EmpresaUsuario.class, id);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}

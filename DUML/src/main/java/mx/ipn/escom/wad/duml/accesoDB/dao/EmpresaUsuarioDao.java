package mx.ipn.escom.wad.duml.accesoDB.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
	
	protected String Query1 = "select a from EmpresaUsuario a where idUsuario = ?1";
	
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
	
	public List<EmpresaUsuario> findByIdUsuario(Integer idUsuario){
		Query<EmpresaUsuario> query = sessionFactory.getCurrentSession().createQuery(Query1,EmpresaUsuario.class);
		query.setParameter(1,idUsuario);
		return  query.getResultList();
	
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

package mx.ipn.escom.wad.duml.accesoDB.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Empresa;

@Service("empresaDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON )
public class EmpresaDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	protected String QUERY1 = "select a from Empresa a";
	
public Empresa save(Empresa empresa){
		sessionFactory.getCurrentSession().save(empresa);
		return empresa;
	}
	
	public Empresa update(Empresa empresa){
		sessionFactory.getCurrentSession().merge(empresa);
		sessionFactory.getCurrentSession().update(empresa);
		return empresa;
	}
	
	public void delete(Integer id){
		Empresa empresa = this.findById(id);
		sessionFactory.getCurrentSession().delete(empresa);
	}
	
	public Empresa findById(Integer id){
		return sessionFactory.getCurrentSession().load(Empresa.class, id);
	}
	
	public List<Empresa> getEmpresas(){
		Query<Empresa> query = sessionFactory.getCurrentSession().createQuery(QUERY1,Empresa.class);
		return query.getResultList();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}

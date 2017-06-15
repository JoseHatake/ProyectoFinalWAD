package mx.ipn.escom.wad.duml.accesoDB.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.wad.duml.accesoDB.mapeo.Clase;

@Service("claseDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class ClaseDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Clase save(Clase clase){
		sessionFactory.getCurrentSession().save(clase);
		return clase;
	}
	
	public Clase update(Clase clase){
		sessionFactory.getCurrentSession().merge(clase);
		sessionFactory.getCurrentSession().update(clase);
		return clase;
	}
	
	public void delete(Integer id){
		Clase clase = findById(id);
		sessionFactory.getCurrentSession().delete(clase);
	}
	
	public Clase findById(Integer id){
		return sessionFactory.getCurrentSession().load(Clase.class, id);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}

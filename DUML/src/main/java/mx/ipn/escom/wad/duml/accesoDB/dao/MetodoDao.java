package mx.ipn.escom.wad.duml.accesoDB.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.wad.duml.accesoDB.mapeo.Metodo;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.MetodoId;

@Service("metodoDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)

public class MetodoDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Metodo save(Metodo metodo){
		sessionFactory.getCurrentSession().save(metodo);
		return metodo;
		
	}
	
	public Metodo update(Metodo metodo){
		sessionFactory.getCurrentSession().merge(metodo);
		sessionFactory.getCurrentSession().update(metodo);
		return metodo;
	}
	
	public void delete(MetodoId id){
		Metodo metodo = this.findById(id);
		sessionFactory.getCurrentSession().delete(metodo);
	}
	
	public Metodo findById(MetodoId id){
		return sessionFactory.getCurrentSession().load(Metodo.class, id);
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}

package mx.ipn.escom.wad.duml.accesoDB.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Excepcion;

@Service ("excepcionDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class ExcepcionDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Excepcion save(Excepcion excepcion){
		sessionFactory.getCurrentSession().save(excepcion);
		return excepcion;
	}
	
	public Excepcion update(Excepcion excepcion){
		sessionFactory.getCurrentSession().merge(excepcion);
		sessionFactory.getCurrentSession().update(excepcion);
		return excepcion;
	}
	
	/*public void delete(ExcepcionId id){
		Excepcion excepcion = this.findById(id);
		sessionFactory.getCurrentSession().delete(excepcion);
	}
	
	public Excepcion findById(ExcepcionId id){
		return sessionFactory.getCurrentSession().load(Exception.class, id);
	}*/
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}

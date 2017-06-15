package mx.ipn.escom.wad.duml.accesoDB.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


import mx.ipn.escom.wad.duml.accesoDB.mapeo.MetodoId;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Parametro;

@Service("parametroDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)

public class ParametroDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Parametro save(Parametro parametro){
		sessionFactory.getCurrentSession().save(parametro);
		return parametro;
	}
	
	public Parametro update(Parametro parametro){
		sessionFactory.getCurrentSession().merge(parametro);
		sessionFactory.getCurrentSession().update(parametro);
		return parametro;
	}
	
	public void delete(MetodoId id){
		Parametro parametro = this.findDyId(id);
		sessionFactory.getCurrentSession().delete(parametro);
	}
	
	public Parametro findDyId(MetodoId id){
		return sessionFactory.getCurrentSession().load(Parametro.class, id);
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}

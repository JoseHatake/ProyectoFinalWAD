package mx.ipn.escom.wad.duml.accesoDB.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Parametro;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.ParametroId;

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
	
	public void delete(ParametroId id){
		Parametro parametro = this.findById(id);
		sessionFactory.getCurrentSession().delete(parametro);
	}
	
	public Parametro findById(ParametroId id){
		return sessionFactory.getCurrentSession().load(Parametro.class, id);
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}

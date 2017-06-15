package mx.ipn.escom.wad.duml.accesoDB.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.wad.duml.accesoDB.mapeo.Atributo;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.AtributoId;

@Service("atributoDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class AtributoDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Atributo save(Atributo atributo){
		sessionFactory.getCurrentSession().save(atributo);
		return atributo;
	}
	
	public Atributo update(Atributo atributo){
		sessionFactory.getCurrentSession().merge(atributo);
		sessionFactory.getCurrentSession().update(atributo);
		return atributo;
	}
	
	public void delete(AtributoId id){
		Atributo atributo = this.findById(id);
		sessionFactory.getCurrentSession().delete(atributo);
	}
	
	public Atributo findById(AtributoId id){
		return sessionFactory.getCurrentSession().load(Atributo.class, id);
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}

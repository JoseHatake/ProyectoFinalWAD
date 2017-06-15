package mx.ipn.escom.wad.duml.accesoDB.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Alcance;

@Service("alcanceDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class AlcanceDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Alcance save(Alcance alcance){
		sessionFactory.getCurrentSession().save(alcance);
		return alcance;
	}
	
	public Alcance update(Alcance alcance){
		sessionFactory.getCurrentSession().merge(alcance);
		sessionFactory.getCurrentSession().update(alcance);
		return alcance;
	}
	
	public void delete(Integer id){
		Alcance alcance = this.findById(id);
		sessionFactory.getCurrentSession().delete(alcance);
	}
	
	public Alcance findById(Integer id){
		return sessionFactory.getCurrentSession().load(Alcance.class, id);
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

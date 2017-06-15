package mx.ipn.escom.wad.duml.accesoDB.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Acceso;

@Service("accesoDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class AccesoDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Acceso save(Acceso acceso){
		sessionFactory.getCurrentSession().save(acceso);
		return acceso;
	}
	
	public Acceso update(Acceso acceso){
		sessionFactory.getCurrentSession().merge(acceso);
		sessionFactory.getCurrentSession().update(acceso);
		return acceso;
	}
	
	public void delete(Integer id){
		Acceso acceso = this.findById(id);
		sessionFactory.getCurrentSession().delete(acceso);
	}
	
	public Acceso findById(Integer id){
		return sessionFactory.getCurrentSession().load(Acceso.class, id);
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

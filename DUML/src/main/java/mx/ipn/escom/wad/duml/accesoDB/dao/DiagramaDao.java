package mx.ipn.escom.wad.duml.accesoDB.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.wad.duml.accesoDB.mapeo.Diagrama;

@Service("diagramaDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class DiagramaDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Diagrama save(Diagrama diagrama){
		sessionFactory.getCurrentSession().save(diagrama);
		return diagrama;
	}
	
	public Diagrama update(Diagrama diagrama){
		sessionFactory.getCurrentSession().merge(diagrama);
		return diagrama;
	}
	
	public void delete(Integer id){
		Diagrama diagrama = this.findById(id);
		sessionFactory.getCurrentSession().delete(diagrama);
	}
	
	public Diagrama findById(Integer id){
		return sessionFactory.getCurrentSession().load(Diagrama.class, id);
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

package mx.ipn.escom.wad.duml.accesoDB.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
	
	protected String Query1 ="select a from Diagrama a where idUsuario=$1 and idEmpresa=$2";
	
	public Diagrama save(Diagrama diagrama){
		System.out.println("Entro ---->" + diagrama.toString());
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
	
	public List<Diagrama> findByIDS(Integer idUsuario, Integer idEmpresa){
		Query<Diagrama> query=sessionFactory.getCurrentSession().createQuery(Query1, Diagrama.class);
		query.setParameter(1, idUsuario);
		query.setParameter(2, idEmpresa);
		return query.getResultList();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}

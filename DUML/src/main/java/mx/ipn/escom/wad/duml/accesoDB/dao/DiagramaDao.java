package mx.ipn.escom.wad.duml.accesoDB.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import mx.ipn.escom.wad.duml.accesoDB.mapeo.Diagrama;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Usuario;

@Service("diagramaDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class DiagramaDao {
	@Autowired
	private SessionFactory sessionFactory;
	
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
	
	public void saveQuert(Integer empresa,Integer usuario, String nbdiagrama, String path) {
		Session session = sessionFactory.getCurrentSession();
		Query<Diagrama> query = session.createQuery("insert into diagrana values(null,:empresa,:usuario,:nb_diagrama,:tx_path)", Diagrama.class);
		query.setParameter("empresa", empresa);
		query.setParameter("usuario", usuario);
		query.setParameter("nb_diagrama", nbdiagrama);
		query.setParameter("tx_path", path);
	
		List<Diagrama> results = query.getResultList();
	
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}

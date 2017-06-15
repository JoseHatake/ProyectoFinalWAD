package mx.ipn.escom.wad.duml.accesoDB.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.wad.duml.accesoDB.mapeo.Relacion;

@Service("relacionDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)

public class RelacionDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Relacion save(Relacion relacion){
		sessionFactory.getCurrentSession().save(relacion);
		return relacion;
	}
	
	public Relacion update(Relacion relacion){
		sessionFactory.getCurrentSession().merge(relacion);
		return relacion;
	}
	
	public void delete(Integer id){
		Relacion relacion = this.findById(id);
		sessionFactory.getCurrentSession().delete(relacion);
	}
	
	public Relacion findById(Integer id){
		return sessionFactory.getCurrentSession().load(Relacion.class, id);
	}
}

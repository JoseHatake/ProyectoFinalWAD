package mx.ipn.escom.wad.duml.accesoDB.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.wad.duml.accesoDB.mapeo.TipoRelacion;

@Service("tipoRelacionDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class TipoRelacionDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public TipoRelacion save(TipoRelacion tipoRelacion){
		sessionFactory.getCurrentSession().save(tipoRelacion);
		return tipoRelacion;
	}
	
	public TipoRelacion update(TipoRelacion tipoRelacion){
		sessionFactory.getCurrentSession().merge(tipoRelacion);
		return tipoRelacion;
	}
	
	public void delete(Integer id){
		TipoRelacion tipoRelacion = this.findById(id);
		sessionFactory.getCurrentSession().delete(tipoRelacion);
	}
	
	public TipoRelacion findById(Integer id){
		return sessionFactory.getCurrentSession().load(TipoRelacion.class, id);
	}
}

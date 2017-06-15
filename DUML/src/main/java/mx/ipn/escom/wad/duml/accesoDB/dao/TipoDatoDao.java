package mx.ipn.escom.wad.duml.accesoDB.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.wad.duml.accesoDB.mapeo.TipoDato;

@Service("tipoDatoDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class TipoDatoDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public TipoDato save(TipoDato tipoDato){
		sessionFactory.getCurrentSession().save(tipoDato);
		return tipoDato;
	}
	
	public TipoDato update(TipoDato tipoDato){
		sessionFactory.getCurrentSession().merge(tipoDato);
		return tipoDato;
	}
	
	public void delete(Integer id){
		TipoDato tipoDato = this.findById(id);
		sessionFactory.getCurrentSession().delete(tipoDato);
	}
	
	public TipoDato findById(Integer id){
		return sessionFactory.getCurrentSession().load(TipoDato.class, id);
	}
}

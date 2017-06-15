package mx.ipn.escom.wad.duml.accesoDB.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.wad.duml.accesoDB.mapeo.Usuario;

@Service("usuarioDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class UsuarioDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Usuario save(Usuario usuario){
		sessionFactory.getCurrentSession().save(usuario);
		return usuario;
	}
	
	public Usuario update(Usuario usuario){
		sessionFactory.getCurrentSession().merge(usuario);
		return usuario;
	}
	
	public void delete(Integer id){
		Usuario usuario = this.findById(id);
		sessionFactory.getCurrentSession().delete(usuario);
	}
	
	public Usuario findById(Integer id){
		return sessionFactory.getCurrentSession().load(Usuario.class, id);
	}
}

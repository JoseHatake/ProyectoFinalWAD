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
	
	public Usuario findByLogin(String login) {
		Session session = sessionFactory.getCurrentSession();
		Query<Usuario> query = session.createQuery("from Usuario where login = :login", Usuario.class);
		query.setParameter("login", login);

		List<Usuario> results = query.getResultList();
		Usuario usuario = null;
		if (!CollectionUtils.isEmpty(results)) {
			usuario = results.get(0);
		}

		return usuario;
	}
}

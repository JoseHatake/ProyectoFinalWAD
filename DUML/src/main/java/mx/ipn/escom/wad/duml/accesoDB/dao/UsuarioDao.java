package mx.ipn.escom.wad.duml.accesoDB.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
	
	protected String QUERY1 = "select a from Usuario a where login = ?1 and password = ?2";
	protected String QUERY2 = "select a from Usuario a where login = ?1";
	
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
	
	public Usuario findByLogin(String login, String pass) {
		Query<Usuario> query = sessionFactory.getCurrentSession().createQuery(QUERY1,Usuario.class);
		query.setParameter(1, login);
		query.setParameter(2, pass);
		List<Usuario> respuesta = query.getResultList();
		return respuesta.isEmpty()?new Usuario():respuesta.get(0);
	}
	
	public Boolean estaLogeado(String login){
		Query<Usuario> query = sessionFactory.getCurrentSession().createQuery(QUERY2,Usuario.class);
		query.setParameter(1, login);
		List<Usuario> respuesta = query.getResultList();
		return !respuesta.isEmpty();
	}
}

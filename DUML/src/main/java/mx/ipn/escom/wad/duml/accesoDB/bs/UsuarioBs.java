package mx.ipn.escom.wad.duml.accesoDB.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.wad.duml.accesoDB.dao.UsuarioDao;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Usuario;

@Service("usuarioBS")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class UsuarioBs {
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Transactional(rollbackFor = Exception.class)
	public Usuario save(Usuario usuario){
		return usuarioDao.save(usuario);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Usuario update(Usuario usuario){
		Usuario model = this.findById(usuario.getId());
		model.setLogin(usuario.getLogin());
		model.setNombre(usuario.getNombre());
		model.setPassword(usuario.getPassword());
		model.setPrimerApellido(usuario.getPrimerApellido());
		model.setSegundoApellido(usuario.getSegundoApellido());
		return usuarioDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Integer id){
		usuarioDao.delete(id);
	}
	
	@Transactional(readOnly = true)
	public Usuario findById(Integer id){
		return usuarioDao.findById(id);
	}
	
	@Transactional(readOnly = true)
	public Usuario findByLogin(String login, String pass){
		return usuarioDao.findByLogin(login, pass);
	}

	/**
	 * @return the usuarioDao
	 */
	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	/**
	 * @param usuarioDao the usuarioDao to set
	 */
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
}

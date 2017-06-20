package mx.ipn.escom.wad.duml.accesoDB.bs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.wad.duml.accesoDB.dao.EmpresaUsuarioDao;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.EmpresaUsuario;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.EmpresaUsuarioId;

@Service("empresaUsuarioBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class EmpresaUsuarioBs {
	@Autowired
	private EmpresaUsuarioDao empresaUsuarioDao;
	
	@Transactional(rollbackFor = Exception.class)
	public EmpresaUsuario save(EmpresaUsuario empresaUsuario){
		return empresaUsuarioDao.save(empresaUsuario);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public EmpresaUsuario update(EmpresaUsuario empresaUsuario){
		EmpresaUsuario model = this.findById(empresaUsuario.getId());
		model.setIdEmpresa(empresaUsuario.getId().getIdEmpresa());
		model.setIdUsuario(empresaUsuario.getId().getIdUsuario());
		model.setEmpresaObj(empresaUsuario.getEmpresaObj());
		model.setUsuarioObj(empresaUsuario.getUsuarioObj());
		return empresaUsuarioDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(EmpresaUsuarioId id){
		empresaUsuarioDao.delete(id);
	}
	
	@Transactional(readOnly = true)
	public EmpresaUsuario findById(EmpresaUsuarioId id){
		return empresaUsuarioDao.findById(id);
	}

	@Transactional(readOnly = true)
	public List<EmpresaUsuario> findByIdUsuario(Integer id){
		return empresaUsuarioDao.findByIdUsuario(id);
	}
	/**
	 * @return the empresaUsuarioDao
	 */
	public EmpresaUsuarioDao getEmpresaUsuarioDao() {
		return empresaUsuarioDao;
	}

	/**
	 * @param empresaUsuarioDao the empresaUsuarioDao to set
	 */
	public void setEmpresaUsuarioDao(EmpresaUsuarioDao empresaUsuarioDao) {
		this.empresaUsuarioDao = empresaUsuarioDao;
	}
}

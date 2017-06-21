package mx.ipn.escom.wad.duml.accesoDB.bs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.wad.duml.accesoDB.dao.EmpresaDao;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Empresa;

@Service("empresaBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class EmpresaBs {
	@Autowired
	private EmpresaDao empresaDao;
	
	@Transactional(rollbackFor = Exception.class)
	public Empresa save(Empresa empresa){
		return empresaDao.save(empresa);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Empresa update(Empresa empresa){
		Empresa model = this.findById(empresa.getId());
		model.setNombre(empresa.getNombre());
		model.setRfc(empresa.getRfc());
		return empresaDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Integer id){
		empresaDao.delete(id);
	}
	
	@Transactional(readOnly = true)
	public Empresa findById(Integer id){
		return empresaDao.findById(id);
	}
	
	@Transactional(readOnly = true)
	public List<Empresa> getEmpresas(){
		return empresaDao.getEmpresas();
	}

	/**
	 * @return the empresaDao
	 */
	public EmpresaDao getEmpresaDao() {
		return empresaDao;
	}

	/**
	 * @param empresaDao the empresaDao to set
	 */
	public void setEmpresaDao(EmpresaDao empresaDao) {
		this.empresaDao = empresaDao;
	}
}

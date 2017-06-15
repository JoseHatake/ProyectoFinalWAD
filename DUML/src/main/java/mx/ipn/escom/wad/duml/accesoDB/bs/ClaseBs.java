package mx.ipn.escom.wad.duml.accesoDB.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.wad.duml.accesoDB.dao.ClaseDao;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Clase;

@Service("claseBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class ClaseBs {
	@Autowired
	private ClaseDao claseDao;
	
	@Transactional(rollbackFor = Exception.class)
	public Clase save(Clase clase){
		return claseDao.save(clase);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Clase update(Clase clase){
		Clase model = this.findById(clase.getId());
		model.setIdDiagrama(clase.getIdDiagrama());
		model.setDiagramaObj(clase.getDiagramaObj());
		return claseDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Integer id){
		claseDao.delete(id);
	}
	
	@Transactional(readOnly = true)
	public Clase findById(Integer id){
		return claseDao.findById(id);
	}

	/**
	 * @return the claseDao
	 */
	public ClaseDao getClaseDao() {
		return claseDao;
	}

	/**
	 * @param claseDao the claseDao to set
	 */
	public void setClaseDao(ClaseDao claseDao) {
		this.claseDao = claseDao;
	}
}

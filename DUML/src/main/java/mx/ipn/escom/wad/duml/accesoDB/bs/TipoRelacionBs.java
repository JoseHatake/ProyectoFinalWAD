package mx.ipn.escom.wad.duml.accesoDB.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.wad.duml.accesoDB.dao.TipoRelacionDao;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.TipoRelacion;

@Service("tipoRelacionBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class TipoRelacionBs {
	@Autowired
	private TipoRelacionDao tipoRelacionDao;
	
	@Transactional(rollbackFor = Exception.class)
	public TipoRelacion save(TipoRelacion tipoRelacion){
		return tipoRelacionDao.save(tipoRelacion);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public TipoRelacion update(TipoRelacion tipoRelacion){
		TipoRelacion model = this.findById(tipoRelacion.getId());
		model.setNombre(tipoRelacion.getNombre());
		return tipoRelacionDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Integer id){
		tipoRelacionDao.delete(id);
	}
	
	@Transactional(readOnly = true)
	public TipoRelacion findById(Integer id){
		return tipoRelacionDao.findById(id);
	}

	/**
	 * @return the tipoRelacionDao
	 */
	public TipoRelacionDao getTipoRelacionDao() {
		return tipoRelacionDao;
	}

	/**
	 * @param tipoRelacionDao the tipoRelacionDao to set
	 */
	public void setTipoRelacionDao(TipoRelacionDao tipoRelacionDao) {
		this.tipoRelacionDao = tipoRelacionDao;
	}
}

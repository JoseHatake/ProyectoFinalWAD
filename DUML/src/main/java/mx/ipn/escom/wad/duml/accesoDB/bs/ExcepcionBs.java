package mx.ipn.escom.wad.duml.accesoDB.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.wad.duml.accesoDB.dao.ExcepcionDao;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Excepcion;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.ExcepcionId;

@Service("excepcionBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class ExcepcionBs {
	@Autowired
	private ExcepcionDao excepcionDao;
	
	@Transactional(rollbackFor = Exception.class)
	public Excepcion save(Excepcion excepcion){
		return excepcionDao.save(excepcion);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Excepcion update(Excepcion excepcion){
		Excepcion model = this.findById(excepcion.getId());
		model.setIdClase(excepcion.getIdClase());
		model.setIdExcepcion(excepcion.getIdExcepcion());
		model.setIdMetodo(excepcion.getIdMetodo());
		model.setIdTipo(excepcion.getIdTipo());
		model.setMetodoObj(excepcion.getMetodoObj());
		model.setTipoDatoObj(excepcion.getTipoDatoObj());
		return excepcionDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(ExcepcionId id){
		excepcionDao.delete(id);
	}
	
	@Transactional(readOnly = true)
	public Excepcion findById(ExcepcionId id){
		return excepcionDao.findById(id);
	}

	/**
	 * @return the excepcionDao
	 */
	public ExcepcionDao getExcepcionDao() {
		return excepcionDao;
	}

	/**
	 * @param excepcionDao the excepcionDao to set
	 */
	public void setExcepcionDao(ExcepcionDao excepcionDao) {
		this.excepcionDao = excepcionDao;
	}
}

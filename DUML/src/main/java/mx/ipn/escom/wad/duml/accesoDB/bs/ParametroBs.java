package mx.ipn.escom.wad.duml.accesoDB.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.wad.duml.accesoDB.dao.ParametroDao;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Parametro;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.ParametroId;

@Service("parametroBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class ParametroBs {
	@Autowired
	private ParametroDao parametroDao;
	
	@Transactional(rollbackFor = Exception.class)
	public Parametro save(Parametro parametro){
		return parametroDao.save(parametro);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Parametro update(Parametro parametro){
		Parametro model = this.findById(parametro.getId());
		model.setIdClase(parametro.getIdClase());
		model.setIdMetodo(parametro.getIdMetodo());
		model.setIdTipo(parametro.getIdTipo());
		model.setNombre(parametro.getNombre());
		model.setMetodoObj(parametro.getMetodoObj());
		model.setTipoDatoObj(parametro.getTipoDatoObj());
		return parametroDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(ParametroId id){
		parametroDao.delete(id);
	}
	
	@Transactional(readOnly = true)
	public Parametro findById(ParametroId id){
		return parametroDao.findById(id);
	}

	/**
	 * @return the parametroDao
	 */
	public ParametroDao getParametroDao() {
		return parametroDao;
	}

	/**
	 * @param parametroDao the parametroDao to set
	 */
	public void setParametroDao(ParametroDao parametroDao) {
		this.parametroDao = parametroDao;
	}
}

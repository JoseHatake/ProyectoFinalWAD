package mx.ipn.escom.wad.duml.accesoDB.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.wad.duml.accesoDB.dao.MetodoDao;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Metodo;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.MetodoId;

@Service("metodoBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class MetodoBs {
	@Autowired
	private MetodoDao metodoDao;
	
	@Transactional(rollbackFor = Exception.class)
	public Metodo save(Metodo metodo){
		return metodoDao.save(metodo);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Metodo update(Metodo metodo){
		Metodo model = this.findById(metodo.getId());
		model.setIdClase(metodo.getIdClase());
		model.setIdMetodo(metodo.getIdMetodo());
		model.setIdAcceso(metodo.getIdAcceso());
		model.setIdAlcance(metodo.getIdAlcance());
		model.setIdTipo(metodo.getIdTipo());
		model.setNombre(metodo.getNombre());
		model.setAccesoObj(metodo.getAccesoObj());
		model.setAlcanceObj(metodo.getAlcanceObj());
		model.setClaseObj(metodo.getClaseObj());
		model.setTipoDatoObj(metodo.getTipoDatoObj());
		return metodoDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(MetodoId id){
		metodoDao.delete(id);
	}
	
	@Transactional(readOnly = true)
	public Metodo findById(MetodoId id){
		return metodoDao.findById(id);
	}

	/**
	 * @return the metodoDao
	 */
	public MetodoDao getMetodoDao() {
		return metodoDao;
	}

	/**
	 * @param metodoDao the metodoDao to set
	 */
	public void setMetodoDao(MetodoDao metodoDao) {
		this.metodoDao = metodoDao;
	}
}

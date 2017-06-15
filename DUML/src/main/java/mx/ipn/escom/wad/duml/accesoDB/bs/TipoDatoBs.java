package mx.ipn.escom.wad.duml.accesoDB.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.wad.duml.accesoDB.dao.TipoDatoDao;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.TipoDato;

@Service("tipoDatoBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class TipoDatoBs {
	@Autowired
	private TipoDatoDao tipoDatoDao;
	
	@Transactional(rollbackFor = Exception.class)
	public TipoDato save(TipoDato tipoDato){
		return tipoDatoDao.save(tipoDato);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public TipoDato update(TipoDato tipoDato){
		TipoDato model = this.findById(tipoDato.getId());
		model.setNombre(tipoDato.getNombre());
		model.setPrimitivo(tipoDato.getPrimitivo());
		return tipoDatoDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Integer id){
		tipoDatoDao.delete(id);
	}
	
	@Transactional(readOnly = true)
	public TipoDato findById(Integer id){
		return tipoDatoDao.findById(id);
	}

	/**
	 * @return the tipoDatoDao
	 */
	public TipoDatoDao getTipoDatoDao() {
		return tipoDatoDao;
	}

	/**
	 * @param tipoDatoDao the tipoDatoDao to set
	 */
	public void setTipoDatoDao(TipoDatoDao tipoDatoDao) {
		this.tipoDatoDao = tipoDatoDao;
	}
}

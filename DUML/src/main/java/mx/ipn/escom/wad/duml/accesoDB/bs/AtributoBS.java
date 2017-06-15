package mx.ipn.escom.wad.duml.accesoDB.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.wad.duml.accesoDB.dao.AtributoDao;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Atributo;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.AtributoId;

@Service("atributoBS")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class AtributoBS {
	@Autowired
	private AtributoDao atributoDao;
	
	@Transactional(rollbackFor = Exception.class)
	public Atributo save(Atributo atributo){
		return atributoDao.save(atributo);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Atributo update(Atributo atributo){
		Atributo model = this.findById(atributo.getId());
		model.setIdClase(atributo.getId().getIdClase());
		model.setIdAtributo(atributo.getId().getIdAtributo());
		model.setIdAcceso(atributo.getIdAcceso());
		model.setIdAlcance(atributo.getIdAlcance());
		model.setTipo(atributo.getTipo());
		model.setNombre(atributo.getNombre());
		model.setValor(atributo.getValor());
		model.setAccesoObj(atributo.getAccesoObj());
		model.setAlcanceObj(atributo.getAlcanceObj());
		model.setTipoObj(atributo.getTipoObj());
		model.setClaseObj(atributo.getClaseObj());
		return atributoDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(AtributoId id){
		atributoDao.delete(id);
	}
	
	@Transactional(readOnly = true)
	public Atributo findById(AtributoId id){
		return atributoDao.findById(id);
	}

	/**
	 * @return the atributoDao
	 */
	public AtributoDao getAtributoDao() {
		return atributoDao;
	}

	/**
	 * @param atributoDao the atributoDao to set
	 */
	public void setAtributoDao(AtributoDao atributoDao) {
		this.atributoDao = atributoDao;
	}
}

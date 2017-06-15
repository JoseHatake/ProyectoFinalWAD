package mx.ipn.escom.wad.duml.accesoDB.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.wad.duml.accesoDB.dao.AlcanceDao;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Alcance;

@Service("alcanceBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class AlcanceBs {
	@Autowired
	private AlcanceDao alcanceDao;
	
	@Transactional(rollbackFor = Exception.class)
	public Alcance save(Alcance alcance){
		return alcanceDao.save(alcance);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Alcance update(Alcance alcance){
		Alcance model = this.findById(alcance.getId());
		model.setNombre(alcance.getNombre());
		return alcanceDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Integer id){
		alcanceDao.delete(id);
	}
	
	@Transactional(readOnly = true)
	public Alcance findById(Integer id){
		return alcanceDao.findById(id);
	}

	/**
	 * @return the alcanceDao
	 */
	public AlcanceDao getAlcanceDao() {
		return alcanceDao;
	}

	/**
	 * @param alcanceDao the alcanceDao to set
	 */
	public void setAlcanceDao(AlcanceDao alcanceDao) {
		this.alcanceDao = alcanceDao;
	}
}

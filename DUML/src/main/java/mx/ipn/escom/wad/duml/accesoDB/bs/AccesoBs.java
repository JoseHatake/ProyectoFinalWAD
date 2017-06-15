package mx.ipn.escom.wad.duml.accesoDB.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.ipn.escom.wad.duml.accesoDB.dao.AccesoDao;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Acceso;

@Service("accesoBd")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class AccesoBs {
	@Autowired
	private AccesoDao accesoDao;
	
	@Transactional(rollbackFor = Exception.class)
	public Acceso save(Acceso acceso){
		return accesoDao.save(acceso);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Acceso update(Acceso acceso){
		Acceso model = this.findById(acceso.getId());
		model.setNombre(acceso.getNombre());
		return accesoDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Integer id){
		accesoDao.delete(id);
	}
	
	@Transactional(readOnly = true)
	public Acceso findById(Integer id){
		return accesoDao.findById(id);
	}

	/**
	 * @return the accesoDao
	 */
	public AccesoDao getAccesoDao() {
		return accesoDao;
	}

	/**
	 * @param accesoDao the accesoDao to set
	 */
	public void setAccesoDao(AccesoDao accesoDao) {
		this.accesoDao = accesoDao;
	}
}

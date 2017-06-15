package mx.ipn.escom.wad.duml.accesoDB.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.wad.duml.accesoDB.dao.RelacionDao;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Relacion;

@Service("relacionBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class RelacionBs {
	@Autowired
	private RelacionDao relacionDao;
	
	@Transactional(rollbackFor = Exception.class)
	public Relacion save(Relacion relacion){
		return relacionDao.save(relacion);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Relacion update(Relacion relacion){
		Relacion model = this.findById(relacion.getIdRelacion());
		model.setIdDestido(relacion.getIdDestido());
		model.setIdDiagrama(relacion.getIdDiagrama());
		model.setIdOrigen(relacion.getIdOrigen());
		model.setIdTipo(relacion.getIdTipo());
		model.setClaseOrigenObj(relacion.getClaseOrigenObj());
		model.setClaseDestinoObj(relacion.getClaseDestinoObj());
		model.setDiagramaObj(relacion.getDiagramaObj());
		model.setTipoRelacionObj(relacion.getTipoRelacionObj());
		return relacionDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Integer id){
		relacionDao.delete(id);
	}
	
	@Transactional(readOnly = true)
	public Relacion findById(Integer id){
		return relacionDao.findById(id);
	}

	/**
	 * @return the relacionDao
	 */
	public RelacionDao getRelacionDao() {
		return relacionDao;
	}

	/**
	 * @param relacionDao the relacionDao to set
	 */
	public void setRelacionDao(RelacionDao relacionDao) {
		this.relacionDao = relacionDao;
	}
}

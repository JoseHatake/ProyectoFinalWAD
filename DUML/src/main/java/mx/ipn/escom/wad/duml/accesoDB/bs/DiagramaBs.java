package mx.ipn.escom.wad.duml.accesoDB.bs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.wad.duml.accesoDB.dao.DiagramaDao;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Diagrama;

@Service("diagramaBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class DiagramaBs {
	@Autowired
	private DiagramaDao diagramaDao;
	
	@Transactional(rollbackFor = Exception.class)
	public Diagrama save(Diagrama diagrama){
		return diagramaDao.save(diagrama);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Diagrama update(Diagrama diagrama){
		Diagrama model = this.findById(diagrama.getId());
		model.setIdEmpresa(diagrama.getIdEmpresa());
		model.setIdUsuario(diagrama.getIdUsuario());
		model.setNombre(diagrama.getNombre());
		model.setPath(diagrama.getPath());
		model.setEmpresaObj(diagrama.getEmpresaObj());
		model.setUsuarioObj(diagrama.getUsuarioObj());
		return diagramaDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Integer id){
		diagramaDao.delete(id);
	}
	
	@Transactional(readOnly = true)
	public Diagrama findById(Integer id){
		return diagramaDao.findById(id);
	}
	
	@Transactional(readOnly = true)
	public List<Diagrama> findByIDS(Integer idUsuario, Integer idEmpresa){
		return diagramaDao.findByIDS(idUsuario, idEmpresa);
	}
	
	@Transactional(readOnly = true)
	public Boolean existeDiagrama(Integer idEmpresa, String nombre){
		return diagramaDao.existeDiagrama(idEmpresa, nombre);
	}


	/**
	 * @return the diagramaDao
	 */
	public DiagramaDao getDiagramaDao() {
		return diagramaDao;
	}

	/**
	 * @param diagramaDao the diagramaDao to set
	 */
	public void setDiagramaDao(DiagramaDao diagramaDao) {
		this.diagramaDao = diagramaDao;
	}
}

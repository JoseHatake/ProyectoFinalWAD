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
	
	public Atributo update(Atributo atributo){
		Atributo model = this.findById(atributo.getId());
		model.set
	}
	
	@Transactional(readOnly = true)
	public Atributo findById(AtributoId id){
		return atributoDao.findById(id);
	}
}

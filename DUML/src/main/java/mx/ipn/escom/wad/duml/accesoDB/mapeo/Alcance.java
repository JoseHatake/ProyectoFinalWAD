package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alcance")
public class Alcance {
	@Id
	@Column(name = "id_alcance")
	private Integer id;
	
	@Column(name = "nb_alcance")
	private Integer nombre;
}

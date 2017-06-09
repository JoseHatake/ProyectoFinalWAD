package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "acceso")
public class Acceso {
	@Id
	@Column(name = "id_acceso")
	private Integer id;

	@Column(name = "nb_acceso")
	private Integer nombre;
}

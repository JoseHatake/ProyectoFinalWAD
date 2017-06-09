package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_relacion")
public class TipoRelacion {
	@Id
	@Column(name = "id_tipo")
	private Integer id;

	@Column(name = "nb_tipo")
	private String nombre;
}

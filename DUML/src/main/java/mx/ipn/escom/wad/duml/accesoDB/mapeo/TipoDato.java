package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_dato")
@Inheritance(strategy = InheritanceType.JOINED)
public class TipoDato {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tipo")
	private Integer id;

	@Column(name = "nb_tipo")
	private String nombre;

	@Column(name = "st_primitivo")
	private Boolean primitivo;
}

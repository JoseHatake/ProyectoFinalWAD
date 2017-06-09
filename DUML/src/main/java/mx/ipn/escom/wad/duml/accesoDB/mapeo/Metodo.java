package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "metodo")
public class Metodo {
	@EmbeddedId
	private MetodoId id;
	
	@Column(name = "id_clase", insertable = false, updatable = false)
	private Integer idClase;

	@Column(name = "id_metodo", insertable = false, updatable = false)
	private Integer idMetodo;

	@Column(name = "id_acceso")
	private Integer idAcceso;

	@Column(name = "id_alcance")
	private Integer idAlcance;

	@Column(name = "id_tipo")
	private Integer idTipo;

	@Column(name = "nb_metodo")
	private String nombre;
}

package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "atributo")
public class Atributo {
	@EmbeddedId
	private AtributoId id;

	@Column(name = "id_clase", insertable = false, updatable = false)
	private Integer idClase;

	@Column(name = "id_atributo", insertable = false, updatable = false)
	private Integer idAtributo;

	@Column(name = "id_acceso")
	private Integer idAcceso;

	@Column(name = "id_alcance")
	private Integer idAlcance;

	@Column(name = "id_tipo")
	private Integer tipo;

	@Column(name = "nb_atributo")
	private String nombre;

	@Column(name = "tx_valor")
	private String valor;
}

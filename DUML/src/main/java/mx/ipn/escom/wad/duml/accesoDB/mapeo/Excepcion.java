package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;

public class Excepcion {
	@EmbeddedId
	private ExcepcionId id;

	@Column(name = "id_clase", insertable = false, updatable = false)
	private Integer idClase;

	@Column(name = "id_metodo", insertable = false, updatable = false)
	private Integer idMetodo;

	@Column(name = "id_excepcion", insertable = false, updatable = false)
	private Integer idExcepcion;

	@Column(name = "id_tipo")
	private Integer idTipo;
}

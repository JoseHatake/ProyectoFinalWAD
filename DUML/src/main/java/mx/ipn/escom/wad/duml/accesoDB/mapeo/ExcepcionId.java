package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import javax.persistence.Column;

public class ExcepcionId {
	@Column(name = "id_clase", nullable = false)
	private Integer idClase;

	@Column(name = "id_metodo", nullable = false)
	private Integer idMetodo;

	@Column(name = "id_excepcion", nullable = false)
	private Integer idExcepcion;
}

package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import javax.persistence.Column;

public class AtributoId {
	@Column(name = "id_clase", nullable = false)
	private Integer idClase;

	@Column(name = "id_atributo", nullable = false)
	private Integer idAtributo;
}

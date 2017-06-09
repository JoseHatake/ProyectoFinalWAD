package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MetodoId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "id_clase", nullable = false)
	private Integer idClase;

	@Column(name = "id_metodo", nullable = false)
	private Integer idMetodo;
}

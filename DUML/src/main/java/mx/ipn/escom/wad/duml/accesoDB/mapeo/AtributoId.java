package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import javax.persistence.Column;

public class AtributoId {
	@Column(name = "id_clase", nullable = false)
	private Integer idClase;

	@Column(name = "id_atributo", nullable = false)
	private Integer idAtributo;

	/**
	 * @return the idClase
	 */
	public Integer getIdClase() {
		return idClase;
	}

	/**
	 * @param idClase the idClase to set
	 */
	public void setIdClase(Integer idClase) {
		this.idClase = idClase;
	}

	/**
	 * @return the idAtributo
	 */
	public Integer getIdAtributo() {
		return idAtributo;
	}

	/**
	 * @param idAtributo the idAtributo to set
	 */
	public void setIdAtributo(Integer idAtributo) {
		this.idAtributo = idAtributo;
	}
}

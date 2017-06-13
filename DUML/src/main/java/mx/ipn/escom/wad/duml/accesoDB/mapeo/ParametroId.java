package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ParametroId implements Serializable {
	/**
	 *
	 **/
	private static final long serialVersionUID = 1L;

	@Column(name = "id_clase", nullable = false)
	private Integer idClase;

	@Column(name = "id_metodo", nullable = false)
	private Integer idMetodo;

	@Column(name = "id_parametro", nullable = false)
	private Integer idParametro;

	public ParametroId() {
		super();
	}

	public ParametroId(Integer idClase, Integer idMetodo, Integer idParametro) {
		super();
		this.idClase = idClase;
		this.idMetodo = idMetodo;
		this.idParametro = idParametro;
	}

	/**
	 * @return the idClase
	 */
	public Integer getIdClase() {
		return idClase;
	}

	/**
	 * @param idClase
	 *            the idClase to set
	 */
	public void setIdClase(Integer idClase) {
		this.idClase = idClase;
	}

	/**
	 * @return the idMetodo
	 */
	public Integer getIdMetodo() {
		return idMetodo;
	}

	/**
	 * @param idMetodo
	 *            the idMetodo to set
	 */
	public void setIdMetodo(Integer idMetodo) {
		this.idMetodo = idMetodo;
	}

	public Integer getIdParametro() {
		return idParametro;
	}

	public void setIdParametro(Integer idParametro) {
		this.idParametro = idParametro;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

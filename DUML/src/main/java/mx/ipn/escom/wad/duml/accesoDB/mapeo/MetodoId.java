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
	
	public MetodoId() {
		super();
	}
	
	public MetodoId(Integer idClase, Integer idMetodo) {
		super();
		this.idClase = idClase;
		this.idMetodo = idMetodo;
	}

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
	 * @return the idMetodo
	 */
	public Integer getIdMetodo() {
		return idMetodo;
	}

	/**
	 * @param idMetodo the idMetodo to set
	 */
	public void setIdMetodo(Integer idMetodo) {
		this.idMetodo = idMetodo;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

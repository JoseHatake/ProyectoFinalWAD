package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import javax.persistence.Column;

public class ExcepcionId {
	@Column(name = "id_clase", nullable = false)
	private Integer idClase;

	@Column(name = "id_metodo", nullable = false)
	private Integer idMetodo;

	@Column(name = "id_excepcion", nullable = false)
	private Integer idExcepcion;
	
	public ExcepcionId() {
		super();
	}

	public ExcepcionId(Integer idClase, Integer idMetodo) {
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
	 * @return the idExcepcion
	 */
	public Integer getIdExcepcion() {
		return idExcepcion;
	}

	/**
	 * @param idExcepcion the idExcepcion to set
	 */
	public void setIdExcepcion(Integer idExcepcion) {
		this.idExcepcion = idExcepcion;
	}
}

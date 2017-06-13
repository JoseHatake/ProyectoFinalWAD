package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_metodo", referencedColumnName = "id_metodo", insertable = false, updatable = false)
	private Metodo metodoObj;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo", insertable = false, updatable = false)
	private TipoDato tipoDatoObj;
	
	public Excepcion(){
		super();
	}
	
	public Excepcion(Integer idClase, Integer idMetodo){
		super();
		this.id = new ExcepcionId(idClase,idMetodo);
		this.idClase = idClase;
		this.idMetodo = idMetodo;
	}

	/**
	 * @return the id
	 */
	public ExcepcionId getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ExcepcionId id) {
		this.id = id;
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

	/**
	 * @return the idTipo
	 */
	public Integer getIdTipo() {
		return idTipo;
	}

	/**
	 * @param idTipo the idTipo to set
	 */
	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	/**
	 * @return the metodoObj
	 */
	public Metodo getMetodoObj() {
		return metodoObj;
	}

	/**
	 * @param metodoObj the metodoObj to set
	 */
	public void setMetodoObj(Metodo metodoObj) {
		this.metodoObj = metodoObj;
	}

	/**
	 * @return the tipoDatoObj
	 */
	public TipoDato getTipoDatoObj() {
		return tipoDatoObj;
	}

	/**
	 * @param tipoDatoObj the tipoDatoObj to set
	 */
	public void setTipoDatoObj(TipoDato tipoDatoObj) {
		this.tipoDatoObj = tipoDatoObj;
	}
}

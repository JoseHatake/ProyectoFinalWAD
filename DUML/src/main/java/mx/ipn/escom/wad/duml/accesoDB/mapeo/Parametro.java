package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "parametro")
public class Parametro {
	@EmbeddedId
	private ParametroId id;
	
	@Column(name = "id_parametro")
	private Integer idParametro;
	
	@Column(name = "id_clase")
	private Integer idClase;
	
	@Column(name = "id_metodo")
	private Integer idMetodo;
	
	@Column(name = "id_tipo_dato")
	private Integer idTipo;
	
	@Column(name = "nb_parametro")
	private String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_metodo", referencedColumnName = "id_metodo", insertable = false, updatable = false)
	private Metodo metodoObj;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_dato", referencedColumnName = "id_tipo", insertable = false, updatable = false)
	private TipoDato tipoDatoObj;
	
	public Parametro() {
		super();
	}
	
	public Parametro(Integer idClase, Integer idMetodo) {
		super();
		this.id = new ParametroId(idClase,idMetodo);
		this.idClase = idClase;
		this.idMetodo = idMetodo;
	}

	/**
	 * @return the id
	 */
	public ParametroId getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ParametroId id) {
		this.id = id;
	}

	/**
	 * @return the idParametro
	 */
	public Integer getIdParametro() {
		return idParametro;
	}

	/**
	 * @param idParametro the idParametro to set
	 */
	public void setIdParametro(Integer idParametro) {
		this.idParametro = idParametro;
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
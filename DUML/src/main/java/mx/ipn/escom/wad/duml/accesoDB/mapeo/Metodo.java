package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "metodo")
public class Metodo {
	@EmbeddedId
	private MetodoId id;
	
	@Column(name = "id_clase", insertable = false, updatable = false)
	private Integer idClase;

	@Column(name = "id_metodo", insertable = false, updatable = false)
	private Integer idMetodo;

	@Column(name = "id_acceso")
	private Integer idAcceso;

	@Column(name = "id_alcance")
	private Integer idAlcance;

	@Column(name = "id_tipo")
	private Integer idTipo;

	@Column(name = "nb_metodo")
	private String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_clase", referencedColumnName = "id_clase", insertable = false, updatable = false)
	private Clase claseObj;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_acceso", referencedColumnName = "id_acceso", insertable = false, updatable = false)
	private Acceso accesoObj;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_alcance", referencedColumnName = "id_alcance", insertable = false, updatable = false)
	private Alcance alcanceObj;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo", insertable = false, updatable = false)
	private TipoDato tipoDatoObj;
	
	public Metodo() {
		super();
	}
	
	public Metodo(Integer idClase, Integer idMetodo) {
		super();
		this.id = new MetodoId(idClase,idMetodo);
		this.idClase = idClase;
		this.idMetodo = idMetodo;
	}

	/**
	 * @return the id
	 */
	public MetodoId getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(MetodoId id) {
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
	 * @return the idAcceso
	 */
	public Integer getIdAcceso() {
		return idAcceso;
	}

	/**
	 * @param idAcceso the idAcceso to set
	 */
	public void setIdAcceso(Integer idAcceso) {
		this.idAcceso = idAcceso;
	}

	/**
	 * @return the idAlcance
	 */
	public Integer getIdAlcance() {
		return idAlcance;
	}

	/**
	 * @param idAlcance the idAlcance to set
	 */
	public void setIdAlcance(Integer idAlcance) {
		this.idAlcance = idAlcance;
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
	 * @return the claseObj
	 */
	public Clase getClaseObj() {
		return claseObj;
	}

	/**
	 * @param claseObj the claseObj to set
	 */
	public void setClaseObj(Clase claseObj) {
		this.claseObj = claseObj;
	}

	/**
	 * @return the accesoObj
	 */
	public Acceso getAccesoObj() {
		return accesoObj;
	}

	/**
	 * @param accesoObj the accesoObj to set
	 */
	public void setAccesoObj(Acceso accesoObj) {
		this.accesoObj = accesoObj;
	}

	/**
	 * @return the alcanceObj
	 */
	public Alcance getAlcanceObj() {
		return alcanceObj;
	}

	/**
	 * @param alcanceObj the alcanceObj to set
	 */
	public void setAlcanceObj(Alcance alcanceObj) {
		this.alcanceObj = alcanceObj;
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

package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "atributo")
public class Atributo {
	@EmbeddedId
	private AtributoId id;

	@Column(name = "id_clase", insertable = false, updatable = false)
	private Integer idClase;

	@Column(name = "id_atributo", insertable = false, updatable = false)
	private Integer idAtributo;

	@Column(name = "id_acceso")
	private Integer idAcceso;

	@Column(name = "id_alcance")
	private Integer idAlcance;

	@Column(name = "id_tipo")
	private Integer tipo;

	@Column(name = "nb_atributo")
	private String nombre;

	@Column(name = "tx_valor")
	private String valor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_acceso", referencedColumnName = "id_acceso", insertable = false, updatable = false)
	private Acceso accesoObj;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_alcance", referencedColumnName = "id_alcance", insertable = false, updatable = false)
	private Alcance alcanceObj;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_dato", referencedColumnName = "id_tipo", insertable = false, updatable = false)
	private TipoDato tipoObj;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_clase", referencedColumnName = "id_clase", insertable = false, updatable = false)
	private Clase claseObj;

	/**
	 * @return the id
	 */
	public AtributoId getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(AtributoId id) {
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
	 * @return the tipo
	 */
	public Integer getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
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
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
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
	 * @return the tipoObj
	 */
	public TipoDato getTipoObj() {
		return tipoObj;
	}

	/**
	 * @param tipoObj the tipoObj to set
	 */
	public void setTipoObj(TipoDato tipoObj) {
		this.tipoObj = tipoObj;
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
}

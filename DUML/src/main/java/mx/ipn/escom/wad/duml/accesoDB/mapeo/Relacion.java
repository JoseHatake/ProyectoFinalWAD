package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "relacion")
public class Relacion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_relacion")
	private Integer idRelacion;

	@Column(name = "id_diagrama")
	private Integer idDiagrama;

	@Column(name = "id_tipo")
	private Integer idTipo;

	@Column(name = "id_origen")
	private Integer idOrigen;

	@Column(name = "id_destino")
	private Integer idDestido;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_diagrama", referencedColumnName = "id_diagrama", insertable = false, updatable = false)
	private Diagrama diagramaObj;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo", insertable = false, updatable = false)
	private TipoRelacion tipoRelacionObj;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_origen", referencedColumnName = "id_clase", insertable = false, updatable = false)
	private Clase claseOrigenObj;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_destino", referencedColumnName = "id_clase", insertable = false, updatable = false)
	private Clase claseDestinoObj;

	/**
	 * @return the idRelacion
	 */
	public Integer getIdRelacion() {
		return idRelacion;
	}

	/**
	 * @param idRelacion the idRelacion to set
	 */
	public void setIdRelacion(Integer idRelacion) {
		this.idRelacion = idRelacion;
	}

	/**
	 * @return the idDiagrama
	 */
	public Integer getIdDiagrama() {
		return idDiagrama;
	}

	/**
	 * @param idDiagrama the idDiagrama to set
	 */
	public void setIdDiagrama(Integer idDiagrama) {
		this.idDiagrama = idDiagrama;
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
	 * @return the idOrigen
	 */
	public Integer getIdOrigen() {
		return idOrigen;
	}

	/**
	 * @param idOrigen the idOrigen to set
	 */
	public void setIdOrigen(Integer idOrigen) {
		this.idOrigen = idOrigen;
	}

	/**
	 * @return the idDestido
	 */
	public Integer getIdDestido() {
		return idDestido;
	}

	/**
	 * @param idDestido the idDestido to set
	 */
	public void setIdDestido(Integer idDestido) {
		this.idDestido = idDestido;
	}

	/**
	 * @return the diagramaObj
	 */
	public Diagrama getDiagramaObj() {
		return diagramaObj;
	}

	/**
	 * @param diagramaObj the diagramaObj to set
	 */
	public void setDiagramaObj(Diagrama diagramaObj) {
		this.diagramaObj = diagramaObj;
	}

	/**
	 * @return the tipoRelacionObj
	 */
	public TipoRelacion getTipoRelacionObj() {
		return tipoRelacionObj;
	}

	/**
	 * @param tipoRelacionObj the tipoRelacionObj to set
	 */
	public void setTipoRelacionObj(TipoRelacion tipoRelacionObj) {
		this.tipoRelacionObj = tipoRelacionObj;
	}

	/**
	 * @return the claseOrigenObj
	 */
	public Clase getClaseOrigenObj() {
		return claseOrigenObj;
	}

	/**
	 * @param claseOrigenObj the claseOrigenObj to set
	 */
	public void setClaseOrigenObj(Clase claseOrigenObj) {
		this.claseOrigenObj = claseOrigenObj;
	}

	/**
	 * @return the claseDestinoObj
	 */
	public Clase getClaseDestinoObj() {
		return claseDestinoObj;
	}

	/**
	 * @param claseDestinoObj the claseDestinoObj to set
	 */
	public void setClaseDestinoObj(Clase claseDestinoObj) {
		this.claseDestinoObj = claseDestinoObj;
	}
}

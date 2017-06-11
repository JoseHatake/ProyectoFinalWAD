package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "clase")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "id_clase", referencedColumnName = "id_tipo")
public class Clase {
	@Column(name = "id_diagrama")
	private Integer idDiagrama;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_diagrama", referencedColumnName = "id_diagrama", insertable = false, updatable = false)
	private Diagrama diagramaObj;

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
}

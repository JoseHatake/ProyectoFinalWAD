package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}

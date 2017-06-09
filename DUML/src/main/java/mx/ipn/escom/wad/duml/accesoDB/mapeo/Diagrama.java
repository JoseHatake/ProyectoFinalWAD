package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "diagrama")
public class Diagrama {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_diagrama")
	private Integer id;

	@Column(name = "id_empresa")
	private Integer idEmpresa;

	@Column(name = "id_usuario")
	private Integer idUsuario;

	@Column(name = "nb_diagrama")
	private Integer nombre;

	@Column(name = "tx_path")
	private String path;
}

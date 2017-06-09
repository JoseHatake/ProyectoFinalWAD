package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario")
	private Integer id;

	@Column(name = "tx_login")
	private String login;

	@Column(name = "tx_password")
	private String password;

	@Column(name = "nb_usuario")
	private String nombre;

	@Column(name = "tx_primer_ap")
	private String primerApellido;

	@Column(name = "tx_segundo_ap")
	private String segundoApellido;

}

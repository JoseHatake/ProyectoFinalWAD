package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private String nombre;

	@Column(name = "tx_path")
	private String path;

	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
	private Usuario usuarioObj;

	@ManyToOne
	@JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa", insertable = false, updatable = false)
	private Empresa empresaObj;

	public Diagrama() {
		super();
	}

	public Diagrama(Integer idEmpresa, Integer idUsuario, String nombre, String path) {
		super();
		this.idEmpresa = idEmpresa;
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.path = path;
	}



	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the idEmpresa
	 */
	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	/**
	 * @param idEmpresa
	 *            the idEmpresa to set
	 */
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	/**
	 * @return the idUsuario
	 */
	public Integer getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario
	 *            the idUsuario to set
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path
	 *            the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the usuarioObj
	 */
	public Usuario getUsuarioObj() {
		return usuarioObj;
	}

	/**
	 * @param usuarioObj the usuarioObj to set
	 */
	public void setUsuarioObj(Usuario usuarioObj) {
		this.usuarioObj = usuarioObj;
	}

	/**
	 * @return the empresaObj
	 */
	public Empresa getEmpresaObj() {
		return empresaObj;
	}

	/**
	 * @param empresaObj the empresaObj to set
	 */
	public void setEmpresaObj(Empresa empresaObj) {
		this.empresaObj = empresaObj;
	}
}

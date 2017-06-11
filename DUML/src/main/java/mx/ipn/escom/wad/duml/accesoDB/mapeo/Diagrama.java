package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import javax.persistence.Column;
import javax.persistence.Embedded;
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
	
	@Embedded
	private EmpresaUsuario empresaUsuarioObj;
	
	public Diagrama(){
		super();
	}
	
	public Diagrama(Integer idEmpresa, Integer idUsuario) {
		super();
		this.empresaUsuarioObj = new EmpresaUsuario(idEmpresa, idUsuario);
		this.idEmpresa = idEmpresa;
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
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
	 * @param idEmpresa the idEmpresa to set
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
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the nombre
	 */
	public Integer getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(Integer nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the empresaUsuarioObj
	 */
	public EmpresaUsuario getEmpresaUsuarioObj() {
		return empresaUsuarioObj;
	}

	/**
	 * @param empresaUsuarioObj the empresaUsuarioObj to set
	 */
	public void setEmpresaUsuarioObj(EmpresaUsuario empresaUsuarioObj) {
		this.empresaUsuarioObj = empresaUsuarioObj;
	}
}

package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empresa_usuario")
public class EmpresaUsuario {
	@EmbeddedId
	private EmpresaUsuarioId id;

	@Column(name = "id_empresa", insertable = false, updatable = false)
	private Integer idEmpresa;

	@Column(name = "id_usuario", insertable = false, updatable = false)
	private Integer idUsuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa", insertable = false, updatable = false)
	private Empresa empresaObj;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
	private Usuario usuarioObj;

	public EmpresaUsuario() {
		super();
	}

	public EmpresaUsuario(Integer idEmpresa, Integer idUsuario) {
		super();
		this.id = new EmpresaUsuarioId(idEmpresa, idUsuario);
		this.idEmpresa = idEmpresa;
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the id
	 */
	public EmpresaUsuarioId getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(EmpresaUsuarioId id) {
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
}

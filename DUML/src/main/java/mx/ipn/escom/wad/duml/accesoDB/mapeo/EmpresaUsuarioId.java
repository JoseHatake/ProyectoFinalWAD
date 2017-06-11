package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmpresaUsuarioId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "id_empresa", nullable = false)
	private Integer idEmpresa;

	@Column(name = "id_usuario", nullable = false)
	private Integer idUsuario;

	public EmpresaUsuarioId() {
		super();
	}

	public EmpresaUsuarioId(Integer idEmpresa, Integer idUsuario) {
		super();
		this.idEmpresa = idEmpresa;
		this.idUsuario = idUsuario;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

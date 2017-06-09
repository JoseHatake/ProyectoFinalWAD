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
}

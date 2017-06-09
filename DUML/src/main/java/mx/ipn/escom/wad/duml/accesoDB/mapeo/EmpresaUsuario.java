package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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

	public EmpresaUsuario() {
		super();
	}

	public EmpresaUsuario(Integer idEmpresa, Integer idUsuario) {
		super();
		this.id = new EmpresaUsuarioId(idEmpresa, idUsuario);
		this.idEmpresa = idEmpresa;
		this.idUsuario = idUsuario;
	}
}

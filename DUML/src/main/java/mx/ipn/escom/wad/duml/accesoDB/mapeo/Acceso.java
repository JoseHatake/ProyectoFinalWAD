package mx.ipn.escom.wad.duml.accesoDB.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "acceso")
public class Acceso {
	@Id
	@Column(name = "id_acceso")
	private Integer id;

	@Column(name = "nb_acceso")
	private Integer nombre;

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
}

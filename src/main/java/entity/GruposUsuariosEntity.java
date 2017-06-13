package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "GRUPOSUSUARIOS")
public class GruposUsuariosEntity {

	@Id
	@Column(name = "idGrupoUsuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idGrupoUsuario;

	@Column(name = "idUsuario")
	private Integer idUsuario;

	@Column(name = "idModulo")
	private Integer idModulo;

	@Column(name = "estado")
	private String estado;

	@ManyToOne
	@JoinColumn(name = "idModulo", referencedColumnName = "idModulo", insertable = false, updatable = false)
	ModulosEntity modulosEntity;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
	UsuariosEntity usuariosEntity;
	
//	    public ItemEntry() {}


	/**
	 * @return the idGrupoUsuario
	 */
	public Integer getIdGrupoUsuario() {
		return idGrupoUsuario;
	}

	/**
	 * @param idGrupoUsuario
	 *            the idGrupoUsuario to set
	 */
	public void setIdGrupoUsuario(Integer idGrupoUsuario) {
		this.idGrupoUsuario = idGrupoUsuario;
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
	 * @return the idModulo
	 */
	public Integer getIdModulo() {
		return idModulo;
	}

	/**
	 * @param idModulo
	 *            the idModulo to set
	 */
	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the modulosEntity
	 */
	public ModulosEntity getModulosEntity() {
		return modulosEntity;
	}

	/**
	 * @param modulosEntity the modulosEntity to set
	 */
	public void setModulosEntity(ModulosEntity modulosEntity) {
		this.modulosEntity = modulosEntity;
	}

	/**
	 * @return the usuariosEntity
	 */
	public UsuariosEntity getUsuariosEntity() {
		return usuariosEntity;
	}

	/**
	 * @param usuariosEntity the usuariosEntity to set
	 */
	public void setUsuariosEntity(UsuariosEntity usuariosEntity) {
		this.usuariosEntity = usuariosEntity;
	}
	
	
}

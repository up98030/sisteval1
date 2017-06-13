package entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class UsuariosEntity {

	@Id
	@Column(name = "idUsuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;

	@Column(name = "nombreUsuario")
	private String nombreUsuario;

	@Column(name = "correoUsuario")
	private String correoUsuario;

	@Column(name = "password")
	private String password;

	@Column(name = "nombreCompletoUsuario")
	private String nombreCompleto;

	@Column(name = "idPerfil")
	private Integer idPerfil;

	@Column(name = "estado")
	private String estado;

	@Column(name = "idModulo")
	private Integer idModulo;
	
//	@OneToMany(mappedBy="UsuariosEntity")
//    private Collection<GruposUsuariosEntity> gruposUsuariosEntity;

//	public void setStockDailyRecords(Set<StockDailyRecord> stockDailyRecords) {
//		this.stockDailyRecords = stockDailyRecords;
//	}
//	
//
//	@OneToMany
//	@JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
//	GruposUsuariosEntity gruposUsuariosEntity;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}

//	/**
//	 * @return the gruposUsuariosEntity
//	 */
//	public Collection<GruposUsuariosEntity> getGruposUsuariosEntity() {
//		return gruposUsuariosEntity;
//	}
//
//	/**
//	 * @param gruposUsuariosEntity the gruposUsuariosEntity to set
//	 */
//	public void setGruposUsuariosEntity(Collection<GruposUsuariosEntity> gruposUsuariosEntity) {
//		this.gruposUsuariosEntity = gruposUsuariosEntity;
//	}

}

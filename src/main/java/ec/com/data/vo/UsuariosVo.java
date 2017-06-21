package ec.com.data.vo;

import java.util.Collection;

import entity.GruposUsuariosEntity;
import entity.ModulosEntity;

public class UsuariosVo {
	
	private Integer idUsuario;
	private String nombreUsuario;
	private String correoUsuario;
	private String password;
	private String nombreCompleto;
	private Integer idPerfil;
	private Collection<ModulosEntity> modulos;
	private Collection<GruposUsuariosEntity> gruposUsuariosEntity;
	private String estado;
	private Integer idModulo;
	private Integer idPeriodo;
	
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
	/**
	 * @return the idPeriodo
	 */
	public Integer getIdPeriodo() {
		return idPeriodo;
	}
	/**
	 * @param idPeriodo the idPeriodo to set
	 */
	public void setIdPeriodo(Integer idPeriodo) {
		this.idPeriodo = idPeriodo;
	}
	/**
	 * @return the modulos
	 */
	public Collection<ModulosEntity> getModulos() {
		return modulos;
	}
	/**
	 * @param modulos the modulos to set
	 */
	public void setModulos(Collection<ModulosEntity> modulos) {
		this.modulos = modulos;
	}
	/**
	 * @return the gruposUsuariosEntity
	 */
	public Collection<GruposUsuariosEntity> getGruposUsuariosEntity() {
		return gruposUsuariosEntity;
	}
	/**
	 * @param gruposUsuariosEntity the gruposUsuariosEntity to set
	 */
	public void setGruposUsuariosEntity(Collection<GruposUsuariosEntity> gruposUsuariosEntity) {
		this.gruposUsuariosEntity = gruposUsuariosEntity;
	}
	
}

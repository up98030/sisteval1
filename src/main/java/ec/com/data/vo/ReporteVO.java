package ec.com.data.vo;

import java.util.Collection;

import entity.ModulosEntity;
import entity.TareasEntity;
import entity.TiposTareasEntity;
import entity.UsuariosEntity;

public class ReporteVO {
	
	private Collection<UsuariosEntity> usuarios;
	private Collection<ModulosEntity> grupos;
	private Collection<TiposTareasEntity> categorias;
	private Collection<TareasEntity> tareas;
	private String estado;
	
	/**
	 * @return the usuarios
	 */
	public Collection<UsuariosEntity> getUsuarios() {
		return usuarios;
	}
	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(Collection<UsuariosEntity> usuarios) {
		this.usuarios = usuarios;
	}
	/**
	 * @return the grupos
	 */
	public Collection<ModulosEntity> getGrupos() {
		return grupos;
	}
	/**
	 * @param grupos the grupos to set
	 */
	public void setGrupos(Collection<ModulosEntity> grupos) {
		this.grupos = grupos;
	}
	/**
	 * @return the categorias
	 */
	public Collection<TiposTareasEntity> getCategorias() {
		return categorias;
	}
	/**
	 * @param categorias the categorias to set
	 */
	public void setCategorias(Collection<TiposTareasEntity> categorias) {
		this.categorias = categorias;
	}
	/**
	 * @return the tareas
	 */
	public Collection<TareasEntity> getTareas() {
		return tareas;
	}
	/**
	 * @param tareas the tareas to set
	 */
	public void setTareas(Collection<TareasEntity> tareas) {
		this.tareas = tareas;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
}

package ec.com.data.vo;

import java.util.Collection;

import entity.ModulosEntity;
import entity.TiposTareasEntity;
import entity.UsuariosEntity;

public class ReporteVO {
	
	private Collection<UsuariosEntity> usuarios;
	private Collection<ModulosEntity> grupos;
	private Collection<TiposTareasEntity> categorias;
	
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
	
}

package ec.com.data.vo;

import entity.TareasEntity;
import entity.UsuariosEntity;

public class TareasUsuariosVO {
	
	private String ObservacionesDocente;
	private String estado;
	private Integer idTarea;
	private Integer idTareaUsuario;
	private Integer idUsuario;
	private Double calificacion;
	private TareasEntity tareasEntity;
	private UsuariosEntity usuariosEntity;
	
	public String getObservacionesDocente() {
		return ObservacionesDocente;
	}
	public void setObservacionesDocente(String observacionesDocente) {
		this.ObservacionesDocente = observacionesDocente;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getIdTarea() {
		return idTarea;
	}
	public void setIdTarea(Integer idTarea) {
		this.idTarea = idTarea;
	}
	public Integer getIdTareaUsuario() {
		return idTareaUsuario;
	}
	public void setIdTareaUsuario(Integer idTareaUsuario) {
		this.idTareaUsuario = idTareaUsuario;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public Double getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(Double calificacion) {
		this.calificacion = calificacion;
	}
	public TareasEntity getTareasEntity() {
		return tareasEntity;
	}
	public void setTareasEntity(TareasEntity tareasEntity) {
		this.tareasEntity = tareasEntity;
	}
	public UsuariosEntity getUsuariosEntity() {
		return usuariosEntity;
	}
	public void setUsuariosEntity(UsuariosEntity usuariosEntity) {
		this.usuariosEntity = usuariosEntity;
	}

}

package ec.com.data.vo;

import java.util.Date;

import entity.TareasEntity;
import entity.UsuariosEntity;

public class TareasUsuariosVO {
	
	private String ObservacionesDocente;
	private String estado;
	private Integer idTarea;
	private Integer idTareaUsuario;
	private Integer idUsuario;
	private Integer calificacion;
	private String ObservacionCalificacion;
	private Date FechaEnvio;
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
	
	public Integer getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(Integer calificacion) {
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
	public String getObservacionCalificacion() {
		return ObservacionCalificacion;
	}
	public void setObservacionCalificacion(String observacionCalificacion) {
		ObservacionCalificacion = observacionCalificacion;
	}
	public Date getFechaEnvio() {
		return FechaEnvio;
	}
	public void setFechaEnvio(Date fechaEnvio) {
		FechaEnvio = fechaEnvio;
	}

}

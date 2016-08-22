package ec.com.data.vo;

import entity.TareasEntity;

public class TareasUsuariosVO {
	
	private String ObservacionesDocente;
	private String estado;
	private Integer idTarea;
	private Integer idTareaUsuario;
	private Integer idUsuario;
	private TareasEntity tareasEntity;
	
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
	public TareasEntity getTareasEntity() {
		return tareasEntity;
	}
	public void setTareasEntity(TareasEntity tareasEntity) {
		this.tareasEntity = tareasEntity;
	}
	
	

}

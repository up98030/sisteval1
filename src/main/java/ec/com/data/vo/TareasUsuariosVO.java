package ec.com.data.vo;

import entity.TareasEntity;

public class TareasUsuariosVO {
	
	private String ObservacionesDocente;
	private String estado;
	private int idTarea;
	private int idTareaUsuario;
	private int idUsuario;
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
	public int getIdTarea() {
		return idTarea;
	}
	public void setIdTarea(int idTarea) {
		this.idTarea = idTarea;
	}
	public int getIdTareaUsuario() {
		return idTareaUsuario;
	}
	public void setIdTareaUsuario(int idTareaUsuario) {
		this.idTareaUsuario = idTareaUsuario;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public TareasEntity getTareasEntity() {
		return tareasEntity;
	}
	public void setTareasEntity(TareasEntity tareasEntity) {
		this.tareasEntity = tareasEntity;
	}
	
	

}

package ec.com.data.vo;

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
	private String FechaEnvio;
	private String FechaFin;
	private TareasEntity tareasEntity;
	private UsuariosEntity usuariosEntity;
	private String archivoAdjunto;
    private byte[] ArchivoEnviado;
    private String base64File;


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
	public String getFechaEnvio() {
		return FechaEnvio;
	}
	public void setFechaEnvio(String fechaEnvio) {
		FechaEnvio = fechaEnvio;
	}
	public String getArchivoAdjunto() {
		return archivoAdjunto;
	}
	public void setArchivoAdjunto(String archivoAdjunto) {
		this.archivoAdjunto = archivoAdjunto;
	}
	public String getFechaFin() {
		return FechaFin;
	}
	public void setFechaFin(String fechaFin) {
		FechaFin = fechaFin;
	}
	public byte[] getArchivoEnviado() {
		return ArchivoEnviado;
	}
	public void setArchivoEnviado(byte[] archivoEnviado) {
		ArchivoEnviado = archivoEnviado;
	}
	/**
	 * @return the base64File
	 */
	public String getBase64File() {
		return base64File;
	}
	/**
	 * @param base64File the base64File to set
	 */
	public void setBase64File(String base64File) {
		this.base64File = base64File;
	}

}

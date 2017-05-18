package ec.com.data.vo;

import java.util.Collection;
import java.util.Date;

import entity.TareasUsuariosEntity;

public class TareasVO {
	
	private int idTarea;
	private String nombreTarea;
	private String descripcionTarea;
	private int idModulo;
	private String tipoTarea;
	private int idCreadorTarea;
	private String estado;
	private Date fechaInicio;
	private Date fechaFin;
	private String archivoAdjunto;
	private String criterios;
	private String extensionArchivo;
	private Collection<TareasUsuariosEntity> tareasUsuarios;
	private Integer idPeriodo;
	
	public int getIdTarea() {
		return idTarea;
	}
	public void setIdTarea(int idTarea) {
		this.idTarea = idTarea;
	}
	public String getNombreTarea() {
		return nombreTarea;
	}
	public void setNombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
	}
	public String getDescripcionTarea() {
		return descripcionTarea;
	}
	public void setDescripcionTarea(String descripcionTarea) {
		this.descripcionTarea = descripcionTarea;
	}
	public int getIdModulo() {
		return idModulo;
	}
	public void setIdModulo(int idModulo) {
		this.idModulo = idModulo;
	}
	public String getTipoTarea() {
		return tipoTarea;
	}
	public void setTipoTarea(String tipoTarea) {
		this.tipoTarea = tipoTarea;
	}
	public int getIdCreadorTarea() {
		return idCreadorTarea;
	}
	public void setIdCreadorTarea(int idCreadorTarea) {
		this.idCreadorTarea = idCreadorTarea;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getArchivoAdjunto() {
		return archivoAdjunto;
	}
	public void setArchivoAdjunto(String archivoAdjunto) {
		this.archivoAdjunto = archivoAdjunto;
	}
	public String getCriterios() {
		return criterios;
	}
	public void setCriterios(String criterios) {
		this.criterios = criterios;
	}
	public Collection<TareasUsuariosEntity> getTareasUsuarios() {
		return tareasUsuarios;
	}
	public void setTareasUsuarios(Collection<TareasUsuariosEntity> tareasUsuarios) {
		this.tareasUsuarios = tareasUsuarios;
	}
	/**
	 * @return the extensionArchivo
	 */
	public String getExtensionArchivo() {
		return extensionArchivo;
	}
	/**
	 * @param extensionArchivo the extensionArchivo to set
	 */
	public void setExtensionArchivo(String extensionArchivo) {
		this.extensionArchivo = extensionArchivo;
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
}

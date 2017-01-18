package ec.com.data.vo;

import java.util.Date;

public class NotasVO {
	
	private Integer idUsuario;
	private String estado;
	private Date fechaInicio;
	private Date fechaEnvio;
	private Integer idModulo;
	private Integer idCreador;
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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
	public Date getFechaEnvio() {
		return fechaEnvio;
	}
	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
	public Integer getIdModulo() {
		return idModulo;
	}
	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}
	public Integer getIdCreador() {
		return idCreador;
	}
	public void setIdCreador(Integer idCreador) {
		this.idCreador = idCreador;
	}
	
	
}

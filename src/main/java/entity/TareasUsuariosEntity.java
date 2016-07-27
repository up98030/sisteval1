package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TareasUsuarios")
public class TareasUsuariosEntity {
	
	@Id
    @Column(name = "idTareaUsuario")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idTareaUsuario;
	
	 @Column(name = "idUsuario")
	 private int idUsuario;
	 
	 @Column(name = "idTarea")
	 private int idTarea;
	 
	 @Column(name = "ObservacionesDocente")
	 private String ObservacionesDocente;
	 
	 @Column(name = "ArchivoEnviado")
	 private String ArchivoEnviado;
	 
	 @Column(name = "FechaEnvio")
	 private Date FechaEnvio;
	 
	 @Column(name = "estado")
	 private String estado;

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

	public int getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(int idTarea) {
		this.idTarea = idTarea;
	}

	public String getObservacionesDocente() {
		return ObservacionesDocente;
	}

	public void setObservacionesDocente(String observacionesDocente) {
		ObservacionesDocente = observacionesDocente;
	}

	public String getArchivoEnviado() {
		return ArchivoEnviado;
	}

	public void setArchivoEnviado(String archivoEnviado) {
		ArchivoEnviado = archivoEnviado;
	}

	public Date getFechaEnvio() {
		return FechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		FechaEnvio = fechaEnvio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	 
}

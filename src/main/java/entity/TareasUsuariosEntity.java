package entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TareasUsuarios")
public class TareasUsuariosEntity {
	
	@Id
    @Column(name = "idTareaUsuario")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idTareaUsuario;
	
	 @Column(name = "idUsuario")
	 private Integer idUsuario;
	 
	 @Column(name = "idTarea")
	 private Integer idTarea;
	 
	 @ManyToOne
	 @JoinColumn(name="idTarea",referencedColumnName="idTarea", insertable = false, updatable = false)
	 TareasEntity tareasEntity;
	 
     @ManyToOne
	 @JoinColumn(name="idUsuario",referencedColumnName="idUsuario", insertable = false, updatable = false)
	 UsuariosEntity usuariosEntity;
	 
	 /*@Column(name = "idTarea")
	 private Integer idTarea;*/
	 
	 @Column(name = "ObservacionesDocente")
	 private String ObservacionesDocente;
	 
	 @Column(name = "ArchivoEnviado")
	 private byte[] ArchivoEnviado;
	 
	 @Column(name = "FechaEnvio")
	 private Date FechaEnvio;
	 
	 @Column(name = "estado")
	 private String estado;
	 
	 @Column(name = "calificacion")
	 private Integer calificacion;
	 
	 @Column(name = "ObservacionCalificacion")
	 private Integer ObservacionCalificacion;

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


	public String getObservacionesDocente() {
		return ObservacionesDocente;
	}

	public void setObservacionesDocente(String observacionesDocente) {
		ObservacionesDocente = observacionesDocente;
	}
	
	public TareasEntity getTareasEntity() {
		return tareasEntity;
	}

	public void setTareasEntity(TareasEntity tareasEntity) {
		this.tareasEntity = tareasEntity;
	}

	public byte[] getArchivoEnviado() {
		return ArchivoEnviado;
	}

	public void setArchivoEnviado(byte[] archivoEnviado) {
		ArchivoEnviado = archivoEnviado;
	}
	
	public Integer getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(Integer idTarea) {
		this.idTarea = idTarea;
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

	public UsuariosEntity getUsuariosEntity() {
		return usuariosEntity;
	}

	public void setUsuariosEntity(UsuariosEntity usuariosEntity) {
		this.usuariosEntity = usuariosEntity;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}
	
}

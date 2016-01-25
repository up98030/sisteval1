package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TAREAS")
public class TareasEntity {

    @Id
    @Column(name = "IDTAREA")
    private Long idTarea;

    @Column(name = "NOMBRETAREA")
    private String nombreTarea;
    
    @Column(name = "DESCRIPCIONTAREA")
    private String descripcionTarea;
    
    
    @Column(name = "FECHAINICIO")
    private Date fechaInicio;
    
    @Column(name = "FECHAFIN")
    private Date fechaFin;
    
    @Column(name = "ARCHIVOADJUNTO")
    private String archivoAdjunto;
    
    @Column(name = "ESTADO")
    private String estado;
    
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    
    @Column(name = "ARCHIVO")
    private String archivo;
    
    @Column(name = "CALIFICACION")
    private Integer calificacion;
    
    @Column(name = "IDMODULO")
    private Integer idModulo;
    
    @Column(name = "IDPROFESORCREADOR")
    private Integer idProfesorCreador;
    
    @Column(name = "IDPROFESOR")
    private Integer idProfesor;       

	public String getDescripcionTarea() {
		return descripcionTarea;
	}

	public void setDescripcionTarea(String descripcionTarea) {
		this.descripcionTarea = descripcionTarea;
	}

	public Long getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(Long idTarea) {
		this.idTarea = idTarea;
	}

	public String getNombreTarea() {
		return nombreTarea;
	}

	public void setNombreTarea(String nombre) {
		this.nombreTarea = nombre;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	public Integer getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}

	public Integer getIdProfesorCreador() {
		return idProfesorCreador;
	}

	public void setIdProfesorCreador(Integer idProfesorCreador) {
		this.idProfesorCreador = idProfesorCreador;
	}

	public Integer getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}
	
    
}

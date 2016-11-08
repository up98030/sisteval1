package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author M1155
 *
 */
@Entity
@Table(name = "TAREAS")
public class TareasEntity {

    @Id
    @Column(name = "idTarea")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idTarea;

    @Column(name = "nombreTarea")
    private String nombreTarea;
    
    @Column(name = "descripcionTarea")
    private String descripcionTarea;
    
    @Column(name = "IDMODULO")
    private Integer idModulo;
    
    @Column(name = "tipoTarea")
    private String tipoTarea;
    
    @Column(name = "idCreadorTarea")
    private Integer idCreadorTarea;
    
    @Column(name = "ESTADO")
    private String estado;
        
    @Column(name = "FECHAINICIO")
    private Date fechaInicio;
    
    @Column(name = "FECHAFIN")
    private Date fechaFin;
    
    @Column(name = "ARCHIVOADJUNTO")
    private byte[] archivoAdjunto;
    
    @Column(name = "Criterios")
    private String criterios;

	public Integer getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(Integer idTarea) {
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

	public Integer getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}

	public Integer getIdCreadorTarea() {
		return idCreadorTarea;
	}

	public void setIdCreadorTarea(Integer idCreadorTarea) {
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

	public byte[] getArchivoAdjunto() {
		return archivoAdjunto;
	}

	public void setArchivoAdjunto(byte[] archivoAdjunto) {
		this.archivoAdjunto = archivoAdjunto;
	}

	public String getCriterios() {
		return criterios;
	}

	public void setCriterios(String criterios) {
		this.criterios = criterios;
	}

	public String getTipoTarea() {
		return tipoTarea;
	}

	public void setTipoTarea(String tipoTarea) {
		this.tipoTarea = tipoTarea;
	}

}

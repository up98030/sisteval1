package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPOSTAREAS")
public class TiposTareasEntity {
	

	@Id
    @Column(name = "idTiposTareas")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idTiposTareas;

    @Column(name = "nombreTipoTarea")
    private String nombreTipoTarea;
    
    @Column(name = "descripcionTipoTarea")
    private String descripcionTipoTarea;
    
    @Column(name = "estado")
    private String estado;
    
    @Column(name = "criterios")
    private String criterios;
    
    @Column(name = "calificacion")
    private Integer calificacion;
    

	/**
	 * @return the criterios
	 */
	public String getCriterios() {
		return criterios;
	}

	/**
	 * @param criterios the criterios to set
	 */
	public void setCriterios(String criterios) {
		this.criterios = criterios;
	}

	public Integer getIdTiposTareas() {
		return idTiposTareas;
	}

	public void setIdTiposTareas(Integer idTiposTareas) {
		this.idTiposTareas = idTiposTareas;
	}

	public String getNombreTipoTarea() {
		return nombreTipoTarea;
	}

	public void setNombreTipoTarea(String nombreTipoTarea) {
		this.nombreTipoTarea = nombreTipoTarea;
	}

	public String getDescripcionTipoTarea() {
		return descripcionTipoTarea;
	}

	public void setDescripcionTipoTarea(String descripcionTipoTarea) {
		this.descripcionTipoTarea = descripcionTipoTarea;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the calificacion
	 */
	public Integer getCalificacion() {
		return calificacion;
	}

	/**
	 * @param calificacion the calificacion to set
	 */
	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

}

package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPOSTAREAS")
public class TiposTareasEntity {
	

	@Id
    @Column(name = "idTiposTareas")
    private Integer idTiposTareas;

    @Column(name = "nombreTipoTarea")
    private String nombreTipoTarea;
    
    @Column(name = "descripcionTipoTarea")
    private String descripcionTipoTarea;

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
    
    

}

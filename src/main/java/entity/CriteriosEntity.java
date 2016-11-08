package entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CRITERIOS")
public class CriteriosEntity {
	
	@Id
    @Column(name = "idCriterio")
    private Integer idCriterio;

    @Column(name = "nombreCriterio")
    private String nombreCriterio;
    
    @Column(name = "estado")
    private String estado;
    
    @Column(name = "valorCriterio")
    private String valorCriterio;
    
    @Column(name = "descripcionCriterio")
    private String descripcionCriterio;
    
    
	public Integer getIdCriterio() {
		return idCriterio;
	}

	public void setIdCriterio(Integer idCriterio) {
		this.idCriterio = idCriterio;
	}

	public String getNombreCriterio() {
		return nombreCriterio;
	}

	public void setNombreCriterio(String nombreCriterio) {
		this.nombreCriterio = nombreCriterio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getValorCriterio() {
		return valorCriterio;
	}

	public void setValorCriterio(String valorCriterio) {
		this.valorCriterio = valorCriterio;
	}

	public String getDescripcionCriterio() {
		return descripcionCriterio;
	}

	public void setDescripcionCriterio(String descripcionCriterio) {
		this.descripcionCriterio = descripcionCriterio;
	}

}

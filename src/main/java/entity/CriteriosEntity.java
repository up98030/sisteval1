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
    private int idCriterio;

    @Column(name = "nombreCriterio")
    private String nombreCriterio;
    
    @Column(name = "estado")
    private String estado;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="idCriterio", referencedColumnName="idCriterio")
    Collection<CatalogoCriterioEntity> catalogoCriterio;

	public int getIdCriterio() {
		return idCriterio;
	}

	public void setIdCriterio(int idCriterio) {
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

	public Collection<CatalogoCriterioEntity> getCatalogoCriterio() {
		return catalogoCriterio;
	}

	public void setCatalogoCriterio(Collection<CatalogoCriterioEntity> catalogoCriterio) {
		this.catalogoCriterio = catalogoCriterio;
	}
	
	
    
    

}

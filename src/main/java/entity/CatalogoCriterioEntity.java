package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CATALOGOCRITERIO")
public class CatalogoCriterioEntity {
	

	@Id
    @Column(name = "idCatalogoCriterio")
    private int idCatalogoCriterio;

    @Column(name = "idCriterio")
    private int idCriterio;
    
    @Column(name = "valorCriterio")
    private String valorCriterio;
    
    @Column(name = "estado")
    private String estado;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCriterio", referencedColumnName = "idCriterio", insertable = false, updatable = false)
    private CriteriosEntity criterio;
    
	public int getIdCatalogoCriterio() {
		return idCatalogoCriterio;
	}

	public void setIdCatalogoCriterio(int idCatalogoCriterio) {
		this.idCatalogoCriterio = idCatalogoCriterio;
	}

	public int getIdCriterio() {
		return idCriterio;
	}

	public void setIdCriterio(int idCriterio) {
		this.idCriterio = idCriterio;
	}

	public String getValorCriterio() {
		return valorCriterio;
	}

	public void setValorCriterio(String valorCriterio) {
		this.valorCriterio = valorCriterio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public CriteriosEntity getCriterio() {
		return criterio;
	}

	public void setCriterio(CriteriosEntity criterio) {
		this.criterio = criterio;
	}
	
	
    
}

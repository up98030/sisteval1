package ec.com.data.vo;

import java.util.Collection;

import entity.CatalogoCriterioEntity;

public class CriteriosVO {
	
	private int idCriterio;
	private String nombreCriterio;
	private String estado;
	private Collection<CatalogoCriterioEntity> catalogoCriterios;
	
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
	public Collection<CatalogoCriterioEntity> getCatalogoCriterios() {
		return catalogoCriterios;
	}
	public void setCatalogoCriterios(Collection<CatalogoCriterioEntity> catalogoCriterios) {
		this.catalogoCriterios = catalogoCriterios;
	}
	
}

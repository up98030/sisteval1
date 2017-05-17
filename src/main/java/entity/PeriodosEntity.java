package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Periodos")
public class PeriodosEntity {
	
	@Id
    @Column(name = "idPeriodo")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idPeriodo;
	
	@Column(name = "NombrePeriodo")
    private String nombrePeriodo;
	
	@Column(name = "estado")
    private String estado;

	/**
	 * @return the idPeriodo
	 */
	public Integer getIdPeriodo() {
		return idPeriodo;
	}

	/**
	 * @param idPeriodo the idPeriodo to set
	 */
	public void setIdPeriodo(Integer idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	/**
	 * @return the nombrePeriodo
	 */
	public String getNombrePeriodo() {
		return nombrePeriodo;
	}

	/**
	 * @param nombrePeriodo the nombrePeriodo to set
	 */
	public void setNombrePeriodo(String nombrePeriodo) {
		this.nombrePeriodo = nombrePeriodo;
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
	
}

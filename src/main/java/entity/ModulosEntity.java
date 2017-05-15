package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Modulos")
public class ModulosEntity {
	
	@Id
    @Column(name = "idModulo")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idModulo;
	
	@Column(name = "nombreModulo")
    private String nombreModulo;
	
	@Column(name = "estado")
    private String estado;
	
	@Column(name = "descripcionModulo")
	private String descripcionModulo;

	public Integer getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}

	public String getNombreModulo() {
		return nombreModulo;
	}

	public void setNombreModulo(String nombreModulo) {
		this.nombreModulo = nombreModulo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the descripcionModulo
	 */
	public String getDescripcionModulo() {
		return descripcionModulo;
	}

	/**
	 * @param descripcionModulo the descripcionModulo to set
	 */
	public void setDescripcionModulo(String descripcionModulo) {
		this.descripcionModulo = descripcionModulo;
	}
	
}

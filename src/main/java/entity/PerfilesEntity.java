package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERFILES")
public class PerfilesEntity {

	@Id
    @Column(name = "idPerfil")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idPerfil;

    @Column(name = "nombrePerfil")
    private String nombrePerfil;
    
    @Column(name = "estado")
    private String estado;
    
    @Column(name = "descripcionPerfil")
    private String descripcionPerfil;

	/**
	 * @return the idPerfil
	 */
	public Integer getIdPerfil() {
		return idPerfil;
	}

	/**
	 * @param idPerfil the idPerfil to set
	 */
	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	/**
	 * @return the nombrePerfil
	 */
	public String getNombrePerfil() {
		return nombrePerfil;
	}

	/**
	 * @param nombrePerfil the nombrePerfil to set
	 */
	public void setNombrePerfil(String nombrePerfil) {
		this.nombrePerfil = nombrePerfil;
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
	 * @return the descripcionPerfil
	 */
	public String getDescripcionPerfil() {
		return descripcionPerfil;
	}

	/**
	 * @param descripcionPerfil the descripcionPerfil to set
	 */
	public void setDescripcionPerfil(String descripcionPerfil) {
		this.descripcionPerfil = descripcionPerfil;
	}
    
}

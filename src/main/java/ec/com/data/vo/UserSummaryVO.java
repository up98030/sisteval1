package ec.com.data.vo;

public class UserSummaryVO {
	
	private Integer tareasPendientes;
	private Integer reunionesPendientes;
	private Integer tareasEnviadas;
	private Integer PromedioNotas;
	
	/**
	 * @return the tareasPendientes
	 */
	public Integer getTareasPendientes() {
		return tareasPendientes;
	}
	/**
	 * @param tareasPendientes the tareasPendientes to set
	 */
	public void setTareasPendientes(Integer tareasPendientes) {
		this.tareasPendientes = tareasPendientes;
	}
	/**
	 * @return the reunionesPendientes
	 */
	public Integer getReunionesPendientes() {
		return reunionesPendientes;
	}
	/**
	 * @param reunionesPendientes the reunionesPendientes to set
	 */
	public void setReunionesPendientes(Integer reunionesPendientes) {
		this.reunionesPendientes = reunionesPendientes;
	}
	/**
	 * @return the tareasEnviadas
	 */
	public Integer getTareasEnviadas() {
		return tareasEnviadas;
	}
	/**
	 * @param tareasEnviadas the tareasEnviadas to set
	 */
	public void setTareasEnviadas(Integer tareasEnviadas) {
		this.tareasEnviadas = tareasEnviadas;
	}
	/**
	 * @return the promedioNotas
	 */
	public Integer getPromedioNotas() {
		return PromedioNotas;
	}
	/**
	 * @param promedioNotas the promedioNotas to set
	 */
	public void setPromedioNotas(Integer promedioNotas) {
		PromedioNotas = promedioNotas;
	}
	
}

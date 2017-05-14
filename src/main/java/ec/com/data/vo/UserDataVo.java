package ec.com.data.vo;

import entity.UsuariosEntity;

public class UserDataVo extends UsuariosEntity{
	
	private String usuario;
	private String passwd;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	

}

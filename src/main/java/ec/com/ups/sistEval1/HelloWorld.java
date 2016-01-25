package ec.com.ups.sistEval1;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class HelloWorld implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String hola = "blablablalba";
	private String name;

	public void cambiar(){
		hola = "Hola cambiado";
	}
	
	public String getHola() {
		return hola;
	}
	public void setHola(String hola) {
		this.hola = hola;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
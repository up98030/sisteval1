package adminUtil;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import entity.TareasEntity;

@ManagedBean
@SessionScoped
public class CalificarTareaUtil {
	
	public static String nombreTareacalif;
	public static Long idTarea;
	public static String descripcionTareacalif;
	public static String comentarioTarea;
	
	public static String getNombreTarea() {
		return nombreTareacalif;
	}

	public static void setNombreTarea(String nombreTarea) {
		CalificarTareaUtil.nombreTareacalif = nombreTarea;
	}

	public static Long getIdTarea() {
		return idTarea;
	}

	public static void setIdTarea(Long idTarea) {
		CalificarTareaUtil.idTarea = idTarea;
	}

	public static String getDescripcionTarea() {
		return descripcionTareacalif;
	}

	public static void setDescripcionTarea(String descripcionTarea) {
		CalificarTareaUtil.descripcionTareacalif = descripcionTarea;
	}

	public static String getScomentarioTarea() {
		return comentarioTarea;
	}

	public static void setScomentarioTarea(String scomentarioTarea) {
		CalificarTareaUtil.comentarioTarea = scomentarioTarea;
	}


	public void tareaUnselected(){
		System.out.println("Tarea deseleccionada");
	}

	public void selectTareaCalificar(SelectEvent event){
		System.out.println("Tarea seleccionada!!!....");
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		System.out.println("Contexto: " + context);
		try{
		context.redirect("calificarTarea.xhtml");
		} catch(Exception e){
			System.out.println("No se puede redireccionar");
		}
		nombreTareacalif = ((TareasEntity) event.getObject()).getNombreTarea();
		idTarea = ((TareasEntity) event.getObject()).getIdTarea();
		descripcionTareacalif = ((TareasEntity) event.getObject()).getDescripcionTarea();
		comentarioTarea =((TareasEntity) event.getObject()).getObservaciones();
		
		FacesMessage msg = new FacesMessage("Tarea Seleccionada", ((TareasEntity) event.getObject()).getNombreTarea());
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
}

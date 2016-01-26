package util;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import ec.com.data.vo.TareaVo;
import entity.StudentEntity;
import entity.TareasEntity;

@ManagedBean(name = "util")
@SessionScoped
public class TareasSelectUtil {
	
    private List<TareaVo> tarea;
    private String nombreTarea;
    private Long idTarea;       
    private String descripcionTarea;

	public List<TareaVo> getTarea() {
		
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");
		 
	     ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
	     srb.applySettings(cf.getProperties());
	     ServiceRegistry sr = srb.buildServiceRegistry();
	     SessionFactory sf = cf.buildSessionFactory(sr);

	     Session session = sf.openSession();
	     TareasEntity std = (TareasEntity) session.load(TareasEntity.class, new Long(2));
	     
	     String hql = "FROM entity.TareasEntity";
	     Query query = session.createQuery(hql);
	     List results = query.list();
	     tarea = query.list();

	     System.out.println("Loaded object Student name is: " + std.getNombreTarea());
	     System.out.println("LOS RESULTADOS SON: " + results);
	     
	     System.out.println("Object Loaded successfully.....!!");
	     session.close();
	     sf.close();
		
		return tarea;
	}
	
	private TareasEntity tareaSelect;
	
	public void tareaSelected(SelectEvent event){
		System.out.println("Tarea seleccionada!!!....");
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		System.out.println("Contexto: " + context);
		try{
		context.redirect("tarea.xhtml");
		} catch(Exception e){
			System.out.println("No se puede redireccionar");
		}
		nombreTarea = ((TareasEntity) event.getObject()).getNombreTarea();
		idTarea = ((TareasEntity) event.getObject()).getIdTarea();
		descripcionTarea = ((TareasEntity) event.getObject()).getDescripcionTarea();
		
		
		FacesMessage msg = new FacesMessage("Tarea Seleccionada", ((TareasEntity) event.getObject()).getNombreTarea());
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void tareaUnselected(UnselectEvent event){
		FacesMessage msg = new FacesMessage("Tarea Seleccionada", ((TareasEntity) event.getObject()).getNombreTarea());
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public TareasEntity getTareaSelect() {
		System.out.println("Tarea seleccionada!!!....");
		return tareaSelect;
	}

	public void setTareaSelect(TareasEntity tareaSelect) {
		this.tareaSelect = tareaSelect;
	}

	public void setTarea(List<TareaVo> tarea) {
		this.tarea = tarea;
	}

	public static void main(String[] args) {
		Configuration cf = new Configuration().configure("/hibernate.cfg.xml");
		 
//	     ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
//	     srb.applySettings(cf.getProperties());
//	     ServiceRegistry sr = srb.build();
//	     SessionFactory sf = cf.buildSessionFactory(sr);
//
//	     Session session = sf.openSession();
//	     TareasEntity std = (TareasEntity) session.load(TareasEntity.class, new Long(2));
//
//	     // For loading Transaction object is not necessary
//	     System.out.println("Loaded object Student name is: " + std.getNombreTarea());
//
//	     System.out.println("Object Loaded successfully.....!!");
//	     session.close();
//	     sf.close();
	}
	
	public void select(){
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");
		 
	     ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
	     srb.applySettings(cf.getProperties());
	     ServiceRegistry sr = srb.buildServiceRegistry();
	     SessionFactory sf = cf.buildSessionFactory(sr);

	     Session session = sf.openSession();
	     TareasEntity std = (TareasEntity) session.load(TareasEntity.class, new Long(2));
	     
	     String hql = "FROM entity.TareasEntity";
	     Query query = session.createQuery(hql);
	     List results = query.list();
	     tarea = query.list();

	     System.out.println("Loaded object Student name is: " + std.getNombreTarea());
	     System.out.println("LOS RESULTADOS SON: " + results);
	     
	     System.out.println("Object Loaded successfully.....!!");
	     session.close();
	     sf.close();
	}
	
	public void selectStudent(){
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");
		 
	     ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
	     srb.applySettings(cf.getProperties());
	     ServiceRegistry sr = srb.buildServiceRegistry();
	     SessionFactory sf = cf.buildSessionFactory(sr);

	     Session session = sf.openSession();
	     StudentEntity std = (StudentEntity) session.load(StudentEntity.class, new Integer(2));

	     // For loading Transaction object is not necessary
	     System.out.println("COLLEGE IS: " + std.getCollege());

	     System.out.println("Object Loaded successfully.....!!");
	     session.close();
	     sf.close();
	}

	
	
	public String getDescripcionTarea() {
		return descripcionTarea;
	}

	public void setDescripcionTarea(String descripcionTarea) {
		this.descripcionTarea = descripcionTarea;
	}

	public String getNombreTarea() {
		return nombreTarea;
	}

	public void setNombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
	}

	public Long getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(Long idTarea) {
		this.idTarea = idTarea;
	}
	
	
	

}

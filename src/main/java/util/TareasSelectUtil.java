package util;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "util")
@SessionScoped
public class TareasSelectUtil {

//    private List<TareaVo> tarea;
//    public static String nombreTarea;
//    public static Long idTarea;       
//    public static String descripcionTarea;
//    public static String comentarioTarea;
//        
//
//	public List<TareaVo> getTarea() {
//		
//		Configuration cf = new Configuration().configure("hibernate.cfg.xml");
//		 
//	     ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
//	     srb.applySettings(cf.getProperties());
//	     ServiceRegistry sr = srb.buildServiceRegistry();
//	     SessionFactory sf = cf.buildSessionFactory(sr);
//
//	     Session session = sf.openSession();
//	     //TareasEntity std = (TareasEntity) session.load(TareasEntity.class, new Long(2));
//	     
//	     String hql = "FROM entity.TareasEntity tareas where tareas.estado = 'ACT'";
//	     Query query = session.createQuery(hql);
//	     List results = query.list();
//	     tarea = query.list();
//
////	     System.out.println("Loaded object Student name is: " + std.getNombreTarea());
////	     System.out.println("LOS RESULTADOS SON: " + results);
//	     
//	     System.out.println("Object Loaded successfully.....!!");
//	     session.close();
//	     sf.close();
//		
//		return tarea;
//	}
//	
//	private TareasEntity tareaSelect;
//	
//	public void tareaSelected(SelectEvent event){
//		System.out.println("Tarea seleccionada!!!....");
//		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
//		System.out.println("Contexto: " + context);
//		try{
//		context.redirect("tarea.xhtml");
//		} catch(Exception e){
//			System.out.println("No se puede redireccionar");
//		}
//		nombreTarea = ((TareasEntity) event.getObject()).getNombreTarea();
//		idTarea = ((TareasEntity) event.getObject()).getIdTarea();
//		descripcionTarea = ((TareasEntity) event.getObject()).getDescripcionTarea();
//		/*comentarioTarea =((TareasEntity) event.getObject()).getObservaciones();*/
//		
//		FacesMessage msg = new FacesMessage("Tarea Seleccionada", ((TareasEntity) event.getObject()).getNombreTarea());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//	}
//	
//	public void tareaUnselected(UnselectEvent event){
//		FacesMessage msg = new FacesMessage("Tarea Seleccionada", ((TareasEntity) event.getObject()).getNombreTarea());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//	}
//
//	public TareasEntity getTareaSelect() {
//		System.out.println("Tarea seleccionada!!!....");
//		return tareaSelect;
//	}
//
//	public void setTareaSelect(TareasEntity tareaSelect) {
//		this.tareaSelect = tareaSelect;
//	}
//
//	public void setTarea(List<TareaVo> tarea) {
//		this.tarea = tarea;
//	}
//	
//	public void select(){
//		Configuration cf = new Configuration().configure("hibernate.cfg.xml");
//		 
//	     ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
//	     srb.applySettings(cf.getProperties());
//	     ServiceRegistry sr = srb.buildServiceRegistry();
//	     SessionFactory sf = cf.buildSessionFactory(sr);
//
//	     Session session = sf.openSession();
//	    // TareasEntity std = (TareasEntity) session.load(TareasEntity.class, new Long(1));
//	     
//	     String hql = "FROM entity.TareasEntity";
//	     Query query = session.createQuery(hql);
//	     List results = query.list();
//	     tarea = query.list();
//
//	    // System.out.println("Loaded object Student name is: " + std.getNombreTarea());
//	    // System.out.println("LOS RESULTADOS SON: " + results);
//	     
//	     System.out.println("Object Loaded successfully.....!!");
//	     session.close();
//	     sf.close();
//	}
//	
//
//    
//    public static String getComentarioTarea() {
//		return comentarioTarea;
//	}
//
//	public static void setComentarioTarea(String comentarioTarea) {
//		TareasSelectUtil.comentarioTarea = comentarioTarea;
//	}
//
//	public void updateTarea(){
//    	System.out.println("ACTUALIZANDO TAREA....");
//    }
//		
//	public String getDescripcionTarea() {
//		return descripcionTarea;
//	}
//
//	public void setDescripcionTarea(String descripcionTarea) {
//		this.descripcionTarea = descripcionTarea;
//	}
//
//	public String getNombreTarea() {
//		return nombreTarea;
//	}
//
//	public void setNombreTarea(String nombreTarea) {
//		this.nombreTarea = nombreTarea;
//	}
//
//	public Long getIdTarea() {
//		return idTarea;
//	}
//
//	public void setIdTarea(Long idTarea) {
//		this.idTarea = idTarea;
//	}
//	
//	
//	

}

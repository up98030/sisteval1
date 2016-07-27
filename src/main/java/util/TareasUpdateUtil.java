package util;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "updateUtil")
@SessionScoped
public class TareasUpdateUtil {		
	
//	public void enviarTarea(String observaciones){
//		
//					
//		System.out.println("Actualizando Tarea....");
//		Configuration cf = new Configuration().configure("hibernate.cfg.xml");
//
//        ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
//        srb.applySettings(cf.getProperties());
//        ServiceRegistry sr = srb.buildServiceRegistry();
//        SessionFactory sf = cf.buildSessionFactory(sr);
//
//        Session session = sf.openSession();   
//                
//        TareasEntity tareasEntity = (TareasEntity) session.load(TareasEntity.class, TareasSelectUtil.idTarea);
//        Transaction tx = session.beginTransaction();
//
//        try{
//        //tareasEntity.setIdTarea(1L);        
//        tareasEntity.setNombreTarea(TareasSelectUtil.nombreTarea);
//        tareasEntity.setFechaInicio(new Date());
//        tareasEntity.setFechaFin(new Date());
//        tareasEntity.setEstado("ENV");
//        tareasEntity.setDescripcionTarea(TareasSelectUtil.descripcionTarea);
//        tareasEntity.setArchivoAdjunto("Archivo1.pdf");
//       /* tareasEntity.setArchivo("Archivo subido.pdf");
//        tareasEntity.setObservaciones(observaciones);
//        tareasEntity.setIdModulo(74477);
//        tareasEntity.setIdProfesorCreador(4494);
//        tareasEntity.setIdProfesor(111);
//        tareasEntity.setCalificacion(0);*/
//        } catch(Exception e){
//        	System.out.println("Error" + e);
//        }
//        try{      
//        tx.commit(); // Update method will be called implicitly.
//        System.out.println("Object Updated successfully !");
////        session.close();
////        sf.close();
//		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
//		context.redirect("listaTareas.xhtml");
//        } catch(Exception e){
//        	System.out.println("Error" + e);
//        }
//	}
//	
	}


package util;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TareasInsertUtil {

	
//    private Date date1;
//	
//	public Date getDate1() {
//		return date1;
//	}
//
//	public void setDate1(Date date1) {
//		this.date1 = date1;
//	}
//
//		/*public static void main(String[] args) {
//		
//		Configuration cf = new Configuration().configure("hibernate.cfg.xml");		 
//		
//		Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        
//        TareasEntity tareasEntity = new TareasEntity();
//
//        tareasEntity.setIdTarea(5L);        
//        tareasEntity.setNombreTarea("Tarea de Prueba1");
//        tareasEntity.setFechaInicio(new Date());
//        tareasEntity.setFechaFin(new Date());
//        tareasEntity.setEstado("ACT");
//        tareasEntity.setDescripcionTarea("Es la primera tarea de prueba de hibernate");
//        tareasEntity.setArchivoAdjunto("Archivo1.pdf");
//        tareasEntity.setArchivo("Archivo subido.pdf");
//        tareasEntity.setObservaciones("Observaciones de la tarea1");
//        tareasEntity.setIdModulo(74477);
//        tareasEntity.setIdProfesorCreador(4494);
//        tareasEntity.setIdProfesor(111);
//        tareasEntity.setCalificacion(0);
//                     
//        //Save the employee in database
//        session.save(tareasEntity);
// 
//        //Commit the transaction
//        session.getTransaction().commit();
//        HibernateUtil.shutdown();
//	
//
//}*/
//		public void insertarTarea(String nombre, String descripcion, Date fechaFinTarea){
//			
//			System.out.println("INSERTANDO TAREA..." + fechaFinTarea);
//			//System.out.println("Parametro: " + input);
//			Session session = HibernateUtil.getSessionFactory().openSession();
//	        session.beginTransaction();
//	        
//	        TareasEntity tareasEntity = new TareasEntity();
//
//	        //tareasEntity.setIdTarea(3295L);        
//	        tareasEntity.setNombreTarea(nombre);
//	        tareasEntity.setFechaInicio(new Date());
//	        tareasEntity.setFechaFin(fechaFinTarea);
//	        tareasEntity.setEstado("ACT");
//	        tareasEntity.setDescripcionTarea(descripcion);
//	        tareasEntity.setArchivoAdjunto("Archivo1.pdf");
//	        //tareasEntity.setArchivo("Archivo subido.pdf");
//	        //tareasEntity.setObservaciones("Observaciones de la tarea1");
//	    /*    tareasEntity.setIdModulo(74477);
//	        tareasEntity.setIdProfesorCreador(4494);
//	        tareasEntity.setIdProfesor(111);
//	        tareasEntity.setCalificacion(0);*/
//	                     
//	        //Save the employee in database
//	        session.save(tareasEntity);
//	 
//	        //Commit the transaction
//	        session.getTransaction().commit();
//	       // HibernateUtil.shutdown();
//			
//		}
//		
//		public void testBoton(){
//			System.out.println("EVENTO 1111....");
//		}

}

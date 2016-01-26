package util;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import entity.TareasEntity;

public class TareasUpdateUtil {
	
	public static void main(String[] args){
		
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");

        ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
        srb.applySettings(cf.getProperties());
        ServiceRegistry sr = srb.buildServiceRegistry();
        SessionFactory sf = cf.buildSessionFactory(sr);

        Session session = sf.openSession();

        TareasEntity tareasEntity = (TareasEntity) session.load(TareasEntity.class, new Long(3));
        Transaction tx = session.beginTransaction();

        try{
        //tareasEntity.setIdTarea(1L);        
        tareasEntity.setNombreTarea("Tarea de Prueba1");
        tareasEntity.setFechaInicio(new Date());
        tareasEntity.setFechaFin(new Date());
        tareasEntity.setEstado("ACT");
        tareasEntity.setDescripcionTarea("Es la primera tarea de prueba de hibernate");
        tareasEntity.setArchivoAdjunto("Archivo1.pdf");
        tareasEntity.setArchivo("Archivo subido.pdf");
        tareasEntity.setObservaciones("Observaciones de la tarea1");
        tareasEntity.setIdModulo(74477);
        tareasEntity.setIdProfesorCreador(4494);
        tareasEntity.setIdProfesor(111);
        tareasEntity.setCalificacion(0);
        } catch(Exception e){
        	System.out.println("Error" + e);
        }
        try{      
        tx.commit(); // Update method will be called implicitly.
        System.out.println("Object Updated successfully !");
        session.close();
        sf.close();
        } catch(Exception e){
        	System.out.println("Error" + e);
        }
	}

}

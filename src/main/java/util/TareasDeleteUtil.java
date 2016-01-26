package util;

import java.util.Date;

import org.hibernate.Session;

import entity.TareasEntity;

public class TareasDeleteUtil {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        TareasEntity tareasEntity = new TareasEntity();

        tareasEntity.setIdTarea(2L);        
                     
        //Save the employee in database
        session.delete(tareasEntity);
 
        //Commit the transaction
        session.getTransaction().commit();
        HibernateUtil.shutdown();
		
	}

}

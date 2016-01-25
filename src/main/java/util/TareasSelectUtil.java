package util;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import entity.StudentEntity;
import entity.TareasEntity;

@ManagedBean(name = "util")
@SessionScoped
public class TareasSelectUtil {

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

	     // For loading Transaction object is not necessary
	     System.out.println("Loaded object Student name is: " + std.getNombreTarea());

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

}

package util;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import ec.com.data.vo.TareaVo;
import entity.StudentEntity;
import entity.TareasEntity;

@ManagedBean(name = "util")
@SessionScoped
public class TareasSelectUtil {
	
    private List<TareaVo> tarea;


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

}

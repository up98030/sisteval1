package ec.com.ups.sistEval;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import com.google.gson.Gson;

import ec.com.data.vo.TareaVo;

public class HQLTests {

	
	@Test
	public void criterios(){
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");

		ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
	     srb.applySettings(cf.getProperties());
	     ServiceRegistry sr = srb.buildServiceRegistry();
	     SessionFactory sf = cf.buildSessionFactory(sr);

	     Session session = sf.openSession();
	     try{
	    	 String hql = "FROM entity.CriteriosEntity as criterios join entity.CatalogoCriterioEntity as catalogo";
		     Query query = session.createQuery(hql);
		     List<TareaVo> tarea;
		     List results = query.list();
		     tarea = query.list();
		     String json = new Gson().toJson(tarea);
		     
		     System.out.println(json);	 
	     }catch(Exception e){
	    	 System.out.println(e);
	     }
	     
	}
	
}

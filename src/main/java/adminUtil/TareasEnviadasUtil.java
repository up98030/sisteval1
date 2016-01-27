package adminUtil;

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

@ManagedBean(name = "tareasEnviadasUtil")
@SessionScoped
public class TareasEnviadasUtil {
	
	private List<TareaVo> tarea;
    public static String nombreTarea;
    public static Long idTarea;       
    public static String descripcionTarea;

    public List<TareaVo> getTarea() {
		
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");
		 
	     ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
	     srb.applySettings(cf.getProperties());
	     ServiceRegistry sr = srb.buildServiceRegistry();
	     SessionFactory sf = cf.buildSessionFactory(sr);

	     Session session = sf.openSession();
	     
	     String hql = "FROM entity.TareasEntity tareas where tareas.estado = 'ENV'";
	     Query query = session.createQuery(hql);
	     List results = query.list();
	     tarea = query.list();

	     System.out.println("Object Loaded successfully.....!!");
	     session.close();
	     sf.close();
		
		return tarea;
	}
	
	public void setTarea(List<TareaVo> tarea) {
		this.tarea = tarea;
	}
}

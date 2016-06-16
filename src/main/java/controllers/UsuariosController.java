package controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import ec.com.data.vo.UsuariosVo;

@Controller
@RequestMapping("/ws")
public class UsuariosController {
	
	@RequestMapping(value = "/usuarios/", method = RequestMethod.GET)
	public ResponseEntity<String> listAllUsers(HttpServletResponse response) {
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");
		
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		 
	     ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
	     srb.applySettings(cf.getProperties());
	     ServiceRegistry sr = srb.buildServiceRegistry();
	     SessionFactory sf = cf.buildSessionFactory(sr);

	     Session session = sf.openSession();
	     //TareasEntity std = (TareasEntity) session.load(TareasEntity.class, new Long(2));
	     
	     String hql = "SELECT usuarios FROM entity.UsuariosEntity usuarios where usuarios.estado = 'ACT'";
	     Query query = session.createQuery(hql);
	     List<UsuariosVo> tarea;
	     List results = query.list();
	     tarea = query.list();
	     String json = new Gson().toJson(tarea);


//	     System.out.println("Loaded object Student name is: " + std.getNombreTarea());
//	     System.out.println("LOS RESULTADOS SON: " + results);
	     
	     System.out.println("Object Loaded successfully.....!!");
	     session.close();
	     sf.close();
				
		return new ResponseEntity<String>(json, HttpStatus.OK);
	}

}

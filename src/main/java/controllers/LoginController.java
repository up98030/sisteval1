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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import ec.com.data.vo.UsuariosVo;

@Controller
@RequestMapping("/ws")
public class LoginController {
	
	@RequestMapping(value = "/login/", method = RequestMethod.POST, consumes = {"application/xml", "application/json"})
	public ResponseEntity<String> login(HttpServletResponse response,@RequestBody String userData){
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");
		System.out.println("useDatar: " + userData);
		String [] userData1  = userData.split(","); 
		String user = userData1[0];
		String passwd = userData1[1];
		System.out.println("User: " + user);
		System.out.println("Passwd: " + passwd);
		
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
	     
	     String hql = "FROM entity.UsuariosEntity usuarios where usuarios.estado = 'ACT' and usuarios.usernom = '" + user + "' and usuarios.userpwd = '" + passwd + "'";
	     Query query = session.createQuery(hql);
	     
	     List<UsuariosVo> usuario;
	     List results = query.list();
	     usuario = query.list();
	     		
	     if(!usuario.isEmpty()){
	    	 String json = new Gson().toJson(usuario);
	 		return new ResponseEntity<String>(json, HttpStatus.OK);
	     }else{
	    	 String json = new Gson().toJson("no existe usuario");
	    	 System.out.println("No existe usuario");
	 		return new ResponseEntity<String>(json, HttpStatus.BAD_REQUEST);	 
	     }
	}

}

package controllers;

import java.io.File;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import ec.com.data.vo.UsuariosVo;
import entity.UsuariosEntity;

@Controller
@RequestMapping("/ws")
public class LoginController {
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/login/", method = RequestMethod.POST, consumes = {"application/xml", "application/json"})
	public ResponseEntity<String> login(HttpServletResponse response,@RequestBody String userData){
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");
		
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		String datosUsuario = null;
		try{
			UsuariosEntity user = mapper.readValue(userData, UsuariosEntity.class);
			
			System.out.println("useDatar: " + userData);
			String [] userData1  = userData.split(","); 
			String username = user.getNombreUsuario(); 
			String passwd = user.getPassword();
			System.out.println("User: " + user);
			System.out.println("Passwd: " + passwd);
			
			ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
		     srb.applySettings(cf.getProperties());
		     ServiceRegistry sr = srb.buildServiceRegistry();
		     SessionFactory sf = cf.buildSessionFactory(sr);

		     Session session = sf.openSession();
		     
		     String hql = "FROM entity.UsuariosEntity usuarios where usuarios.estado = 'ACT' and usuarios.nombreUsuario = '" + username + "' and usuarios.password = '" + passwd + "'";
		     Query query = session.createQuery(hql);
		     
		     //List<UsuariosVo> usuario;
		     UsuariosEntity usuario = (UsuariosEntity) query.uniqueResult();
		     //usuario = query.list();
		     		
		     if(!(usuario == null)){
		    	 datosUsuario = new Gson().toJson(usuario);
		 		return new ResponseEntity<String>(datosUsuario, HttpStatus.OK);
		     }else{
		    	 datosUsuario = new Gson().toJson("no existe usuario");
		    	 System.out.println("No existe usuario");
		     }
		     
		} catch(Exception e){
			System.out.println(e);
	 		return new ResponseEntity<String>("Usuario o contraseña incorrectos", HttpStatus.FORBIDDEN);	 

		}
		

		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        
 		return new ResponseEntity<String>(datosUsuario, HttpStatus.OK);	 

	}

}

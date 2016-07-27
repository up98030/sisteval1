package controllers;

import java.util.Collection;
import java.util.Date;
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

import ec.com.data.vo.TareaVo;
import ec.com.data.vo.TareasUsuariosVO;
import entity.ModulosEntity;
import entity.TareasEntity;
import entity.TareasUsuariosEntity;
import entity.UsuariosEntity;
import util.HibernateUtil;

@Controller
@RequestMapping("/ws")
public class TareasController {
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/buscarUsuariosModulo/", method = RequestMethod.POST)
	public ResponseEntity<String> buscarUsuariosModulo(HttpServletResponse response, @RequestBody String moduloData) {
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");
		
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		String usuariosModulo = null;
		try{
			ModulosEntity modulo = mapper.readValue(moduloData, ModulosEntity.class);
			
			ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
		     srb.applySettings(cf.getProperties());
		     ServiceRegistry sr = srb.buildServiceRegistry();
		     SessionFactory sf = cf.buildSessionFactory(sr);

		     Session session = sf.openSession();
		     
		     String hql = "FROM entity.UsuariosEntity usuarios where usuarios.estado = 'ACT' and usuarios.idModulo = '" + modulo.getIdModulo() + "'";
		     Query query = session.createQuery(hql);
		     
		     Collection<UsuariosEntity> listaUsuariosModulo = (Collection<UsuariosEntity>) query.list();
		     
		     if(listaUsuariosModulo != null){
		    	 usuariosModulo = new Gson().toJson(listaUsuariosModulo);
			 		return new ResponseEntity<String>(usuariosModulo, HttpStatus.OK);
		     }else{
			 		return new ResponseEntity<String>("No existen usuarios", HttpStatus.OK);
		     }
		     
		}catch(Exception e){
	 		return new ResponseEntity<String>("Error al encontrar usuarios", HttpStatus.BAD_REQUEST);
		}
	}

	
	@RequestMapping(value = "/tareas/", method = RequestMethod.GET)
	public ResponseEntity<String> listAllTareas(HttpServletResponse response) {
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
	     
	     String hql = "FROM entity.TareasEntity tareas where tareas.estado = 'ACT'";
	     Query query = session.createQuery(hql);
	     List<TareaVo> tarea;
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
	
	@RequestMapping(value = "/getCriterios/", method = RequestMethod.GET)
	public ResponseEntity<String> getAllCriterios(HttpServletResponse response) {
		
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");

		ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
	     srb.applySettings(cf.getProperties());
	     ServiceRegistry sr = srb.buildServiceRegistry();
	     SessionFactory sf = cf.buildSessionFactory(sr);

	     Session session = sf.openSession();
	     
	     String hql = "FROM entity.TareasEntity tareas where tareas.estado = 'ACT'";
	     Query query = session.createQuery(hql);
	     List<TareaVo> tarea;
	     List results = query.list();
	     tarea = query.list();
	     String json = new Gson().toJson(tarea);
	
		return null;
	}


	
	
	@RequestMapping(value = "/crearTarea/", method = RequestMethod.POST, consumes = {"application/xml", "application/json"})
	public ResponseEntity<String> login(HttpServletResponse response,@RequestBody String tareaData){
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");
		
		ObjectMapper mapper = new ObjectMapper(); 
		String datosUsuario = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
		try{
			TareasUsuariosVO tareaVO = mapper.readValue(tareaData, TareasUsuariosVO.class);
			
			TareasEntity tareasEntity = new TareasEntity();

	        tareasEntity.setNombreTarea(tareaVO.getNombreTarea());
	        tareasEntity.setFechaInicio(new Date());
	        tareasEntity.setFechaFin(new Date());
	        tareasEntity.setEstado("ACT");
	        tareasEntity.setTipoTarea("TAREA");
	        tareasEntity.setIdCreadorTarea(1);
	        tareasEntity.setIdCriterio(1);
	        tareasEntity.setIdModulo(1);
	        tareasEntity.setDescripcionTarea(tareaVO.getDescripcionTarea());
	        tareasEntity.setArchivoAdjunto("Archivo1.pdf");
	        
	        session.save(tareasEntity);
	        
	    	// String json = new Gson().toJson("Tarea Insertada...");
	        for(TareasUsuariosEntity tareaUsuario : tareaVO.getTareasUsuarios()){
		        TareasUsuariosEntity tareaUsuariosEntity = new TareasUsuariosEntity();
		        tareaUsuariosEntity.setIdUsuario(tareaUsuario.getIdUsuario());
		        tareaUsuariosEntity.setIdTarea(tareasEntity.getIdTarea());
		        tareaUsuariosEntity.setEstado("CRE");
		        session.save(tareaUsuariosEntity);
	        }
	        
	        session.getTransaction().commit();

		     String json = new Gson().toJson("Tarea Creada");
	 		return new ResponseEntity<String>(json, HttpStatus.OK);	 

		}catch(Exception e){
		     String json = new Gson().toJson("No se pudo crear tarea");
			return new ResponseEntity<String>(json, HttpStatus.OK);
		}
		
	}
	

}

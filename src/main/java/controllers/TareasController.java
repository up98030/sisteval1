package controllers;

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

import com.google.gson.Gson;

import ec.com.data.vo.TareaVo;
import ec.com.data.vo.UsuariosVo;
import entity.TareasEntity;
import util.HibernateUtil;

@Controller
@RequestMapping("/ws")
public class TareasController {
	
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
	
	
	@RequestMapping(value = "/crearTarea/", method = RequestMethod.POST, consumes = {"application/xml", "application/json"})
	public ResponseEntity<String> login(HttpServletResponse response,@RequestBody String tareaData){
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");
		System.out.println("useDatar: " + tareaData);
		String [] tareaObject  = tareaData.split(","); 
		String nombre = tareaObject[0];
		String descripcion = tareaObject[1];
		Date fechaFin = new Date(tareaObject[2]);
		System.out.println("nombre: " + nombre);
		System.out.println("fecha: " + fechaFin);
		
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		
        System.out.println("INSERTANDO TAREA..." + nombre);
		//System.out.println("Parametro: " + input);
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        TareasEntity tareasEntity = new TareasEntity();

        //tareasEntity.setIdTarea(3295L);        
        tareasEntity.setNombreTarea(nombre);
        tareasEntity.setFechaInicio(new Date());
        tareasEntity.setFechaFin(fechaFin);
        tareasEntity.setEstado("ACT");
        tareasEntity.setDescripcionTarea(descripcion);
        tareasEntity.setArchivoAdjunto("Archivo1.pdf");
        //tareasEntity.setArchivo("Archivo subido.pdf");
        //tareasEntity.setObservaciones("Observaciones de la tarea1");
        tareasEntity.setIdModulo(74477);
        tareasEntity.setIdProfesorCreador(4494);
        tareasEntity.setIdProfesor(111);
        tareasEntity.setCalificacion(0);
                     
        //Save the employee in database
        session.save(tareasEntity);
 
        //Commit the transaction
        session.getTransaction().commit();
	     		
    	 String json = new Gson().toJson("Tarea Insertada...");
 		return new ResponseEntity<String>(json, HttpStatus.OK);	 
	}
	

}

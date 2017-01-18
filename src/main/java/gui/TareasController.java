package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

//import org.apache.commons.codec.binary.Base64;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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

import ec.com.data.vo.CriteriosVO;
import ec.com.data.vo.TareasUsuariosVO;
import ec.com.data.vo.TareasVO;
import entity.CriteriosEntity;
import entity.ModulosEntity;
import entity.TareasEntity;
import entity.TareasUsuariosEntity;
import entity.TiposTareasEntity;
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

	
	@RequestMapping(value = "/tareas/", method = RequestMethod.POST)
	public ResponseEntity<String> listAllTareas(HttpServletResponse response,@RequestBody String tareasUsusariosVO) {
		
		
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");
		
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		try{
			TareasUsuariosVO tareaUsuarioVO = mapper.readValue(tareasUsusariosVO, TareasUsuariosVO.class);
			 ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
		     srb.applySettings(cf.getProperties());
		     ServiceRegistry sr = srb.buildServiceRegistry();
		     SessionFactory sf = cf.buildSessionFactory(sr);

		     Session session = sf.openSession();
		     
		     Criteria criteria = session.createCriteria(TareasUsuariosEntity.class,"root");
		     criteria.createAlias("tareasEntity", "tareasEntity");	
		     criteria.createAlias("usuariosEntity", "usuariosEntity");		     		    

		     if(tareaUsuarioVO.getIdUsuario() != null){
			     criteria.add(Restrictions.eq("idUsuario",tareaUsuarioVO.getIdUsuario()));
			     if(tareaUsuarioVO.getTareasEntity().getTipoTarea().equals("REUNION")){
				     criteria.add(Restrictions.eq("tareasEntity.tipoTarea",tareaUsuarioVO.getTareasEntity().getTipoTarea()));
			     }
			     if(tareaUsuarioVO.getTareasEntity().getTipoTarea().equals("TAREA")){
				     criteria.add(Restrictions.eq("tareasEntity.tipoTarea",tareaUsuarioVO.getTareasEntity().getTipoTarea()));
			     }
		     }
		     criteria.add(Restrictions.eq("estado", tareaUsuarioVO.getEstado()));
		     if(tareaUsuarioVO.getTareasEntity().getIdCreadorTarea() != null){
			     criteria.add(Restrictions.eq("tareasEntity.idCreadorTarea", tareaUsuarioVO.getTareasEntity().getIdCreadorTarea()));
		     }
		     
			ProjectionList projections = Projections.projectionList();
			projections.add(Projections.property("idTareaUsuario"),"tareasUsuariosEntity.idTareaUsuario");
			projections.add(Projections.property("idUsuario"),"tareasUsuariosEntity.idUsuario");
			projections.add(Projections.property("idTarea"),"tareasUsuariosEntity.idTarea");
			projections.add(Projections.property("ObservacionesDocente"),"tareasUsuariosEntity.ObservacionesDocente");
			projections.add(Projections.property("ArchivoEnviado"),"tareasUsuariosEntity.ArchivoEnviado");
			projections.add(Projections.property("FechaEnvio"),"tareasUsuariosEntity.FechaEnvio");
			projections.add(Projections.property("estado"),"tareasUsuariosEntity.estado");

			

		     
		     Collection<TareasUsuariosEntity> tareas = (Collection<TareasUsuariosEntity>) criteria.list();
		     String json = new Gson().toJson(tareas);

		     //TareasEntity std = (TareasEntity) session.load(TareasEntity.class, new Long(2));
		     
		    /* String hql = "FROM entity.TareasEntity tareas where tareas.estado = 'ACT'";
		     Query query = session.createQuery(hql);
		     List<TareaVo> tarea;
		     List results = query.list();
		     tarea = query.list();*/


//		     System.out.println("Loaded object Student name is: " + std.getNombreTarea());
//		     System.out.println("LOS RESULTADOS SON: " + results);
		     
		     session.close();
		     sf.close();
					
			return new ResponseEntity<String>(json, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<String>("Error", HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/getCriterios/", method = RequestMethod.GET)
	public ResponseEntity<String> getAllCriterios(HttpServletResponse response) {
		
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");

		ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
	     srb.applySettings(cf.getProperties());
	     ServiceRegistry sr = srb.buildServiceRegistry();
	     SessionFactory sf = cf.buildSessionFactory(sr);
	     Session session = sf.openSession();
	     session.clear();
	     
	     CriteriosEntity criteriosEntity = new CriteriosEntity();
	     Collection<CriteriosEntity> criterios = new ArrayList<CriteriosEntity>(0);
	     
	     Collection<CriteriosVO> criteriosVO = new ArrayList<CriteriosVO>(0);

	     try{
		    Criteria criteria = session.createCriteria(CriteriosEntity.class, "root");
			ProjectionList projections = Projections.projectionList();
			projections.add(Projections.property("idCriterio"),"idCriterio");
			projections.add(Projections.property("nombreCriterio"),"nombreCriterio");
			projections.add(Projections.property("estado"),"estado");
			projections.add(Projections.property("valorCriterio"),"valorCriterio");
			projections.add(Projections.property("descripcionCriterio"),"descripcionCriterio");

			//criteria.setProjection(Projections.distinct(projections));
			criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
		     criterios = (Collection<CriteriosEntity>)criteria.list();		   
		     System.out.println(criterios);
		     session.flush();
	     }catch(Exception e){
	    	 
	     }
	     String criteriosJson = new Gson().toJson(criterios);
	 		return new ResponseEntity<String>(criteriosJson, HttpStatus.OK);	 
	}
	
	@RequestMapping(value = "/getTiposTareas/", method = RequestMethod.GET)
	public ResponseEntity<String> getAllTiposTareas(HttpServletResponse response) {
		
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");

		ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
	     srb.applySettings(cf.getProperties());
	     ServiceRegistry sr = srb.buildServiceRegistry();
	     SessionFactory sf = cf.buildSessionFactory(sr);
	     Session session = sf.openSession();
	     session.clear();
	     
	     Collection<TiposTareasEntity> tiposTareas = new ArrayList<TiposTareasEntity>(0);
	     
	     try{
		    Criteria criteria = session.createCriteria(TiposTareasEntity.class, "root");
		     tiposTareas = (Collection<TiposTareasEntity>)criteria.list();		   
		     System.out.println(tiposTareas);
		     session.flush();
	     }catch(Exception e){
	    	 
	     }
	     String criteriosJson = new Gson().toJson(tiposTareas);
	 		return new ResponseEntity<String>(criteriosJson, HttpStatus.OK);	
		
	}

	public static byte[] loadFile(File file){
		try {
			InputStream is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		long length = file.length();
		if(length > Integer.MAX_VALUE){
			
		}
		byte[] bytes = new byte[(int)length];
		return bytes;
	}
	
//	public String encodeFileToBase64(String fileName){
//		File file = new File(fileName);
//		byte[] bytes = loadFile(file);
//		byte[] encoded = Base64.encodeBase64(bytes);
//		String encodedString = new String(encoded);
//		return encodedString;
//	}
//	
//	public byte[] decodeFileToBase64(String base64FileString){
//		byte[] file = Base64.decodeBase64(base64FileString);
//		return file;
//	}
	
	
	@RequestMapping(value = "/crearTarea/", method = RequestMethod.POST, consumes = {"application/xml", "application/json"})
	public ResponseEntity<String> login(HttpServletResponse response,@RequestBody String tareaData){
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");
		
		ObjectMapper mapper = new ObjectMapper(); 
		String datosUsuario = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
		try{
			TareasVO tareaVO = mapper.readValue(tareaData, TareasVO.class);
			
			TareasEntity tareasEntity = new TareasEntity();

	        tareasEntity.setNombreTarea(tareaVO.getNombreTarea());
	        tareasEntity.setFechaInicio(new Date());
	        tareasEntity.setFechaFin(new Date());
	        tareasEntity.setEstado("ACT");
	        tareasEntity.setTipoTarea(tareaVO.getTipoTarea());
	        tareasEntity.setIdCreadorTarea(tareaVO.getIdCreadorTarea());
	        tareasEntity.setCriterios(tareaVO.getCriterios());
	        tareasEntity.setIdModulo(1);
	        tareasEntity.setDescripcionTarea(tareaVO.getDescripcionTarea());
	        byte[] decoded = org.apache.commons.codec.binary.Base64.decodeBase64(tareaVO.getArchivoAdjunto().getBytes());
	        tareasEntity.setArchivoAdjunto(decoded);
	        //tareasEntity.setArchivoAdjunto(Base64.getDecoder().decode(tareaVO.getArchivoAdjunto()));
	       // tareasEntity.setArchivoAdjunto(decodeFileToBase64(tareaVO.getArchivoAdjunto()));
	        
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
	
	
	@RequestMapping(value = "/enviarTarea/", method = RequestMethod.POST)
	public ResponseEntity<String> calificarTarea(HttpServletResponse response,@RequestBody String tareaData) {
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");
			
		ObjectMapper mapper = new ObjectMapper(); 
		String respuesta;
			try{		
				java.text.SimpleDateFormat sdf = 
					     new java.text.SimpleDateFormat("yyyy-MM-dd");

					String currentTime = sdf.format(new Date());
				Session session = HibernateUtil.getSessionFactory().openSession();
		        session.beginTransaction();
		        String hql = null;
		        TareasUsuariosVO tareaVO = mapper.readValue(tareaData, TareasUsuariosVO.class);
		        
		        byte[] decoded = org.apache.commons.codec.binary.Base64.decodeBase64(tareaVO.getArchivoAdjunto().getBytes());
		        
		        if(tareaVO.getCalificacion() == null || tareaVO.getCalificacion().toString().isEmpty()){
		        	hql = "UPDATE TareasUsuariosEntity SET ObservacionesDocente = '"+tareaVO.getObservacionesDocente()+
						 	"' , estado ='"+ tareaVO.getEstado() +"', ArchivoEnviado='" + decoded + "' ,FechaEnvio = '" + currentTime  + "' where idTareaUsuario =" + tareaVO.getIdTareaUsuario();
		        }else{
		        	hql = "UPDATE TareasUsuariosEntity SET calificacion = "+tareaVO.getCalificacion()+
						 	" , estado ='"+ tareaVO.getEstado() +"' ,ObservacionCalificacion = '" + tareaVO.getObservacionCalificacion() + "' where idTareaUsuario =" + tareaVO.getIdTareaUsuario();
		        }
				 
			     Query query = session.createQuery(hql);
			     query.executeUpdate();
			     session.getTransaction().commit();
			     session.flush();
				 session.close();
				 
				 respuesta = new Gson().toJson("Tarea Enviada correctamente");
			return new ResponseEntity<String>(respuesta, HttpStatus.OK);
			}catch(Exception e){
				respuesta = new Gson().toJson("No se pudo enviar tarea");
				System.out.println("Error: " + e.getMessage());
				return new ResponseEntity<String>(respuesta, HttpStatus.BAD_REQUEST);
			}
	}
	
	
	

}

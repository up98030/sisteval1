package controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

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

import ec.com.data.vo.NotasVO;
import ec.com.data.vo.TareasUsuariosVO;
import entity.TareasUsuariosEntity;
import entity.UsuariosEntity;

@Controller
@RequestMapping("/ws")
public class NotasController {
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/notasAspiranteParametros/", method = RequestMethod.POST)
	public ResponseEntity<String> buscarUsuariosModulo(HttpServletResponse response, @RequestBody String parametrosData) {
		
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");
		
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		
		String usuariosModulo = null;
		try{
			
			NotasVO notasVO = mapper.readValue(parametrosData, NotasVO.class);
			
			ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
		     srb.applySettings(cf.getProperties());
		     ServiceRegistry sr = srb.buildServiceRegistry();
		     SessionFactory sf = cf.buildSessionFactory(sr);

		     Session session = sf.openSession();
		     //joins
		     Criteria criteria = session.createCriteria(TareasUsuariosEntity.class,"root");
		     criteria.createAlias("tareasEntity", "tareasEntity");	
		     criteria.createAlias("usuariosEntity", "usuariosEntity");
		     //condiciones
//		     criteria.add(Restrictions.eq("tareasEntity.tipoTarea","TAREA"));
		     //Si no tiene estado trae de todos los estados
		     if(notasVO.getEstado() != null){
			     criteria.add(Restrictions.eq("estado",notasVO.getEstado()));
		     }
		     //Si no tiene idUsuario trae de todos los usuarios(Director de carrera)
		     if(notasVO.getIdUsuario() != null){
		    	 criteria.add(Restrictions.eq("idUsuario",notasVO.getIdUsuario()));
		     }
		     //Para traer todas las del modulo
		     if(notasVO.getIdModulo() != null){
		    	 criteria.add(Restrictions.eq("tareasEntity.idModulo",notasVO.getIdModulo()));
		     }
		     //Filtra por fecha envio
		     if(notasVO.getFechaEnvio() != null){
		    	 criteria.add(Restrictions.le("tareasEntity.fechaEnvio",notasVO.getFechaEnvio()));
		     }
		     
		     //Filtra por fecha creacion
		     if(notasVO.getFechaEnvio() != null){
		    	 criteria.add(Restrictions.le("tareasEntity.fechaInicio",notasVO.getFechaEnvio()));
		     }
		     
		     
		     ProjectionList projections = Projections.projectionList();
				projections.add(Projections.property("estado"),"tareasUsuariosEntity.estado");
				projections.add(Projections.property("idUsuario"),"tareasUsuariosEntity.idUsuario");
				projections.add(Projections.property("calificacion"),"tareasUsuariosEntity.calificacion");
				projections.add(Projections.property("idTareaUsuario"),"tareasUsuariosEntity.idTareaUsuario");
				projections.add(Projections.property("idTarea"),"tareasUsuariosEntity.idTarea");
				projections.add(Projections.property("FechaEnvio"),"tareasUsuariosEntity.FechaEnvio");
				
				Collection<TareasUsuariosEntity> tareas = (Collection<TareasUsuariosEntity>) criteria.list();
				for(TareasUsuariosEntity tarea : tareas){
					tarea.setGruposUsuariosEntity(null);
					tarea.setUsuariosEntity(null);
				}
			     String json = new Gson().toJson(tareas);
			     
			     session.close();
			     sf.close();
						
				return new ResponseEntity<String>(json, HttpStatus.OK);
				
		     
		}catch(Exception e){
	 		return new ResponseEntity<String>("Error al encontrar notas", HttpStatus.BAD_REQUEST);
		}
	}

}

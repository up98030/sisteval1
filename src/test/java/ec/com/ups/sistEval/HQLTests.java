package ec.com.ups.sistEval;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.google.gson.Gson;

import entity.TiposTareasEntity;

public class HQLTests {

	/*
	@Test
	public void criterios(){
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");

		ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
	     srb.applySettings(cf.getProperties());
	     ServiceRegistry sr = srb.buildServiceRegistry();
	     SessionFactory sf = cf.buildSessionFactory(sr);

	     Session session = sf.openSession();
	     session.clear();
	     try{
		    Criteria criteria = session.createCriteria(CriteriosEntity.class, "root");
		    criteria.createAlias("catalogoCriterioEntity", "catalogoCriterioEntity");
			ProjectionList projections = Projections.projectionList();
			projections.add(Projections.property("idCriterio"),"idCriterio");
			projections.add(Projections.property("nombreCriterio"),"nombreCriterio");
			projections.add(Projections.property("estado"),"estado");
			projections.add(Projections.property("catalogoCriterioEntity.valorCriterio"),"catalogoCriterioEntity.valorCriterio");
			projections.add(Projections.property("catalogoCriterioEntity.descripcion"),"catalogoCriterioEntity.descripcion");
			projections.add(Projections.property("catalogoCriterioEntity.idCriterio"),"catalogoCriterioEntity.idCriterio");

			//criteria.setProjection(Projections.distinct(projections));
			criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);

		     Collection<CriteriosEntity> criterios = (Collection<CriteriosEntity>)criteria.list();
		     session.flush();
		     
	     }catch(Exception e){
	    	 System.out.println(e);
	     }
	     
	}*/
	/*
	@Test
	public void tareas(){
Configuration cf = new Configuration().configure("hibernate.cfg.xml");
		 
	     ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
	     srb.applySettings(cf.getProperties());
	     ServiceRegistry sr = srb.buildServiceRegistry();
	     SessionFactory sf = cf.buildSessionFactory(sr);

	     Session session = sf.openSession();
	     try{
	    	 Criteria criteria = session.createCriteria(TareasUsuariosEntity.class,"root");
		     criteria.createAlias("tareasEntity", "tareasEntity");
		     
		     criteria.add(Restrictions.eq("idUsuario",1));
		     
		     Collection<TareasUsuariosEntity> tareas = (Collection<TareasUsuariosEntity>) criteria.list(); 
		     String json = new Gson().toJson(tareas);
	     }catch(Exception e){
	    	 System.out.println(e);
	     }
	     
	     
	     session.close();
	     sf.close();
	}
	*/
	/*
	@Test
	public void enviarTarea(){
		try{
			
			Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        
		     String hql = "UPDATE TareasUsuariosEntity SET ObservacionesDocente = null, estado = 'env' where idTareaUsuario = 10";
		     Query query = session.createQuery(hql);
		     query.executeUpdate();
		        session.getTransaction().commit();

		     session.flush();

			 session.close();
			 //sf.close();
			String answer = "Tarea actualizada correctamente";			
			//return new ResponseEntity<String>(answer, HttpStatus.OK);
			}catch(Exception e){
				System.out.println("Error: " + e.getMessage());
				//return new ResponseEntity<String>("Error", HttpStatus.BAD_REQUEST);
			}
	}*/
	
	/*
	@Test
	public void getTiposTareas(){
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
//		    ProjectionList projections = Projections.projectionList();
//			projections.add(Projections.property("idTiposTareas"),"idTiposTareas");
//			projections.add(Projections.property("nombreTipoTarea"),"nombreTipoTarea");
//			projections.add(Projections.property("descripcionTipoTarea"),"descripcionTipoTarea");
//			projections.add(Projections.property("estado"),"estado");

			//criteria.setProjection(Projections.distinct(projections));
			//criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
		     tiposTareas = (Collection<TiposTareasEntity>)criteria.list();
		     for(TiposTareasEntity tipoTarea : tiposTareas){
		    	 System.out.println(tipoTarea.getNombreTipoTarea());
		     }
		     System.out.println(tiposTareas);
		     session.flush();
	     }catch(Exception e){
	    	 
	     }
	     String criteriosJson = new Gson().toJson(tiposTareas);
	}
	*/
	
	
}

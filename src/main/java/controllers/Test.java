package controllers;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import ec.com.data.vo.TareasUsuariosVO;
import util.HibernateUtil;

public class Test {
	
//	@org.junit.Test
//	public void consultaNotas(){
//		Configuration cf = new Configuration().configure("hibernate.cfg.xml");
//		
//		ObjectMapper mapper = new ObjectMapper(); 
//		String respuesta;
//			try{		
//				java.text.SimpleDateFormat sdf = 
//					     new java.text.SimpleDateFormat("yyyy-MM-dd");
//
//					String currentTime = sdf.format(new Date());
//				Session session = HibernateUtil.getSessionFactory().openSession();
//		        session.beginTransaction();
//		        //TareasUsuariosVO tareaVO = mapper.readValue(tareaData, TareasUsuariosVO.class);
//		        TareasUsuariosVO tareaVO = mapper.readValue("asdf", TareasUsuariosVO.class);
//		        
//		        byte[] decoded = org.apache.commons.codec.binary.Base64.decodeBase64(tareaVO.getArchivoAdjunto().getBytes());
//		        
//			     String hql = "FROM entity.UsuariosEntity usuarios where usuarios.estado = 'ACT';";
//
//				 
//			     Query query = session.createQuery(hql);
//			     query.executeUpdate();
//			     session.getTransaction().commit();
//			     query.list();
//			     System.out.println(query.list());
//			     session.flush();
//				 session.close();
//				 
//				 respuesta = new Gson().toJson("Tarea Enviada correctamente");
//	}catch(Exception e){
//		
//	}
//	}
}

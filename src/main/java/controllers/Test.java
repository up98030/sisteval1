package controllers;

import java.util.Properties;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
//import org.jboss.logging.Message;

//import entity.TareasUsuariosEntity;

public class Test {
	
//	@org.junit.Test
//	public void sendMail(){
//		Properties props = new Properties();
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.socketFactory.port", "465");
//		props.put("mail.smtp.socketFactory.class",
//				"javax.net.ssl.SSLSocketFactory");
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.port", "465");
//
//		Session session = Session.getDefaultInstance(props,
//			new javax.mail.Authenticator() {
//				protected PasswordAuthentication getPasswordAuthentication() {
//					return new PasswordAuthentication("p98030@gmail.com","98030506");
//				}
//			});
//
//		try {
//
//			Message message = new MimeMessage(session);
//			message.setFrom(new InternetAddress("from@no-spam.com"));
//			message.setRecipients(Message.RecipientType.TO,
//					InternetAddress.parse("up98030@gmail.com"));
//			message.setSubject("Testing Subject");
//			message.setText("Dear Mail Crawler," +
//					"\n\n No spam to my email, please!");
//
//			Transport.send(message);
//
//			System.out.println("Done");
//
//		} catch (MessagingException e) {
//			throw new RuntimeException(e);
//		}
//	}
	
//	@org.junit.Test
	public void reporte(){
		try{
//			ObjectMapper mapper = new ObjectMapper(); 
//			ReporteVO reporteObj = mapper.readValue(reporteData, ReporteVO.class);
//			Configuration cf = new Configuration().configure("hibernate.cfg.xml");
//			
//			ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
//			srb.applySettings(cf.getProperties());
//			ServiceRegistry sr = srb.buildServiceRegistry();
//			SessionFactory sf = cf.buildSessionFactory(sr);
//
//			Session session = sf.openSession();
//			
//			StringBuilder hql = new StringBuilder();
//
//			hql.append("SELECT TARUSU FROM entity.TareasUsuariosEntity TARUSU ");
//			hql.append("LEFT JOIN TARUSU.tareasEntity TAR ");
//			hql.append("LEFT JOIN TARUSU.usuariosEntity USU ");
//			hql.append("LEFT JOIN USU.gruposUsuariosEntity GRUPUSU ");
//			hql.append("LEFT JOIN TAR.tiposTareasEntity TIPTAR ");
//			hql.append("WHERE TARUSU.estado IN ('CLF','ENV') ");
//			hql.append("AND GRUPUSU.idGrupoUsuario IN (4,5,6,7) ");
//			hql.append("AND TIPTAR.idTiposTareas IN (1,2) ");
//			hql.append("AND TAR.estado = 'ACT' ");
//			
//			Query query = session.createQuery(hql.toString());

//			Collection<TareasUsuariosEntity> reporteTareasUsuarios = (Collection<TareasUsuariosEntity>) query.list();
			
//			String reporte = new Gson().toJson(reporteTareasUsuarios);
//			System.out.println(reporte);
		}catch(Exception e){
			System.out.println("Error : " + e);
		}
	}
	
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
//	
//	@org.junit.Test
//	public void login(){
//		
//	}
}

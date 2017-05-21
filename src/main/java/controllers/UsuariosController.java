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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import ec.com.data.vo.UsuariosVo;
import entity.ModulosEntity;
import entity.PerfilesEntity;
import entity.UsuariosEntity;
import util.HibernateUtil;

@Controller
@RequestMapping("/ws")
public class UsuariosController {

	@RequestMapping(value = "/modulos/", method = RequestMethod.GET)
	public ResponseEntity<String> listAllModules(HttpServletResponse response) {
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");

		try {

			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
			response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

			ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
			srb.applySettings(cf.getProperties());
			ServiceRegistry sr = srb.buildServiceRegistry();
			SessionFactory sf = cf.buildSessionFactory(sr);

			Session session = sf.openSession();
			// TareasEntity std = (TareasEntity)
			// session.load(TareasEntity.class, new Long(2));

			String hql = "SELECT modulos FROM entity.ModulosEntity modulos where modulos.estado = 'ACT'";
			Query query = session.createQuery(hql);
			List<ModulosEntity> modulos;
			List results = query.list();
			modulos = query.list();
			String json = new Gson().toJson(modulos);

			session.close();
			sf.close();

			return new ResponseEntity<String>(json, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return new ResponseEntity<String>("Error al obtener lista modulos", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/perfiles/", method = RequestMethod.GET)
	public ResponseEntity<String> listarPerfiles(HttpServletResponse response) {
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");

		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
			response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

			ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
			srb.applySettings(cf.getProperties());
			ServiceRegistry sr = srb.buildServiceRegistry();
			SessionFactory sf = cf.buildSessionFactory(sr);

			Session session = sf.openSession();
			String hql = "SELECT perfiles FROM entity.PerfilesEntity perfiles where perfiles.estado = 'ACT'";
			Query query = session.createQuery(hql);
			List<PerfilesEntity> modulos;
			List results = query.list();
			modulos = query.list();
			String json = new Gson().toJson(modulos);

			session.close();
			sf.close();

			return new ResponseEntity<String>(json, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return new ResponseEntity<String>("Error al obtener lista perfiles", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

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
		// TareasEntity std = (TareasEntity) session.load(TareasEntity.class,
		// new Long(2));

		String hql = "SELECT usuarios FROM entity.UsuariosEntity usuarios where usuarios.estado = 'ACT'";
		Query query = session.createQuery(hql);
		List<UsuariosVo> usuarios;
		List results = query.list();
		usuarios = query.list();
		String json = new Gson().toJson(usuarios);

		// System.out.println("Loaded object Student name is: " +
		// std.getNombreTarea());
		// System.out.println("LOS RESULTADOS SON: " + results);

		session.close();
		sf.close();

		return new ResponseEntity<String>(json, HttpStatus.OK);
	}

	@RequestMapping(value = "/crearModulo/", method = RequestMethod.POST, consumes = { "application/xml",
			"application/json" })
	public ResponseEntity<String> crearModulo(HttpServletResponse response, @RequestBody String moduloData) {
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");

		ObjectMapper mapper = new ObjectMapper();
		String datosUsuario = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		try {
			ModulosEntity nuevoModulo = mapper.readValue(moduloData, ModulosEntity.class);

			UsuariosEntity usuariosEntity = new UsuariosEntity();

			if (nuevoModulo.getIdModulo() != null) {
				session.update(nuevoModulo);
			} else {
				session.save(nuevoModulo);
			}

			session.getTransaction().commit();

			String json = new Gson().toJson("Modulo Creado");
			return new ResponseEntity<String>(json, HttpStatus.OK);

		} catch (Exception e) {
			String json = new Gson().toJson("No se pudo crear modulo");
			return new ResponseEntity<String>(json, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/crearUsuario/", method = RequestMethod.POST, consumes = { "application/xml",
			"application/json" })
	public ResponseEntity<String> createUser(HttpServletResponse response, @RequestBody String userData) {
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");

		ObjectMapper mapper = new ObjectMapper();
		String datosUsuario = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		try {
			UsuariosVo usuarioVO = mapper.readValue(userData, UsuariosVo.class);

			UsuariosEntity usuariosEntity = new UsuariosEntity();

			usuariosEntity.setNombreUsuario(usuarioVO.getNombreUsuario());
			usuariosEntity.setNombreCompleto(usuarioVO.getNombreCompleto());
			usuariosEntity.setCorreoUsuario(usuarioVO.getCorreoUsuario());
			usuariosEntity.setPassword(usuarioVO.getPassword());
			usuariosEntity.setIdPerfil(usuarioVO.getIdPerfil());
			usuariosEntity.setIdModulo(usuarioVO.getIdModulo());
			usuariosEntity.setEstado(usuarioVO.getEstado());

			if (usuarioVO.getIdUsuario() != null) {
				usuariosEntity.setIdUsuario(usuarioVO.getIdUsuario());
				session.update(usuariosEntity);
			} else {
				session.save(usuariosEntity);
			}

			session.getTransaction().commit();

			String json = new Gson().toJson("Usuario Creado");
			return new ResponseEntity<String>(json, HttpStatus.OK);

		} catch (Exception e) {
			String json = new Gson().toJson("No se pudo crear usuario");
			return new ResponseEntity<String>(json, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/actualizarUsuario/", method = RequestMethod.POST, consumes = { "application/xml",
			"application/json" })
	public ResponseEntity<String> calificarTarea(HttpServletResponse response, @RequestBody String usuarioData) {
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");

		ObjectMapper mapper = new ObjectMapper();
		String respuesta;
		try {

			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			String hql = null;
			UsuariosVo usuarioVo = mapper.readValue(usuarioData, UsuariosVo.class);

			StringBuilder sentencia = new StringBuilder();

			hql = "UPDATE UsuariosEntity SET nombreUsuario = '" + usuarioVo.getNombreUsuario() + "', "
					+ "correoUsuario = '" + usuarioVo.getCorreoUsuario() + "', nombreCompleto = '"
					+ usuarioVo.getNombreCompleto() + "' ";

			sentencia.append(hql);

			if (!StringUtils.isEmpty(usuarioVo.getPassword())) {
				sentencia.append(", password = '" + usuarioVo.getPassword() + "' ");
			}

			sentencia.append("where idUsuario = " + usuarioVo.getIdUsuario());

			Query query = session.createQuery(sentencia.toString());
			query.executeUpdate();
			session.getTransaction().commit();
			session.flush();
			session.close();

			respuesta = new Gson().toJson("Usuario actualizado");
			return new ResponseEntity<String>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Gson().toJson("No se pudo actualizar usuario");
			System.out.println("Error: " + e.getMessage());
			return new ResponseEntity<String>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/actualizarModulo/", method = RequestMethod.POST, consumes = { "application/xml",
			"application/json" })
	public ResponseEntity<String> actualizarModulo(HttpServletResponse response, @RequestBody String moduloData) {
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");

		ObjectMapper mapper = new ObjectMapper();
		String respuesta;
		try {

			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			String hql = null;
			ModulosEntity moduloVo = mapper.readValue(moduloData, ModulosEntity.class);

			StringBuilder sentencia = new StringBuilder();

			hql = "UPDATE ModulosEntity SET estado = '" + moduloVo.getEstado() + "'";

			sentencia.append(hql);

			// if(!StringUtils.isEmpty(moduloVo.getPassword())){
			// sentencia.append(", password = '" + moduloVo.getPassword() + "'
			// ");
			// }

			sentencia.append("where idModulo = " + moduloVo.getIdModulo());

			Query query = session.createQuery(sentencia.toString());
			query.executeUpdate();
			session.getTransaction().commit();
			session.flush();
			session.close();

			respuesta = new Gson().toJson("Modulo actualizado");
			return new ResponseEntity<String>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Gson().toJson("No se pudo actualizar modulo");
			System.out.println("Error: " + e.getMessage());
			return new ResponseEntity<String>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

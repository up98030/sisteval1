package controllers;

import java.util.Collection;
import java.util.List;

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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import ec.com.data.vo.UserSummaryVO;
import ec.com.data.vo.UsuariosVo;
import entity.ModulosEntity;
import entity.PeriodosEntity;
import entity.TareasUsuariosEntity;
import entity.UsuariosEntity;
import util.HibernateUtil;

@Controller
@RequestMapping("/ws")
public class LoginController {

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/summary/", method = RequestMethod.POST, consumes = { "application/xml",
			"application/json" })
	public ResponseEntity<String> userSummary(HttpServletResponse response, @RequestBody String userData) {

		Configuration cf = new Configuration().configure("hibernate.cfg.xml");
		ObjectMapper mapper = new ObjectMapper();

		try {
			UsuariosVo usuarioVO = mapper.readValue(userData, UsuariosVo.class);

			ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
			srb.applySettings(cf.getProperties());
			ServiceRegistry sr = srb.buildServiceRegistry();
			SessionFactory sf = cf.buildSessionFactory(sr);

			Session session = sf.openSession();

			Criteria criteria = session.createCriteria(TareasUsuariosEntity.class, "root");
			criteria.createAlias("tareasEntity", "tareasEntity");

			criteria.add(Restrictions.eq("idUsuario", usuarioVO.getIdUsuario()));
			// criteria.add(Restrictions.eq("estado", "CRE"));
			criteria.add(Restrictions.eq("tareasEntity.idModulo", usuarioVO.getIdModulo()));
			criteria.add(Restrictions.eq("tareasEntity.estado", "ACT"));
			criteria.add(Restrictions.eq("tareasEntity.idPeriodo", usuarioVO.getIdPeriodo()));

			ProjectionList projections = Projections.projectionList();
			projections.add(Projections.property("idTareaUsuario"), "tareasUsuariosEntity.idTareaUsuario");
			projections.add(Projections.property("idUsuario"), "tareasUsuariosEntity.idUsuario");
			projections.add(Projections.property("idTarea"), "tareasUsuariosEntity.idTarea");
			projections.add(Projections.property("ObservacionesDocente"), "tareasUsuariosEntity.ObservacionesDocente");
			projections.add(Projections.property("ArchivoEnviado"), "tareasUsuariosEntity.ArchivoEnviado");
			projections.add(Projections.property("FechaEnvio"), "tareasUsuariosEntity.FechaEnvio");
			projections.add(Projections.property("estado"), "tareasUsuariosEntity.estado");
			projections.add(Projections.property("tareasEntity"), "tareasUsuariosEntity_tareasEntity");
			projections.add(Projections.property("tareasEntity.tipoTarea"),
					"tareasUsuariosEntity_tareasEntity_tipoTarea");
			projections.add(Projections.property("tareasEntity.nombreTarea"),
					"tareasUsuariosEntity_tareasEntity_nombreTarea");

			Collection<TareasUsuariosEntity> tareasReunionesUsuario = (Collection<TareasUsuariosEntity>) criteria
					.list();

			UserSummaryVO summary = new UserSummaryVO();

			Integer promedio = 0;
			int contador = 0;
			Integer tareasPendientes = 0;
			Integer reunionesPendientes = 0;
			for (TareasUsuariosEntity tarea : tareasReunionesUsuario) {
				if (tarea.getTareasEntity().getTipoTarea().equals("TAREA") && tarea.getEstado().equals("CLF")
						&& tarea.getCalificacion() != null) {
					promedio += tarea.getCalificacion();
					contador++;
				}
				if (tarea.getTareasEntity().getTipoTarea().equals("TAREA") && tarea.getEstado().equals("CRE")) {
					tareasPendientes++;
				}
				if (tarea.getTareasEntity().getTipoTarea().equals("REUNION") && tarea.getEstado().equals("CRE")) {
					reunionesPendientes++;
				}
			}
			summary.setTareasPendientes(tareasPendientes);
			summary.setReunionesPendientes(reunionesPendientes);

			if (contador > 0 && promedio > 0) {
				promedio = promedio / contador;
				summary.setPromedioNotas(promedio);
			} else {
				summary.setPromedioNotas(0);
			}
			String summaryJson = new Gson().toJson(summary);

			return new ResponseEntity<String>(summaryJson, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Error al obtener resumen de usuario");
			return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/login/", method = RequestMethod.POST, consumes = { "application/xml",
			"application/json" })
	public ResponseEntity<String> login(HttpServletResponse response, @RequestBody String userData) {
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");

		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		String datosUsuario = null;
		try {
			UsuariosEntity user = mapper.readValue(userData, UsuariosEntity.class);

			System.out.println("useDatar: " + userData);
			String[] userData1 = userData.split(",");
			String username = user.getNombreUsuario();
			String passwd = user.getPassword();
			System.out.println("User: " + user);
			System.out.println("Passwd: " + passwd);

			ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
			srb.applySettings(cf.getProperties());
			ServiceRegistry sr = srb.buildServiceRegistry();
			SessionFactory sf = cf.buildSessionFactory(sr);

			Session session = sf.openSession();

			String hql = "FROM entity.UsuariosEntity usuarios where usuarios.estado = 'ACT' and usuarios.nombreUsuario = '"
					+ username + "' and usuarios.password = '" + passwd + "'";
			Query query = session.createQuery(hql);
			query.setMaxResults(1);
			// List<UsuariosVo> usuario;
			UsuariosEntity usuario = (UsuariosEntity) query.uniqueResult();
			// usuario = query.list();

			if (!(usuario == null)) {
				datosUsuario = new Gson().toJson(usuario);
				return new ResponseEntity<String>(datosUsuario, HttpStatus.OK);
			} else {
				datosUsuario = new Gson().toJson("no existe usuario");
				System.out.println("No existe usuario");
				return new ResponseEntity<String>("Usuario o contraseña incorrectos", HttpStatus.FORBIDDEN);
			}

		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<String>("Usuario o contraseña incorrectos", HttpStatus.FORBIDDEN);

		}
		// response.setHeader("Access-Control-Allow-Origin", "*");
		// response.setHeader("Access-Control-Allow-Methods", "POST, GET,
		// OPTIONS, DELETE");
		// response.setHeader("Access-Control-Max-Age", "3600");
		// response.setHeader("Access-Control-Allow-Headers",
		// "x-requested-with");

	}

	@RequestMapping(value = "/periodos/", method = RequestMethod.GET)
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

			String hql = "SELECT periodos FROM entity.PeriodosEntity periodos";
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
			return new ResponseEntity<String>("Error al obtener lista periodos", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/crearPeriodo/", method = RequestMethod.POST, consumes = { "application/xml",
			"application/json" })
	public ResponseEntity<String> crearPeriodo(HttpServletResponse response, @RequestBody String periodoData) {
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");

		ObjectMapper mapper = new ObjectMapper();
		String datosUsuario = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		try {
			PeriodosEntity nuevoPeriodo = mapper.readValue(periodoData, PeriodosEntity.class);

			if (nuevoPeriodo.getIdPeriodo() != null) {
				session.update(nuevoPeriodo);
			} else {
				session.save(nuevoPeriodo);
			}

			session.getTransaction().commit();

			String json = new Gson().toJson("Periodo Creado");
			return new ResponseEntity<String>(json, HttpStatus.OK);

		} catch (Exception e) {
			String json = new Gson().toJson("No se pudo crear periodo");
			return new ResponseEntity<String>(json, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/actualizarPeriodoActivo/", method = RequestMethod.POST, consumes = { "application/xml",
			"application/json" })
	public ResponseEntity<String> actualizarPeriodoActivo(HttpServletResponse response,
			@RequestBody String periodoData) {
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");

		ObjectMapper mapper = new ObjectMapper();
		String datosUsuario = null;
		String respuesta = "";
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			String hql = null;
			PeriodosEntity periodo = mapper.readValue(periodoData, PeriodosEntity.class);

			hql = "UPDATE PeriodosEntity SET estado = 'INA'" ;

			Query query = session.createQuery(hql.toString());
			query.executeUpdate();
			session.getTransaction().commit();
			session.flush();

			hql = "UPDATE PeriodosEntity SET estado = 'ACT' where idPeriodo = " + periodo.getIdPeriodo() ;
			
			session.beginTransaction();
			query = session.createQuery(hql.toString());
			query.executeUpdate();
			session.getTransaction().commit();
			session.flush();
			
			respuesta = new Gson().toJson("Periodo actualizado");

			return new ResponseEntity<String>(respuesta, HttpStatus.OK);

		} catch (Exception e) {
			String json = new Gson().toJson("No se pudo crear periodo");
			return new ResponseEntity<String>(json, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

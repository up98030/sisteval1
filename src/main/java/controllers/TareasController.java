package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

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

	public static final Logger LOGGER = Logger.getLogger(TareasController.class.getName());

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/buscarUsuariosModulo/", method = RequestMethod.POST)
	public ResponseEntity<String> buscarUsuariosModulo(HttpServletResponse response, @RequestBody String moduloData) {
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");

		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		String usuariosModulo = null;
		try {
			ModulosEntity modulo = mapper.readValue(moduloData, ModulosEntity.class);

			ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
			srb.applySettings(cf.getProperties());
			ServiceRegistry sr = srb.buildServiceRegistry();
			SessionFactory sf = cf.buildSessionFactory(sr);

			Session session = sf.openSession();
			
			StringBuilder hql = new StringBuilder();

			hql.append("SELECT distinct usuarios FROM entity.UsuariosEntity usuarios where usuarios.estado = 'ACT'");
//			if(modulo.getIdModulo() != null){
//				hql.append(" AND usuarios.idModulo = " + modulo.getIdModulo()); 
//			}
			Query query = session.createQuery(hql.toString());

			Collection<UsuariosEntity> listaUsuariosModulo = (Collection<UsuariosEntity>) query.list();

			if (listaUsuariosModulo != null) {
				for(UsuariosEntity usuario : listaUsuariosModulo){
					usuario.setGruposUsuariosEntity(null);
				}
				usuariosModulo = new Gson().toJson(listaUsuariosModulo);
				return new ResponseEntity<String>(usuariosModulo, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No existen usuarios", HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>("Error al encontrar usuarios", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/tareas/{idTarea}/{idUsuario}", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<byte[]> obtenerArchivoBinesProductos(@PathVariable("idTarea") Integer idTarea,
			@PathVariable("idUsuario") Integer idUsuario, HttpServletResponse response) {

		Configuration cf = new Configuration().configure("hibernate.cfg.xml");

		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally

		try {
			ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
			srb.applySettings(cf.getProperties());
			ServiceRegistry sr = srb.buildServiceRegistry();
			SessionFactory sf = cf.buildSessionFactory(sr);

			Session session = sf.openSession();

			String hql = "FROM entity.TareasEntity tarea where tarea.idTarea = " + idTarea;
			Query query = session.createQuery(hql);

			TareasEntity tarea = (TareasEntity) query.uniqueResult();

			/**
			 * pablo generA 
			 * pablo eso que tienes en la base no sirve, hace falta poner algo bien
			 * estas?si
			 * a ya pero bueno ya aparece eso ya le puedo presentar mañana 
			 * mil gracias Michel!!!!!1
			 * :)
			 * pero puedes poner algo bueno en la base para probar
			 * mmm, no se esq guardo desde la aplicacion no se si se pueda ya voy a entrar 
			 * mira vamos a hacer una prueba, cogiendo una imagen del disco duro y mostrandola en la web
			 * si? ok
			 * 
			 * pablo? viste? si entonces algo esta guardando mal pero ya es eso no mas
			 * bueno ok
			 * GRACIAS MICHEELLL
			 * !!!
			 * d Bale dale
			 * YO TE RECOMPENSO ESTE FERIADO
			 * ;)jajajajajajajajajaja
			 * 
			 */
			if (tarea != null) {
				LOGGER.info("size file: " + (tarea.getArchivoAdjunto() != null ? tarea.getArchivoAdjunto().length : 0));
			}
			final byte[] lines = tarea.getArchivoAdjunto();
			
			// esto es para probar que el archivo que esta en la base es bueno 
//			FileUtils.writeByteArrayToFile(new File("d:\\prueba\\1.png"), lines);
			
			Path path = Paths.get("d:/prueba/test.jpg");
			byte[] data = Files.readAllBytes(path);

			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.setContentType(MediaType.IMAGE_PNG);
			responseHeaders.setCacheControl("private, max-age=0");
			responseHeaders.add("Content-Disposition", "attachment; filename=tarea.png");
			ServletOutputStream responseOutputStream = response.getOutputStream();
		    responseOutputStream.write(data);
		    responseOutputStream.flush();
		    responseOutputStream.close();

			return new ResponseEntity<byte[]>(lines, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			return new ResponseEntity<byte[]>(new byte[0], HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/tareas/", method = RequestMethod.POST)
	public ResponseEntity<String> listAllTareas(HttpServletResponse response, @RequestBody String tareasUsusariosVO) {

		Configuration cf = new Configuration().configure("hibernate.cfg.xml");

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		try {
			TareasUsuariosVO tareaUsuarioVO = mapper.readValue(tareasUsusariosVO, TareasUsuariosVO.class);
			ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
			srb.applySettings(cf.getProperties());
			ServiceRegistry sr = srb.buildServiceRegistry();
			SessionFactory sf = cf.buildSessionFactory(sr);

			Session session = sf.openSession();

			Criteria criteria = session.createCriteria(TareasUsuariosEntity.class, "root");
			criteria.createAlias("tareasEntity", "tareasEntity");
			criteria.createAlias("usuariosEntity", "usuariosEntity");

			if (tareaUsuarioVO.getIdUsuario() != null) {
				criteria.add(Restrictions.eq("idUsuario", tareaUsuarioVO.getIdUsuario()));
			}
			criteria.add(Restrictions.eq("estado", tareaUsuarioVO.getEstado()));
			if (tareaUsuarioVO.getTareasEntity() != null
					&& tareaUsuarioVO.getTareasEntity().getIdCreadorTarea() != null) {
				criteria.add(Restrictions.eq("tareasEntity.idCreadorTarea",
						tareaUsuarioVO.getTareasEntity().getIdCreadorTarea()));
			}
			// Fecha menor, son las reuniones proximas
			if (tareaUsuarioVO.getFechaEnvio() != null) {
				criteria.add(Restrictions.le("tareasEntity.fechaFin", new Date(tareaUsuarioVO.getFechaEnvio())));
			}

			// Fecha mayor son las reuniones pasadas
			if (tareaUsuarioVO.getFechaFin() != null) {
				criteria.add(Restrictions.ge("tareasEntity.fechaFin", new Date(tareaUsuarioVO.getFechaFin())));
			}

			ProjectionList projections = Projections.projectionList();
			projections.add(Projections.property("idTareaUsuario"), "tareasUsuariosEntity.idTareaUsuario");
			projections.add(Projections.property("idUsuario"), "tareasUsuariosEntity.idUsuario");
			projections.add(Projections.property("idTarea"), "tareasUsuariosEntity.idTarea");
			projections.add(Projections.property("ObservacionesDocente"), "tareasUsuariosEntity.ObservacionesDocente");
			projections.add(Projections.property("idTipoTarea"), "tareasUsuariosEntity.idTipoTarea");
			projections.add(Projections.property("ArchivoEnviado"), "tareasUsuariosEntity.ArchivoEnviado");
			projections.add(Projections.property("FechaEnvio"), "tareasUsuariosEntity.FechaEnvio");
			projections.add(Projections.property("estado"), "tareasUsuariosEntity.estado");

			Collection<TareasUsuariosEntity> tareas = (Collection<TareasUsuariosEntity>) criteria.list();
			
			for(TareasUsuariosEntity tarea : tareas){
				
				tarea.setBase64File(Base64.encodeBase64String(tarea.getTareasEntity().getArchivoAdjunto()));
				tarea.setGruposUsuariosEntity(null);
				tarea.setUsuariosEntity(null);
			}
			String json = new Gson().toJson(tareas);

			session.close();
			sf.close();

			return new ResponseEntity<String>(json, HttpStatus.OK);
		} catch (Exception e) {
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

		try {
			Criteria criteria = session.createCriteria(CriteriosEntity.class, "root");
			ProjectionList projections = Projections.projectionList();
			projections.add(Projections.property("idCriterio"), "idCriterio");
			projections.add(Projections.property("nombreCriterio"), "nombreCriterio");
			projections.add(Projections.property("estado"), "estado");
			projections.add(Projections.property("valorCriterio"), "valorCriterio");
			projections.add(Projections.property("descripcionCriterio"), "descripcionCriterio");

			// criteria.setProjection(Projections.distinct(projections));
			criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
			criterios = (Collection<CriteriosEntity>) criteria.list();
			System.out.println(criterios);
			session.flush();
		} catch (Exception e) {

		}
		String criteriosJson = new Gson().toJson(criterios);
		return new ResponseEntity<String>(criteriosJson, HttpStatus.OK);
	}

	@RequestMapping(value = "/crearTipoTarea/", method = RequestMethod.POST, consumes = { "application/xml",
			"application/json" })
	public ResponseEntity<String> crearTipoTarea(HttpServletResponse response, @RequestBody String tipoTareaData) {
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");

		ObjectMapper mapper = new ObjectMapper();
		String datosUsuario = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		try {
			TiposTareasEntity nuevoTipo = mapper.readValue(tipoTareaData, TiposTareasEntity.class);

			UsuariosEntity usuariosEntity = new UsuariosEntity();

			if (nuevoTipo.getIdTiposTareas() != null) {
				session.update(nuevoTipo);
			} else {
				session.save(nuevoTipo);
			}

			session.getTransaction().commit();

			String json = new Gson().toJson("Tipo tarea creada creado");
			return new ResponseEntity<String>(json, HttpStatus.OK);

		} catch (Exception e) {
			String json = new Gson().toJson("No se pudo crear tipo tarea");
			return new ResponseEntity<String>(json, HttpStatus.INTERNAL_SERVER_ERROR);
		}
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

		try {
			Criteria criteria = session.createCriteria(TiposTareasEntity.class, "root");
			criteria.add(Restrictions.eq("estado", "ACT"));

			tiposTareas = (Collection<TiposTareasEntity>) criteria.list();
			System.out.println(tiposTareas);
			session.flush();
			String criteriosJson = new Gson().toJson(tiposTareas);
			return new ResponseEntity<String>(criteriosJson, HttpStatus.OK);
		} catch (Exception e) {
			String json = new Gson().toJson("No se pudo obtener tipos tarea");
			return new ResponseEntity<String>(json, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public static byte[] loadFile(File file) {
		try {
			InputStream is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		long length = file.length();
		if (length > Integer.MAX_VALUE) {

		}
		byte[] bytes = new byte[(int) length];
		return bytes;
	}

	// public String encodeFileToBase64(String fileName){
	// File file = new File(fileName);
	// byte[] bytes = loadFile(file);
	// byte[] encoded = Base64.encodeBase64(bytes);
	// String encodedString = new String(encoded);
	// return encodedString;
	// }
	//
	// public byte[] decodeFileToBase64(String base64FileString){
	// byte[] file = Base64.decodeBase64(base64FileString);
	// return file;
	// }

	@RequestMapping(value = "/crearTarea/", method = RequestMethod.POST, consumes = { "application/xml",
			"application/json" })
	public ResponseEntity<String> crearTarea(HttpServletResponse response, @RequestBody String tareaData) {
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");

		ObjectMapper mapper = new ObjectMapper();
		String datosUsuario = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		try {
			TareasVO tareaVO = mapper.readValue(tareaData, TareasVO.class);

			TareasEntity tareasEntity = new TareasEntity();

			tareasEntity.setNombreTarea(tareaVO.getNombreTarea());
			tareasEntity.setFechaInicio(new Date());
			tareasEntity.setFechaFin(tareaVO.getFechaFin());
			tareasEntity.setEstado("ACT");
			tareasEntity.setIdTipoTarea(tareaVO.getIdTipoTarea());
			tareasEntity.setIdCreadorTarea(tareaVO.getIdCreadorTarea());
			tareasEntity.setCriterios(tareaVO.getCriterios());
			tareasEntity.setIdModulo(1);
			tareasEntity.setDescripcionTarea(tareaVO.getDescripcionTarea());
			tareasEntity.setExtensionArchivo(tareaVO.getExtensionArchivo());
			if (tareaVO.getArchivoAdjunto() != null) {		
				String base64Image = tareaVO.getArchivoAdjunto().split(",")[1];
				byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
//				byte[] decoded = Base64.decodeBase64(tareaVO.getArchivoAdjunto());
				tareasEntity.setArchivoAdjunto(imageBytes);
			}
			// tareasEntity.setArchivoAdjunto(Base64.getDecoder().decode(tareaVO.getArchivoAdjunto()));
			// tareasEntity.setArchivoAdjunto(decodeFileToBase64(tareaVO.getArchivoAdjunto()));

			session.save(tareasEntity);

			// String json = new Gson().toJson("Tarea Insertada...");
			for (TareasUsuariosEntity tareaUsuario : tareaVO.getTareasUsuarios()) {
				TareasUsuariosEntity tareaUsuariosEntity = new TareasUsuariosEntity();
				tareaUsuariosEntity.setIdUsuario(tareaUsuario.getIdUsuario());
				tareaUsuariosEntity.setIdTarea(tareasEntity.getIdTarea());
				tareaUsuariosEntity.setEstado("CRE");
				session.save(tareaUsuariosEntity);
			}

			session.getTransaction().commit();

			String json = new Gson().toJson("Tarea Creada");
			return new ResponseEntity<String>(json, HttpStatus.OK);

		} catch (Exception e) {
			String json = new Gson().toJson("No se pudo crear tarea");
			return new ResponseEntity<String>(json, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/enviarTarea/", method = RequestMethod.POST)
	public ResponseEntity<String> calificarTarea(HttpServletResponse response, @RequestBody String tareaData) {
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");

		ObjectMapper mapper = new ObjectMapper();
		String respuesta;
		try {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");

			String currentTime = sdf.format(new Date());
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			String hql = null;
			byte[] decoded = null;
			TareasUsuariosVO tareaVO = mapper.readValue(tareaData, TareasUsuariosVO.class);

			if (tareaVO.getCalificacion() == null || tareaVO.getCalificacion().toString().isEmpty()) {
				if(tareaVO.getArchivoAdjunto() != null){
					decoded = org.apache.commons.codec.binary.Base64.decodeBase64(tareaVO.getArchivoAdjunto().getBytes());
				}
				hql = "UPDATE TareasUsuariosEntity SET ObservacionesDocente = '" + tareaVO.getObservacionesDocente()
						+ "' , estado ='" + tareaVO.getEstado() + "', ArchivoEnviado='" + decoded + "' ,FechaEnvio = '"
						+ currentTime + "' where idTareaUsuario =" + tareaVO.getIdTareaUsuario();
			} else {
				hql = "UPDATE TareasUsuariosEntity SET calificacion = " + tareaVO.getCalificacion() + " , estado ='"
						+ tareaVO.getEstado() + "' ,ObservacionCalificacion = '" + tareaVO.getObservacionCalificacion()
						+ "' where idTareaUsuario =" + tareaVO.getIdTareaUsuario();
			}

			Query query = session.createQuery(hql);
			query.executeUpdate();
			session.getTransaction().commit();
			session.flush();
			session.close();

			respuesta = new Gson().toJson("Tarea Enviada correctamente");
			return new ResponseEntity<String>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta = new Gson().toJson("No se pudo enviar tarea");
			System.out.println("Error: " + e.getMessage());
			return new ResponseEntity<String>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/crearTareaArchivo/", method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = {
			"multipart/form-data", "application/x-www-form-urlencoded" })
	public ResponseEntity<String> procesarArchivoVentas(@RequestBody MultipartFile file) {

		try {

			if (file == null) {
				throw new Exception("El archivo esta vacio");
			}

			System.out.println("Procesando archivo {getOriginalFilename} ... " + file.getOriginalFilename());
			System.out.println("Procesando archivo {getBytes} ... " + file.getBytes());
			System.out.println("Procesando archivo {getInputStream} ... " + file.getInputStream());
			System.out.println("Procesando archivo {getContentType} ... " + file.getContentType());
			System.out.println("Procesando archivo {getName} ... " + file.getName());

			final Path pathArchivoVentasTemp = Files.createTempFile(file.getOriginalFilename(), null);
			file.transferTo(pathArchivoVentasTemp.toFile());

			return new ResponseEntity<String>("Exito", HttpStatus.OK);

		} catch (Exception e) {
			System.out.println("Error procesando archivo." + e);
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/uploadFile/", method = RequestMethod.POST)
	public @ResponseBody String upload(@RequestParam("file") MultipartFile file) {
		System.out.println("asdf");
		// System.out.println("Json: " + jsonForm);
		System.out.println("File: " + file.getSize());
		return null;

	}
	// public ResponseEntity<String> anularVenta(
	// @RequestParam(value = "infoClient") String infoClientString,
	// @RequestParam(value = "file") MultipartFile file) {

}

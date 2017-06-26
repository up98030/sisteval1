package controllers;

import java.util.ArrayList;
import java.util.Collection;
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
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import ec.com.data.vo.ReporteVO;
import entity.ModulosEntity;
import entity.TareasEntity;
import entity.TareasUsuariosEntity;
import entity.TiposTareasEntity;
import entity.UsuariosEntity;

@Controller
@RequestMapping("/ws")
public class ReportesController {

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/crearReporte/", method = RequestMethod.POST)
	public ResponseEntity<String> crearReporte(HttpServletResponse response, @RequestBody String reporteData) {
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");

		try {
			ObjectMapper mapper = new ObjectMapper();
			ReporteVO reporteObj = mapper.readValue(reporteData, ReporteVO.class);

			ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
			srb.applySettings(cf.getProperties());
			ServiceRegistry sr = srb.buildServiceRegistry();
			SessionFactory sf = cf.buildSessionFactory(sr);

			Session session = sf.openSession();

			StringBuilder hql = new StringBuilder();
			List<Integer> idsUsuarios = new ArrayList<Integer>();
			List<Integer> idsModulos = new ArrayList<Integer>();
			List<Integer> idsCategorias = new ArrayList<Integer>();
			List<Integer> idsTareas = new ArrayList<Integer>();

			hql.append("SELECT DISTINCT TARUSU FROM entity.TareasUsuariosEntity TARUSU ");
			hql.append("LEFT JOIN TARUSU.tareasEntity TAR ");
			hql.append("LEFT JOIN TARUSU.usuariosEntity USU ");
			hql.append("LEFT JOIN USU.gruposUsuariosEntity GRUPUSU ");
			hql.append("LEFT JOIN TAR.tiposTareasEntity TIPTAR ");
			hql.append("WHERE TAR.estado = 'ACT' ");
			if(StringUtils.isEmpty(reporteObj.getEstado())){
				hql.append("AND TARUSU.estado IN ('ENV','CLF') ");
			}else{
				hql.append("AND TARUSU.estado = '" + reporteObj.getEstado() + "'");
			}
			if (!CollectionUtils.isEmpty(reporteObj.getGrupos())) {
				for(ModulosEntity modulo : reporteObj.getGrupos()){
					idsModulos.add(modulo.getIdModulo());
				}
				hql.append("AND GRUPUSU.idModulo IN (:modulos) " );
//				hql.append("AND TAR.idModulo IN (:modulos) " );

			}
			if (!CollectionUtils.isEmpty(reporteObj.getCategorias())) {
				for(TiposTareasEntity categoria : reporteObj.getCategorias()){
					idsCategorias.add(categoria.getIdTiposTareas());
				}
				hql.append("AND TIPTAR.idTiposTareas IN (:categorias) ");

			}
			if (!CollectionUtils.isEmpty(reporteObj.getTareas())) {
				for(TareasEntity tarea : reporteObj.getTareas()){
					idsTareas.add(tarea.getIdTarea());
				}
				hql.append("AND TAR.idTarea IN (:tareas) ");
				
			}
			if (!CollectionUtils.isEmpty(reporteObj.getUsuarios())) {
				for(UsuariosEntity usuario : reporteObj.getUsuarios()){
					idsUsuarios.add(usuario.getIdUsuario());
				}
				hql.append("AND USU.idUsuario IN (:usuarios)" );
			}
			
			Query query = session.createQuery(hql.toString());
			if (!CollectionUtils.isEmpty(reporteObj.getGrupos())) {
				query.setParameterList("modulos", idsModulos);
			}
			if (!CollectionUtils.isEmpty(reporteObj.getCategorias())) {
				query.setParameterList("categorias", idsCategorias);
			}			
			if (!CollectionUtils.isEmpty(reporteObj.getUsuarios())) {
				query.setParameterList("usuarios", idsUsuarios);
			}			
			if (!CollectionUtils.isEmpty(reporteObj.getTareas())) {
				query.setParameterList("tareas", idsTareas);
			}			
			Double promedio = 0D;
			Collection<TareasUsuariosEntity> reporteTareasUsuarios = (Collection<TareasUsuariosEntity>) query.list();
			if(reporteObj.getUsuarios().size() == 1){
				for(TareasUsuariosEntity tarea : reporteTareasUsuarios){
					promedio += tarea.getCalificacion();
				}
				promedio = promedio/reporteTareasUsuarios.size();				
			}
			for(TareasUsuariosEntity tarea : reporteTareasUsuarios){
				tarea.setGruposUsuariosEntity(null);
				tarea.getUsuariosEntity().setGruposUsuariosEntity(null);
				tarea.getTareasEntity().setPromedio(promedio);
			}

			String reporte = new Gson().toJson(reporteTareasUsuarios);
			return new ResponseEntity<String>(reporte, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("Error al crear reporte ", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/tareasActivas/", method = RequestMethod.GET)
	public ResponseEntity<String> listAllTareas(HttpServletResponse response) {
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");
		try{
			ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
			srb.applySettings(cf.getProperties());
			ServiceRegistry sr = srb.buildServiceRegistry();
			SessionFactory sf = cf.buildSessionFactory(sr);

			Session session = sf.openSession();
			
			StringBuilder hql = new StringBuilder();
			hql.append("SELECT DISTINCT TAR FROM entity.TareasEntity TAR ");
			hql.append("WHERE TAR.estado = 'ACT'");
			Query query = session.createQuery(hql.toString());
			Collection<TareasEntity> tareasUsuarios = (Collection<TareasEntity>) query.list();
			String tareas = new Gson().toJson(tareasUsuarios);
			return new ResponseEntity<String>(tareas, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<String>("Error obtener lista tareas ", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}

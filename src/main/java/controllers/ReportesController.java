package controllers;

import java.util.Collection;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import ec.com.data.vo.ReporteVO;
import entity.ModulosEntity;
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
			Integer arregloIdUsuarios[]  = null;
			Integer arregloIdModulos[]  = null;
			Integer arregloIdCategorias[]  = null;

			hql.append("SELECT TARUSU FROM entity.TareasUsuariosEntity TARUSU ");
			hql.append("LEFT JOIN TARUSU.tareasEntity TAR ");
			hql.append("LEFT JOIN TARUSU.usuariosEntity USU ");
			hql.append("LEFT JOIN USU.gruposUsuariosEntity GRUPUSU ");
			hql.append("LEFT JOIN TAR.tiposTareasEntity TIPTAR ");
			hql.append("WHERE TAR.estado = 'ACT' ");
			hql.append("AND TARUSU.estado IN ('ENV','CLF') ");
			if (!CollectionUtils.isEmpty(reporteObj.getGrupos())) {
				int a = 0;
				arregloIdModulos = new Integer[reporteObj.getGrupos().size()];
				for(ModulosEntity modulo : reporteObj.getGrupos()){
					arregloIdModulos[a] = modulo.getIdModulo();
					a++;
				}
				hql.append("AND GRUPUSU.idModulo IN " + arregloIdModulos);

			}
			if (!CollectionUtils.isEmpty(reporteObj.getCategorias())) {
				int b = 0;
				arregloIdCategorias = new Integer[reporteObj.getCategorias().size()];
				for(TiposTareasEntity categoria : reporteObj.getCategorias()){
					arregloIdCategorias[b] = categoria.getIdTiposTareas();
					b++;
				}
				hql.append("AND TIPTAR.idTiposTareas IN " + arregloIdCategorias);

			}
			if (!CollectionUtils.isEmpty(reporteObj.getUsuarios())) {
				int x = 0;
				arregloIdUsuarios = new Integer[reporteObj.getUsuarios().size()];
				for(UsuariosEntity usuario : reporteObj.getUsuarios()){
					arregloIdUsuarios[x] = usuario.getIdUsuario();
					x++;
				}
				hql.append("AND USU.idUsuario IN " + arregloIdUsuarios);
			}
			
			Query query = session.createQuery(hql.toString());
			query.setparameter
			
			Collection<TareasUsuariosEntity> reporteTareasUsuarios = (Collection<TareasUsuariosEntity>) query.list();

			String reporte = new Gson().toJson(reporteTareasUsuarios);
			return new ResponseEntity<String>(reporte, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("Error al crear reporte ", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}

package com.projekat.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projekat.repository.PorudzbinaRepository;

import model.Porudzbina;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping(value = "/izvestajController")
public class IzvestajController {

	@Autowired
	PorudzbinaRepository pr;

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpServletResponse response;

	@RequestMapping(value = "/getPdf", method = RequestMethod.GET)
	public void generisiIzvestaj(List<Porudzbina> lista) throws Exception {

		try {
			response.setContentType("text/html");
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lista);
			InputStream inputStream = this.getClass().getResourceAsStream("/reports/IzvestajRestoran.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
			Map<String, Object> params = new HashMap<String, Object>();

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
			inputStream.close();

			response.setContentType("application/x-download");
			response.addHeader("Content-disposition", "attachment; filename=EasyFoodIzvestaj.pdf");
			OutputStream out = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, out);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/datum", method = RequestMethod.GET)
	public void datum(HttpServletRequest request, Date pocetniD, Date zavrsniD) {

		List<Porudzbina> porudzbine = pr.findByDatum(pocetniD, zavrsniD);

		request.getSession().setAttribute("porudzbine", porudzbine);

		try {
			generisiIzvestaj(porudzbine);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

}

package com.projekat.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projekat.repository.JelaRepository;
import com.projekat.repository.KategorijaRepositorty;
import com.projekat.repository.KuhinjaRepository;

import model.Jelo;
import model.Kategorija;
import model.Kuhinja;

@Controller
@RequestMapping(value = "/korisnikController")

public class KorisnikController {

	@Autowired
	JelaRepository jr;
	
	@Autowired
	KategorijaRepositorty kr;
	
	@Autowired
	KuhinjaRepository ku;
	
	@RequestMapping(value = "/pozoviStranicuJelo", method = RequestMethod.GET)
	public String otvoriJela(HttpServletRequest request) {
		
		List<Kategorija> kategorije = kr.findAll();
		List<Kuhinja> kuhinje = ku.findAll();
		
		request.getSession().setAttribute("kategorije", kategorije);
		request.getSession().setAttribute("kuhinje", kuhinje);
		
		return "jela";
	
	}
	
	@RequestMapping(value = "/prikazJela", method = RequestMethod.GET)
	public String prikaziJela(HttpServletRequest request, String kuhinja, String kategorija) {
		
		Kuhinja k = null;
		if(kuhinja!=null)
			k = ku.findById(Integer.parseInt(kuhinja)).get();
		Kategorija kat = null;
		if(kategorija!=null)
			kat = kr.findById(Integer.parseInt(kategorija)).get();
		List<Jelo> jela = new ArrayList<Jelo>();
		if(kat == null) 
			jela = jr.findByKuhinja(k);
		if(k == null)
			jela = jr.findByKategorija(kat);
		if(k != null && kat != null)
			jela = jr.findByKiK(kat.getIdKategorija(), k.getIdKuhinja());
			
		request.getSession().setAttribute("jela", jela);
		return "jela";
	}
	
	@RequestMapping(value = "/naruciJelo", method = RequestMethod.GET)
	public String naruciJelo(Integer id, HttpServletRequest request) {
		return "naruciJelo";
	}
}

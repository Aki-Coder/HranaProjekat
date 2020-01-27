package com.projekat.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projekat.repository.JelaRepository;
import com.projekat.repository.KategorijaRepositorty;
import com.projekat.repository.KomentarRepository;
import com.projekat.repository.KorisnikRepository;
import com.projekat.repository.KuhinjaRepository;
import com.projekat.repository.PorudzbinaRepository;

import model.Jelo;
import model.Kategorija;
import model.Komentar;
import model.Korisnik;
import model.Kuhinja;
import model.Porudzbina;

@Controller
@RequestMapping(value = "/korisnikController")

public class KorisnikController {

	@Autowired
	JelaRepository jr;
	
	@Autowired
	KategorijaRepositorty kr;
	
	@Autowired
	KuhinjaRepository ku;
	
	@Autowired
	PorudzbinaRepository pr;
	
	@Autowired
	KorisnikRepository ksr;
	
	@Autowired
	KomentarRepository komr;
	
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
	public String naruciJelo(HttpServletRequest request) {
		String jela [] = request.getParameterValues("checkBox");
		
		List<Jelo> listaJela = new ArrayList<>();
		for (String jelo : jela) {
			Jelo j = jr.findById(Integer.parseInt(jelo)).get();
			listaJela.add(j);
		}
		
	
		int cena = listaJela.stream().collect(Collectors.summingInt(Jelo::getCena));
		
		
	
		request.getSession().setAttribute("listaJela", listaJela);
		request.getSession().setAttribute("cena", cena);
		return "naruciJelo";
	}
	
	@RequestMapping(value = "/poruci", method = RequestMethod.POST)
	public String poruci(HttpServletRequest request,String adresa,Date datum,String nazivPorudzbine) {
		
		
		Integer cena =(Integer) request.getSession().getAttribute("cena");
		
		Porudzbina p = new Porudzbina();
		p.setAdresaPorudzbine(adresa);
		p.setDatum(datum);
		p.setUkupnaCena(cena);
		p.setNazivPorudzbine(nazivPorudzbine);
		
		p.setStatus("neisporucena");
		
		Korisnik k = (Korisnik) request.getSession().getAttribute("korisnik");
		p.setKorisnik1(k);
		p.setKorisnik2(null);
//		Korisnik k1 = ksr.findById(2).get();
//		p.setKorisnik2(k1);
		
		@SuppressWarnings("unchecked")
		List<Jelo> jelca = (List<Jelo>)request.getSession().getAttribute("listaJela");
		p.setJelos(jelca);
		
		Porudzbina poruci = pr.save(p);
		request.getSession().setAttribute("poruci", poruci);
		
		
		return "poruka";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	@RequestMapping(value = "/komentar", method = RequestMethod.GET)
	public String komentar(HttpServletRequest request,Integer id) {
		
		Jelo j = jr.findById(id).get();
		request.getSession().setAttribute("j", j);
		
		
		return "komentar";
	}
	
	@RequestMapping(value = "/ostaviKomentar", method = RequestMethod.POST)
	public String ostaviKomentar(HttpServletRequest request,Date datum,String komm) {
		Jelo j = (Jelo) request.getSession().getAttribute("j");
		
		Korisnik korisnik = ksr.findById(3).get();
		
		
		Komentar k = new Komentar();
		k.setDatum(datum);
		k.setJelo(j);
		k.setKorisnik(korisnik);
		k.setKomentar(komm);
		
		Komentar komentar = komr.save(k);
		return "komentar";
	}
	
	
}

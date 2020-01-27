package com.projekat.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping(value = "/vlasnikController")


public class VlasnikController {
	
	@Autowired
	JelaRepository jr;
	
	@Autowired
	KategorijaRepositorty kr;
	
	@Autowired
	KuhinjaRepository kuh;
	
	@Autowired
	KomentarRepository komr;
	
	@Autowired
	PorudzbinaRepository pr;
	
	@Autowired
	KorisnikRepository korr;
	


	@RequestMapping(value = "/unosJela", method = RequestMethod.POST)
	public String unesiJelo(HttpServletRequest request,String nazivJ,String detaljiJ,Integer cenaJ,String kuhinjaJ,String kategorijaJ) {
		
		Jelo j = new Jelo();
		j.setNaziv(nazivJ);
		j.setDetalji(detaljiJ);
		j.setCena(cenaJ);
	
		List<Kategorija> kategorije = kr.findByKategorija(kategorijaJ);
		List<Kuhinja> kuhinje = kuh.findByKuhinja(kuhinjaJ);
		
		
		Kuhinja k = null;
		if(kuhinje.isEmpty()) {
			k = new Kuhinja();
			k.setVrstaKuhinje(kuhinjaJ);
			k = kuh.save(k);
		}else {
			k = kuhinje.get(0);
		}
		
		Kategorija ku = null;
		if(kategorije.isEmpty()) {
			ku = new Kategorija();
			ku.setVrstaKategorije(kategorijaJ);
			ku = kr.save(ku);
		}else {
			ku = kategorije.get(0);
		}
		
		j.setKuhinja(k);
		j.setKategorija(ku);
		
		Jelo jelo = jr.save(j);
		request.getSession().setAttribute("jelo", jelo);
		return "unosJela";
	}
	
	@RequestMapping(value = "/pregledKomm",method = RequestMethod.GET)
	public String pogledajKomentar(HttpServletRequest request,String nazivJela) {
		
		
		
		List<Komentar> komentari = komr.findByKomentariZaJelo(nazivJela);
		
		request.getSession().setAttribute("komentari", komentari);
		
		return "pregledKomentara";
	}
	
	@RequestMapping(value = "/brisiKomentare", method = RequestMethod.GET)
	public String brisiKomentare(HttpServletRequest request) {
		
		String k [] = request.getParameterValues("checkBox");
			
		Arrays.stream(k)
		      .map(Integer::parseInt)
		      .map(kom -> komr.findById(kom).get())
		      .forEach(kom1 -> komr.delete(kom1));
		
		request.getSession().setAttribute("obrisano", true);
		return "pregledKomentara";
	}
	
	@RequestMapping(value = "/unosJelaAzuriraj", method = RequestMethod.GET)
	public String azuriraj(HttpServletRequest request,String nazivJ) {
		Jelo j = jr.findByNazivJela(nazivJ);
	
		
		request.getSession().setAttribute("jela", j);
		return "azuriraj";
	}
	
	@RequestMapping(value = "/azurirajCenu", method = RequestMethod.POST)
	public String azurirajCenu(HttpServletRequest request,String cena) {
		Integer c = Integer.parseInt(cena);
		
		Jelo jelo = (Jelo) request.getSession().getAttribute("jela");
		
		jelo.setCena(c);
		
		jr.save(jelo);
		request.getSession().setAttribute("jelo", jelo);
		
		
		return "azuriraj";
	}
	
	@RequestMapping(value = "/prikaziNarudzbine", method = RequestMethod.GET)
	public String dodeliRadnike(HttpServletRequest request) {
		
		
		List<Korisnik> radnici = korr.findByUloga("radnik");
		List<Porudzbina> p =  pr.findByStatus("neisporucena");
		
		request.getSession().setAttribute("radnici", radnici);
		request.getSession().setAttribute("porudzbine", p);
		
		return "narudzbine";
	}
	
	@RequestMapping(value = "/isporuci", method = RequestMethod.POST)
	public String isporuci(HttpServletRequest request, String por, String radnik) {
		Porudzbina poruzdbina = pr.findById(Integer.parseInt(por)).get();
		Korisnik korisnik = korr.findById(Integer.parseInt(radnik)).get();
		
		poruzdbina.setStatus("isporuceno");
		poruzdbina.setKorisnik2(korisnik);
		
		pr.save(poruzdbina);
		return dodeliRadnike(request);
	}
	

}

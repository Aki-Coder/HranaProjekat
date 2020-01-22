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
import com.projekat.repository.KomentarRepository;
import com.projekat.repository.KuhinjaRepository;

import model.Jelo;
import model.Kategorija;
import model.Komentar;
import model.Kuhinja;

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
		
//		String k [] = request.getParameterValues("checkBox");
//		
//		List<Komentar> listaKomentara = new ArrayList<>();
//		for (String komm : k) {
//			Komentar komentar = komr.findById(Integer.parseInt(komm)).get();
//			listaKomentara.add(komentar);
//		}
		
		List<Komentar> komentari = komr.findByKomentariZaJelo(nazivJela);
		
		request.getSession().setAttribute("komentari", komentari);
		//request.getSession().setAttribute("listaKomentara", listaKomentara);
		return "pregledKomentara";
	}
}

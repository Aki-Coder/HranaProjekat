package com.projekat.controller;

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
@RequestMapping(value = "/vlasnikController")


public class VlasnikController {
	
	@Autowired
	JelaRepository jr;
	
	@Autowired
	KategorijaRepositorty kr;
	
	@Autowired
	KuhinjaRepository kuh;

	@RequestMapping(value = "/unosJela", method = RequestMethod.POST)
	public String unesiJelo(HttpServletRequest request,String nazivJ,String detaljiJ,Integer cenaJ,String kuhinjaJ,String kategorijaJ) {
		

		
		Jelo j = new Jelo();
		j.setNaziv(nazivJ);
		j.setDetalji(detaljiJ);
		j.setCena(cenaJ);
	
		List<Kategorija> kategorije = kr.findByVrstaKategorije(kategorijaJ);
		List<Kuhinja> kuhinje = kuh.findByVrstaKuhinje(kuhinjaJ);
		
		Kuhinja k;
		if(kuhinje.isEmpty()) {
			k = new Kuhinja();
			k.setVrstaKuhinje(kuhinjaJ);
			kuh.save(k);
		}else {
			k = kuhinje.get(0);
		}
		
		Kategorija ku;
		if(kategorije.isEmpty()) {
			ku = new Kategorija();
			ku.setVrstaKategorije(kategorijaJ);
			kr.save(ku);
		}else {
			ku = kategorije.get(0);
		}
		
		j.setKuhinja(k);
		j.setKategorija(ku);
		
		Jelo jelo = jr.save(j);
		request.getSession().setAttribute("jelo", jelo);
		return "unosJela";
	}
}

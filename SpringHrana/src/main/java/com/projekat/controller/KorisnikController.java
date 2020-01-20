package com.projekat.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projekat.repository.JelaRepository;

import model.Jelo;

@Controller
@RequestMapping(value = "/korisnikController")

public class KorisnikController {

	@Autowired
	JelaRepository jr;
	
	@RequestMapping(value = "/prikazJela", method = RequestMethod.GET)
	public String prikazJela(HttpServletRequest request) {
		List<Jelo> jela = jr.findAll();
		
		request.getSession().setAttribute("jela", jela);
		return "pages/jela";
	}
}

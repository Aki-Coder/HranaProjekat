package com.projekat.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Porudzbina;

public interface PorudzbinaRepository extends JpaRepository<Porudzbina, Integer> {
	
	public List<Porudzbina> findByStatus(String status);
	
	@Query("select p from Porudzbina p  where p.datum >= :pocetniD and p.datum <= :zavrsniD")
	public List<Porudzbina> findByDatum(@Param("pocetniD") Date pocetniD, @Param("zavrsniD") Date zavrsniD);

}

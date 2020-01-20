package com.projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Jelo;
import model.Kategorija;
import model.Kuhinja;

public interface JelaRepository extends JpaRepository<Jelo, Integer>{
	
	public List<Jelo> findByKategorija(Kategorija k);
	
	public List<Jelo> findByKuhinja(Kuhinja k);
	
	@Query("select j from Jelo j where j.kategorija.idKategorija like :idK and j.kuhinja.idKuhinja like :idKuh")
	public List<Jelo> findByKiK(@Param("idK") Integer idK, @Param("idKuh") Integer idKuh);
	
}

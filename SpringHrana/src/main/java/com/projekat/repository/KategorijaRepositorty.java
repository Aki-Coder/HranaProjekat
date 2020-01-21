package com.projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Kategorija;

public interface KategorijaRepositorty  extends JpaRepository<Kategorija, Integer>{
	
//	@Query("select j from Jelo j where j.kategorija.vrstaKategorije like :vrstaKategorije ")
//	public List<Kategorija> findByJela(@Param("vrstaKategorije") String kategorija);

	public List<Kategorija> findByVrstaKategorije(String vrstaKategorije);
}

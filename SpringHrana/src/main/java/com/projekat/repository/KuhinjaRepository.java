package com.projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Jelo;
import model.Kuhinja;

public interface KuhinjaRepository extends JpaRepository<Kuhinja, Integer> {
	
	@Query("select j from Jelo j where j.kuhinja.vrstaKuhinje like :vrstaKuhinje")
	List<Kuhinja> findByKuhinja(@Param("vrstaKuhinje") String kuhinja);
	

}

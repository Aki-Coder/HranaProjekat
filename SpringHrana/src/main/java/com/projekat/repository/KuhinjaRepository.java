package com.projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Jelo;
import model.Kuhinja;

public interface KuhinjaRepository extends JpaRepository<Kuhinja, Integer> {
	
	@Query("select k from Kuhinja k where k.vrstaKuhinje like :vrstaKuhinje")
	public List<Kuhinja> findByKuhinja(@Param("vrstaKuhinje") String kuhinja);
	//public List<Kuhinja> findByVrstaKuhinje(String vrstaKuhinje);
	

}

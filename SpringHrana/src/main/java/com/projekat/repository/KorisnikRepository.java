package com.projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {
	
	public Korisnik findByUsername(String username);
	
	@Query("select k from Korisnik k where k.uloga.nazivUloga like :nazivUloga")
	public List<Korisnik> findByUloga(@Param("nazivUloga") String uloga);

}

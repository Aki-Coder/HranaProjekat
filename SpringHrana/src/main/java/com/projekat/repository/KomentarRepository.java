package com.projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Komentar;

public interface KomentarRepository extends JpaRepository<Komentar, Integer> {

	@Query("select k from Komentar k where k.komentar like :nazivJela")
	public List<Komentar> findByKomentariZaJelo(@Param("nazivJela") String naziv);
	//List<Komentar> findByJelo(String naziv);
}

package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Korisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKorisnik;

	private String adresa;

	private String ime;

	private String password;

	private String prezime;

	private String username;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="korisnik")
	private List<Komentar> komentars;

	//bi-directional many-to-one association to Uloga
	@ManyToOne
	@JoinColumn(name="Uloga_idUloga")
	private Uloga uloga;

	//bi-directional many-to-one association to Porudzbina
	@OneToMany(mappedBy="korisnik1")
	private List<Porudzbina> porudzbinas1;

	//bi-directional many-to-one association to Porudzbina
	@OneToMany(mappedBy="korisnik2")
	private List<Porudzbina> porudzbinas2;

	public Korisnik() {
	}

	public int getIdKorisnik() {
		return this.idKorisnik;
	}

	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Komentar> getKomentars() {
		return this.komentars;
	}

	public void setKomentars(List<Komentar> komentars) {
		this.komentars = komentars;
	}

	public Komentar addKomentar(Komentar komentar) {
		getKomentars().add(komentar);
		komentar.setKorisnik(this);

		return komentar;
	}

	public Komentar removeKomentar(Komentar komentar) {
		getKomentars().remove(komentar);
		komentar.setKorisnik(null);

		return komentar;
	}

	public Uloga getUloga() {
		return this.uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

	public List<Porudzbina> getPorudzbinas1() {
		return this.porudzbinas1;
	}

	public void setPorudzbinas1(List<Porudzbina> porudzbinas1) {
		this.porudzbinas1 = porudzbinas1;
	}

	public Porudzbina addPorudzbinas1(Porudzbina porudzbinas1) {
		getPorudzbinas1().add(porudzbinas1);
		porudzbinas1.setKorisnik1(this);

		return porudzbinas1;
	}

	public Porudzbina removePorudzbinas1(Porudzbina porudzbinas1) {
		getPorudzbinas1().remove(porudzbinas1);
		porudzbinas1.setKorisnik1(null);

		return porudzbinas1;
	}

	public List<Porudzbina> getPorudzbinas2() {
		return this.porudzbinas2;
	}

	public void setPorudzbinas2(List<Porudzbina> porudzbinas2) {
		this.porudzbinas2 = porudzbinas2;
	}

	public Porudzbina addPorudzbinas2(Porudzbina porudzbinas2) {
		getPorudzbinas2().add(porudzbinas2);
		porudzbinas2.setKorisnik2(this);

		return porudzbinas2;
	}

	public Porudzbina removePorudzbinas2(Porudzbina porudzbinas2) {
		getPorudzbinas2().remove(porudzbinas2);
		porudzbinas2.setKorisnik2(null);

		return porudzbinas2;
	}

}
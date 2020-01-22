package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Jelo database table.
 * 
 */
@Entity
@NamedQuery(name="Jelo.findAll", query="SELECT j FROM Jelo j")
public class Jelo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idJelo;

	private int cena;

	private String detalji;

	private String naziv;

	//bi-directional many-to-one association to Kategorija
	@ManyToOne
	@JoinColumn(name="Kategorija_idKategorija")
	private Kategorija kategorija;

	//bi-directional many-to-one association to Kuhinja
	@ManyToOne
	@JoinColumn(name="Kuhinja_idKuhinja")
	private Kuhinja kuhinja;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="jelo")
	private List<Komentar> komentars;

	//bi-directional many-to-many association to Porudzbina
	@ManyToMany(mappedBy="jelos")
	private List<Porudzbina> porudzbinas;

	public Jelo() {
	}

	public int getIdJelo() {
		return this.idJelo;
	}

	public void setIdJelo(int idJelo) {
		this.idJelo = idJelo;
	}

	public int getCena() {
		return this.cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public String getDetalji() {
		return this.detalji;
	}

	public void setDetalji(String detalji) {
		this.detalji = detalji;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Kategorija getKategorija() {
		return this.kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	public Kuhinja getKuhinja() {
		return this.kuhinja;
	}

	public void setKuhinja(Kuhinja kuhinja) {
		this.kuhinja = kuhinja;
	}

	public List<Komentar> getKomentars() {
		return this.komentars;
	}

	public void setKomentars(List<Komentar> komentars) {
		this.komentars = komentars;
	}

	public Komentar addKomentar(Komentar komentar) {
		getKomentars().add(komentar);
		komentar.setJelo(this);

		return komentar;
	}

	public Komentar removeKomentar(Komentar komentar) {
		getKomentars().remove(komentar);
		komentar.setJelo(null);

		return komentar;
	}

	public List<Porudzbina> getPorudzbinas() {
		return this.porudzbinas;
	}

	public void setPorudzbinas(List<Porudzbina> porudzbinas) {
		this.porudzbinas = porudzbinas;
	}

}
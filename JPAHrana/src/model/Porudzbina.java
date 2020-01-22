package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Porudzbina database table.
 * 
 */
@Entity
@NamedQuery(name="Porudzbina.findAll", query="SELECT p FROM Porudzbina p")
public class Porudzbina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPorudzbina;

	private String adresaPorudzbine;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datum;

	private String nazivPorudzbine;

	private String status;

	private int ukupnaCena;

	//bi-directional many-to-many association to Jelo
	@ManyToMany
	@JoinTable(
		name="Stavka"
		, joinColumns={
			@JoinColumn(name="Porudzbina_idPorudzbina")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Jelo_idJelo")
			}
		)
	private List<Jelo> jelos;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="Korisnik_idKorisnikGost")
	private Korisnik korisnik1;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="Korisnik_idKorisnikRadnik")
	private Korisnik korisnik2;

	public Porudzbina() {
	}

	public int getIdPorudzbina() {
		return this.idPorudzbina;
	}

	public void setIdPorudzbina(int idPorudzbina) {
		this.idPorudzbina = idPorudzbina;
	}

	public String getAdresaPorudzbine() {
		return this.adresaPorudzbine;
	}

	public void setAdresaPorudzbine(String adresaPorudzbine) {
		this.adresaPorudzbine = adresaPorudzbine;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getNazivPorudzbine() {
		return this.nazivPorudzbine;
	}

	public void setNazivPorudzbine(String nazivPorudzbine) {
		this.nazivPorudzbine = nazivPorudzbine;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getUkupnaCena() {
		return this.ukupnaCena;
	}

	public void setUkupnaCena(int ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}

	public List<Jelo> getJelos() {
		return this.jelos;
	}

	public void setJelos(List<Jelo> jelos) {
		this.jelos = jelos;
	}

	public Korisnik getKorisnik1() {
		return this.korisnik1;
	}

	public void setKorisnik1(Korisnik korisnik1) {
		this.korisnik1 = korisnik1;
	}

	public Korisnik getKorisnik2() {
		return this.korisnik2;
	}

	public void setKorisnik2(Korisnik korisnik2) {
		this.korisnik2 = korisnik2;
	}

}
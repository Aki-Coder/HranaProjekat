package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Stavka database table.
 * 
 */
@Entity
@NamedQuery(name="Stavka.findAll", query="SELECT s FROM Stavka s")
public class Stavka implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idStavka;

	//bi-directional many-to-one association to Jelo
	@ManyToOne
	@JoinColumn(name="Jelo_idJelo")
	private Jelo jelo;

	//bi-directional many-to-one association to Porudzbina
	@ManyToOne
	@JoinColumn(name="Porudzbina_idPorudzbina")
	private Porudzbina porudzbina;

	public Stavka() {
	}

	public int getIdStavka() {
		return this.idStavka;
	}

	public void setIdStavka(int idStavka) {
		this.idStavka = idStavka;
	}

	public Jelo getJelo() {
		return this.jelo;
	}

	public void setJelo(Jelo jelo) {
		this.jelo = jelo;
	}

	public Porudzbina getPorudzbina() {
		return this.porudzbina;
	}

	public void setPorudzbina(Porudzbina porudzbina) {
		this.porudzbina = porudzbina;
	}

}
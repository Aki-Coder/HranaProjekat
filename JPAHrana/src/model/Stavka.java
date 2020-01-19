package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	//bi-directional many-to-one association to Porudzbina
	@OneToMany(mappedBy="stavka")
	private List<Porudzbina> porudzbinas;

	//bi-directional many-to-one association to Jelo
	@ManyToOne
	@JoinColumn(name="Jelo_idJelo")
	private Jelo jelo;

	public Stavka() {
	}

	public int getIdStavka() {
		return this.idStavka;
	}

	public void setIdStavka(int idStavka) {
		this.idStavka = idStavka;
	}

	public List<Porudzbina> getPorudzbinas() {
		return this.porudzbinas;
	}

	public void setPorudzbinas(List<Porudzbina> porudzbinas) {
		this.porudzbinas = porudzbinas;
	}

	public Porudzbina addPorudzbina(Porudzbina porudzbina) {
		getPorudzbinas().add(porudzbina);
		porudzbina.setStavka(this);

		return porudzbina;
	}

	public Porudzbina removePorudzbina(Porudzbina porudzbina) {
		getPorudzbinas().remove(porudzbina);
		porudzbina.setStavka(null);

		return porudzbina;
	}

	public Jelo getJelo() {
		return this.jelo;
	}

	public void setJelo(Jelo jelo) {
		this.jelo = jelo;
	}

}
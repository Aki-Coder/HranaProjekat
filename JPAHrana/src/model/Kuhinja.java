package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Kuhinja database table.
 * 
 */
@Entity
@NamedQuery(name="Kuhinja.findAll", query="SELECT k FROM Kuhinja k")
public class Kuhinja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKuhinja;

	private String vrstaKuhinje;

	//bi-directional many-to-one association to Jelo
	@OneToMany(mappedBy="kuhinja")
	private List<Jelo> jelos;

	public Kuhinja() {
	}

	public int getIdKuhinja() {
		return this.idKuhinja;
	}

	public void setIdKuhinja(int idKuhinja) {
		this.idKuhinja = idKuhinja;
	}

	public String getVrstaKuhinje() {
		return this.vrstaKuhinje;
	}

	public void setVrstaKuhinje(String vrstaKuhinje) {
		this.vrstaKuhinje = vrstaKuhinje;
	}

	public List<Jelo> getJelos() {
		return this.jelos;
	}

	public void setJelos(List<Jelo> jelos) {
		this.jelos = jelos;
	}

	public Jelo addJelo(Jelo jelo) {
		getJelos().add(jelo);
		jelo.setKuhinja(this);

		return jelo;
	}

	public Jelo removeJelo(Jelo jelo) {
		getJelos().remove(jelo);
		jelo.setKuhinja(null);

		return jelo;
	}

}
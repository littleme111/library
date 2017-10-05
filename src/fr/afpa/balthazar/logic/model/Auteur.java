package fr.afpa.balthazar.logic.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;


/**
 * @PrimaryKeyJoinColumn : self explanatory name : key on which to join.
 * !!!! Annoations always on getters
 *
 */


@Entity
@Table(name="auteur")
@PrimaryKeyJoinColumn(name="id_personne")
public class Auteur extends Personne{

	private String alias;

	private Set<Livre> ecrits;


	@Column(name="alias")
	public String getAlias() {
		return alias;
	}


	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "auteurs")
	public Set<Livre> getEcrits() {
		return ecrits;
	}


	public void setAlias(String alias) {
		this.alias = alias;
	}
	public void setEcrits(Set<Livre> ecrits) {
		this.ecrits = ecrits;
	}
}

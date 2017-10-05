package fr.afpa.balthazar.logic.model;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.joda.time.DateTime;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;
import java.util.Collection;

/**
 * @PrimaryKeyJoinColumn : self explanatory name : kay on which to join.
 * !!!! Annoations always on getters
 */

@Entity
@Table(name="abonne", uniqueConstraints= @UniqueConstraint(columnNames = {"email", "noAbonne"}))
@PrimaryKeyJoinColumn(name="id_personne")
@Validated
public class Abonne extends Personne {



    private String email;


    private String noAbonne;

    private Set<Historique> historique;
    private int nbEmprunts;

    public Abonne() {

    }

    public Abonne(String email,  String nom, String prenom, DateTime date) {
        super(nom, prenom, date);
        this.email = email;
        this.nbEmprunts = 0;


    }

    public Abonne(String email,  Set<Historique> historique) {
        this.email = email;
        this.historique = historique;
    }


    @Column(name="email")
    @NotNull
    @Size(min=3, max = 50)
    @Email
    public String getEmail() { return email; }

    @Column(name="noAbonne")
    public String getNoAbonne() {
        return noAbonne;
    }


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "abonne")
    //Subselect to avoid doubles whilst using criteriion.
    @Fetch(FetchMode.SUBSELECT)
    public Set<Historique> getHistorique() {
        return historique;
    }

    @Column(name="nbEmprunts")
    public int getNbEmprunts() {
        return nbEmprunts;
    }

    public void setNbEmprunts(int nbEmprunts) {
        this.nbEmprunts = nbEmprunts;
    }

    public void setEmail(String email) { this.email = email; }
    public void setHistorique(Set<Historique> historique) {
        this.historique = historique;
    }
    public void setNoAbonne(String noAbonne) {
        this.noAbonne = noAbonne;
    }


    @Override
    public String toString() {
        return "Abonne{" +
                "email='" + email + '\'' +
                ", noAbonne='" + noAbonne + '\'' +
                ", historique=" + historique +
                ", nbEmprunts=" + nbEmprunts +
                "} " + super.toString();
    }
}

package fr.afpa.balthazar.logic.model;

import org.joda.time.DateTime;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 * Abstract class person centralizes common ionformation from authors and users.
 *
 *
 * @Entity notation : marks entity as table.
 * @Table name = alows speicification on table name, if null class name is used.
 * @Inheritance Strategy : Joined, joins sub classes - authors and abonnes
 */
@Entity
@Table(name="personnes")
@Inheritance(strategy= InheritanceType.JOINED)
@Validated
public abstract class Personne {


    private Long id_personne;

    private String prenom;

    private String nom;

    private DateTime date_naissance;

    public Personne() {
    }

    public Personne(String prenom, String nom, DateTime date_naissance) {
        this.prenom = prenom;
        this.nom = nom;
        this.date_naissance = date_naissance;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personne")
    public Long getId() {
        return id_personne;
    }

    public void setId(Long id) {
        this.id_personne = id;
    }


    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    @Column(name = "prenom")
    @NotNull
    @Size(min = 3, max = 25, message = "Votre nom doit faire entre {min} et {max} caractères.")
    public String getPrenom() {
        return prenom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }
    @Column(name = "nom")
    @NotNull
    @Size(min = 3, max = 25)
    public String getNom() {
        return nom;
    }


    public void setDate_naissance(DateTime date_naissance) {
        this.date_naissance = date_naissance;
    }

    @Column(name="date_naissance")
    @NotNull
    @Past
    public DateTime getDate_naissance() {
        return date_naissance;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id_personne=" + id_personne +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", date_naissance=" + date_naissance +
                '}';
    }
}

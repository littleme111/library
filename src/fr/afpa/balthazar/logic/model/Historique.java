package fr.afpa.balthazar.logic.model;

import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table(name="historique")
public class Historique {

    private Long id_historique;
    private DateTime date_emp;
    private DateTime date_ret;
    private Abonne abonne;
    private Exemplaire exemplaire;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId_historique() {
        return id_historique;
    }

    public void setId_historique(Long id_historique) {
        this.id_historique = id_historique;
    }
    @Column(name="date_emp")
    public DateTime getDate_emp() {
        return date_emp;
    }

    public void setDate_emp(DateTime date_emp) {
        this.date_emp = date_emp;
    }
    @Column(name="date_ret")
    public DateTime getDate_ret() {
        return date_ret;
    }

    public void setDate_ret(DateTime date_ret) {
        this.date_ret = date_ret;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_personne")
    public Abonne getAbonne() {
        return abonne;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_exemplaire")
    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }
}

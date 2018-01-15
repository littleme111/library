package fr.afpa.balthazar.logic.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="exemplaire")
public class Exemplaire {


    private Long id_exemplaire;
    private boolean disponible;
    private Livre livre;
    private Set<Historique> historique;

    public Exemplaire() {
    }

    public Exemplaire(boolean disponible, Livre livre) {
        this.disponible = disponible;
        this.livre = livre;
    }

    @Id
    @Column(name="id_exemplaire")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId_exemplaire() {
        return id_exemplaire;
    }

    public void setId_exemplaire(Long id_exemplaire) {
        this.id_exemplaire = id_exemplaire;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ISBN")
    public Livre getLivre() {
        return livre;
    }


    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "exemplaire")
    public Set<Historique> getHistorique() {
        return historique;
    }

    public void setHistorique(Set<Historique> historique) {
        this.historique = historique;
    }
}

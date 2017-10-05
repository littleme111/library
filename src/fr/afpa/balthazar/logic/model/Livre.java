package fr.afpa.balthazar.logic.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;



@Entity
@Table(name="livre")
public class Livre {


    private String ISBN;
    private String title;
    private String sub_title;
    private Collection collection;
    private Set<Auteur> auteurs = new HashSet<Auteur>();
    private Set<Exemplaire> exemplaires;


    public Livre() {
    }

    public Livre(String ISBN, String title, String sub_title, String nomCollection) {
        this.collection = new Collection(nomCollection);
        this.collection.setNomCollection(nomCollection);
        this.ISBN = ISBN;
        this.title = title;
        this.sub_title = sub_title;
    }

    @Id
    @Column(name="ISBN")
    @Size(min = 13, max = 13, message = "L'ISBN d'un livre fait exactement 13 caractères ")
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    @Column(name="titre")
    @NotNull
    @Size(min = 3, max = 50, message="Le titre doit faire au moins 3 caractères.")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Column(name="sous_titre")
    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    @ManyToOne
    @JoinColumn(name="id_collection")
    public Collection getCollection() {
        return collection;
    }
    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ecrit",
            joinColumns = @JoinColumn(name = "ISBN", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_personne"))
    @Fetch(FetchMode.SUBSELECT)
    public Set<Auteur> getAuteurs() {
        return auteurs;
    }

    public void setAuteurs(Set<Auteur> auteurs) {
        this.auteurs = auteurs;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "livre")
    @Fetch(FetchMode.SUBSELECT)
    public Set<Exemplaire> getExemplaires() {
        return exemplaires;
    }

    public void setExemplaires(Set<Exemplaire> exemplaires) {
        this.exemplaires = exemplaires;
    }


    @Transient
    public boolean isDisponible(){
        for(Exemplaire e: this.exemplaires){
            if(e.isDisponible()){
               return true;
            }else{
                continue;
            }

        }
        return false;
    }
}

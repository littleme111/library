package fr.afpa.balthazar.logic.model;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;
@Entity
@Table(name="COLLECTION")
public class Collection {


    private String id;

    private String nomCollection;

    private Set<Livre> livresCollection;

    public Collection() {}

    public Collection(String nomCollection) {
        this.nomCollection = nomCollection;
    }


    @Id
    @Column(name="id_collection")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getId() {
        return id;
    }

    @Column(name="nom")
    @Size(min = 3, max = 30)
    public String getNomCollection() {
        return nomCollection;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "collection")
    @Transient
    public Set<Livre> getLivresCollection() {
        return livresCollection;
    }


    public void setId(String id) {
        this.id = id;
    }
    public void setNomCollection(String nomCollection) {
        this.nomCollection = nomCollection;
    }
    public void setLivresCollection(Set<Livre> livresCollection) {
        this.livresCollection = livresCollection;
    }
}

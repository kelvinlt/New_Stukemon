/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author x2382383c
 */
@Entity
@Table(name = "trainer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trainer.findAll", query = "SELECT t FROM Trainer t")
    , @NamedQuery(name = "Trainer.findByName", query = "SELECT t FROM Trainer t WHERE t.name = :name")
    , @NamedQuery(name = "Trainer.findByPokeballs", query = "SELECT t FROM Trainer t WHERE t.pokeballs = :pokeballs")
    , @NamedQuery(name = "Trainer.findByPotions", query = "SELECT t FROM Trainer t WHERE t.potions = :potions")
    , @NamedQuery(name = "Trainer.findByPoints", query = "SELECT t FROM Trainer t WHERE t.points = :points")})
public class Trainer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pokeballs")
    private int pokeballs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "potions")
    private int potions;
    @Basic(optional = false)
    @NotNull
    @Column(name = "points")
    private int points;
    @OneToMany(mappedBy = "trainer")
    private Collection<Pokemon> pokemonCollection;

    public Trainer() {
    }

    public Trainer(String name) {
        this.name = name;
    }

    public Trainer(String name, int pokeballs, int potions, int points) {
        this.name = name;
        this.pokeballs = pokeballs;
        this.potions = potions;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPokeballs() {
        return pokeballs;
    }

    public void setPokeballs(int pokeballs) {
        this.pokeballs = pokeballs;
    }

    public int getPotions() {
        return potions;
    }

    public void setPotions(int potions) {
        this.potions = potions;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @XmlTransient
    public Collection<Pokemon> getPokemonCollection() {
        return pokemonCollection;
    }

    public void setPokemonCollection(Collection<Pokemon> pokemonCollection) {
        this.pokemonCollection = pokemonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trainer)) {
            return false;
        }
        Trainer other = (Trainer) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Trainer[ name=" + name + " ]";
    }
    
}

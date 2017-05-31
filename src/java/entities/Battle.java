/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author x2382383c
 */
@Entity
@Table(name = "battle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Battle.findAll", query = "SELECT b FROM Battle b")
    , @NamedQuery(name = "Battle.findByIdbattle", query = "SELECT b FROM Battle b WHERE b.idbattle = :idbattle")})
public class Battle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbattle")
    private Integer idbattle;
    @JoinColumn(name = "pokemon1", referencedColumnName = "name")
    @ManyToOne(optional = false)
    private Pokemon pokemon1;
    @JoinColumn(name = "pokemon2", referencedColumnName = "name")
    @ManyToOne(optional = false)
    private Pokemon pokemon2;
    @JoinColumn(name = "winner", referencedColumnName = "name")
    @ManyToOne
    private Pokemon winner;

    public Battle() {
    }

    public Battle(Integer idbattle) {
        this.idbattle = idbattle;
    }

    public Integer getIdbattle() {
        return idbattle;
    }

    public void setIdbattle(Integer idbattle) {
        this.idbattle = idbattle;
    }

    public Pokemon getPokemon1() {
        return pokemon1;
    }

    public void setPokemon1(Pokemon pokemon1) {
        this.pokemon1 = pokemon1;
    }

    public Pokemon getPokemon2() {
        return pokemon2;
    }

    public void setPokemon2(Pokemon pokemon2) {
        this.pokemon2 = pokemon2;
    }

    public Pokemon getWinner() {
        return winner;
    }

    public void setWinner(Pokemon winner) {
        this.winner = winner;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbattle != null ? idbattle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Battle)) {
            return false;
        }
        Battle other = (Battle) object;
        if ((this.idbattle == null && other.idbattle != null) || (this.idbattle != null && !this.idbattle.equals(other.idbattle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Battle[ idbattle=" + idbattle + " ]";
    }
    
}

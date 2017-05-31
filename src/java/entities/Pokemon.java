/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "pokemon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pokemon.findAll", query = "SELECT p FROM Pokemon p")
    , @NamedQuery(name = "Pokemon.findByName", query = "SELECT p FROM Pokemon p WHERE p.name = :name")
    , @NamedQuery(name = "Pokemon.findByType", query = "SELECT p FROM Pokemon p WHERE p.type = :type")
    , @NamedQuery(name = "Pokemon.findByAbility", query = "SELECT p FROM Pokemon p WHERE p.ability = :ability")
    , @NamedQuery(name = "Pokemon.findByAttack", query = "SELECT p FROM Pokemon p WHERE p.attack = :attack")
    , @NamedQuery(name = "Pokemon.findByDefense", query = "SELECT p FROM Pokemon p WHERE p.defense = :defense")
    , @NamedQuery(name = "Pokemon.findBySpeed", query = "SELECT p FROM Pokemon p WHERE p.speed = :speed")
    , @NamedQuery(name = "Pokemon.findByLife", query = "SELECT p FROM Pokemon p WHERE p.life = :life")
    , @NamedQuery(name = "Pokemon.findByLevel", query = "SELECT p FROM Pokemon p WHERE p.level = :level")})
public class Pokemon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ability")
    private String ability;
    @Basic(optional = false)
    @NotNull
    @Column(name = "attack")
    private int attack;
    @Basic(optional = false)
    @NotNull
    @Column(name = "defense")
    private int defense;
    @Basic(optional = false)
    @NotNull
    @Column(name = "speed")
    private int speed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "life")
    private int life;
    @Basic(optional = false)
    @NotNull
    @Column(name = "level")
    private int level;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pokemon1")
    private Collection<Battle> battleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pokemon2")
    private Collection<Battle> battleCollection1;
    @OneToMany(mappedBy = "winner")
    private Collection<Battle> battleCollection2;
    @JoinColumn(name = "trainer", referencedColumnName = "name")
    @ManyToOne
    private Trainer trainer;

    public Pokemon() {
    }

    public Pokemon(String name) {
        this.name = name;
    }

    public Pokemon(String name, String type, String ability, int attack, int defense, int speed, int life, int level) {
        this.name = name;
        this.type = type;
        this.ability = ability;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.life = life;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @XmlTransient
    public Collection<Battle> getBattleCollection() {
        return battleCollection;
    }

    public void setBattleCollection(Collection<Battle> battleCollection) {
        this.battleCollection = battleCollection;
    }

    @XmlTransient
    public Collection<Battle> getBattleCollection1() {
        return battleCollection1;
    }

    public void setBattleCollection1(Collection<Battle> battleCollection1) {
        this.battleCollection1 = battleCollection1;
    }

    @XmlTransient
    public Collection<Battle> getBattleCollection2() {
        return battleCollection2;
    }

    public void setBattleCollection2(Collection<Battle> battleCollection2) {
        this.battleCollection2 = battleCollection2;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
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
        if (!(object instanceof Pokemon)) {
            return false;
        }
        Pokemon other = (Pokemon) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Pokemon[ name=" + name + " ]";
    }
    
}

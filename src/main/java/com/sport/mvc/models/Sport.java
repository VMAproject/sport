package com.sport.mvc.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sport")
public class Sport extends Model {

    ///// коментарий

    private static final long serialVersionUID = -5417868963964887203L;

    private String sport;

    private String country;

    @ManyToMany(mappedBy = "sports")
    private Set<User> trainers = new HashSet<>();

    @ManyToMany(mappedBy = "sports")
    private Set<Student> sports = new HashSet<>();

    public Sport() {
        super();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public Set<User> getTrainers() {
        return trainers;
    }

    public void setTrainers(Set<User> trainers) {
        this.trainers = trainers;
    }

    public Set<Student> getSports() {
        return sports;
    }

    public void setSports(Set<Student> sports) {
        this.sports = sports;
    }
}

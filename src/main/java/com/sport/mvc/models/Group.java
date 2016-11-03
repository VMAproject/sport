package com.sport.mvc.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "group2")
public class Group extends Model {

    private static final long serialVersionUID = 5110150966894003873L;

    @Column(name = "name")
    private String name;

    @Column(name = "nameTraine")
    private String nameTraine;

    @Column(name = "discription")
    private String discription;

    public Group(Long id) {
        super(id);
    }

    @ManyToMany(mappedBy = "groups")
    private Set<User> treiners = new HashSet<>();

    @ManyToMany(mappedBy = "groups", cascade = CascadeType.ALL)
    private Set<Student> students = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private CategoryGroup categoryGroup;

    public Group() {
        super();
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getTreiners() {
        return treiners;
    }

    public void setTreiners(Set<User> treiners) {
        this.treiners = treiners;
    }

    public CategoryGroup getCategoryGroup() {
        return categoryGroup;
    }

    public void setCategoryGroup(CategoryGroup categoryGroup) {
        this.categoryGroup = categoryGroup;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public String getNameTraine() {
        return nameTraine;
    }

    public void setNameTraine(String nameTraine) {
        this.nameTraine = nameTraine;
    }
}

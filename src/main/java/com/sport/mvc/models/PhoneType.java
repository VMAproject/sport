package com.sport.mvc.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "phone_type")
public class PhoneType extends Model {

    private static final long serialVersionUID = 3656710234246240941L;

    @Column(name = "type_name")
    private String type;

    @OneToMany(mappedBy = "phoneType" , cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Phone> phones = new HashSet<>();

    public PhoneType() {
        super();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

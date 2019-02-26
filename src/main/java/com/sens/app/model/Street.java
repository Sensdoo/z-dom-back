package com.sens.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "Streets")
public class Street {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    @OneToMany(mappedBy = "street", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Address> addresses;

    public Street() {
    }

    public Street(@NotBlank @Size(min = 3, max = 50) String name, Set<Address> addresses) {
        this.name = name;
        this.addresses = addresses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
}

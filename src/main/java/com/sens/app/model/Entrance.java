package com.sens.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "entrances")
public class Entrance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String access;

    @NotNull
    private Date lastUpdate;

    @NotBlank
    @Size(min = 3, max = 50)
    private String editor;

    @NotNull
    private int entranceNumber;

    @NotBlank
    @Size(max = 1000)
    private String descriptionInterzet = "Нет данных";

    @NotBlank
    @Size(max = 1000)
    private String descriptionDomru = "Нет данных";

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
//    @JsonBackReference
    private Address address;

    public Entrance() {
    }

    public Entrance(String access, Date lastUpdate, String editor,
                    int entranceNumber, String descriptionInterzet, String descriptionDomru, Address address) {
        this.access = access;
        this.lastUpdate = lastUpdate;
        this.editor = editor;
        this.entranceNumber = entranceNumber;
        this.descriptionInterzet = descriptionInterzet;
        this.descriptionDomru = descriptionDomru;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public int getEntranceNumber() {
        return entranceNumber;
    }

    public void setEntranceNumber(int entranceNumber) {
        this.entranceNumber = entranceNumber;
    }

    public String getDescriptionInterzet() {
        return descriptionInterzet;
    }

    public void setDescriptionInterzet(String descriptionInterzet) {
        this.descriptionInterzet = descriptionInterzet;
    }

    public String getDescriptionDomru() {
        return descriptionDomru;
    }

    public void setDescriptionDomru(String descriptionDomru) {
        this.descriptionDomru = descriptionDomru;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}

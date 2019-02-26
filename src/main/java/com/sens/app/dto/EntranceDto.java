package com.sens.app.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class EntranceDto {

    private Long id;

    @NotNull
    private int entranceNumber;

    @NotNull
    private Long addressId;

    @NotBlank
    @Size(min = 3, max = 50)
    private String editor;

    @NotNull
    private Date lastUpdate;

    @NotBlank
    @Size(min = 3, max = 255)
    private String descriptionDomru;

    @NotBlank
    @Size(min = 3, max = 255)
    private String descriptionInterzet;

    @NotBlank
    private String access;

    public EntranceDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getEntranceNumber() {
        return entranceNumber;
    }

    public void setEntranceNumber(int entranceNumber) {
        this.entranceNumber = entranceNumber;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getDescriptionDomru() {
        return descriptionDomru;
    }

    public void setDescriptionDomru(String descriptionDomru) {
        this.descriptionDomru = descriptionDomru;
    }

    public String getDescriptionInterzet() {
        return descriptionInterzet;
    }

    public void setDescriptionInterzet(String descriptionInterzet) {
        this.descriptionInterzet = descriptionInterzet;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }
}

package com.company.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * Event entity.
 */
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;
    
    @Version
    @Column(nullable = true)
    private Integer version;

    @Column(nullable = false)    
    private String name;
    
    @Column(nullable = false)    
    private String description;
    
    @Column(nullable = false)    
    private String dateAndTime;    
    
    @Column(nullable = false)    
    private String place;
    
    @Column(nullable = false)    
    private String address;
  
    @Column(nullable = false)
    private String organizerName;
    
    @Column(nullable = false)
    private String organizerEmail;
    
    @Column(nullable = false)
    private String organizerMobilePhone;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }    
    
    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
    
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }
    
    public String getOrganizerEmail() {
        return organizerEmail;
    }

    public void setOrganizerEmail(String organizerEmail) {
        this.organizerEmail = organizerEmail;
    }
    
    public String getOrganizerMobilePhone() {
        return organizerMobilePhone;
    }

    public void setOrganizerMobilePhone(String organizerMobilePhone) {
        this.organizerMobilePhone = organizerMobilePhone;
    }    
    
}

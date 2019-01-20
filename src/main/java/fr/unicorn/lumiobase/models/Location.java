package fr.unicorn.lumiobase.models;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location {
    @Id @GeneratedValue
    private Long id;
    public String zip;
    public String country;

    public Location() {
    }

    public Location(String zip, String country) {
        this.zip = zip;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public String getZip() {
        return zip;
    }

    public String getCountry() {
        return country;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

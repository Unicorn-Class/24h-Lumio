package fr.unicorn.lumiobase.models.Sensors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Presence {
    @Id
    @GeneratedValue
    private Long id;
    private boolean value;
    private Date date;

    public Presence(boolean value) {
        this.value = value;
        this.date = new Date();
    }

    public Long getId() {
        return id;
    }

    public boolean getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }
}

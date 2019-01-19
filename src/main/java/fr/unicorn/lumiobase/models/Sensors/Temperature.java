package fr.unicorn.lumiobase.models.Sensors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Temperature {
    @Id
    @GeneratedValue
    private Long id;
    private float value;
    private Date date;

    public Temperature(float value) {
        this.value = value;
        this.date = new Date();
    }

    public Long getId() {
        return id;
    }

    public float getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }
}

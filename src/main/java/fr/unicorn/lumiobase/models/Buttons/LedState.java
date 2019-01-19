package fr.unicorn.lumiobase.models.Buttons;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class LedState {
    @Id
    @GeneratedValue
    private Long id;
    private boolean value;
    private Date date;
    private int ledId;

    public LedState(boolean value, int ledId) {
        this.value = value;
        this.date = new Date();
        this.ledId = ledId;
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

    public int getLedId() {
        return ledId;
    }
}

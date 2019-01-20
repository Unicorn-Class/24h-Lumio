package fr.unicorn.lumiobase.models.Scenario;

import com.mysql.cj.protocol.ColumnDefinition;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Scenario {
    @Id @GeneratedValue private Long id;
    @Column(columnDefinition="text") private String json;

    public Scenario() {}

    public Scenario(String json) {
        this.json = json;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public Long getId() {
        return id;
    }
}

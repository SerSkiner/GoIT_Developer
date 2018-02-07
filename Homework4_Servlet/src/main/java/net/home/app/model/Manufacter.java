package net.home.app.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "manufacturers")
public class Manufacter implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "manufacter_name")
    private String manufacter_name;

    public Manufacter() {

    }

    public Manufacter(String manufacter_name) {
        this.manufacter_name = manufacter_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManufacter_name() {
        return manufacter_name;
    }

    public void setManufacter_name(String manufacter_name) {
        this.manufacter_name = manufacter_name;
    }

    @Override
    public String toString() {
        return "Manufacter{" +
                "id='" + id + '\'' +
                ", manufacter_name='" + manufacter_name + '\'' +
                '}';
    }
}

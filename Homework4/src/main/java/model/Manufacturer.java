package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "manufacturer")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long ID;

    @Column(name = "NAME")
    private String NAME;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "manufacturer")
    private List<Product> products;

    public Manufacturer() {
    }

    public Manufacturer(long ID, String NAME) {
        this.ID = ID;
        this.NAME = NAME;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return
                 NAME + '\''
                ;
    }
}


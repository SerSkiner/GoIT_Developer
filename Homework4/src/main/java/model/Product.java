package model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long ID;

    @Column(name = "NAME")
    private String NAME;

    @Column(name = "PRICE")
    private String PRICE;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MANUFACTURER_ID", referencedColumnName = "ID")
    private Manufacturer manufacturer;

    public Product() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getPRICE() {
        return PRICE;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }



    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", NAME='" + NAME + '\'' +
                ", PRICE='" + PRICE + '\'' +
                ", manufacturer=" + manufacturer +
                '}';
    }
}

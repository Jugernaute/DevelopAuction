package ua.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Manufacturer;
    private String nameManufacturer;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            mappedBy = "manufacturer")
    private List<Product> productListOfManufacture;

    public Manufacturer() {
    }

    public Manufacturer(String nameManufacturer) {
        this.nameManufacturer = nameManufacturer;
    }

    public Manufacturer(String nameManufacturer, List<Product> productListOfManufacture) {
        this.nameManufacturer = nameManufacturer;
        this.productListOfManufacture = productListOfManufacture;
    }

    public int getId_Manufacturer() {
        return id_Manufacturer;
    }

    public Manufacturer setId_Manufacturer(int id_Manufacturer) {
        this.id_Manufacturer = id_Manufacturer;
        return this;
    }

    public String getNameManufacturer() {
        return nameManufacturer;
    }

    public Manufacturer setNameManufacturer(String nameManufacturer) {
        this.nameManufacturer = nameManufacturer;
        return this;
    }

    public List<Product> getProductListOfManufacture() {
        return productListOfManufacture;
    }

    public Manufacturer setProductListOfManufacture(List<Product> productListOfManufacture) {
        this.productListOfManufacture = productListOfManufacture;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacturer that = (Manufacturer) o;
        return id_Manufacturer == that.id_Manufacturer &&
                Objects.equals(nameManufacturer, that.nameManufacturer) &&
                Objects.equals(productListOfManufacture, that.productListOfManufacture);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id_Manufacturer, nameManufacturer, productListOfManufacture);
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id_Manufacturer=" + id_Manufacturer +
                ", nameManufacturer='" + nameManufacturer + '\'' +
                '}';
    }
}

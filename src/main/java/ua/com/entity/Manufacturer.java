package ua.com.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idManufacturer;
    private String nameManufacturer;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST
          )
    private List<Product> listManufacturerProduct = new ArrayList<>();

    public Manufacturer() {
    }

    public Manufacturer(String nameManufacturer, List<Product> listManufacturerProduct) {
        this.nameManufacturer = nameManufacturer;
        this.listManufacturerProduct = listManufacturerProduct;
    }

    public int getIdManufacturer() {
        return idManufacturer;
    }

    public Manufacturer setIdManufacturer(int idManufacturer) {
        this.idManufacturer = idManufacturer;
        return this;
    }

    public String getNameManufacturer() {
        return nameManufacturer;
    }

    public Manufacturer setNameManufacturer(String nameManufacturer) {
        this.nameManufacturer = nameManufacturer;
        return this;
    }

    public List<Product> getListManufacturerProduct() {
        return listManufacturerProduct;
    }

    public Manufacturer setListManufacturerProduct(List<Product> listManufacturerProduct) {
        this.listManufacturerProduct = listManufacturerProduct;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacturer that = (Manufacturer) o;
        return idManufacturer == that.idManufacturer &&
                Objects.equals(nameManufacturer, that.nameManufacturer) &&
                Objects.equals(listManufacturerProduct, that.listManufacturerProduct);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idManufacturer, nameManufacturer, listManufacturerProduct);
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "idManufacturer=" + idManufacturer +
                ", nameManufacturer='" + nameManufacturer + '\'' +
                '}';
    }
}

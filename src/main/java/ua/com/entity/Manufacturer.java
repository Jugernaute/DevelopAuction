package ua.com.entity;

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

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
          )
    private List<Product> listManufacturerProduct = new ArrayList<>();

    public Manufacturer() {
    }

    public Manufacturer(String nameManufacturer, List<Product> listManufacturerProduct) {
        this.nameManufacturer = nameManufacturer;
        this.listManufacturerProduct = listManufacturerProduct;
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
        return id_Manufacturer == that.id_Manufacturer &&
                Objects.equals(nameManufacturer, that.nameManufacturer) &&
                Objects.equals(listManufacturerProduct, that.listManufacturerProduct);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id_Manufacturer, nameManufacturer, listManufacturerProduct);
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id_Manufacturer=" + id_Manufacturer +
                ", nameManufacturer='" + nameManufacturer + '\'' +
                '}';
    }
}

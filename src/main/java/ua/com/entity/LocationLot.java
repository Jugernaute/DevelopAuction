package ua.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class LocationLot {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_LocationLot;
    private String regionLot;
    private String locationLot;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER,
    cascade = CascadeType.REFRESH)
    private Product products;


    public LocationLot(String regionLot, String locationLot) {
        this.regionLot = regionLot;
        this.locationLot = locationLot;
    }

    public LocationLot(String regionLot) {
        this.regionLot = regionLot;
    }

    public LocationLot() {
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    public int getId_LocationLot() {
        return id_LocationLot;
    }

    public void setId_LocationLot(int id_LocationLot) {
        this.id_LocationLot = id_LocationLot;
    }

    public String getRegionLot() {
        return regionLot;
    }

    public void setRegionLot(String regionLot) {
        this.regionLot = regionLot;
    }

    public String getLocationLot() {
        return locationLot;
    }

    public void setLocationLot(String locationLot) {
        this.locationLot = locationLot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationLot that = (LocationLot) o;
        return id_LocationLot == that.id_LocationLot &&
                Objects.equals(regionLot, that.regionLot) &&
                Objects.equals(locationLot, that.locationLot);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id_LocationLot, regionLot, locationLot);
    }

    @Override
    public String toString() {
        return "LocationLot{" +
                "id_LocationLot=" + id_LocationLot +
                ", regionLot='" + regionLot + '\'' +
                ", locationLot='" + locationLot + '\'' +
                '}';
    }
}

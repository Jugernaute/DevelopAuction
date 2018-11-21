package ua.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Delivery {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Delivery;
    private String methodDelivery;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL/*, CascadeType.DETACH*/})
    private List<Lot> lot = new ArrayList<>();

    public Delivery(String methodDelivery) {
        this.methodDelivery = methodDelivery;
    }

    public Delivery() {
    }

    public Delivery(String methodDelivery,List<Lot> lot) {
        this.methodDelivery = methodDelivery;
        this.lot = lot;
    }

    public int getId_Delivery() {
        return id_Delivery;
    }

    public Delivery setId_Delivery(int id_Delivery) {
        this.id_Delivery = id_Delivery;
        return this;
    }

    public String getMethodDelivery() {
        return methodDelivery;
    }

    public Delivery setMethodDelivery(String methodDelivery) {
        this.methodDelivery = methodDelivery;
        return this;
    }

    public List<Lot> getLot() {
        return lot;
    }

    public Delivery setLot(List<Lot> lot) {
        this.lot = lot;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return id_Delivery == delivery.id_Delivery &&
                Objects.equals(methodDelivery, delivery.methodDelivery) &&
                Objects.equals(lot, delivery.lot);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id_Delivery, methodDelivery, lot);
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id_Delivery=" + id_Delivery +
                ", methodDelivery='" + methodDelivery + '\'' +
                '}';
    }
}

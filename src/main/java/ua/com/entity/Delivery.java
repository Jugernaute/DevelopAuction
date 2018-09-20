package ua.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Delivery;
    private String methodDelivery;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    private List<Lot> listLot;

    public Delivery() {
    }

    public Delivery(String methodDelivery) {
        this.methodDelivery = methodDelivery;
    }

    public Delivery(String methodDelivery, List<Lot> listLot) {
        this.methodDelivery = methodDelivery;
        this.listLot = listLot;
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

    public List<Lot> getListLot() {
        return listLot;
    }

    public Delivery setListLot(List<Lot> listLot) {
        this.listLot = listLot;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return id_Delivery == delivery.id_Delivery &&
                Objects.equals(methodDelivery, delivery.methodDelivery) &&
                Objects.equals(listLot, delivery.listLot);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id_Delivery, methodDelivery, listLot);
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id_Delivery=" + id_Delivery +
                ", methodDelivery='" + methodDelivery + '\'' +
                '}';
    }
}

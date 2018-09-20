package ua.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDelivery;
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

    public int getIdDelivery() {
        return idDelivery;
    }

    public Delivery setIdDelivery(int idDelivery) {
        this.idDelivery = idDelivery;
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
        return idDelivery == delivery.idDelivery &&
                Objects.equals(methodDelivery, delivery.methodDelivery) &&
                Objects.equals(listLot, delivery.listLot);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idDelivery, methodDelivery, listLot);
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "idDelivery=" + idDelivery +
                ", methodDelivery='" + methodDelivery + '\'' +
                '}';
    }
}

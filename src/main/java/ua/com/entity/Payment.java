package ua.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Payment;
    private String mathodPayment;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST} )
    private List<Lot> listLot;

    public Payment() {
    }

    public Payment(String mathodPayment, List<Lot> listLot) {
        this.mathodPayment = mathodPayment;
        this.listLot = listLot;
    }

    public int getId_Payment() {
        return id_Payment;
    }

    public Payment setId_Payment(int id_Payment) {
        this.id_Payment = id_Payment;
        return this;
    }

    public String getMathodPayment() {
        return mathodPayment;
    }

    public Payment setMathodPayment(String mathodPayment) {
        this.mathodPayment = mathodPayment;
        return this;
    }

    public List<Lot> getListLot() {
        return listLot;
    }

    public Payment setListLot(List<Lot> listLot) {
        this.listLot = listLot;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id_Payment == payment.id_Payment &&
                Objects.equals(mathodPayment, payment.mathodPayment) &&
                Objects.equals(listLot, payment.listLot);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id_Payment, mathodPayment, listLot);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id_Payment=" + id_Payment +
                ", mathodPayment='" + mathodPayment + '\'' +
                '}';
    }
}

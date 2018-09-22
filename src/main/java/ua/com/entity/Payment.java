package ua.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Payment;
    private String methodPayment;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            mappedBy = "payment")
    private Lot lot;

    public Payment() {
    }

    public Payment(String methodPayment) {
        this.methodPayment = methodPayment;
    }

    public Payment(String methodPayment, Lot lot) {
        this.methodPayment = methodPayment;
        this.lot = lot;
    }

    public int getId_Payment() {
        return id_Payment;
    }

    public Payment setId_Payment(int id_Payment) {
        this.id_Payment = id_Payment;
        return this;
    }

    public String getMethodPayment() {
        return methodPayment;
    }

    public Payment setMethodPayment(String methodPayment) {
        this.methodPayment = methodPayment;
        return this;
    }

    public Lot getLot() {
        return lot;
    }

    public Payment setLot(Lot lot) {
        this.lot = lot;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id_Payment == payment.id_Payment &&
                Objects.equals(methodPayment, payment.methodPayment) &&
                Objects.equals(lot, payment.lot);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id_Payment, methodPayment, lot);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id_Payment=" + id_Payment +
                ", methodPayment='" + methodPayment + '\'' +
                '}';
    }
}

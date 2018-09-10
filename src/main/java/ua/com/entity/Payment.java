package ua.com.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Payment;
    private String mathodPayment;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL )
    private Lot lot;

    public Payment() {
    }

    public Payment(String mathodPayment, Lot lot) {
        this.mathodPayment = mathodPayment;
        this.lot = lot;
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
                Objects.equals(mathodPayment, payment.mathodPayment) &&
                Objects.equals(lot, payment.lot);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id_Payment, mathodPayment, lot);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id_Payment=" + id_Payment +
                ", mathodPayment='" + mathodPayment + '\'' +
                '}';
    }
}

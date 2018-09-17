package ua.com.entity;

import javafx.scene.chart.PieChart;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.List;
import java.util.Objects;

@Entity
public class Lot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLot;
    private String dataStartLot;
    private String dataEndLot;
    private int startPrice;
    private int hotPrise;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE)
    private Product product;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            mappedBy = "lot")
    private List<Bet> listLotBet;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE)
    private Delivery delivery;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE})
    private Payment payment;

    public Lot() {
    }

    public Lot(String dataStartLot, String dataEndLot, int startPrice, int hotPrise) {
        this.dataStartLot = dataStartLot;
        this.dataEndLot = dataEndLot;
        this.startPrice = startPrice;
        this.hotPrise = hotPrise;
    }

    public Lot(String dataStartLot, String dataEndLot, int startPrice, int hotPrise, Product product, List<Bet> listLotBet, Delivery delivery, Payment payment) {
        this.dataStartLot = dataStartLot;
        this.dataEndLot = dataEndLot;
        this.startPrice = startPrice;
        this.hotPrise = hotPrise;
        this.product = product;
        this.listLotBet = listLotBet;
        this.delivery = delivery;
        this.payment = payment;
    }

    public int getIdLot() {
        return idLot;
    }

    public Lot setIdLot(int idLot) {
        this.idLot = idLot;
        return this;
    }

    public String getDataStartLot() {
        return dataStartLot;
    }

    public Lot setDataStartLot(String dataStartLot) {
        this.dataStartLot = dataStartLot;
        return this;
    }

    public String getDataEndLot() {
        return dataEndLot;
    }

    public Lot setDataEndLot(String dataEndLot) {
        this.dataEndLot = dataEndLot;
        return this;
    }

    public int getStartPrice() {
        return startPrice;
    }

    public Lot setStartPrice(int startPrice) {
        this.startPrice = startPrice;
        return this;
    }

    public int getHotPrise() {
        return hotPrise;
    }

    public Lot setHotPrise(int hotPrise) {
        this.hotPrise = hotPrise;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public Lot setProduct(Product product) {
        this.product = product;
        return this;
    }

    public List<Bet> getListLotBet() {
        return listLotBet;
    }

    public Lot setListLotBet(List<Bet> listLotBet) {
        this.listLotBet = listLotBet;
        return this;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public Lot setDelivery(Delivery delivery) {
        this.delivery = delivery;
        return this;
    }

    public Payment getPayment() {
        return payment;
    }

    public Lot setPayment(Payment payment) {
        this.payment = payment;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lot lot = (Lot) o;
        return idLot == lot.idLot &&
                startPrice == lot.startPrice &&
                hotPrise == lot.hotPrise &&
                Objects.equals(dataStartLot, lot.dataStartLot) &&
                Objects.equals(dataEndLot, lot.dataEndLot) &&
                Objects.equals(product, lot.product) &&
                Objects.equals(listLotBet, lot.listLotBet) &&
                Objects.equals(delivery, lot.delivery) &&
                Objects.equals(payment, lot.payment);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idLot, dataStartLot, dataEndLot, startPrice, hotPrise, product, listLotBet, delivery, payment);
    }

    @Override
    public String toString() {
        return "Lot{" +
                "idLot=" + idLot +
                ", dataStartLot='" + dataStartLot + '\'' +
                ", dataEndLot='" + dataEndLot + '\'' +
                ", startPrice=" + startPrice +
                ", hotPrise=" + hotPrise +
                '}';
    }
}

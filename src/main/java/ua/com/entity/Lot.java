package ua.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.scene.chart.PieChart;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Lot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Lot;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dataStartLot;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dataEndLot;
    private int startPrice;
    private int hotPrice;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Location> location;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "lot")
    private List<Bet> listLotBet;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE)
    private Product product;


    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL},
            mappedBy = "lot")
    private List<Delivery> delivery;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE)
    private Payment payment;

    public Lot() {
    }

    public Lot(LocalDateTime dataStartLot, LocalDateTime dataEndLot, int startPrice, int hotPrice) {
        this.dataStartLot = dataStartLot;
        this.dataEndLot = dataEndLot;
        this.startPrice = startPrice;
        this.hotPrice = hotPrice;
    }

    public Lot(LocalDateTime dataStartLot, LocalDateTime dataEndLot, int startPrice, int hotPrice, List<Bet> listLotBet, Product product, List<Delivery> delivery, Payment payment) {
        this.dataStartLot = dataStartLot;
        this.dataEndLot = dataEndLot;
        this.startPrice = startPrice;
        this.hotPrice = hotPrice;
        this.listLotBet = listLotBet;
        this.product = product;
        this.delivery = delivery;
        this.payment = payment;
    }

    public int getId_Lot() {
        return id_Lot;
    }

    public Lot setId_Lot(int id_Lot) {
        this.id_Lot = id_Lot;
        return this;
    }

    public List<Location> getLocation() {
        return location;
    }

    public void setLocation(List<Location> location) {
        this.location = location;
    }

    public LocalDateTime getDataStartLot() {
        return dataStartLot;
    }

    public Lot setDataStartLot(LocalDateTime dataStartLot) {
        this.dataStartLot = dataStartLot;
        return this;
    }

    public LocalDateTime getDataEndLot() {
        return dataEndLot;
    }

    public Lot setDataEndLot(LocalDateTime dataEndLot) {
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

    public int getHotPrice() {
        return hotPrice;
    }

    public Lot setHotPrice(int hotPrice) {
        this.hotPrice = hotPrice;
        return this;
    }

    public List<Bet> getListLotBet() {
        return listLotBet;
    }

    public Lot setListLotBet(List<Bet> listLotBet) {
        this.listLotBet = listLotBet;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public Lot setProduct(Product product) {
        this.product = product;
        return this;
    }

    public List<Delivery> getDelivery() {
        return delivery;
    }

    public Lot setDelivery(List<Delivery> delivery) {
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
        return id_Lot == lot.id_Lot &&
                startPrice == lot.startPrice &&
                hotPrice == lot.hotPrice &&
                Objects.equals(dataStartLot, lot.dataStartLot) &&
                Objects.equals(dataEndLot, lot.dataEndLot) &&
                Objects.equals(listLotBet, lot.listLotBet) &&
                Objects.equals(product, lot.product) &&
                Objects.equals(delivery, lot.delivery) &&
                Objects.equals(payment, lot.payment);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id_Lot, dataStartLot, dataEndLot, startPrice, hotPrice, listLotBet, product, delivery, payment);
    }

    @Override
    public String toString() {
        return "Lot{" +
                "id_Lot=" + id_Lot +
                ", dataStartLot='" + dataStartLot + '\'' +
                ", dataEndLot='" + dataEndLot + '\'' +
                ", startPrice=" + startPrice +
                ", hotPrice=" + hotPrice +
                '}';
    }
}

package ua.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Lot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Lot;
    @DateTimeFormat(pattern = "EEE, d MMM yyyy HH:mm:ss")
    private LocalDateTime dataStartLot;
    @DateTimeFormat(pattern = "EEE, d MMM yyyy HH:mm:ss")
    private LocalDateTime dataEndLot;
    private int startPrice;
    private int hotPrice;
    private int currentPrice;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE)
    private Basket basket;

    @JsonIgnore
    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            mappedBy = "lot"
    )
    private CompletedLot listOfLotEnd;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE/*.PERSIST,CascadeType.REMOVE*/})
    private List<LocationUser> location;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "lot")
    private List<Bet> listLotBet;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER,
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

    public Lot(LocalDateTime dataStartLot, LocalDateTime dataEndLot, int startPrice, int hotPrice, int currentPrice, Basket basket, CompletedLot listOfLotEnd, List<LocationUser> location, List<Bet> listLotBet, Product product, List<Delivery> delivery, Payment payment) {
        this.dataStartLot = dataStartLot;
        this.dataEndLot = dataEndLot;
        this.startPrice = startPrice;
        this.hotPrice = hotPrice;
        this.listLotBet = listLotBet;
        this.product = product;
        this.delivery = delivery;
        this.payment = payment;
    }

    public Basket getBasket() {
        return basket;
    }

    public Lot setBasket(Basket basket) {
        this.basket = basket;
        return this;
    }

    public CompletedLot getListOfLotEnd() {
        return listOfLotEnd;
    }

    public Lot setListOfLotEnd(CompletedLot listOfLotEnd) {
        this.listOfLotEnd = listOfLotEnd;
        return this;
    }

    public int getId_Lot() {
        return id_Lot;
    }

    public Lot setId_Lot(int id_Lot) {
        this.id_Lot = id_Lot;
        return this;
    }

    public List<LocationUser> getLocation() {
        return location;
    }

    public void setLocation(List<LocationUser> location) {
        this.location = location;
    }

    public LocalDateTime getDataStartLot() {
        return dataStartLot;
    }

    public Lot setDataStartLot(LocalDateTime dataStartLot) {
        this.dataStartLot = dataStartLot;
        return this;
    }

    public CompletedLot getListOfEndLot() {
        return listOfLotEnd;
    }

    public void setListOfEndLot(CompletedLot completedLot) {
        this.listOfLotEnd = completedLot;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
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
                currentPrice == lot.currentPrice &&
                Objects.equals(dataStartLot, lot.dataStartLot) &&
                Objects.equals(dataEndLot, lot.dataEndLot) &&
                Objects.equals(basket, lot.basket) &&
                Objects.equals(listOfLotEnd, lot.listOfLotEnd) &&
                Objects.equals(location, lot.location) &&
                Objects.equals(listLotBet, lot.listLotBet) &&
                Objects.equals(product, lot.product) &&
                Objects.equals(delivery, lot.delivery) &&
                Objects.equals(payment, lot.payment);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id_Lot, dataStartLot, dataEndLot, startPrice, hotPrice, currentPrice, basket, listOfLotEnd, location, listLotBet, product, delivery, payment);
    }

    @Override
    public String toString() {
        return "Lot{" +
                "id_Lot=" + id_Lot +
                ", dataStartLot=" + dataStartLot +
                ", dataEndLot=" + dataEndLot +
                ", startPrice=" + startPrice +
                ", hotPrice=" + hotPrice +
                ", currentPrice=" + currentPrice +
                '}';
    }
}

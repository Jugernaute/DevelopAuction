package ua.com.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idBet;
    private int sumOfTheBet;
    private int stapeBet;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE)
    private Lot lot;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE)
    private User user;

    public Bet() {
    }

    public Bet(int sumOfTheBet, int stapeBet) {
        this.sumOfTheBet = sumOfTheBet;
        this.stapeBet = stapeBet;
    }

    public Bet(int sumOfTheBet, int stapeBet, Lot lot, User user) {
        this.sumOfTheBet = sumOfTheBet;
        this.stapeBet = stapeBet;
        this.lot = lot;
        this.user = user;
    }

    public int getIdBet() {
        return idBet;
    }

    public Bet setIdBet(int idBet) {
        this.idBet = idBet;
        return this;
    }

    public int getSumOfTheBet() {
        return sumOfTheBet;
    }

    public Bet setSumOfTheBet(int sumOfTheBet) {
        this.sumOfTheBet = sumOfTheBet;
        return this;
    }

    public int getStapeBet() {
        return stapeBet;
    }

    public Bet setStapeBet(int stapeBet) {
        this.stapeBet = stapeBet;
        return this;
    }

    public Lot getLot() {
        return lot;
    }

    public Bet setLot(Lot lot) {
        this.lot = lot;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Bet setUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bet bet = (Bet) o;
        return idBet == bet.idBet &&
                sumOfTheBet == bet.sumOfTheBet &&
                stapeBet == bet.stapeBet &&
                Objects.equals(lot, bet.lot) &&
                Objects.equals(user, bet.user);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idBet, sumOfTheBet, stapeBet, lot, user);
    }

    @Override
    public String toString() {
        return "Bet{" +
                "idBet=" + idBet +
                ", sumOfTheBet=" + sumOfTheBet +
                ", stapeBet=" + stapeBet +
                ", lot=" + lot +
                '}';
    }
}

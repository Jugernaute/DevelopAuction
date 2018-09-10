package ua.com.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_Bet;
    private int sum_of_the_bet;
    private int stapeBet;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Lot lot;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private User user;

    public Bet() {
    }

    public Bet(int sum_of_the_bet, int stapeBet, Lot lot, User user) {
        this.sum_of_the_bet = sum_of_the_bet;
        this.stapeBet = stapeBet;
        this.lot = lot;
        this.user = user;
    }

    public int getId_Bet() {
        return id_Bet;
    }

    public Bet setId_Bet(int id_Bet) {
        this.id_Bet = id_Bet;
        return this;
    }

    public int getSum_of_the_bet() {
        return sum_of_the_bet;
    }

    public Bet setSum_of_the_bet(int sum_of_the_bet) {
        this.sum_of_the_bet = sum_of_the_bet;
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

    public Bet setUser1(User user) {
        this.user = user;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bet bet = (Bet) o;
        return id_Bet == bet.id_Bet &&
                sum_of_the_bet == bet.sum_of_the_bet &&
                stapeBet == bet.stapeBet &&
                Objects.equals(lot, bet.lot) &&
                Objects.equals(user, bet.user);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id_Bet, sum_of_the_bet, stapeBet, lot, user);
    }

    @Override
    public String toString() {
        return "Bet{" +
                "id_Bet=" + id_Bet +
                ", sum_of_the_bet=" + sum_of_the_bet +
                ", stapeBet=" + stapeBet +
                ", lot=" + lot +
                '}';
    }
}

package ua.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBasket;

    private String nameBasketUser;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE}
//            , mappedBy = "basket"
    )
    private List<Lot> lotList;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE})
    private User user;

    public Basket(String nameBasketUser, User user) {
        this.nameBasketUser = nameBasketUser;
        this.user = user;
    }

    public Basket(String nameBasketUser, List<Lot> lotList, User user) {
        this.nameBasketUser = nameBasketUser;
        this.lotList = lotList;
        this.user = user;
    }

    public Basket() {
    }

    public Basket(String nameBasketUser) {
        this.nameBasketUser = nameBasketUser;
    }


    public int getIdBasket() {
        return idBasket;
    }

    public Basket setIdBasket(int idBasket) {
        this.idBasket = idBasket;
        return this;
    }

    public String getNameBasketUser() {
        return nameBasketUser;
    }

    public Basket setNameBasketUser(String nameBasketUser) {
        this.nameBasketUser = nameBasketUser;
        return this;
    }

    public List<Lot> getLotList() {
        return lotList;
    }

    public Basket setLotList(List<Lot> lotList) {
        this.lotList = lotList;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Basket setUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return idBasket == basket.idBasket &&
                Objects.equals(nameBasketUser, basket.nameBasketUser) &&
                Objects.equals(lotList, basket.lotList) &&
                Objects.equals(user, basket.user);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idBasket, nameBasketUser, lotList, user);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "idBasket=" + idBasket +
                ", nameBasketUser='" + nameBasketUser + '\'' +
                '}';
    }
}

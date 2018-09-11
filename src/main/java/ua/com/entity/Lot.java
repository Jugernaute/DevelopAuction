package ua.com.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString(exclude = {"product", "listLotBet", "delivery", "payment"})
@EqualsAndHashCode(exclude = {"product", "listLotBet", "delivery"})

@Entity
public class Lot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Lot;
    private String dataStartLot;
    private String dataEndLot;
    private int startPrice;
    int hotPrice;


    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            mappedBy = "lot")
    List<Bet> listLotBet;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE)
    private Product product;


    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE)
    private Delivery delivery;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE)
    private Payment payment;

    public Lot(String dataStartLot, String dataEndLot,
               int startPrice, int hotPrice
               /*List<Bet> listLotBet, Product product,
               Delivery delivery, Payment payment*/) {
        this.dataStartLot = dataStartLot;
        this.dataEndLot = dataEndLot;
        this.startPrice = startPrice;
        this.hotPrice = hotPrice;
//        this.listLotBet = listLotBet;
//        this.product = product;
//        this.delivery = delivery;
//        this.payment = payment;
    }
}

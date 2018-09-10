package ua.com.entity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode

@Entity
public class AuctionItems {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_AucItem;
    private String startDate;
    private String actualCloseDate;
    private String plannedCloseDate;
    private int actualSellingPrice;
    private int reservePrice;
//    private int paymenAmount;
//    private String paymentDate;
    private String successfulBider;
    private String comments;
    private String description;

//    private Bidders_Sellers bidders_sellers;

    public AuctionItems(String startDate, String plannedCloseDate, int reservePrice, String description) {
        this.startDate = startDate;
        this.plannedCloseDate = plannedCloseDate;
        this.reservePrice = reservePrice;
        this.description = description;
    }
}

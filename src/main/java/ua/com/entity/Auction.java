package ua.com.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString(exclude = {"byersList", "product"})
@EqualsAndHashCode

@Entity
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Auction;
    private String dataStartAuction;
    private String dataCloseAuction;

  @ManyToMany(mappedBy = "auctionList", fetch = FetchType.EAGER,
          cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Client> byersList;

    @OneToOne(cascade = CascadeType.MERGE,
            fetch = FetchType.EAGER)
    private Product product;

    public Auction(String dataStartAuction, String dataCloseAuction, Product product) {
        this.dataStartAuction = dataStartAuction;
        this.dataCloseAuction = dataCloseAuction;
        this.product = product;
        this.byersList = new HashSet<>();
    }


}

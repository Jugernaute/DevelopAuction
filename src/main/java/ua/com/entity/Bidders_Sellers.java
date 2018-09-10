package ua.com.entity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode

@Entity
public class Bidders_Sellers {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Bid_Sel;
    private boolean BIDDERS = false;
    private boolean SELLERS = false;


}

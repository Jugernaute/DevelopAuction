package ua.com.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString(exclude = "lotListDelivery")
@EqualsAndHashCode

@Entity
public class Delivery {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Delivery;
    private String methodDelivery;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
    mappedBy = "delivery")
    private List<Lot> lotListDelivery;

    public Delivery(String methodDelivery) {
        this.methodDelivery = methodDelivery;
    }
}

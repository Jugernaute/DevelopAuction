package ua.com.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString(exclude = "lot")
@EqualsAndHashCode

@Entity
public class Delivery {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Delivery;
    private String methodDelivery;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
    mappedBy = "delivery")
    private Lot lot;

    public Delivery(String methodDelivery) {
        this.methodDelivery = methodDelivery;
    }
}

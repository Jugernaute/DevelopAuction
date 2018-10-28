package ua.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
    mappedBy = "deliveries")
    private List<Lot> lotListDelivery;

    public Delivery(String methodDelivery) {
        this.methodDelivery = methodDelivery;
    }
}

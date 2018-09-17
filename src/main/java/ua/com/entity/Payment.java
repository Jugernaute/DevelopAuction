package ua.com.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString(exclude = "lotListPayment")
@EqualsAndHashCode

@Entity
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Payment;
    private String methodPayment;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            mappedBy = "payment")
    private List<Lot>lotListPayment;

    public Payment(String methodPayment) {
        this.methodPayment = methodPayment;
    }
}

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
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Payment;
    private String methodPayment;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            mappedBy = "payment")
    private Lot lot;

    public Payment(String methodPayment) {
        this.methodPayment = methodPayment;
    }
}

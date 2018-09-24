package ua.com.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString(exclude = {"lot", "user"})
@EqualsAndHashCode(exclude = {"lot", "user"})

@Entity
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Bet;
    private int sum_of_the_bet;
    private int stepBet;

    @ManyToOne
            (fetch = FetchType.LAZY,
                    cascade = CascadeType.MERGE)
    private Lot lot;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE)
    private User user;


    public Bet(int sum_of_the_bet) {
        this.sum_of_the_bet = sum_of_the_bet;
    }


}

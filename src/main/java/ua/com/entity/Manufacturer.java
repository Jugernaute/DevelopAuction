package ua.com.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString(exclude = {"productListOfManufacture"})
@EqualsAndHashCode

@Entity
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Manufacturer;

    private String nameManufacturer;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            mappedBy = "manufacturer")
    private List<Product> productListOfManufacture;

    public Manufacturer(String nameManufacturer) {
        this.nameManufacturer = nameManufacturer;
    }




}

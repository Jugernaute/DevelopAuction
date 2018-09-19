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
@ToString(exclude = {"productListOfManufacture"})
@EqualsAndHashCode

@Entity
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Manufacturer;
    private String nameManufacturer;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH},
            mappedBy = "manufacturer")
    private List<Product> productListOfManufacture;

    public Manufacturer(String nameManufacturer) {
        this.nameManufacturer = nameManufacturer;
    }
}

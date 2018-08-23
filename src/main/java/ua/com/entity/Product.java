package ua.com.entity;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
//        (exclude = {"subCategory"})
@EqualsAndHashCode

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id_Product;

        private String nameProduct;
        private String modelProduct;
        private String description;
        private int price;

    public Product(String nameProduct, String modelProduct, String description, int price) {
        this.nameProduct = nameProduct;
        this.modelProduct = modelProduct;
        this.description = description;
        this.price = price;
    }



    @ManyToOne(fetch = FetchType.LAZY,
        cascade = CascadeType.MERGE)
        private SubCategory subCategory;

}

package ua.com.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString(exclude = {"subCategory", "auction", "client", "manufacturer"})
@EqualsAndHashCode(exclude = {"subCategory", "auction", "client", "manufacturer"})

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Product;

    private String nameProduct;
    private String modelProduct;
    private String descriptionProduct;
    private int priceProduct;

    public Product(String nameProduct, String modelProduct, String descriptionProduct, int priceProduct) {
        this.nameProduct = nameProduct;
        this.modelProduct = modelProduct;
        this.descriptionProduct = descriptionProduct;
        this.priceProduct = priceProduct;
    }


    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE)
    private SubCategory subCategory;


    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE)
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE)
    private Manufacturer manufacturer;

    @OneToOne(fetch = FetchType.EAGER,
    cascade = CascadeType.PERSIST)
    private Auction auction;

}

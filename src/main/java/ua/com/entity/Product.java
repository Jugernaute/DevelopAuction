package ua.com.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString(exclude = {"subCategory", "lot", "userOwner", "manufacturer"})
@EqualsAndHashCode(exclude = {"subCategory", "lot", "userOwner", "manufacturer"})

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Product;

    private String nameProduct;
    private String modelProduct;
    private String descriptionProduct;
    private String linkOnImageProduct;
    @Enumerated(EnumType.STRING)
    private StateProduct stateProduct;


    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE)
    private SubCategory subCategory;


    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE)
    private User userOwner;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE)
    private Manufacturer manufacturer;

    @OneToOne(fetch = FetchType.LAZY,
    cascade = CascadeType.PERSIST,
    mappedBy = "product")
    private Lot lot;

    public Product(String nameProduct, String modelProduct,
                   String descriptionProduct, SubCategory subCategory,
                   User userOwner, Manufacturer manufacturer) {
        this.nameProduct = nameProduct;
        this.modelProduct = modelProduct;
        this.descriptionProduct = descriptionProduct;
        this.subCategory = subCategory;
        this.userOwner = userOwner;
        this.manufacturer = manufacturer;
    }
}

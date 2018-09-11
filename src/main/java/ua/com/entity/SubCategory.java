package ua.com.entity;

import javax.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString  (exclude = {"commonCategory","products"})
@EqualsAndHashCode (exclude = {"commonCategory","products"})

@Entity
public class SubCategory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_SubCategory;
    private String nameSubCategory;

    @ManyToOne(fetch = FetchType.LAZY,
                cascade = {CascadeType.MERGE})
    private CommonCategory commonCategory;

    @OneToMany(fetch = FetchType.LAZY,
    cascade = CascadeType.PERSIST,
    mappedBy = "subCategory")
    private List<Product>products;


    public SubCategory(String nameSubCategory) {
        this.nameSubCategory = nameSubCategory;
    }


}

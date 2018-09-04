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
@EqualsAndHashCode

@Entity
public class SubCategory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_SubCategory;
    private String nameSubCategory;

    public SubCategory(String nameSubCategory) {
        this.nameSubCategory = nameSubCategory;
    }

    @ManyToOne(fetch = FetchType.EAGER,
                //merge - work
                cascade = {CascadeType.MERGE})
    private CommonCategory commonCategory;

    @OneToMany(fetch = FetchType.EAGER,
    cascade = CascadeType.PERSIST,
    mappedBy = "subCategory")
    private List<Product>products;

}

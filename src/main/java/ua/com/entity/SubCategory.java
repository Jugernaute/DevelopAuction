package ua.com.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,
                cascade = {CascadeType.MERGE})
    private CommonCategory commonCategory;
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,
    cascade = {CascadeType.PERSIST,CascadeType.DETACH},
    mappedBy = "subCategory")
    private List<Product>products;


    public SubCategory(String nameSubCategory) {
        this.nameSubCategory = nameSubCategory;
    }


}

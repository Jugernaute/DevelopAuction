package ua.com.entity;

import javax.persistence.*;
import java.util.List;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString (exclude = {"subCategoryList"})
@EqualsAndHashCode

@Entity

public class CommonCategory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_CommonCategory;
    private String nameCommonCategory;

    public CommonCategory(String nameCommonCategory) {
        this.nameCommonCategory = nameCommonCategory;
    }

    @OneToMany(
            fetch = FetchType.EAGER,
            //persist, merge, refresh, - save Subcategory to base without problem
            //detach - don't work
            cascade = CascadeType.PERSIST,
            mappedBy = "commonCategory"
    )
    List<SubCategory> subCategoryList;
}

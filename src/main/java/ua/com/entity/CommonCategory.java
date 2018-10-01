package ua.com.entity;

import javax.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString (exclude = {"subCategoryList"})
@EqualsAndHashCode (exclude = {"subCategoryList"})

@Entity

public class CommonCategory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_CommonCategory;
    private String nameCommonCategory;

    public CommonCategory(String nameCommonCategory) {
        this.nameCommonCategory = nameCommonCategory;
    }
    @JsonIgnore
    @OneToMany(
            fetch = FetchType.EAGER,           // змінили з LAZY
            cascade = {CascadeType.PERSIST, CascadeType.DETACH},
            mappedBy = "commonCategory"
    )
    List<SubCategory> subCategoryList;


}

package ua.com.entity;

import javax.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString  (exclude = {"commonCategory","products"})
//@EqualsAndHashCode

@Entity
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_SubCategory;

    private String nameSubCategory;


    @ManyToOne(fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private CommonCategory commonCategory;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Product> listSubCategoryProduct;

    public SubCategory() {
    }

    public SubCategory(String nameSubCategory, CommonCategory commonCategory, List<Product> listSubCategoryProduct) {
        this.nameSubCategory = nameSubCategory;
        this.commonCategory = commonCategory;
        this.listSubCategoryProduct = listSubCategoryProduct;
    }

    public int getId_SubCategory() {
        return id_SubCategory;
    }

    public SubCategory setId_SubCategory(int id_SubCategory) {
        this.id_SubCategory = id_SubCategory;
        return this;
    }

    public String getNameSubCategory() {
        return nameSubCategory;
    }

    public SubCategory setNameSubCategory(String nameSubCategory) {
        this.nameSubCategory = nameSubCategory;
        return this;
    }

    public CommonCategory getCommonCategory() {
        return commonCategory;
    }

    public SubCategory setCommonCategory(CommonCategory commonCategory) {
        this.commonCategory = commonCategory;
        return this;
    }

    public List<Product> getListSubCategoryProduct() {
        return listSubCategoryProduct;
    }

    public SubCategory setListSubCategoryProduct(List<Product> listSubCategoryProduct) {
        this.listSubCategoryProduct = listSubCategoryProduct;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubCategory that = (SubCategory) o;
        return id_SubCategory == that.id_SubCategory &&
                Objects.equals(nameSubCategory, that.nameSubCategory) &&
                Objects.equals(commonCategory, that.commonCategory) &&
                Objects.equals(listSubCategoryProduct, that.listSubCategoryProduct);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id_SubCategory, nameSubCategory, commonCategory, listSubCategoryProduct);
    }

    @Override()
    public String toString() {
        return "SubCategory{" +
                "id_SubCategory=" + id_SubCategory +
                ", nameSubCategory='" + nameSubCategory + '\'' +
                '}';
    }
}

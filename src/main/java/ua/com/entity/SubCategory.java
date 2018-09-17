package ua.com.entity;

import javax.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;


@Entity
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSubCategory;

    private String nameSubCategory;


    @ManyToOne(fetch = FetchType.LAZY,
               cascade = {CascadeType.MERGE})
    private CommonCategory commonCategory;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST})
    private List<Product> listSubCategoryProduct;


    public SubCategory() {
    }

    public SubCategory(String nameSubCategory) {
        this.nameSubCategory = nameSubCategory;
    }

    public SubCategory(String nameSubCategory, CommonCategory commonCategory, List<Product> listSubCategoryProduct) {
        this.nameSubCategory = nameSubCategory;
        this.commonCategory = commonCategory;
        this.listSubCategoryProduct = listSubCategoryProduct;
    }

    public List<Product> getListSubCategoryProduct() {
        return listSubCategoryProduct;
    }

    public SubCategory setListSubCategoryProduct(List<Product> listSubCategoryProduct) {
        this.listSubCategoryProduct = listSubCategoryProduct;
        return this;
    }

    public CommonCategory getCommonCategory() {
        return commonCategory;
    }

    public SubCategory setCommonCategory(CommonCategory commonCategory) {
        this.commonCategory = commonCategory;
        return this;
    }

    public int getIdSubCategory() {
        return idSubCategory;
    }

    public SubCategory setIdSubCategory(int idSubCategory) {
        this.idSubCategory = idSubCategory;
        return this;
    }

    public String getNameSubCategory() {
        return nameSubCategory;
    }

    public SubCategory setNameSubCategory(String nameSubCategory) {
        this.nameSubCategory = nameSubCategory;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubCategory that = (SubCategory) o;
        return idSubCategory == that.idSubCategory &&
                Objects.equals(nameSubCategory, that.nameSubCategory) &&
                Objects.equals(commonCategory, that.commonCategory) &&
                Objects.equals(listSubCategoryProduct, that.listSubCategoryProduct);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idSubCategory, nameSubCategory, commonCategory, listSubCategoryProduct);
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "idSubCategory=" + idSubCategory +
                ", nameSubCategory='" + nameSubCategory + '\'' +
                '}';
    }
}

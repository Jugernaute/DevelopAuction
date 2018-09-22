package ua.com.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;
import java.util.Objects;


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
    @OneToMany(fetch = FetchType.LAZY,
    cascade = CascadeType.PERSIST,
    mappedBy = "subCategory")
    private List<Product>products;


    public SubCategory() {
    }

    public SubCategory(String nameSubCategory) {
        this.nameSubCategory = nameSubCategory;
    }

    public SubCategory(String nameSubCategory, CommonCategory commonCategory, List<Product> products) {
        this.nameSubCategory = nameSubCategory;
        this.commonCategory = commonCategory;
        this.products = products;
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

    public List<Product> getProducts() {
        return products;
    }

    public SubCategory setProducts(List<Product> products) {
        this.products = products;
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
                Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id_SubCategory, nameSubCategory, commonCategory, products);
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "id_SubCategory=" + id_SubCategory +
                ", nameSubCategory='" + nameSubCategory + '\'' +
                '}';
    }
}

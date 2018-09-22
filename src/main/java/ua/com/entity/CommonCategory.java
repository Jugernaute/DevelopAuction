package ua.com.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            mappedBy = "commonCategory"
    )
    List<SubCategory> subCategoryList;

    public CommonCategory() {
    }

    public CommonCategory(String nameCommonCategory, List<SubCategory> subCategoryList) {
        this.nameCommonCategory = nameCommonCategory;
        this.subCategoryList = subCategoryList;
    }

    public int getId_CommonCategory() {
        return id_CommonCategory;
    }

    public CommonCategory setId_CommonCategory(int id_CommonCategory) {
        this.id_CommonCategory = id_CommonCategory;
        return this;
    }

    public String getNameCommonCategory() {
        return nameCommonCategory;
    }

    public CommonCategory setNameCommonCategory(String nameCommonCategory) {
        this.nameCommonCategory = nameCommonCategory;
        return this;
    }

    public List<SubCategory> getSubCategoryList() {
        return subCategoryList;
    }

    public CommonCategory setSubCategoryList(List<SubCategory> subCategoryList) {
        this.subCategoryList = subCategoryList;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonCategory that = (CommonCategory) o;
        return id_CommonCategory == that.id_CommonCategory &&
                Objects.equals(nameCommonCategory, that.nameCommonCategory) &&
                Objects.equals(subCategoryList, that.subCategoryList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id_CommonCategory, nameCommonCategory, subCategoryList);
    }

    @Override
    public String toString() {
        return "CommonCategory{" +
                "id_CommonCategory=" + id_CommonCategory +
                ", nameCommonCategory='" + nameCommonCategory + '\'' +
                '}';
    }
}

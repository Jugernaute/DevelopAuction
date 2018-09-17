package ua.com.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.*;

@Entity

public class CommonCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCommonCategory;
    private String nameCommonCategory;

    public CommonCategory(String nameCommonCategory) {
        this.nameCommonCategory = nameCommonCategory;
    }

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE},
            mappedBy = "commonCategory"
    )
    List<SubCategory> listSubCategorie = new ArrayList<>();


    public CommonCategory() {
    }

    public CommonCategory(String nameCommonCategory, List<SubCategory> listSubCategorie) {
        this.nameCommonCategory = nameCommonCategory;
        this.listSubCategorie = listSubCategorie;
    }

    public List<SubCategory> getListSubCategorie() {
        return listSubCategorie;
    }

    public CommonCategory setListSubCategorie(List<SubCategory> listSubCategorie) {
        this.listSubCategorie = listSubCategorie;
        return this;
    }

    public int getIdCommonCategory() {
        return idCommonCategory;
    }

    public CommonCategory setIdCommonCategory(int idCommonCategory) {
        this.idCommonCategory = idCommonCategory;
        return this;
    }

    public String getNameCommonCategory() {
        return nameCommonCategory;
    }

    public CommonCategory setNameCommonCategory(String nameCommonCategory) {
        this.nameCommonCategory = nameCommonCategory;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonCategory that = (CommonCategory) o;
        return idCommonCategory == that.idCommonCategory &&
                Objects.equals(nameCommonCategory, that.nameCommonCategory) &&
                Objects.equals(listSubCategorie, that.listSubCategorie);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idCommonCategory, nameCommonCategory, listSubCategorie);
    }

    @Override
    public String toString() {
        return "CommonCategory{" +
                "idCommonCategory=" + idCommonCategory +
                ", nameCommonCategory='" + nameCommonCategory + '\'' +
                '}';
    }
}

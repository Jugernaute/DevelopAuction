package ua.com.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id_Product;

        private String nameProduct;
        private String modelProduct;
        private String descriptionProduct;
        private String linkOnImageProduct;
//        @Enumerated(EnumType.STRING)
//        private StateProduct stateProduct;


    @JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE)
        private SubCategory subCategory;

@JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE)
        private User userOwner;
@JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY,
                cascade = CascadeType.MERGE)
        private Manufacturer manufacturer;
@JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,
    cascade = CascadeType.PERSIST,
    mappedBy = "product")
    private Lot lot;

    public Product() {
    }

    public Product(String nameProduct, String modelProduct, String descriptionProduct, String linkOnImageProduct) {
        this.nameProduct = nameProduct;
        this.modelProduct = modelProduct;
        this.descriptionProduct = descriptionProduct;
        this.linkOnImageProduct = linkOnImageProduct;
    }

    public Product(String nameProduct, String modelProduct, String descriptionProduct, String linkOnImageProduct, SubCategory subCategory, User userOwner, Manufacturer manufacturer, Lot lot) {
        this.nameProduct = nameProduct;
        this.modelProduct = modelProduct;
        this.descriptionProduct = descriptionProduct;
        this.linkOnImageProduct = linkOnImageProduct;
        this.subCategory = subCategory;
        this.userOwner = userOwner;
        this.manufacturer = manufacturer;
        this.lot = lot;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public Product setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
        return this;
    }

    public int getId_Product() {
        return id_Product;
    }

    public Product setId_Product(int id_Product) {
        this.id_Product = id_Product;
        return this;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public Product setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
        return this;
    }

    public String getModelProduct() {
        return modelProduct;
    }

    public Product setModelProduct(String modelProduct) {
        this.modelProduct = modelProduct;
        return this;
    }

    public String getLinkOnImageProduct() {
        return linkOnImageProduct;
    }

    public Product setLinkOnImageProduct(String linkOnImageProduct) {
        this.linkOnImageProduct = linkOnImageProduct;
        return this;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public Product setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
        return this;
    }

//    public StateProduct getStateProduct() {
//        return stateProduct;
//    }
//
//    public Product setStateProduct(StateProduct stateProduct) {
//        this.stateProduct = stateProduct;
//        return this;
//    }

    public User getUserOwner() {
        return userOwner;
    }

    public Product setUserOwner(User userOwner) {
        this.userOwner = userOwner;
        return this;
    }

    public Lot getLot() {
        return lot;
    }

    public Product setLot(Lot lot) {
        this.lot = lot;
        return this;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public Product setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id_Product == product.id_Product &&
                Objects.equals(nameProduct, product.nameProduct) &&
                Objects.equals(modelProduct, product.modelProduct) &&
                Objects.equals(descriptionProduct, product.descriptionProduct) &&
                Objects.equals(linkOnImageProduct, product.linkOnImageProduct) &&
                Objects.equals(subCategory, product.subCategory) &&
                Objects.equals(userOwner, product.userOwner) &&
                Objects.equals(manufacturer, product.manufacturer) &&
                Objects.equals(lot, product.lot);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id_Product, nameProduct, modelProduct, descriptionProduct, linkOnImageProduct, subCategory, userOwner, manufacturer, lot);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id_Product=" + id_Product +
                ", nameProduct='" + nameProduct + '\'' +
                ", modelProduct='" + modelProduct + '\'' +
                ", descriptionProduct='" + descriptionProduct + '\'' +
                ", linkOnImageProduct='" + linkOnImageProduct + '\'' +
                '}';
    }
}

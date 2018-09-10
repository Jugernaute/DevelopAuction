package ua.com.entity;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
//        (exclude = {"subCategory"})
//@EqualsAndHashCode

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id_Product;

        private String nameProduct;
        private String modelProduct;
        private String linkOnImageProduct;
        private String descriptionProduct;
        private StateProduct stateProduct;

        @ManyToOne(fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
        private SubCategory subCategory;

        @ManyToOne(fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
        private User userOwner;

        @OneToOne(fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
        private Lot lot;

        @ManyToOne(fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
        private Manufacturer manufacturer;

    public Product() {
    }

    public Product(String nameProduct, String modelProduct, String linkOnImageProduct, String descriptionProduct, StateProduct stateProduct, SubCategory subCategory, User userOwner, Lot lot, Manufacturer manufacturer) {
        this.nameProduct = nameProduct;
        this.modelProduct = modelProduct;
        this.linkOnImageProduct = linkOnImageProduct;
        this.descriptionProduct = descriptionProduct;
        this.stateProduct = stateProduct;
        this.subCategory = subCategory;
        this.userOwner = userOwner;
        this.lot = lot;
        this.manufacturer = manufacturer;
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

    public StateProduct getStateProduct() {
        return stateProduct;
    }

    public Product setStateProduct(StateProduct stateProduct) {
        this.stateProduct = stateProduct;
        return this;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public Product setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
        return this;
    }

    public User getUser1Owner() {
        return userOwner;
    }

    public Product setUser1Owner(User user1Owner) {
        this.userOwner = user1Owner;
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
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return id_Product == product.id_Product &&
                Objects.equals(nameProduct, product.nameProduct) &&
                Objects.equals(modelProduct, product.modelProduct) &&
                Objects.equals(linkOnImageProduct, product.linkOnImageProduct) &&
                Objects.equals(descriptionProduct, product.descriptionProduct) &&
                stateProduct == product.stateProduct &&
                Objects.equals(subCategory, product.subCategory) &&
                Objects.equals(userOwner, product.userOwner) &&
                Objects.equals(lot, product.lot) &&
                Objects.equals(manufacturer, product.manufacturer);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), id_Product, nameProduct, modelProduct, linkOnImageProduct, descriptionProduct, stateProduct, subCategory, userOwner, lot, manufacturer);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id_Product=" + id_Product +
                ", nameProduct='" + nameProduct + '\'' +
                ", modelProduct='" + modelProduct + '\'' +
                ", linkOnImageProduct='" + linkOnImageProduct + '\'' +
                ", descriptionProduct='" + descriptionProduct + '\'' +
                ", stateProduct=" + stateProduct +
                '}';
    }
}

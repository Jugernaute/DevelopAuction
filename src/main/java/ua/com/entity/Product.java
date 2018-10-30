package ua.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Product;

    private String nameProduct;
    private String modelProduct;
    private String descriptionProduct;
    @Enumerated(EnumType.STRING)
    private StateProduct stateProduct;
    @Enumerated(EnumType.STRING)
    private TypeSell typeSell;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, //eager my
    cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "product"
    )
    private List<ImageLink> imageLinks;

    @JsonIgnore
    @OneToOne(

            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "products"
    )
    private LocationLot locationLots;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE/*,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH*/})
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
    cascade = {/*CascadeType.MERGE,*/ CascadeType.REMOVE, CascadeType.PERSIST}, //merge
    mappedBy = "product")
    private Lot lot;

    public Product() {
    }

    public Product(String nameProduct, String modelProduct, String descriptionProduct) {
        this.nameProduct = nameProduct;
        this.modelProduct = modelProduct;
        this.descriptionProduct = descriptionProduct;
    }

    public Product(String nameProduct, String modelProduct, String descriptionProduct, SubCategory subCategory, User userOwner, Manufacturer manufacturer, Lot lot) {
        this.nameProduct = nameProduct;
        this.modelProduct = modelProduct;
        this.descriptionProduct = descriptionProduct;
        this.subCategory = subCategory;
        this.userOwner = userOwner;
        this.manufacturer = manufacturer;
        this.lot = lot;
    }

    public TypeSell getTypeSell() {
        return typeSell;
    }

    public void setTypeSell(TypeSell typeSell) {
        this.typeSell = typeSell;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public Product setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
        return this;
    }

    public LocationLot getLocationLots() {
        return locationLots;
    }

    public void setLocationLots(LocationLot locationLots) {
        this.locationLots = locationLots;
    }

    public StateProduct getStateProduct() {
        return stateProduct;
    }

    public void setStateProduct(StateProduct stateProduct) {
        this.stateProduct = stateProduct;
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

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public Product setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
        return this;
    }

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

    public List<ImageLink> getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(List<ImageLink> imageLinks) {
        this.imageLinks = imageLinks;
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
                stateProduct == product.stateProduct &&
                Objects.equals(imageLinks, product.imageLinks) &&
                Objects.equals(subCategory, product.subCategory) &&
                Objects.equals(userOwner, product.userOwner) &&
                Objects.equals(manufacturer, product.manufacturer) &&
                Objects.equals(lot, product.lot);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id_Product, nameProduct, modelProduct, descriptionProduct, /*linkOnImageProduct,*/ subCategory, userOwner, manufacturer, lot);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id_Product=" + id_Product +
                ", nameProduct='" + nameProduct + '\'' +
                ", modelProduct='" + modelProduct + '\'' +
                ", descriptionProduct='" + descriptionProduct + '\'' +
//                ", linkOnImageProduct='" + linkOnImageProduct + '\'' +
//                ", stateProduct=" + stateProduct +
//                ", userOwner=" + userOwner +
//                ", manufacturer=" + manufacturer +
//                ", lot=" + lot +
                '}';
    }
}

package ua.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
public class ImageLink {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_ImageLink;
    private String linkOfImage;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE})
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ImageLink(String linkOfImage) {
        this.linkOfImage = linkOfImage;
    }

    public ImageLink() {
    }

    public int getId_ImageLink() {
        return id_ImageLink;
    }

    public void setId_ImageLink(int id_ImageLink) {
        this.id_ImageLink = id_ImageLink;
    }

    public String getLinkOfImage() {
        return linkOfImage;
    }

    @Override
    public String toString() {
        return "ImageLink{" +
                "id_ImageLink=" + id_ImageLink +
                ", linkOfImage='" + linkOfImage + '\'' +
                '}';
    }

    public void setLinkOfImage(String linkOfImage) {
        this.linkOfImage = linkOfImage;
    }
}

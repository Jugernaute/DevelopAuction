package ua.com.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
        (exclude = {"productListOfClient"})
@EqualsAndHashCode
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOfClient;
    private String nameOfClient;
    private String surNameOfClient;
    private String emailOfClient;
    private boolean isBuyer;
    private boolean isSeller;
    @OneToMany(
            cascade = CascadeType.DETACH,
            fetch = FetchType.EAGER,
            mappedBy = "client")
    private List<Product> productListOfClient = new ArrayList<Product>();




}

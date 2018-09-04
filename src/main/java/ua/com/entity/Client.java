package ua.com.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString(exclude = {"productListOfClient", "typeOfClients", "auctionList"})
@EqualsAndHashCode

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClient;

    @Enumerated
    @ElementCollection(
            targetClass = TypeClient.class,
            fetch = FetchType.EAGER)
    @CollectionTable(name = "type_client",
            joinColumns = @JoinColumn(name = "client_id"))
    @Column(name = "type")
    private Set<TypeClient> typeOfClients;

    private String nameClient;

    private String surNameClient;

    private String emailClient;


    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST,
            mappedBy = "client")
    private List<Product> productListOfClient;


    @ManyToMany( fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST,
            CascadeType.MERGE})
    @JoinTable(name = "client_auction",
            joinColumns = { @JoinColumn(name = "idClient") },
            inverseJoinColumns = { @JoinColumn(name = "id_Auction") })
    private Set<Auction> auctionList;

    public Client(String nameClient, String surNameClient, String emailClient) {
        this.typeOfClients = new HashSet<>();
        this.nameClient = nameClient;
        this.surNameClient = surNameClient;
        this.emailClient = emailClient;
        this.auctionList = new HashSet<>();
        this.productListOfClient = new ArrayList<>();
    }


}

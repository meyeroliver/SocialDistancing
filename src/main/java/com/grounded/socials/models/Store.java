package com.grounded.socials.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "stores")
public class Store {
    @Id
    private int id;
    @Column(name = "store_name")
    private String storeName;
    private String address;
    private float latitude;
    private float longitude;
    private int customers;
    /**
     * {
     * id: 1,
     * username: "oh-meyer",
     * firstname: "Oliver",
     * lastname: "Meyer",
     * address: "6 Clift Street, Suider Paarl, Paarl, 7624",
     * cellPhone: "0762598650",
     * latitude: -33.7634,
     * longitude: 18.9621
     *
     *
     *
     * id: 1,
     * storeName: "SUPERSPAR The Vineyard, Paarl",
     * address: "7646 Main Road Paarl,Shop 1, Vineyard Centre, 57, Cape Town, 7620",
     * latitude: -33.763,
     * longitude: 18.9621,
     * customers: 0
     *
     *
     * }
     * */
}



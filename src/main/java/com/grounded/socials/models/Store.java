package com.grounded.socials.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "stores")
public class Store {
    @Id
    private int id;
    @Column(name = "store_name")
    private String storeName;
    private String address;
    private float latitude;
    private float longitude;
    private int customers;
}

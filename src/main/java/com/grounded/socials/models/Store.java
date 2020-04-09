package com.grounded.socials.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Store {

    private int id;
    private String storeName;
    private String address;
    private float latitude;
    private float longitude;
    private int customers;
}

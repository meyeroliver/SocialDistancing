package com.grounded.socials.models;

import lombok.*;
import org.omg.PortableInterceptor.NON_EXISTENT;

import javax.persistence.*;

@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "store")
public class Store {
    @Id
    private int id;
    @Column(name = "store_name")
    @NonNull
    private String storeName;
    @NonNull
    private String address;
    @NonNull
    private float latitude;
    @NonNull
    private float longitude;
    private int customers;
    @ManyToOne
    private User user;
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



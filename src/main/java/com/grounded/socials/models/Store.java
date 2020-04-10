package com.grounded.socials.models;

import lombok.*;
import org.omg.PortableInterceptor.NON_EXISTENT;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @ManyToMany
    private List<User> users =  new ArrayList<>();
}



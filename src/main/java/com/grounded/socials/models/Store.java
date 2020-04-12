package com.grounded.socials.models;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.annotations.SQLInsert;

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
@SQLInsert(sql = "insert into store (customers, latitude, longitude, store_name, address) " +
        "values (?, ?, ?, ?, ?)" +
        " on duplicate key update address = address")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "address")
public class Store {
    /*@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;*/
    @NonNull
    @Id
    private String address;
    @NonNull
    @Column(name = "store_name")
    private String storeName;
    @NonNull
    private Float latitude;
    @NonNull
    private Float longitude;
    private int customers;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "storeList")
    @JsonBackReference
    private List<User> userList =  new ArrayList<>();
}



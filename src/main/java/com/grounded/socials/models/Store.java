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
@SQLInsert(sql = "insert into store (customers, id, latitude, longitude, store_name, address) " +
        "values (?, ?, ?, ?, ?, ?)" +
        " on duplicate key update id = id")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Store {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NonNull
    @Column(name = "store_name")
    private String storeName;
    @NonNull
    @Id
    private String address;
    @NonNull
    private Float latitude;
    @NonNull
    private Float longitude;
    private int customers;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> userList =  new ArrayList<>();
}



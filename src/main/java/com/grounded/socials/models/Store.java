package com.grounded.socials.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
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
    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> users =  new ArrayList<>();
}



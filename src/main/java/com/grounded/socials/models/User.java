package com.grounded.socials.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "user")
public class User {
    @Id
    private int id;
    @NonNull
    private String username;
    @NonNull
    private String firstname;
    @NonNull
    private String lastname;
    @NonNull
    private String address;
    @NonNull
    private String cellPhone;
    @NonNull
    private float latitude;
    @NonNull
    private float longitude;
    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Store> stores = new ArrayList<>();
}

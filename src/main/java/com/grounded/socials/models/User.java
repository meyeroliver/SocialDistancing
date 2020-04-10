package com.grounded.socials.models;

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
    @OneToMany(mappedBy = "user")
    private List<Store> storeList = new ArrayList<>();
}

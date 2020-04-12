package com.grounded.socials.models;

import com.fasterxml.jackson.annotation.*;
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
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private Float latitude;
    @NonNull
    private Float longitude;
    @ManyToMany( fetch = FetchType.EAGER,
            /*mappedBy = "userList",*/
            cascade = CascadeType.PERSIST)
    @JoinTable(name="user_store",
                joinColumns = {@JoinColumn(name = "user_id")},
                inverseJoinColumns = {@JoinColumn(name = "")}
    )
    private List<Store> storeList = new ArrayList<>();
}

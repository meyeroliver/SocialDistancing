package com.grounded.socials.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "users")
public class User {
    @Id
    private int id;
    private String username;
    private String firstname;
    private String lastname;
    private String address;
    private String cellPhone;
    private float latitude;
    private float longitude;
    @OneToOne
    private Store store  ;
}

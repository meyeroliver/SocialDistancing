package com.grounded.socials.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "users")
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
}

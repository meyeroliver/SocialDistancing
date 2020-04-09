package com.grounded.socials.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {
    private int userId;
    private String username;
    private String firstname;
    private String lastname;
    private String address;
    private String cellPhone;
    private float latitude;
    private float longitude;
}

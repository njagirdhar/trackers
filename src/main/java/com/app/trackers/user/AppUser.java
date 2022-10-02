package com.app.trackers.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "USER_TBL")
public class AppUser implements Serializable {

    @Id
    private String userId;
    @Field(name = "FIRST_NM")
    private String firstName;
    @Field(name = "LAST_NM")
    private String lastName;
    @Field(name = "MAIL")
    private String email;
    @Field(name = "PASSWORD")
    private String password;
    @Field(name = "MOBILE_NUM")
    private String mobileNumber;
    @Field(name = "USR_ROLE")
    private AppUserRole appUserRole;
}

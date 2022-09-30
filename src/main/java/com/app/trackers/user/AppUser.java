package com.app.trackers.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER_TBL")
public class AppUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    @Column(name = "FIRST_NM" , length = 100)
    private String firstName;
    @Column(name = "LAST_NM" , length = 100)
    private String lastName;
    @Column(name = "MAIL" ,unique = true)
    private String email;
    @Column(name = "PASSWORD" , length = 60)
    private String password;
    @Column(name = "MOBILE_NUM" , length = 10)
    private String mobileNumber;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
}

package com.app.trackers.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "FORGOT_TBL")
public class ForgotEntity {

    @Id
    private Long id;
    @Field(name = "MAIL")
    private String email;
    @Field(name = "PIN")
    private String pin;
}

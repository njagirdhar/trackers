package com.app.trackers.expense;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(value = "EXPENSE_TBL")
public class Expense {

    @Id
    private Long id;
    @Field(name = "TITLE" , order = 1)
    private String title;
    @Field(name = "DESCRIPTION" , order = 2)
    private String description;
    @Field(name = "AMOUNT" , order = 3)
    private double amount;
    @Field(name = "DATETIME", order = 4)
    private String dateTime;
}

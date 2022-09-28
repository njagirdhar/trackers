package com.app.trackers.expense;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "EXPENSE_TBL")
public class Expense {

    @Id
    private Long id;
    @Column(name = "TITLE" , length = 25)
    private String title;
    @Column(name = "DESCRIPTION" , length = 75)
    private String description;
    @Column(name = "AMOUNT" , length = 10 , scale = 2)
    private double amount;
    @Column(name = "DATETIME" , length = 12)
    private String dateTime;
}

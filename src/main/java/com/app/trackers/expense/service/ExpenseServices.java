package com.app.trackers.expense.service;

import com.app.trackers.expense.Expense;
import com.app.trackers.expense.repo.ExpenseRepository;
import com.app.trackers.expense.responses.AppResponse;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Setter
public class ExpenseServices {

    private final ExpenseRepository expenseRepository;

    public ExpenseServices(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public AppResponse addExpenses(Expense expense) {
        expense.setId(Long.valueOf(new Random().nextInt(999999)));
        Expense expense1 = expenseRepository.save(expense);
        return new AppResponse("expense saved with ID:"+ expense1.getId());
    }

    public List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }
}
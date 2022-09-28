package com.app.trackers.expense;

import com.app.trackers.expense.responses.AppResponse;
import com.app.trackers.expense.service.ExpenseServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/expenses")
@Slf4j
public class ExpenseController {

    private final ExpenseServices expenseServices;

    public ExpenseController(ExpenseServices expenseServices) {
        this.expenseServices = expenseServices;
    }

    @PostMapping
    public ResponseEntity<AppResponse> addExpenses(@RequestBody Expense expense) {
        return ResponseEntity.status(HttpStatus.CREATED).body(expenseServices.addExpenses(expense));
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getExpenses() {
        return ResponseEntity.status(HttpStatus.OK).body(expenseServices.getExpenses());
    }

}

package com.app.trackers.expense.repo;

import com.app.trackers.expense.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense ,Long> {
}

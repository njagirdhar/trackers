package com.app.trackers.expense.repo;

import com.app.trackers.expense.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense ,Long> {
}

package com.fleetcontrol.service;

import com.fleetcontrol.dto.ExpenseRequest;
import com.fleetcontrol.model.Expense;

import java.util.List;

public interface ExpenseService {

    Expense createExpense(ExpenseRequest form);

    List<Expense> getAllExpense();

    List<Expense> getExpenseByTripId(Long id);

    List<Expense> getExpenseByCategory(String category);

    List<Expense> findByCategoryContaining(String string);

    List<String> findAllCategories();
}

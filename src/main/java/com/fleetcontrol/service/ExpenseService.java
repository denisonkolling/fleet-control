package com.fleetcontrol.service;

import com.fleetcontrol.dto.ExpenseRequest;
import com.fleetcontrol.model.Expense;

import java.util.List;

public interface ExpenseService {

    public Expense createExpense(ExpenseRequest form);

    public List<Expense> getAllExpense();

    public List<Expense> getExpenseByTripId(Long id);

    public List<Expense> getExpenseByCategory(String category);

    public List<Expense> findByCategoryContaining(String string);

}

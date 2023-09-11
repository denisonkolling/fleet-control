package com.fleetcontrol.service;

import com.fleetcontrol.dto.ExpenseRequest;
import com.fleetcontrol.model.Expense;

public interface ExpenseService {

    public Expense createExpense(ExpenseRequest form);

}

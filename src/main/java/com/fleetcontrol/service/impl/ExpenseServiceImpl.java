package com.fleetcontrol.service.impl;

import com.fleetcontrol.model.Expense;
import com.fleetcontrol.repository.ExpenseRepository;
import com.fleetcontrol.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;


    @Override
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }
}

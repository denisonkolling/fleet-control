package com.fleetcontrol.service.impl;

import com.fleetcontrol.dto.ExpenseRequest;
import com.fleetcontrol.model.Expense;
import com.fleetcontrol.model.Trip;
import com.fleetcontrol.repository.ExpenseRepository;
import com.fleetcontrol.repository.TripRepository;
import com.fleetcontrol.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private TripRepository tripRepository;


    @Override
    public Expense createExpense(ExpenseRequest form) {
        Expense expense = new Expense();
        Trip trip = tripRepository.findById(form.getTripId()).get();

        expense.setTrip(trip);
        expense.setDescription(form.getDescription());
        expense.setCategory(form.getCategory());
        expense.setValue(form.getValue());
        expense.setExpenseDate(form.getExpenseDate());

        return expenseRepository.save(expense);
    }
}

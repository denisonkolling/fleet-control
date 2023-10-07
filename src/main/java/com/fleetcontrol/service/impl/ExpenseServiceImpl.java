package com.fleetcontrol.service.impl;

import com.fleetcontrol.dto.ExpenseRequest;
import com.fleetcontrol.model.Expense;
import com.fleetcontrol.model.Trip;
import com.fleetcontrol.repository.ExpenseRepository;
import com.fleetcontrol.repository.TripRepository;
import com.fleetcontrol.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

        List<Expense> tripExpenses = trip.getExpenses();

        List<Double> expensesValue = new ArrayList<>();

        for (Expense expenses: tripExpenses){
            double expenseTotalValue = expenses.getValue();
            expensesValue.add(expenseTotalValue);
        }

        double totalTripExpense = expensesValue.stream().mapToDouble(tripExpenseValue -> tripExpenseValue).sum();


        trip.setTripTotalExpense(totalTripExpense);

        tripRepository.save(trip);
        return expenseRepository.save(expense);
    }

    @Override
    public List<Expense> getAllExpense() {
        return expenseRepository.findAll();
    }

    @Override
    public List<Expense> getExpenseByTripId(Long tripId) {
        return expenseRepository.findByTripId(tripId);
    }

    @Override
    public List<Expense> getExpenseByCategory(String category) {
        return expenseRepository.findByCategory(category);
    }

    @Override
    public List<Expense> findByCategoryContaining(String string) {
        return expenseRepository.findByCategoryContaining(string);
    }

}

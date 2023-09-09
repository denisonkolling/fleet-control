package com.fleetcontrol.controller;

import com.fleetcontrol.model.Expense;
import com.fleetcontrol.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/expense")
    public ResponseEntity<?> createExpense(@RequestBody Expense expense){
        return new ResponseEntity<>(expenseService.createExpense(expense), HttpStatus.CREATED);
    }
}

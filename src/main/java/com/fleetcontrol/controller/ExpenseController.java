package com.fleetcontrol.controller;

import com.fleetcontrol.dto.ExpenseRequest;
import com.fleetcontrol.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseEntity<?> createExpense(@RequestBody ExpenseRequest form) {
        return new ResponseEntity<>(expenseService.createExpense(form), HttpStatus.CREATED);
    }

    @GetMapping
    private ResponseEntity<?> getAllExpense() {
        return new ResponseEntity<>(expenseService.getAllExpense(), HttpStatus.OK);
    }

    @GetMapping("trip/{tripId}")
    public ResponseEntity<?> getExpenseByTripId(@PathVariable Long tripId) {
        return new ResponseEntity<>(expenseService.getExpenseByTripId(tripId), HttpStatus.OK);
    }

    @GetMapping("category/{category}")
    public ResponseEntity<?> getExpenseByCategory(@PathVariable String category) {
        return new ResponseEntity<>(expenseService.getExpenseByCategory(category), HttpStatus.OK);
    }

    @GetMapping("category/search/{search}")
    public ResponseEntity<?> findByCategoryContaining(@PathVariable String search) {
        return new ResponseEntity<>(expenseService.findByCategoryContaining(search), HttpStatus.OK);

    }

    @GetMapping("category")
    public ResponseEntity<List<String>> findAllCategories() {
        return new ResponseEntity<>(expenseService.findAllCategories(), HttpStatus.OK);
    }
}

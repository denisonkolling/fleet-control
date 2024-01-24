package com.fleetcontrol.repository;

import com.fleetcontrol.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    public List<Expense> findByTripId(Long tripId);

    @Query("SELECT c from Expense c WHERE c.category ILIKE CONCAT ('%', :category, '%')")
    public List<Expense> findByCategory(String category);

    public List<Expense> findByCategoryContaining(String string);

    @Query("SELECT DISTINCT c.category FROM Expense c")
    public List<String> findAllCategories();

}

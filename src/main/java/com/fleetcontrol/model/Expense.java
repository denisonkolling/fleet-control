package com.fleetcontrol.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "trip_expenses")

public class Expense {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String description;

  private String category;

  private Double value;

  private Date expenseDate;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "trip_id")
  private Trip trip;

}
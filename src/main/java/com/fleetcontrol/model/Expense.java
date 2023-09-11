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
  public Long id;

  public String description;

  public String category;

  public Double value;

  public Date expenseDate;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "trip_id")
  private Trip trip;

}
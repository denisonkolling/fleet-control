package com.fleetcontrol.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table (name = "trips")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Trip {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  public String vehicle;

  public String origin;

  public String destination;

  public Long distance;

  public Long invoice;

  @OneToMany(mappedBy = "trip", fetch = FetchType.LAZY)

  @JsonIgnore
  private List<Expense> expenses = new ArrayList<>();

}
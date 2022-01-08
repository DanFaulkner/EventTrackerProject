package com.skilldistillery.lifttracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.lifttracker.entities.Weight;

public interface WeightRepository extends JpaRepository<Weight, Integer> {

}

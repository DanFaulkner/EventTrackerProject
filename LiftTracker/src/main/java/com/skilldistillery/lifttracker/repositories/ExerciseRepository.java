package com.skilldistillery.lifttracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.lifttracker.entities.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {

}

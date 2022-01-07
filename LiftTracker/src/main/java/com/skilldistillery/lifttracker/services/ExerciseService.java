package com.skilldistillery.lifttracker.services;

import java.util.List;

import com.skilldistillery.lifttracker.entities.Exercise;

public interface ExerciseService {

	
	List<Exercise> getAllExercises();
	Exercise getExerciseById(int exerciseId);
	Exercise addExercise(Exercise exercise);
	Exercise editExercise(Exercise exercise);
	boolean deleteExercise(int exerciseId);
}

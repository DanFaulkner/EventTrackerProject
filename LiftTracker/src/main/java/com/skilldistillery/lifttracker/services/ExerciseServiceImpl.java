package com.skilldistillery.lifttracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.lifttracker.entities.Exercise;
import com.skilldistillery.lifttracker.repositories.ExerciseRepository;

@Service
public class ExerciseServiceImpl implements ExerciseService {
	
	@Autowired
	private ExerciseRepository exerciseRepo;

	@Override
	public List<Exercise> getAllExercises() {
		return exerciseRepo.findAll();
	}

	@Override
	public Exercise getExerciseById(int exerciseId) {
		return exerciseRepo.findById(exerciseId).get();
	}

	@Override
	public Exercise addExercise(Exercise exercise) {
		return exerciseRepo.save(exercise);
	}

	@Override
	public Exercise editExercise(Exercise exercise) {
		return exerciseRepo.saveAndFlush(exercise);
	}

	@Override
	public boolean deleteExercise(int exerciseId) {
		boolean deleted = false;
		if(exerciseRepo.existsById(exerciseId)) {
			exerciseRepo.deleteById(exerciseId);
			deleted = true;
		}
		return deleted;
	}

}

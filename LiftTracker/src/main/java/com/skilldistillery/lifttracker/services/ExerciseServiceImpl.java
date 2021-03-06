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
	
	/*---------------------------------------------------------------------
	 * get all exercises
	 ---------------------------------------------------------------------*/

	@Override
	public List<Exercise> getAllExercises() {
		return exerciseRepo.findAll();
	}

	/*---------------------------------------------------------------------
	 * get exercise by id
	 ---------------------------------------------------------------------*/
	
	@Override
	public Exercise getExerciseById(int exerciseId) {
		if (exerciseRepo.existsById(exerciseId)) {
			return exerciseRepo.findById(exerciseId).get();
		}
		return null;
	}

	/*---------------------------------------------------------------------
	 * create an exercise
	 ---------------------------------------------------------------------*/
	
	@Override
	public Exercise addExercise(Exercise exercise) {
		return exerciseRepo.saveAndFlush(exercise);
	}
	
	/*---------------------------------------------------------------------
	 * edit an exercise
	 ---------------------------------------------------------------------*/

	@Override
	public Exercise editExercise(int id, Exercise exercise) {
		exercise.setId(id);
		if (exerciseRepo.existsById(id)) {
			return exerciseRepo.save(exercise);
		}
		return null;
	}
	
	/*---------------------------------------------------------------------
	 * delete an exercise
	 ---------------------------------------------------------------------*/

	@Override
	public boolean deleteExercise(int exerciseId) {
		boolean deleted = false;
		if (exerciseRepo.existsById(exerciseId)) {
			exerciseRepo.deleteById(exerciseId);
			deleted = true;
		}
		return deleted;
	}

}

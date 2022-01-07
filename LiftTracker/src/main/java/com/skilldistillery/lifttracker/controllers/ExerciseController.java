package com.skilldistillery.lifttracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.lifttracker.entities.Exercise;
import com.skilldistillery.lifttracker.services.ExerciseService;

@RestController
@RequestMapping("api")
public class ExerciseController {
	
	@Autowired
	private ExerciseService exerciseSvc;
	
	@GetMapping("exercises")
	public List<Exercise> index(){
		return exerciseSvc.getAllExercises();
	}
	
	@GetMapping("exercises/{id}")
	public Exercise getExerciseById(@PathVariable int id) {
		return exerciseSvc.getExerciseById(id);
	}
	
	@PostMapping("exercises")
	public Exercise addExercise(@RequestBody Exercise exercise) {
		return exerciseSvc.addExercise(exercise);
	}
	
	@PutMapping("exercise/{id}")
	public Exercise editExercise(@RequestBody Exercise exercise) {
		return exerciseSvc.editExercise(exercise);
	}
	
	@DeleteMapping("exercise/{id}")
	public void deleteExercide(@PathVariable int id) {
		exerciseSvc.deleteExercise(id);
	}

}

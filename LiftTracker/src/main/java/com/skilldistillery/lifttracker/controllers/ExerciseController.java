package com.skilldistillery.lifttracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	/*---------------------------------------------------------------------
	 * get all exercises
	 ---------------------------------------------------------------------*/

	@GetMapping("exercises")
	public List<Exercise> index() {
		return exerciseSvc.getAllExercises();
	}
	
	/*---------------------------------------------------------------------
	 * get exercise by id
	 ---------------------------------------------------------------------*/

	@GetMapping("exercises/{id}")
	public Exercise getExerciseById(@PathVariable int id, HttpServletResponse res) {
		Exercise exercise = exerciseSvc.getExerciseById(id);
		if (exercise == null) {
			res.setStatus(400);
		}
		return exercise;
	}

	
	/*---------------------------------------------------------------------
	 * create an exercise
	 ---------------------------------------------------------------------*/
	
	@PostMapping("exercises")
	public Exercise addExercise(@RequestBody Exercise exercise, HttpServletResponse res, HttpServletRequest req) {
		try {
			exerciseSvc.addExercise(exercise);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(exercise.getId());
			res.setHeader("Location", url.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("INVALID JSON");
			res.setStatus(400);
			exercise = null;
		}
		return exercise;
	}

	
	/*---------------------------------------------------------------------
	 * edit an exercise
	 ---------------------------------------------------------------------*/
	
	@PutMapping("exercises/{id}")
	public Exercise editExercise(@PathVariable int id, @RequestBody Exercise exercise, HttpServletResponse res) {
		try {
			if (exerciseSvc.getExerciseById(id) != null) {
				exerciseSvc.editExercise(id, exercise);
			} else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		return exercise;
	}

	
	/*---------------------------------------------------------------------
	 * delete an exercise
	 ---------------------------------------------------------------------*/
	
	@DeleteMapping("exercises/{id}")
	public void deleteExercise(@PathVariable int id, HttpServletResponse res) {
		try {
		if(exerciseSvc.deleteExercise(id)) {
			res.setStatus(204);
		}else {
			res.setStatus(404);
		}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
	}

}

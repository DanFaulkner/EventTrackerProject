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

import com.skilldistillery.lifttracker.entities.Weight;
import com.skilldistillery.lifttracker.entities.Weight;
import com.skilldistillery.lifttracker.services.WeightService;

@RestController
@RequestMapping("api")
public class WeightController {
	
	@Autowired
	private WeightService weightSvc;
	
	@GetMapping("weights")
	public List<Weight> index() {
		return weightSvc.getAllWeight();
	}
	
	/*---------------------------------------------------------------------
	 * get weight by id
	 ---------------------------------------------------------------------*/

	@GetMapping("weights/{id}")
	public Weight getWeightById(@PathVariable int id, HttpServletResponse res) {
		Weight exercise = weightSvc.getWeightById(id);
		if (exercise == null) {
			res.setStatus(400);
		}
		return exercise;
	}

	
	/*---------------------------------------------------------------------
	 * create an weight
	 ---------------------------------------------------------------------*/
	
	@PostMapping("weights")
	public Weight addWeights(@RequestBody Weight weight, HttpServletResponse res, HttpServletRequest req) {
		Weight newWeight = new Weight();
		try {
			newWeight = weightSvc.addWeight(weight);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(weight.getId());
			res.setHeader("Location", url.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("INVALID JSON");
			res.setStatus(400);
			newWeight = null;
		}
		return newWeight;
	}

	
	/*---------------------------------------------------------------------
	 * edit an weight
	 ---------------------------------------------------------------------*/
	
	@PutMapping("weights/{id}")
	public Weight editWeight(@PathVariable int id, @RequestBody Weight weight, HttpServletResponse res) {
		try {
			if (weightSvc.getWeightById(id) != null) {
				weightSvc.editWeight(id, weight);
			} else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		return weight;
	}

	
	/*---------------------------------------------------------------------
	 * delete an weight
	 ---------------------------------------------------------------------*/
	
	@DeleteMapping("weights/{id}")
	public void deleteWeight(@PathVariable int id, HttpServletResponse res) {
		try {
		if(weightSvc.deleteWeight(id)) {
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

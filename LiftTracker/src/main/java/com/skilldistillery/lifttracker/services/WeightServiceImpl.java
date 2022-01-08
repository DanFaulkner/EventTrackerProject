package com.skilldistillery.lifttracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.lifttracker.entities.Weight;
import com.skilldistillery.lifttracker.repositories.WeightRepository;

@Service
public class WeightServiceImpl implements WeightService {

	@Autowired
	private WeightRepository weightRepo;

	/*---------------------------------------------------------------------
	 * find all weights
	 ---------------------------------------------------------------------*/
	
	@Override
	public List<Weight> getAllWeight() {
		return weightRepo.findAll();
	}
	
	/*---------------------------------------------------------------------
	 * get a weight by id
	 ---------------------------------------------------------------------*/

	@Override
	public Weight getWeightById(int weightId) {
		if (weightRepo.existsById(weightId)) {
			return weightRepo.findById(weightId).get();
		}
		return null;
	}
	
	/*---------------------------------------------------------------------
	 * add a weight
	 ---------------------------------------------------------------------*/

	@Override
	public Weight addWeight(Weight weight) {
		return weightRepo.saveAndFlush(weight);
	}
	
	/*---------------------------------------------------------------------
	 * edit a weight
	 ---------------------------------------------------------------------*/

	@Override
	public Weight editWeight(int id, Weight weight) {
		weight.setId(id);
		weight.setDate(weightRepo.findById(id).get().getDate());
		weight.setUser(weightRepo.findById(id).get().getUser());
		weight.setExercise(weightRepo.findById(id).get().getExercise());
		if(weightRepo.existsById(id)) {
			return weightRepo.save(weight);
		}
		return null;
	}

	/*---------------------------------------------------------------------
	 * delete a weight
	 ---------------------------------------------------------------------*/
	@Override
	public boolean deleteWeight(int weightId) {
		boolean deleted = false;
		if (weightRepo.existsById(weightId)) {
			weightRepo.deleteById(weightId);
			deleted = true;
		}
		return deleted;
	}

}

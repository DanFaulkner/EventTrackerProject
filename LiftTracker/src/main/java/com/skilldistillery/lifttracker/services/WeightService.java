package com.skilldistillery.lifttracker.services;

import java.util.List;

import com.skilldistillery.lifttracker.entities.Weight;

public interface WeightService {

	List<Weight> getAllWeight();
	Weight getWeightById(int weightId);
	Weight addWeight(Weight exercise);
	Weight editWeight(int id, Weight weight);
	boolean deleteWeight(int weightId);
}

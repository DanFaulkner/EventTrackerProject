package com.skilldistillery.lifttracker.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Exercise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "exercise")
	private List<Weight> weights;
	
	/*---------------------------------------------------------------
	 * Constructors
	 ---------------------------------------------------------------*/
	
	public Exercise() {
	
	}
	
	public Exercise(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	/*---------------------------------------------------------------
	 * Getters and Setters
	 ---------------------------------------------------------------*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Weight> getWeights() {
		return weights;
	}
	
	public void setWeights(List<Weight> weights) {
		this.weights = weights;
	}
	
	/*---------------------------------------------------------------
	 * Hashcode and Equals
	 ---------------------------------------------------------------*/


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exercise other = (Exercise) obj;
		return id == other.id && Objects.equals(name, other.name);
	}
	
	/*---------------------------------------------------------------
	 * ToString
	 ---------------------------------------------------------------*/

	@Override
	public String toString() {
		return "Exercise [id=" + id + ", name=" + name + "]";
	}
	
	

}

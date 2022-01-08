package com.skilldistillery.lifttracker.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Weight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int amount;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "exercise_id")
	private Exercise exercise;
	
	@CreationTimestamp
	private LocalDateTime date;
	
	/*---------------------------------------------------------------
	 * Constructors
	 ---------------------------------------------------------------*/
	
	public Weight() {}
	
	public Weight(int id, int amount) {
		super();
		this.id = id;
		this.amount = amount;
	}
	
	/*---------------------------------------------------------------
	 * Getter and Setters
	 ---------------------------------------------------------------*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Exercise getExercise() {
		return exercise;
	}
	
	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	public LocalDateTime getDate() {
		return date;
	}
	
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	/*---------------------------------------------------------------
	 * Hascode and Equals
	 ---------------------------------------------------------------*/
	
	@Override
	public int hashCode() {
		return Objects.hash(amount, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weight other = (Weight) obj;
		return amount == other.amount && id == other.id;
	}
	
	/*---------------------------------------------------------------
	 * ToString
	 ---------------------------------------------------------------*/

	@Override
	public String toString() {
		return "Weight [id=" + id + ", amount=" + amount + "]";
	}
	
	
	
	

}

package com.skilldistillery.lifttracker.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	
	private String password;
	
	private String name;
	
	private Integer height;
	
	private Integer weight;
	
	/*---------------------------------------------------------------
	 * Constructors
	 ---------------------------------------------------------------*/
	
	public User() {}

	public User(int id, String username, String password, String name, Integer height, Integer weight) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.height = height;
		this.weight = weight;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	/*---------------------------------------------------------------
	 * Hashcode and Equals
	 ---------------------------------------------------------------*/
	
	@Override
	public int hashCode() {
		return Objects.hash(height, id, name, password, username, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(height, other.height) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username)
				&& Objects.equals(weight, other.weight);
	}

	
	/*---------------------------------------------------------------
	 * ToString
	 ---------------------------------------------------------------*/
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", height="
				+ height + ", weight=" + weight + "]";
	}
	
	

}

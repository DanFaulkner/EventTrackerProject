package com.skilldistillery.lifttracker.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeightTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Weight weight;

	
	@BeforeAll
	static void setupBeforeClass() {
		emf = Persistence.createEntityManagerFactory("JPALiftTracker");
	}
	
	@AfterAll
	static void tearDownAfterClass() {
		emf.close();
	}
	
	@BeforeEach
	void setUp()throws Exception {
		em = emf.createEntityManager();
		weight = em.find(Weight.class, 1);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test
	void test_weight_mapping() {
		assertNotNull(weight);
		assertEquals(35, weight.getAmount());
		assertEquals(2022, weight.getDate().getYear());
	}
	
	@Test 
	void test_weight_user_mapping(){
		assertNotNull(weight);
		assertEquals("admin", weight.getUser().getUsername());
		assertEquals("admin", weight.getUser().getPassword());
	}
	
	@Test 
	void test_weight_exercise_mapping(){
		assertNotNull(weight);
		assertEquals("dumbbell bicep curls", weight.getExercise().getName());
	}

}

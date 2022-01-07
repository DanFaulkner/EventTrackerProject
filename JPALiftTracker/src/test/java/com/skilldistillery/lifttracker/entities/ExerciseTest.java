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

class ExerciseTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Exercise ex;

	
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
		ex = em.find(Exercise.class, 1);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}
	@Test
	void test() {
		assertNotNull(ex);
		assertEquals("dumbbell bicep curls", ex.getName());
	}

}

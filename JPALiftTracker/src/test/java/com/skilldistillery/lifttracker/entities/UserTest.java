package com.skilldistillery.lifttracker.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private User user;

	
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
		user = em.find(User.class, 1);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}
	
	@Test
	void test_user_mapping() {
		assertNotNull(user);
		assertEquals("admin", user.getUsername());
		assertEquals("admin", user.getPassword());
		assertEquals("ad min", user.getName());
	}
	
	@Test
	void test_user_to_weights_mapping() {
		assertNotNull(user);
		assertTrue(user.getWeights().size() > 0);
	}

}

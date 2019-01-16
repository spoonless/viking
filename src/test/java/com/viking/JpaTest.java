package com.viking;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class JpaTest {
	
	private static EntityManagerFactory emf;
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@BeforeClass
	public static void creerEntityManagerFactory() {
		emf = Persistence.createEntityManagerFactory("viking-catalogue");
	}
	
	@AfterClass
	public static void fermerEntityManagerFactory() {
		if (emf != null) {
			emf.close();
		}
	}
	
	@Before
	public void creerEntityManager() {
		entityManager = emf.createEntityManager();
	}
	
	@After
	public void fermerEntityManager() {
		entityManager.close();
	}
	
}









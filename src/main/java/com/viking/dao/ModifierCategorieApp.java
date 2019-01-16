package com.viking.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.viking.entite.Categorie;

public class ModifierCategorieApp {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("viking-catalogue");
		EntityManager entityManager = emf.createEntityManager();
		try {
			Categorie categorie = entityManager.find(Categorie.class, 15L);
			entityManager.refresh(categorie);
			entityManager.refresh(categorie);
			entityManager.refresh(categorie);
			entityManager.refresh(categorie);
			entityManager.refresh(categorie);
			entityManager.refresh(categorie);
			entityManager.refresh(categorie);

		} finally {
			entityManager.close();
			emf.close();
		}
	}

}

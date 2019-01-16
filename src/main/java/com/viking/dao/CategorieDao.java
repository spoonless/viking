package com.viking.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.viking.entite.Categorie;

public class CategorieDao {

	private EntityManager entityManager;

	public CategorieDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Categorie get(long id) {
		return entityManager.find(Categorie.class, id);
	}

	public void create(Categorie c) {
		entityManager.getTransaction().begin();
		entityManager.persist(c);
		entityManager.getTransaction().commit();
	}

	public void delete(Categorie c) {
		entityManager.getTransaction().begin();
		entityManager.remove(c);
		entityManager.getTransaction().commit();
	}
	
	public List<Categorie> getAll() {
		return entityManager.createQuery("select c from Categorie c order by c.nom", Categorie.class).getResultList();
	}
	
	public Categorie getByNom(String nom) {
		List<Categorie> categories = entityManager.createQuery("select c from Categorie c where c.nom = :nom", Categorie.class)
				            					  .setParameter("nom", nom)
				            					  .setMaxResults(1)
				                                  .getResultList();
		return categories.isEmpty() ? null : categories.get(0);
	}
}

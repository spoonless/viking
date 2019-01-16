package com.viking.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.viking.JpaTest;
import com.viking.entite.Categorie;

public class CategorieDaoTest extends JpaTest {
	
	@Test
	public void testGetCategorie() throws Exception {
		CategorieDao categorieDao = new CategorieDao(getEntityManager());
		
		Categorie categorie = categorieDao.get(1);
		
		assertEquals("écran", categorie.getNom());
	}

	@Test
	public void testCreateDeleteCategorie() throws Exception {
		CategorieDao categorieDao = new CategorieDao(getEntityManager());
		Categorie categorie = new Categorie();
		categorie.setNom("Ma categorie");
		
		categorieDao.create(categorie);
		categorieDao.delete(categorie);
		Categorie categorieSupprimee = categorieDao.get(categorie.getId());
		
		assertNotNull(categorie.getId());
		assertNull(categorieSupprimee);
	}
	
	@Test
	public void testGetAll() throws Exception {
		CategorieDao categorieDao = new CategorieDao(getEntityManager());
		
		List<Categorie> categories = categorieDao.getAll();
		
		assertFalse(categories.isEmpty());
	}

	@Test
	public void testGetByNom() throws Exception {
		CategorieDao categorieDao = new CategorieDao(getEntityManager());
		
		Categorie categorie = categorieDao.getByNom("écran");
		
		assertNotNull(categorie);
		assertEquals("écran", categorie.getNom());
	}

	@Test
	public void testGetByNomQuandLaCategorieNexistePas() throws Exception {
		CategorieDao categorieDao = new CategorieDao(getEntityManager());
		
		Categorie categorie = categorieDao.getByNom("xxxxxxxxxxx");
		
		assertNull(categorie);
	}
}

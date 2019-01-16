package viking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.viking.entite.Constructeur;

public class JpaTest {
	
	private static EntityManagerFactory emf;
	private EntityManager entityManager;
	
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
	
	@Test
	@Ignore
	public void testFindConstructeur() throws Exception {
		Constructeur c = entityManager.find(Constructeur.class, 1L);
		
		assertEquals(Long.valueOf(1), c.getId());
		assertEquals("asus", c.getNom());
	}

	@Test
	public void testPersistConstructeur() throws Exception {
		Constructeur constructeur = new Constructeur();
		constructeur.setNom("atari");

		entityManager.getTransaction().begin();
		entityManager.persist(constructeur);
		entityManager.getTransaction().commit();
		
		assertNotNull(constructeur.getId());
	}
}









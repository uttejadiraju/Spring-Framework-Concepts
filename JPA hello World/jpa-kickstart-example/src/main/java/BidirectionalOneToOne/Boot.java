package BidirectionalOneToOne;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;

public class Boot {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("example-unit");

	public static void main(String[] args) {

		try {
			EntityManager em = factory.createEntityManager();
			persistEntities(em);

			nativeQuery(em, "SHOW COLUMNS FROM EntityX");
			nativeQuery(em, "SHOW COLUMNS FROM EntityY");
			
			
			nativeQuery(em, "SELECT * FROM EntityX");
			nativeQuery(em, "SELECT * FROM EntityY");
			
			

			loadEntityX(factory);
			loadEntityY(factory);

			em.close();
		} finally {
			factory.close();
		}

	}

	private static void loadEntityX(EntityManagerFactory emf) {
		System.out.println("-- Loading Parent --");
		EntityManager em = emf.createEntityManager();
		EntityX entityA = em.find(EntityX.class, 1);
		System.out.println(entityA);
		System.out.println(entityA.getEntityY());
		em.close();
	}

	private static void loadEntityY(EntityManagerFactory emf) {
		System.out.println("-- Loading EntityB --");
		EntityManager em = emf.createEntityManager();
		EntityY entityY = em.find(EntityY.class, 2);
		System.out.println(entityY);
		System.out.println(entityY.getEntityX());
		em.close();
	}

	private static void persistEntities(EntityManager em) {

		EntityY b = new EntityY();

		b.setbValue("hurray!!!");
		EntityX a = new EntityX();

		a.setEntityY(b);

		em.getTransaction().begin();

		em.persist(a);
		em.persist(b);

		em.getTransaction().commit();

	}

	public static void nativeQuery(EntityManager em, String s) {
		System.out.printf("---------------------------%n'%s'%n", s);
		Query query = em.createNativeQuery(s);
		List list = query.getResultList();
		for (Object o : list) {
			if (o instanceof Object[]) {
				System.out.println(Arrays.toString((Object[]) o));
			} else {
				System.out.println(o);
			}
		}
	}
}

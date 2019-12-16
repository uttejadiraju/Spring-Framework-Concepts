package manysToOne;

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

			nativeQuery(em, "SELECT * FROM EntityA7");
			nativeQuery(em, "SELECT * FROM EntityA8");

			nativeQuery(em, "SHOW COLUMNS FROM EntityA7");
			nativeQuery(em, "SHOW COLUMNS FROM EntityA8");

			nativeQuery(em, "SELECT max(id) from EntityA7");

			loadEntityA(factory);
			loadEntityB(factory);

			em.close();
		} finally {
			factory.close();
		}

	}

	private static void persistEntities(EntityManager em) {
		EntityA8 b = new EntityA8();

		b.setbValue("hurray!!!");

		for (int i = 1; i <= 100; i++) {
			EntityA7 a = new EntityA7();

			a.setEntityA8(b);

			em.getTransaction().begin();

			em.persist(a);
			
			
			em.persist(b);

			em.getTransaction().commit();
		}



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

	private static void loadEntityA(EntityManagerFactory emf) {
		System.out.println("-- Loading Parent --");
		EntityManager em = emf.createEntityManager();
		List<EntityA7> entityAList = em.createQuery("Select t from EntityA7 t").getResultList();
		entityAList.forEach(System.out::println);
		em.close();
	}

	private static void loadEntityB(EntityManagerFactory emf) {
		System.out.println("-- Loading EntityB --");
		EntityManager em = emf.createEntityManager();
		List<EntityA8> entityBList = em.createQuery("Select t from EntityA8 t").getResultList();
		entityBList.forEach(System.out::println);
		em.close();
	}
}

package ManyToMany;

import java.util.Arrays;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;

public class ManyToManyRel {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("example-unit");

	public static void main(String[] args) {

		try {
			EntityManager em = factory.createEntityManager();
			persistEntities(em);

			nativeQuery(em, "SHOW COLUMNS FROM EntityA66");
			nativeQuery(em, "SHOW COLUMNS FROM EntityA77");

			loadEntityA(factory);
			loadEntityB(factory);

			em.close();
		} finally {
			factory.close();
		}

	}

	private static void persistEntities(EntityManager em) {

		EntityA66 a = new EntityA66();
		EntityA66 a1 = new EntityA66();
		EntityA77 b = new EntityA77();
		EntityA77 b1 = new EntityA77();

		b.setbValue("hurray!!!");
		b1.setbValue("yahoo!!!");

		a.setEntityB(Arrays.asList(b, b1));
		a1.setEntityB(Arrays.asList(b, b1));

		em.getTransaction().begin();

		em.persist(a);
		em.persist(a1);

		em.persist(b);

		em.persist(b1);

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

	private static void loadEntityA(EntityManagerFactory emf) {
		System.out.println("-- Loading Parent --");
		EntityManager em = emf.createEntityManager();
		List<EntityA66> entityAList = em.createQuery("Select t from EntityA66 t").getResultList();
		entityAList.forEach(System.out::println);
		em.close();
	}

	private static void loadEntityB(EntityManagerFactory emf) {
		System.out.println("-- Loading EntityB --");
		EntityManager em = emf.createEntityManager();
		List<EntityA77> entityBList = em.createQuery("Select t from EntityA77 t").getResultList();
		entityBList.forEach(System.out::println);
		em.close();
	}
}

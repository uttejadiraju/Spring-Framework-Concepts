package fieldAccess;

import javax.persistence.EntityManager;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.Arrays;
import java.util.List;

public class ExampleMain {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

	public static void main(String[] args) {
		try {
			persistEvent();
			nativeQuery("SELECT * FROM MyObject");
		} finally {
			entityManagerFactory.close();
		}
	}

	private static void persistEvent() {
		EntityManager em = entityManagerFactory.createEntityManager();

		em.getTransaction().begin();
		em.persist(new MyObject3());
		em.getTransaction().commit();

		em.close();
	}

	public static void nativeQuery(String s) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("--------\n" + s);
		Query query = entityManager.createNativeQuery(s);
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
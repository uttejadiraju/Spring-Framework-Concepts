package jpaGeneratorSeq;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.stream.IntStream;

public class ExampleMain {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

	public static void main(String[] args) {
		try {
			persistEvent();
			nativeQuery("select id from MyObject");
		} finally {
			entityManagerFactory.close();
		}
	}

	private static void persistEvent() {
		EntityManager em = entityManagerFactory.createEntityManager();

		IntStream.range(0, 100).forEach(e -> {
			em.getTransaction().begin();
			em.persist(new MyObject1());
			em.getTransaction().commit();
		});

		em.close();
	}

	@SuppressWarnings("unchecked")
	public static void nativeQuery(String s) {
		EntityManager em = entityManagerFactory.createEntityManager();
		System.out.println("-- native query --");
		Query query = em.createNativeQuery(s);
		query.getResultList().forEach(System.out::println);
		em.close();
	}
}
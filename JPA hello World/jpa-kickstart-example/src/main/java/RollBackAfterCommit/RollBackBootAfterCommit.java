package RollBackAfterCommit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.Arrays;
import java.util.List;

public class RollBackBootAfterCommit {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
		try {
			persistCustomerEntity(emf);
			runNativeQuery("SHOW COLUMNS FROM Customer", emf);
		} finally {
			emf.close();
		}
	}

	private static void persistCustomerEntity(EntityManagerFactory emf) {
		System.out.println("-- Persisting Customer entity --");
		EntityManager em = emf.createEntityManager();

		Customer customer = new Customer();
		customer.setName("Uttej");
		customer.setAddress("Hyd");

		em.getTransaction().begin();

		System.out.println("Before persisting");

		loadByEntity(em, customer);

		em.persist(customer);

		System.out.println("After persisting");

		loadByEntity(em, customer);
		
		em.getTransaction().commit();
		
		em.getTransaction().rollback();
		
		System.out.println("After rollback");
		
		loadByEntity(em, customer);
		
		
		em.close();
	}

	private static void loadByEntity(EntityManager em, Customer cust) {
		log(" load by customer id");
		System.out.println("Cust id " + cust.getId());
		System.out.println("Context contains " + em.contains(cust));

	}

	private static void printObject(Object obj) {
		System.out.println("Object: " + obj);
	}

	private static void runNativeQuery(String s, EntityManagerFactory emf) {

		EntityManager entityManager = emf.createEntityManager();
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

	private static void log(String s) {
		System.out.printf("-------------- %n %s %n", s);
	}
}
package UniqueConstraintsColumnViolation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.Arrays;
import java.util.List;

public class UniqueBoot {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
		try {
			persistCustomerEntity(emf);
			loadEntities(emf);
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

		Customer customer1 = new Customer();
		customer1.setName("Uttej");
		customer1.setAddress("Hyd");

		em.getTransaction().begin();
		em.persist(customer);
		em.persist(customer1);
		em.getTransaction().commit();
		em.close();
	}

	private static void loadEntities(EntityManagerFactory emf) {
		System.out.println("-- Loading Customer --");
		EntityManager em = emf.createEntityManager();
		
		List<Customer> customers = em.createQuery("Select t from Customer t").getResultList();
		customers.forEach(UniqueBoot::printObject);
	}

	private static void printObject(Object obj) {
		System.out.println("Object: " + obj);
	}

	private static void runNativeQuery(String s, EntityManagerFactory emf) {
		System.out.printf("-- %s --%n", s);
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
}
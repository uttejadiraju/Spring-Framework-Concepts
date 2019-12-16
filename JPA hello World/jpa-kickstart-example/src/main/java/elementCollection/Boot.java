package elementCollection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.Arrays;
import java.util.List;

public class Boot {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
		try {
			persistEntity(emf);
			runNativeQueries(emf);
			loadEntity(emf);
		} finally {
			emf.close();
		}
	}

	private static void persistEntity(EntityManagerFactory emf) {

		System.out.println("-- Persisting entities --");
		EntityManager em = emf.createEntityManager();

		Customer c1 = new Customer();
		c1.setName("Lindsey Craft");
		c1.setPhoneNumbers(Arrays.asList("111-111-1111", "222-222-222"));
		System.out.println(c1);

		Customer c2 = new Customer();
		c2.setName("Morgan Philips");
		c2.setPhoneNumbers(Arrays.asList("333-333-3333"));
		System.out.println(c2);

		em.getTransaction().begin();
		em.persist(c1);
		em.persist(c2);
		em.getTransaction().commit();
		em.close();
	}

	private static void runNativeQueries(EntityManagerFactory emf) {
		System.out.println("-- Native queries --");
		EntityManager em = emf.createEntityManager();
		nativeQuery(em, "Select * from Customer");
		nativeQuery(em, "Select * from Customer_PhoneNumbers");
	}

	private static void loadEntity(EntityManagerFactory emf) {
		System.out.println("-- Loading Customer --");
		EntityManager em = emf.createEntityManager();
		List<Customer> entityAList = em.createQuery("Select t from Customer t").getResultList();
		entityAList.forEach(System.out::println);
		em.close();
	}

	private static void nativeQuery(EntityManager em, String s) {
		System.out.printf("'%s'%n", s);
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

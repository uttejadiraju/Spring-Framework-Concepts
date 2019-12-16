package FlushTypeAuto;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.Arrays;
import java.util.List;

public class FlushAutoBoot {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
		try {
			persistCustomerEntity(emf);
		} finally {
			emf.close();
		}

	}

	private static void persistCustomerEntity(EntityManagerFactory emf) {
		System.out.println("-- Persisting Customer entity --");
		
		EntityManager em = emf.createEntityManager();
		em.setFlushMode(FlushModeType.AUTO);
		
		
		
		nativeQuery(em, "SHOW COLUMNS FROM Customer");
		
		
		Customer customer = new Customer();
		customer.setName("Maria Dorsey");
		customer.setAddress("1719 Shumaker Boulevard, Sylvania");
		
		

		Customer customer1 = new Customer();
		customer1.setName("Maria Dorsey");
		customer1.setAddress("1719 Shumaker Boulevard, Sylvania");

		log(" persist customer ");

		em.getTransaction().begin();

		
		em.persist(customer);
		em.persist(customer1);
		
		// Early error detection. Sync with database. Runs queries on database.
		em.flush();
		

		loadByEntity(em, customer);

		loadByEntity(em, customer1);
		
		

		em.getTransaction().commit();

		

		em.close();
	}

	private static void log(String s) {
		System.out.printf("-------------- %n %s \n", s);
		System.out.printf("-------------- %n");
	}

	private static void loadByEntity(EntityManager em, Customer cust) {
		log(" load by customer id");
		System.out.println("Cust id " + cust.getId());
		System.out.println("Context contains " + em.contains(cust));

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
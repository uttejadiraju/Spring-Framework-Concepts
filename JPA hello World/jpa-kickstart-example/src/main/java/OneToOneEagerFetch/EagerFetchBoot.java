package OneToOneEagerFetch;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EagerFetchBoot {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
		try {
			persistCustomerEntity(emf);
			loadEntities(emf);
		} finally {
			emf.close();
		}
	}

	private static void persistCustomerEntity(EntityManagerFactory emf) {
		System.out.println("-- Persisting Customer entity --");
		EntityManager em = emf.createEntityManager();

		Customer customer = new Customer();
		customer.setName("Maria Dorsey");
		customer.setAddress("1719 Shumaker Boulevard, Sylvania");
		OrderItem orderItem = new OrderItem();
		orderItem.setItemName("GEN SSD");
		orderItem.setQuantity(3);
		customer.setOrderItem(orderItem);

		em.getTransaction().begin();
		em.persist(orderItem);
		em.persist(customer);
		em.getTransaction().commit();
		em.close();
	}

	private static void loadEntities(EntityManagerFactory emf) {
		System.out.println("-- Loading Customer --");
		EntityManager em = emf.createEntityManager();
		List<Customer> customers = em.createQuery("Select t from Customer t").getResultList();
		customers.forEach(EagerFetchBoot::printObject);
		for (Customer customer : customers) {
			System.out.println("-- accessing customer#OrderItem --");
			OrderItem orderItem = customer.getOrderItem();
			printObject(orderItem);
		}
		em.close();
	}

	private static void printObject(Object obj) {
		System.out.println("Object: " + obj);
	}
}
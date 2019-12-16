package embeddedId;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Boot {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
		try {
			persistEntity(emf);
			runNativeQueries(emf);
			loadEntity(emf);
			loadByPersonInfo(23, "uttej", emf.createEntityManager());
			loadByPersonInfo(23, "vamshi", emf.createEntityManager());
		} finally {
			emf.close();
		}
	}

	private static void persistEntity(EntityManagerFactory emf) {
		System.out.println("-- Persisting entities --");
		EntityManager em = emf.createEntityManager();

		PersonInfo info1 = new PersonInfo("uttej", 23);
		PersonInfo info2 = new PersonInfo("vamshi", 24);

		Person p1 = new Person(info1);
		Person p2 = new Person(info2);

		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.getTransaction().commit();

		em.close();
	}

	private static void runNativeQueries(EntityManagerFactory emf) {
		System.out.println("-- native queries --");
		EntityManager em = emf.createEntityManager();
		nativeQuery(em, "SHOW COLUMNS from Person");
		nativeQuery(em, "Select * from Person");
	}

	private static void loadEntity(EntityManagerFactory emf) {
		System.out.println("-- Loading Parent --");
		EntityManager em = emf.createEntityManager();
		em.createQuery("Select t from Person t").getResultList().forEach(System.out::println);
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

	private static void loadByPersonInfo(int age, String name, EntityManager em) {
		System.out.println("---- Load by entity ----");
		PersonInfo info = new PersonInfo(name, age);
		Person person = em.find(Person.class, info);
		System.out.println(person);
	}
}

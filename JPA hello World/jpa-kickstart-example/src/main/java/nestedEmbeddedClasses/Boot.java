package nestedEmbeddedClasses;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.*;

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

		Parent Parent = new Parent();
		ClassA a = new ClassA();
		ClassB b = new ClassB();
		
		
		a.setMyInt(10);
		a.setMyStr("a test String");
		a.setClassBRef(b);
		
		
		Parent.setClassARef(a);
		
		
		

		System.out.println(Parent);

		em.getTransaction().begin();
		em.persist(Parent);
		em.getTransaction().commit();
		
		
		
		em.close();
	}

	private static void runNativeQueries(EntityManagerFactory emf) {
		System.out.println("-- native queries --");
		EntityManager em = emf.createEntityManager();
		nativeQuery(em, "SHOW COLUMNS from Parent");
		nativeQuery(em, "Select * from Parent");
	}

	private static void loadEntity(EntityManagerFactory emf) {
		System.out.println("-- Loading Parent --");
		EntityManager em = emf.createEntityManager();
		List<Parent> entityAList = em.createQuery("Select t from Parent t").getResultList();
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

package JoinTable;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;

public class Boot {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("example-unit");

	public static void main(String[] args) {

		try {
			EntityManager em = factory.createEntityManager();
			persistEntities(em);

			nativeQuery(em, "SELECT * FROM Parent");
			nativeQuery(em, "SELECT * FROM EntityB");
			
			nativeQuery(em, "SELECT * FROM MY_JOIN_TABLE");

			em.close();
		} finally {
			factory.close();
		}

	}

	private static void persistEntities(EntityManager em) {
		for (int i = 1; i <= 100; i++) {
			
			EntityB5 b = new EntityB5();
			b.setbValue("hurray!!!");
			
			
			EntityA5 a = new EntityA5();
			a.setEntityB(b);

			em.getTransaction().begin();

			em.persist(a);
			em.persist(b);

			em.getTransaction().commit();
		}

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

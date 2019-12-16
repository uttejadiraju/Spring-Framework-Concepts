package OneToManyForeignKey;

import java.util.Arrays;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;

import OneToMany.EntityA01;
import OneToMany.EntityA00;

public class OneToManyBoot {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("example-unit");

	public static void main(String[] args) {

		try {
			EntityManager em = factory.createEntityManager();
			persistEntities(em);

			

			nativeQuery(em, "SHOW COLUMNS FROM EntityA000");
			nativeQuery(em, "SHOW COLUMNS FROM EntityA011");
			
			loadEntityA(factory);
			loadEntityB(factory);

			em.close();
		} finally {
			factory.close();
		}

	}

	private static void persistEntities(EntityManager em) {

		
		
		
		EntityA000 a = new EntityA000();
		EntityA011 b = new EntityA011();
		EntityA011 b1 = new EntityA011();
		
		b.setbValue("hurray!!!");
		b1.setbValue("yahoo!!!");
		
		
		a.setEntityB(Arrays.asList(b, b1));
		

		
		
		em.getTransaction().begin();

		em.persist(a);
		
		
		em.persist(b);
		
		em.persist(b1);

		em.getTransaction().commit();
		

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

	private static void loadEntityA(EntityManagerFactory emf) {
		System.out.println("-- Loading Parent --");
		EntityManager em = emf.createEntityManager();
		List<EntityA000> entityAList = em.createQuery("Select t from EntityA000 t").getResultList();
		entityAList.forEach(System.out::println);
		em.close();
	}

	private static void loadEntityB(EntityManagerFactory emf) {
		System.out.println("-- Loading EntityB --");
		EntityManager em = emf.createEntityManager();
		List<EntityA011> entityBList = em.createQuery("Select t from EntityA011 t").getResultList();
		entityBList.forEach(System.out::println);
		em.close();
	}
}

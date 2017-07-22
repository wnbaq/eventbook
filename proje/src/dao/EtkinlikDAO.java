package dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.Etkinlik;
import bean.Kullanici;


public class EtkinlikDAO {


	private static void createEtkinlik(int id, String etkinlikIsmi, String baslangicZamani, String bitisZamani,
			String yasAraligi) {
		try {
			// 1. configuring hibernate
			Configuration configuration = new Configuration().configure();

			// 2. create sessionfactory
			SessionFactory sessionFactory = configuration.buildSessionFactory();

			// 3. Get Session object
			Session session = sessionFactory.openSession();

			// 4. Starting Transaction
			Transaction transaction = session.beginTransaction();
			Etkinlik etkinlik = new Etkinlik();
			etkinlik.setEid(id);
			etkinlik.setEtkinlikIsmi(etkinlikIsmi);
			etkinlik.setBaslangicZamani(baslangicZamani);
			etkinlik.setBitisZamani(bitisZamani);
			etkinlik.setYasAraligi(yasAraligi);
			session.save(etkinlik);
			transaction.commit();
		

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}

	}

//	private static void listEtkinlik() {
//		EntityManager em = emf.createEntityManager();
//
//		List<Etkinlik> etkinlikler = em.createQuery("select e from Etkinlik e", Etkinlik.class).getResultList();
//
//		for (Etkinlik e : etkinlikler) {
//			System.out.println(e.getEid() + "-" + e.getEtkinlikIsmi() + "-" + e.getBaslangicZamani() + "-"
//					+ e.getBitisZamani() + "-" + e.getYasAraligi());
//		}
//		em.close();
//	}
//
//	private static void modifyEtkinlik(int id, String etkinlikIsmi, String baslangicZamani, String bitisZamani,
//			String yasAraligi) {
//		// TODO: her bir field icin ayri ayri
//
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//
//		Etkinlik etkinlik = em.createQuery("select e from Etkinlik e where e.id = :eid", Etkinlik.class)
//				.setParameter("eid", "id").getSingleResult();
//		etkinlik.setEid(id);
//		etkinlik.setEtkinlikIsmi(etkinlikIsmi);
//		etkinlik.setBaslangicZamani(baslangicZamani);
//		etkinlik.setBitisZamani(bitisZamani);
//		etkinlik.setYasAraligi(yasAraligi);
//
//		em.persist(etkinlik);
//
//		em.getTransaction().commit();
//		em.close();
//
//	}

}

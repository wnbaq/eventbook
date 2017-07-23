package dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

import bean.Kullanici;

public class KullaniciDAO {

	public void addUserDetails(String userName, String surname, String password, String email) {
		try {
			// 1. configuring hibernate
			Configuration configuration = new Configuration().configure();

			// 2. create sessionfactory
			SessionFactory sessionFactory = configuration.buildSessionFactory();

			// 3. Get Session object
			Session session = sessionFactory.openSession();

			// 4. Starting Transaction
			Transaction transaction = session.beginTransaction();

			Kullanici user = new Kullanici();
			int id = getLastIndex() + 1;
			user.setid(id);
			user.setname(userName);
			user.setsurname(surname);
			user.setpassword(password);
			user.setEmail(email);
			session.save(user);
			transaction.commit();
			System.out.println("\n\n Details Added \n");

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}

	}

	private static int getLastIndex() {
		// 1. configuring hibernate
		Configuration configuration = new Configuration().configure();

		// 2. create sessionfactory
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		// 3. Get Session object
		Session session = sessionFactory.openSession();

		// 4. Starting Transaction
		Transaction transaction = session.beginTransaction();

		List<Kullanici> kullanicilar = session.createQuery("select k from Kullanici k", Kullanici.class)
				.getResultList();
		if (kullanicilar.isEmpty())
			return -1;
		else
			return kullanicilar.get(kullanicilar.size() - 1).getid();
	}

}

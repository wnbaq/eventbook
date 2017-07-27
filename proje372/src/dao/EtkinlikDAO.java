package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	public void createEtkinlik(Etkinlik e) {
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
			int id = getLastIndex() + 1;
			etkinlik.setid(id);
			etkinlik.setEtkinlikIsmi(e.getEtkinlikIsmi());
			etkinlik.setBaslangicZamani(e.getBaslangicZamani());
			etkinlik.setBitisZamani(e.getBitisZamani());
			etkinlik.setYasAraligi(e.getYasAraligi());
			etkinlik.setEmail(e.getEmail());
			etkinlik.setType(e.getType());
			session.save(etkinlik);
			transaction.commit();
		

		} catch (HibernateException es) {
			System.out.println(es.getMessage());
			System.out.println("error");
		}}

	private static int getLastIndex() {
		// 1. configuring hibernate
		Configuration configuration = new Configuration().configure();

		// 2. create sessionfactory
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		// 3. Get Session object
		Session session = sessionFactory.openSession();

		// 4. Starting Transaction
		Transaction transaction = session.beginTransaction();

		List<Etkinlik> etkinlikler = session.createQuery("select k from Etkinlik k", Etkinlik.class).getResultList();
		if (etkinlikler.isEmpty())
			return -1;
		else
			return etkinlikler.get(etkinlikler.size() - 1).getid();
	}

	public List<Etkinlik> listEtkinlik() {
		List<Etkinlik> list = new ArrayList<Etkinlik>();
		try {
			Connection con = getCon();
			PreparedStatement ps = con.prepareStatement("select * from etkinlik");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Etkinlik b = new Etkinlik();
				b.setid(rs.getInt(1));
				b.setEtkinlikIsmi(rs.getString(2));
				b.setBaslangicZamani(rs.getTimestamp(3));
				b.setBitisZamani(rs.getTimestamp(4));
				b.setYasAraligi(rs.getString(5));
				b.setType(rs.getString(6));
				list.add(b);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public static List<Etkinlik> getRecordsByType(String type) {
		List<Etkinlik> list = new ArrayList<Etkinlik>();
		try {
			Connection con = getCon();
			PreparedStatement ps = con.prepareStatement("select * from etkinlik where tur='" + type +"'");
			//ps.setString(1, type);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Etkinlik b = new Etkinlik();
				b.setid(rs.getInt(1));
				b.setEtkinlikIsmi(rs.getString(2));
				b.setBaslangicZamani(rs.getTimestamp(3));
				b.setBitisZamani(rs.getTimestamp(4));
				b.setYasAraligi(rs.getString(5));
				b.setType(rs.getString(6));
				list.add(b);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = getCon();
			PreparedStatement ps = con.prepareStatement("delete from etkinlik where e_id="+id);
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	// private static void modifyEtkinlik(int id, String etkinlikIsmi, Date
	// baslangicZamani, Date bitisZamani,
	// String yasAraligi) {
	// // TODO: her bir field icin ayri ayri
	//
	// EntityManager em = emf.createEntityManager();
	// em.getTransaction().begin();
	//
	// Etkinlik etkinlik = em.createQuery("select e from Etkinlik e where e.id =
	// :eid", Etkinlik.class)
	// .setParameter("eid", "id").getSingleResult();
	// etkinlik.setid(id);
	// etkinlik.setEtkinlikIsmi(etkinlikIsmi);
	// etkinlik.setBaslangicZamani(baslangicZamani);
	// etkinlik.setBitisZamani(bitisZamani);
	// etkinlik.setYasAraligi(yasAraligi);
	//
	// em.persist(etkinlik);
	//
	// em.getTransaction().commit();
	// em.close();
	//
	// }
	public static Connection getCon() {
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost/devdb", "postgres", "gbb199494");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}

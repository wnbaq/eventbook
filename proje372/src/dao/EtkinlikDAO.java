package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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


	public  void createEtkinlik(String etkinlikIsmi, Date baslangicZamani, Date bitisZamani,
			String yasAraligi, String email, String tur) {
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
			etkinlik.setEtkinlikIsmi(etkinlikIsmi);
			etkinlik.setBaslangicZamani(baslangicZamani);
			etkinlik.setBitisZamani(bitisZamani);
			etkinlik.setYasAraligi(yasAraligi);
			etkinlik.setEmail(email);
			etkinlik.setType(tur);
			session.save(etkinlik);
			transaction.commit();
		

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

		List<Etkinlik> etkinlikler = session.createQuery("select k from Etkinlik k", Etkinlik.class)
				.getResultList();
		if (etkinlikler.isEmpty())
			return -1;
		else
			return etkinlikler.get(etkinlikler.size() - 1).getid();
	}

	public  List<Etkinlik> listEtkinlik() {
		List<Etkinlik> list=new ArrayList<Etkinlik>();
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("select * from etkinlik");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Etkinlik b=new Etkinlik();
				b.setid(rs.getInt(1));
				b.setBaslangicZamani(rs.getDate(2));
				b.setBitisZamani(rs.getDate(3));
				b.setEmail(rs.getString(4));
				b.setEtkinlikIsmi(rs.getString(5));
				b.setType(rs.getString(6));
				list.add(b);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	public static List<Etkinlik> getRecordsByType(String type){
		List<Etkinlik> list=new ArrayList<Etkinlik>();
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("select * from etkinlik where type=? ");
			ps.setString(1,type);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Etkinlik b=new Etkinlik();
				b.setid(rs.getInt(1));
				b.setBaslangicZamani(rs.getDate(2));
				b.setBitisZamani(rs.getDate(3));
				b.setEmail(rs.getString(4));
				b.setEtkinlikIsmi(rs.getString(5));
				b.setType(rs.getString(6));
				list.add(b);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("delete from etkinlik where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
//	private static void modifyEtkinlik(int id, String etkinlikIsmi, Date baslangicZamani, Date bitisZamani,
//			String yasAraligi) {
//		// TODO: her bir field icin ayri ayri
//
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//
//		Etkinlik etkinlik = em.createQuery("select e from Etkinlik e where e.id = :eid", Etkinlik.class)
//				.setParameter("eid", "id").getSingleResult();
//		etkinlik.setid(id);
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
	public static Connection getCon(){
		Connection con=null;
		try{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://localhost/devdb","postgres","gbb199494");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
}

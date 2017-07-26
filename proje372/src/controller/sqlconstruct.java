package controller;

import java.sql.*;

public class sqlconstruct {

	public static void main(String[] args) throws SQLException {

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC jar'ini kontrol et!");
		}

		
		
		Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/devdb", "postgres", "gbb199494");
		Statement st = c.createStatement();
		String make1="CREATE TABLE IF NOT EXISTS kullanici(id SERIAL NOT NULL PRIMARY KEY,isim varchar(50) NOT NULL,soyisim varchar(50) NOT NULL,parola varchar(50) NOT NULL,email varchar(50) NOT NULL)";
		String make2="CREATE TABLE IF NOT EXISTS uye(id int REFERENCES kullanici(id),isim varchar(50) NOT NULL,soyisim varchar(50) NOT NULL,parola varchar(50) NOT NULL,email varchar(50) NOT NULL)";
		String make3="CREATE TABLE IF NOT EXISTS yonetici(id int REFERENCES kullanici(id),isim varchar(50) NOT NULL,soyisim varchar(50) NOT NULL,parola varchar(50) NOT NULL,email varchar(50) NOT NULL)";
		String make4="CREATE TABLE IF NOT EXISTS mekan(m_id SERIAL NOT NULL PRIMARY KEY,mekan_ismi varchar(50) NOT NULL,mekan_sahibi varchar(50) NOT NULL,il varchar(50) NOT NULL,ilce varchar(50) NOT NULL,kapasite varchar(50) NOT NULL,telefon varchar(50) NOT NULL)";
		String make5="CREATE TABLE IF NOT EXISTS "
				+ "etkinlik(e_id SERIAL NOT NULL PRIMARY KEY,"
				+ "etkinlik_ismi varchar(100) NOT NULL,"
				+ "baslangic_zamani varchar(100) ,"
				+ "bitis_zamani varchar(100) ,"
				+ "yas_araligi varchar(50) ,tur varchar(50) NOT NULL)";
		
		
		String make6="CREATE TABLE IF NOT EXISTS networking(e_id int REFERENCES etkinlik(e_id),baslangic_zamani date NOT NULL,bitis_zamani date NOT NULL,yas_araligi varchar(50) NOT NULL,m_id int REFERENCES mekan(m_id))";
		String make7="CREATE TABLE IF NOT EXISTS egitim(e_id int REFERENCES etkinlik(e_id),baslangic_zamani date NOT NULL,bitis_zamani date NOT NULL,yas_araligi varchar(50) NOT NULL,m_id int REFERENCES mekan(m_id))";
		String make8="CREATE TABLE IF NOT EXISTS muzik(e_id int REFERENCES etkinlik(e_id),baslangic_zamani date NOT NULL,bitis_zamani date NOT NULL,yas_araligi varchar(50) NOT NULL,m_id int REFERENCES mekan(m_id))";
		String make9="CREATE TABLE IF NOT EXISTS spor(e_id int REFERENCES etkinlik(e_id),baslangic_zamani date NOT NULL,bitis_zamani date NOT NULL,yas_araligi varchar(50) NOT NULL,m_id int REFERENCES mekan(m_id))";
		String make10="CREATE TABLE IF NOT EXISTS yemek(e_id int REFERENCES etkinlik(e_id),baslangic_zamani date NOT NULL,bitis_zamani date NOT NULL,yas_araligi varchar(50) NOT NULL,m_id int REFERENCES mekan(m_id))";
		String make11="CREATE TABLE IF NOT EXISTS sanat(e_id int REFERENCES etkinlik(e_id),baslangic_zamani date NOT NULL,bitis_zamani date NOT NULL,yas_araligi varchar(50) NOT NULL,m_id int REFERENCES mekan(m_id))";
		String make12="CREATE TABLE IF NOT EXISTS parti(e_id int REFERENCES etkinlik(e_id),baslangic_zamani date NOT NULL,bitis_zamani date NOT NULL,yas_araligi varchar(50) NOT NULL,m_id int REFERENCES mekan(m_id))";
		
		
		String make13="CREATE TABLE IF NOT EXISTS misafirListesi(id int REFERENCES etkinlik(e_id),kapasite varchar(50) NOT NULL,e_id int REFERENCES etkinlik(e_id))";
		String make14="CREATE TABLE IF NOT EXISTS program(id int REFERENCES kullanici(id))";
		
		st.executeUpdate(make1);
		st.executeUpdate(make2);
		st.executeUpdate(make3);
		st.executeUpdate(make4);
		st.executeUpdate(make5);
		st.executeUpdate(make6);
		st.executeUpdate(make7);
		st.executeUpdate(make8);
		st.executeUpdate(make9);
		st.executeUpdate(make10);
		st.executeUpdate(make11);
		st.executeUpdate(make12);
		st.executeUpdate(make13);
		st.executeUpdate(make14);
		
		System.out.println("basarili bir sekilde olusmustur");
		st.close();
		c.close();
		
	}
}
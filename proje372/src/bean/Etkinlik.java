package bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class Etkinlik {
	private int id;
	private Date baslangicZamani;
	private Date bitisZamani;
	private String yasAraligi;
	public String email;
	private Set<Mekan> mekanlar;
	private String etkinlikIsmi;
	private String type;

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public Date getBaslangicZamani() {
		return baslangicZamani;
	}

	public void setBaslangicZamani(Date baslangicZamani2) {
		this.baslangicZamani = baslangicZamani2;
	}

	public Date getBitisZamani() {
		return bitisZamani;
	}

	public void setBitisZamani(Date bitisZamani) {
		this.bitisZamani = bitisZamani;
	}

	public String getYasAraligi() {
		return yasAraligi;
	}

	public void setYasAraligi(String yasAraligi) {
		this.yasAraligi = yasAraligi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEtkinlikIsmi() {
		return etkinlikIsmi;
	}

	public void setEtkinlikIsmi(String etkinlikIsmi) {
		this.etkinlikIsmi = etkinlikIsmi;
	}

	public Set<Mekan> getMekanlar() {
		return mekanlar;
	}

	public void setMekanlar(Set<Mekan> mekanlar) {
		this.mekanlar = mekanlar;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



}

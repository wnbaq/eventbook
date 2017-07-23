package bean;

import java.util.Date;
import java.util.Set;

public class Etkinlik {
	private int id;
	private Date baslangicZamani;
	private Date bitisZamani;
	private String yasAraligi;
	private String email;
	private Set<Mekan> mekanlar;
	private String etkinlikIsmi;

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public Date getBaslangicZamani() {
		return baslangicZamani;
	}

	public void setBaslangicZamani(Date baslangicZamani) {
		this.baslangicZamani = baslangicZamani;
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

}

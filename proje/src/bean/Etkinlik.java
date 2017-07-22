package bean;

import java.util.Set;

public class Etkinlik {
	private int eid;
	private String baslangicZamani;
	private String bitisZamani;
	private String yasAraligi;
	private String email;
	private Set<Mekan> mekanlar;
	private String etkinlikIsmi;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getBaslangicZamani() {
		return baslangicZamani;
	}

	public void setBaslangicZamani(String baslangicZamani) {
		this.baslangicZamani = baslangicZamani;
	}

	public String getBitisZamani() {
		return bitisZamani;
	}

	public void setBitisZamani(String bitisZamani) {
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

package bean;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "spor")
public class Spor extends Etkinlik {
	private Date baslangicZamani;
	private Date bitisZamani;
	private String yasAraligi;
	private String email;

	@Column
	public Date getBaslangicZamani() {
		return baslangicZamani;
	}

	public void setBaslangicZamani(Date baslangicZamani) {
		this.baslangicZamani = baslangicZamani;
	}

	@Column
	public Date getBitisZamani() {
		return bitisZamani;
	}

	public void setBitisZamani(Date bitisZamani) {
		this.bitisZamani = bitisZamani;
	}

	@Column
	public String getYasAraligi() {
		return yasAraligi;
	}

	public void setYasAraligi(String yasAraligi) {
		this.yasAraligi = yasAraligi;
	}

	@Column
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

package bean;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "yonetici")
public class Yonetici extends Kullanici {

	private int id;
	private String name;
	private String surname;
	private String password;
	private String email;
	private Set<MisafirListesi> misafir_listesi;


	@Column
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column
	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	@Column
	public String getsurname() {
		return surname;
	}

	public void setsurname(String surname) {
		this.surname = surname;
	}

	@Column
	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Yonetici [id=" + id + ", name=" + name + ", surname=" + surname + ", password=" + password + "]";
	}

	@Column
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@ManyToMany
	@JoinTable(name="yonetici_misafir_listesi",joinColumns={@JoinColumn(name="yoneticiId")},
	inverseJoinColumns={@JoinColumn(name="misafir_listesiId")})	
	public Set<MisafirListesi> getMisafir_listesi() {
		return misafir_listesi;
	}

	public void setMisafir_listesi(Set<MisafirListesi> misafir_listesi) {
		this.misafir_listesi = misafir_listesi;
	}
	
	
}
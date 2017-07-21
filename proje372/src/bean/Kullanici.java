package bean;

import javax.persistence.*;

@Entity
@Table(name = "kullanici")
public class Kullanici {

	private int id;
	private String name;
	private String surname;
	private String password;
	private String email;

	public Kullanici(int id, String name, String surname, String password) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.password = password;
	}

	public Kullanici() {
		super();
	}

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getsurname() {
		return surname;
	}

	public void setsurname(String surname) {
		this.surname = surname;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Kullanici [id=" + id + ", name=" + name + ", surname=" + surname + ", password=" + password + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
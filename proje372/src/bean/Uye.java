package bean;

import javax.persistence.*;

@Entity
@Table(name = "uye")
public class Uye extends Kullanici {

	private int id;
	private String uname;
	private String username;
	private String password;
	private String email;
	private Program program;
	private MisafirListesi misafir_listesi;


	@Column
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public void setUsurname(String username) {
		this.username = username;
	}

	@Column
	public String getUsername() {
		return username;
	}

	public void setUpassword(String password) {
		this.password = password;
	}

	@Column
	public String getUpassword() {
		return password;
	}

	@Column
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "uye", cascade = CascadeType.ALL)
	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}
	
	@ManyToOne
	@JoinColumn(name="misafir_listesiId")
	public MisafirListesi getMisafirlistesi() {
		return misafir_listesi;
	}

	public void setMisafirlistesi(MisafirListesi misafir_listesi) {
		this.misafir_listesi = misafir_listesi;
	}
	
}

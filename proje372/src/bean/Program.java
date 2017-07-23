package bean;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "program")
public class Program {

	private int pid;
	private Uye uye;
	private Set<Etkinlik> etkinlik;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Uye getUye() {
		return uye;
	}

	public void setUye(Uye uye) {
		this.uye = uye;
	}
	
	@ManyToMany
	@JoinTable(name="program_etkinlik",joinColumns={@JoinColumn(name="programId")},
	inverseJoinColumns={@JoinColumn(name="etkinlikId")})	
	public Set<Etkinlik> getEtkinlik() {
		return etkinlik;
	}

	public void setEtkinlik(Set<Etkinlik> etkinlik) {
		this.etkinlik = etkinlik;
	}
	
	
}

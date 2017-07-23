package bean;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "misafir_listesi")
public class MisafirListesi {
	private int id;
	private int kapasite;
	private Etkinlik etkinlik;
	private Set<Uye> uyeler;
	private Set<Yonetici> yoneticiler;


	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column
	public int getKapasite() {
		return kapasite;
	}

	public void setKapasite(int kapasite) {
		this.kapasite = kapasite;
	}

	public MisafirListesi() {
		// TODO Auto-generated constructor stub

	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Etkinlik getEtkinlik() {
		return etkinlik;
	}

	public void setEtkinlik(Etkinlik etkinlik) {
		this.etkinlik = etkinlik;
	}
	
	@OneToMany(mappedBy = "misafir_listesi", fetch = FetchType.EAGER)
	public Set<Uye> getUyeler() {
		return uyeler;
	}

	public void setUyeler(Set<Uye> uyeler) {
		this.uyeler = uyeler;
	}
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="yonetici_misafir_listesi",joinColumns={@JoinColumn(name="misafir_listesiId")},inverseJoinColumns={@JoinColumn(name="yoneticiId")})	
	public Set<Yonetici> getYoneticiler() {
		return yoneticiler;
	}

	public void setYoneticiler(Set<Yonetici> yoneticiler) {
		this.yoneticiler = yoneticiler;
	}
}

package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "novcanik")
public class Novcanik {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="datum_upisa")
	private LocalDateTime createDate ;
	
	private String naziv_Novcanika;
	
	@Enumerated(EnumType.STRING)
	private Tip tip;

	@OneToMany(mappedBy="novcanikObj",fetch=FetchType.EAGER)
	private List<Trosak> troskovi = new ArrayList<Trosak>();
	
	private String user;
	
	
	public Novcanik() {
		LocalDateTime localDate = LocalDateTime.now();
		this.createDate = localDate;
	}
	
	public enum Tip{
		KriptoWallet("Novcanikkriptovaluta"),
		Cloudnovcanik("Cloudnovcanik"),
		PersonalWallet("Osobninovcanik"),
		BusinessWallet("Poslovninovcanik");
		
		
		private String tip;
		
		private Tip(String tip) {
			this.tip=tip;
		}
		
		public String getTip() {
			return this.tip;
		}
		
	}
	
	public String getUser() {
		return this.user;
	}
	
	public void setUser(String user) {
		this.user=user;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}
	
	public LocalDateTime getCreateDate() {
		return this.createDate;
	}
	
	public void setCreateDate(LocalDateTime date) {
		this.createDate=date;
	}
	
	public Tip getTip() {
		return this.tip;
	}
	
	public void setTip(Tip tip) {
		this.tip = tip;
	}
	
	public String getNazivNovcanika() {
		return this.naziv_Novcanika;
	}
	
	public void setNazivNovcanika(String nazivNovcanika) {
		this.naziv_Novcanika=nazivNovcanika;
	}
	
	public List<Trosak> getTrosakFromNovcanik(){
		return this.troskovi;
	}
	
}

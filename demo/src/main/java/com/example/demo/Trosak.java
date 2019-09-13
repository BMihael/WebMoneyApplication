package com.example.demo;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "trosak")
public class Trosak {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="datum_Upisa")
	private LocalDateTime createDate ;
	
	
	@NotEmpty(message="#{msg.validation.enterData}")
	@Size(min = 2, max = 55, message="#{msg.validation.sizeOfData}")
	private String naziv;

	@NotNull(message="#{msg.validation.enterAmount}")
	private Double iznos;
	
	@Enumerated(EnumType.STRING)
	private Vrsta vrsta;
	
	/*
	@Column(name="id_novcanik")
	private Long novcanik;
	*/
	
	/*Tu mozda bude greksa oko ovoga*/
	
	//,cascade = CascadeType.REFRESH, ako ide REMOVE ili ALL onda brise parent entity (novcanik) u bazi
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_novcanik")
	private Novcanik novcanikObj;
	
	public Trosak() {
		LocalDateTime localDate = LocalDateTime.now();
		this.createDate = localDate;
	}
	
	public enum Vrsta{
		Rezije("Režije"),
		Hrana("Hrana"),
		Pice("Piće"),
		Internet("Internet");
		
		private String vrsta;
		
		private Vrsta(String vrsta) {
			this.vrsta=vrsta;
		}
		
		public String getVrsta() {
			return this.vrsta;
		}
	}
	
	/*
	@JsonIgnore
	public Novcanik getNovcanikObj() {
		return this.novcanikObj;
	}
	
	
	public void setNovcanikObj(Novcanik novcanikObj) {
		this.novcanikObj =novcanikObj; 
	}
	*/
	/*
	public Long getNovcanik() {
		return this.novcanik;
	}
	*/
	/*
	public void setNovcanik(Long novcanik) {
		this.novcanik=novcanik;
	}
	*/
	
	///@JsonIgnore
	public Novcanik getNovcanik() {
		return this.novcanikObj;
	}
	
	public void setNovcanik(Novcanik novcanik) {
		this.novcanikObj=novcanik;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long  id) {
		this.id=id;
	}
	
	public LocalDateTime getCreateDate() {
		return this.createDate;
	}
	
	public void setCreateDate(LocalDateTime date) {
		this.createDate=date;
	}
	
	public String getNaziv() {
		return this.naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv=naziv;
	}
	
	public Double getIznos() {
		return this.iznos;
	}
	
	public void setIznos(Double iznos) {
		this.iznos=iznos;
	}
	
	public Vrsta getVrsta() {
		return this.vrsta;
	}
	
	public void setVrsta(Vrsta vrsta) {
		this.vrsta = vrsta;
	}
	
}

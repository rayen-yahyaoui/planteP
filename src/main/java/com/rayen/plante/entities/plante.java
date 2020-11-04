package com.rayen.plante.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class plante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPlante;
	private String nomPlante;
	private String couleurPlante ;
	private Double prix;
	private Date dateVente;
	
	@ManyToOne
	private Type type ;
	
	public plante() {
	super();
	}
	public plante(String nomPlante,String couleurPlante , Double prix, Date dateVente) {
	super();
	this.nomPlante = nomPlante;
	this.prix = prix;
	this.couleurPlante = couleurPlante;
	this.dateVente = dateVente;
	}
	public Long getIdPlante() {
		return idPlante;
		}
		public void setIdPlante(Long idPlante) {
		this.idPlante = idPlante;
		}
		public String getNomPlante() {
		return nomPlante;
		}
		public void setNomPlante(String nomPlante) {
		this.nomPlante = nomPlante;
		}
		public String getcouleurPlante() {
		return couleurPlante;
		}
		public void setcouleurPlante(String couleurPlante) {
		this.couleurPlante = couleurPlante;
		}
		public Double getPrix() {
		return prix;
		}
		public void setPrix(Double prix) {
		this.prix = prix;
		}
		public Date getDateVente() {
		return dateVente;
		}
		public void setDateVente(Date dateVente) {
		this.dateVente = dateVente;
		}
		@Override
		public String toString() {
			return "plante [idPlante=" + idPlante + ", nomPlante=" + nomPlante + ", couleurPlante=" + couleurPlante
					+ ", prix=" + prix + ", dateVente=" + dateVente + "]";
		}
		public Type getType() {
			return type;
		}
		public void setType(Type type) {
			this.type = type;
		}
		
	
}

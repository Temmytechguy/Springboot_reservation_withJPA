package com.doranco.flash.ReservationJPA;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




/**
 * @author Temidayo Folorunsho
 *
 */

@Entity
public class Hotel {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	private String nom;
	private double nuite;
	private int nbNuits;
	
	public Hotel() {
		
	}
	
	public Hotel(String nom, double nuite, int nbNuits) {
		super();
		this.nom = nom;
		this.nuite = nuite;
		this.nbNuits = nbNuits;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
	/**
	 * @return nuite
	 */
	public double getNuite() {
		return nuite;
	}

	
	/**
	 * @param nuite
	 */
	public void setNuite(double nuite) {
		this.nuite = nuite;
	}

	/**
	 * @return nbNuits
	 */
	public int getNbNuits() {
		return nbNuits;
	}

	public void setNbNuits(int nbNuits) {
		this.nbNuits = nbNuits;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", nom=" + nom + ", nuite=" + nuite + ", nbNuits=" + nbNuits + "]";
	}

	
	
}

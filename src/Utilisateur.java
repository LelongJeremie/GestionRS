

import java.util.Scanner;

public class Utilisateur {
	
	protected String nom;
	protected String prenom;
	protected String mail;
	protected String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	protected String id;
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Utilisateur [nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", password=" + password + ", id="
				+ id + "]";
	}
	
//Liste des getters

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getId() {
		return id;
	}

//Liste des setters 
	

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	

public Utilisateur() {
		
	
		//this.hydrate(donnees);
		/*
		//user.ville();
		this.setadresse();
		this.getpersonne(tableau);
		//user.getpersonne(tableau1);
		//System.out.println("Le nombre est "+ nombre*ombre);
		*/
	}

}

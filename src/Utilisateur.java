

import java.util.Scanner;

public class Utilisateur {
	
	private String nom;
	private String prenom;

	private String id;
	
	@Override
	public String toString() {
		return "Utilisateur [nom=" + nom + ", prenom=" + prenom + ", id=" + id + "]";
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
		//System.out.println("Le nombre est "+ nombre*nombre);
		*/
	}

}

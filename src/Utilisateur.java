

import java.util.Scanner;

public class Utilisateur {
	
	protected String nom;
	protected String prenom;
	protected String mail;
	protected String password;
	protected String id;
	protected String role;
	protected String pseudo;
	protected String date_naissance;
	protected String connecternom;
	protected String connecterprenom;
	protected String connectermail;
	protected String connecterpassword;
	protected String connecterid;
	protected String connecterrole;
	protected String connecterpseudo;
	protected String connecterdate_naissance;

	public String getConnecternom() {
		return connecternom;
	}

	public void setConnecternom(String connecternom) {
		this.connecternom = connecternom;
	}

	public String getConnecterprenom() {
		return connecterprenom;
	}

	public void setConnecterprenom(String connecterprenom) {
		this.connecterprenom = connecterprenom;
	}

	public String getConnectermail() {
		return connectermail;
	}

	public void setConnectermail(String connectermail) {
		this.connectermail = connectermail;
	}

	public String getConnecterpassword() {
		return connecterpassword;
	}

	public void setConnecterpassword(String connecterpassword) {
		this.connecterpassword = connecterpassword;
	}

	public String getConnecterid() {
		return connecterid;
	}

	public void setConnecterid(String connecterid) {
		this.connecterid = connecterid;
	}

	public String getConnecterrole() {
		return connecterrole;
	}

	public void setConnecterrole(String connecterrole) {
		this.connecterrole = connecterrole;
	}

	public String getConnecterpseudo() {
		return connecterpseudo;
	}

	public void setConnecterpseudo(String connecterpseudo) {
		this.connecterpseudo = connecterpseudo;
	}

	public String getConnecterdate_naissance() {
		return connecterdate_naissance;
	}

	public void setConnecterdate_naissance(String connecterdate_naissance) {
		this.connecterdate_naissance = connecterdate_naissance;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
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

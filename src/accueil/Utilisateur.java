package accueil;


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
	protected String Token;
	protected String popup;
	protected String idmodif;
	
	protected String nommodif;
	protected String prenommodif;
	protected String mailmodif;
	protected String passwordmodif;
	
	
	public String getNommodif() {
		return nommodif;
	}

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}

	public void setNommodif(String nommodif) {
		this.nommodif = nommodif;
	}

	public String getPrenommodif() {
		return prenommodif;
	}

	public void setPrenommodif(String prenommodif) {
		this.prenommodif = prenommodif;
	}

	public String getMailmodif() {
		return mailmodif;
	}

	public void setMailmodif(String mailmodif) {
		this.mailmodif = mailmodif;
	}

	public String getPasswordmodif() {
		return passwordmodif;
	}

	public void setPasswordmodif(String passwordmodif) {
		this.passwordmodif = passwordmodif;
	}

	public String getRolemodif() {
		return rolemodif;
	}

	public void setRolemodif(String rolemodif) {
		this.rolemodif = rolemodif;
	}

	public String getPseudomodif() {
		return pseudomodif;
	}

	public void setPseudomodif(String pseudomodif) {
		this.pseudomodif = pseudomodif;
	}

	public String getDate_naissancemodif() {
		return date_naissancemodif;
	}

	public void setDate_naissancemodif(String date_naissancemodif) {
		this.date_naissancemodif = date_naissancemodif;
	}


	protected String rolemodif;
	protected String pseudomodif;
	protected String date_naissancemodif;



	public String getIdmodif() {
		return idmodif;
	}

	public void setIdmodif(String idmodif) {
		this.idmodif = idmodif;
	}

	public String getPopup() {
		return popup;
	}

	public void setPopup(String popup) {
		this.popup = popup;
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
				+ id + ", role=" + role + ", pseudo=" + pseudo + ", date_naissance=" + date_naissance + ", popup="
				+ popup + ", idmodif=" + idmodif + ", nommodif=" + nommodif + ", prenommodif=" + prenommodif
				+ ", mailmodif=" + mailmodif + ", passwordmodif=" + passwordmodif + ", rolemodif=" + rolemodif
				+ ", pseudomodif=" + pseudomodif + ", date_naissancemodif=" + date_naissancemodif + "]";
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
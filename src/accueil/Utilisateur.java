package accueil;


import java.util.Scanner;

public class Utilisateur {

	protected String nom;
	protected String prenom;
	protected String mail;
	protected String password;
	protected String id;
	protected String role;
	protected String idclasse;
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
	protected String classemodif;
	public String getValidationmodif() {
		return validationmodif;
	}

	public void setValidationmodif(String validationmodif) {
		this.validationmodif = validationmodif;
	}


	protected String validation;
	protected String validationmodif;
	public String getValidation() {
		return validation;
	}

	public void setValidation(String validation) {
		this.validation = validation;
	}

	public String getClassemodif() {
		return classemodif;
	}

	public void setClassemodif(String classemodif) {
		this.classemodif = classemodif;
	}


	protected String nommodif;
	protected String prenommodif;
	protected String mailmodif;
	protected String passwordmodif;
	protected String classe;

	public Utilisateur(String mail,String password) {
		this.mail = mail;
		this.password = password;
	}


	public String getIdclasse() {
		return idclasse;
	}

	public void setIdclasse(String idclasse) {
		this.idclasse = idclasse;
	}

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

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

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
		return "Nom : " + nommodif + " || Prenom : " + prenommodif + " || Mail : "
				+ mailmodif + " || Classe : " + classemodif + " || Role : " + rolemodif
				+ " || Pseudo : " + pseudomodif + " || date de naissance : " + date_naissancemodif + " || validation :"+validationmodif;
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

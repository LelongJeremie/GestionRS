package vueprofprincipal;

public class Sanction {
	
	
	protected String nom;
	protected String prenom;
	protected String mail;
	protected String id;
	protected String ars;
	protected String commentaire;
	protected String duree;
	protected String date;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		
		if(duree !=  null) {
		return " Description de la sanction : " + commentaire + ", \n duree de la sanction : " + duree + " Date de la sanction : "+date;
		}
		else {
		return " Description de la sanction : " + commentaire;
		}
	
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getArs() {
		return ars;
	}
	public void setArs(String ars) {
		this.ars = ars;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}
	
	

}

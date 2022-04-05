package vueprofprincipal;

public class Disponibilite {
	
	
	protected String nom;
	protected String prenom;
	protected String mail;
	protected String id;
	protected String date;
	protected String disponible;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDisponible() {
		return disponible;
	}
	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}
	@Override
	public String toString() {
		return "nom : " + nom + " || prenom=" + prenom + " || date=" + date
				+ " || disponible=" + disponible;
	}
	
	
	

}

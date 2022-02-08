

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class manager extends Utilisateur {

	Bdd co = new Bdd();

	private Connection cnx = co.connexion();
	Utilisateur user = new Utilisateur();


	public String connexion (Utilisateur user) {
		id="";
		
		System.out.println(user.getMail());
		
		try {
        	// Pr�paration de la requ�te
			java.sql.Statement stm = cnx.createStatement();

			
			ResultSet resultat = stm.executeQuery("SELECT * FROM utilisateur where mail='" + user.getMail() +"' AND password='" + user.getPassword() +"'");

			while(resultat.next()) {
				user.setId(resultat.getString("id"));
				user.setNom(resultat.getString("Nom"));
				user.setPrenom(resultat.getString("Prenom"));
				user.setRole(resultat.getString("role"));
				
				System.out.println("Vous etes connect�, bonjour "+user.getNom()+"");
				
				String prole = user.getRole();
				
				
				return prole;
				
				
			}
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return id;
		}

	public String inscription (Utilisateur user) {
		try {
        	// Pr�paration de la requ�te
			java.sql.Statement stm = cnx.createStatement();


			ResultSet resultat = stm.executeQuery("SELECT * FROM utilisateur where nom='" + user.getNom() +"' AND prenom='" + user.getPrenom() +"'");

			while(resultat.next()) {
				user.setId(this.id = resultat.getString("id"));
				System.out.println("Erreur votre utilisateur est d�j� existant");
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(user.getId() == null) {
		try {
		System.out.println(user);
		java.sql.Statement stm = cnx.createStatement();
		int insert = stm.executeUpdate("INSERT INTO utilisateur(nom,prenom,date_naissance, role, mail, username, password, validation) VALUES ('" + user.getNom() +"','" + user.getPrenom() +"','" + user.getDate_naissance() +"','" + user.getRole() +"', '" + user.getMail() + "','" + user.getPseudo() + "','" + user.getPassword() + "','" + "0" + "')");
		System.out.println("Utilisateur ajout�");
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		String result = "gg";
		return result;
	}
	public void modification (Utilisateur user, String nnom, String nprenom) {
		try {
			java.sql.Statement stm = cnx.createStatement();


			ResultSet resultat = stm.executeQuery("SELECT * FROM utilisateur where nom='" + user.getNom() +"' AND prenom='" + user.getPrenom() +"'");

			while(resultat.next()) {
				user.setId(this.id = resultat.getString("id"));
				System.out.println("Utilisateur existant");
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(id != null) {
		try {
			java.sql.Statement stm = cnx.createStatement();


			int resultat = stm.executeUpdate("UPDATE utilisateur SET nom ='" + nnom + "', prenom ='" + nprenom + "' WHERE nom ='" + nom +"' AND prenom ='" +prenom+"'");
			System.out.println("Utilisateur mis � jour");
			user.setNom(this.nom = nnom);
			user.setPrenom(this.prenom = nprenom);
			System.out.println(user.toString());
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	public void supprimer (Utilisateur user) {
		try {
			java.sql.Statement stm = cnx.createStatement();


			ResultSet resultat = stm.executeQuery("SELECT * FROM utilisateur where nom='" + user.getNom() +"' AND prenom='" + user.getPrenom() +"'");

			while(resultat.next()) {
				user.setId(this.id = resultat.getString("id"));
				System.out.println("Utilisateur existant");
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(id != null) {
		try {
			java.sql.Statement stm = cnx.createStatement();


			int resultat = stm.executeUpdate("DELETE FROM utilisateur WHERE nom = '"+nom+"' AND prenom = '"+prenom+"'");
			System.out.println("Utilisateur supprimer");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}

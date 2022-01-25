

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class manager {
	
	Bdd co = new Bdd();
	
	private Connection cnx = co.connexion();
	Utilisateur user = new Utilisateur();

	
	public void connexion (Utilisateur user) {
		
		try { 
        	// Préparation de la requête 
			java.sql.Statement stm = cnx.createStatement(); 
			
			
			ResultSet resultat = stm.executeQuery("SELECT * FROM utilisateur where nom='" + user.getNom() +"' AND prenom='" + user.getPrenom() +"'"); 
			
			while(resultat.next()) {
				user.setId(resultat.getString("id"));
				System.out.println("Vous etes connecté, bonjour "+user.getNom()+"");
				System.out.println(user.toString());
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	public void inscription (Utilisateur user) {
		try { 
        	// Préparation de la requête 
			java.sql.Statement stm = cnx.createStatement(); 
			
			
			ResultSet resultat = stm.executeQuery("SELECT * FROM utilisateur where nom='" + user.getNom() +"' AND prenom='" + user.getPrenom() +"'"); 
			
			while(resultat.next()) {
				user.setId(this.id = resultat.getString("id"));
				System.out.println("Erreur votre utilisateur est déjà existant");
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(user.getId() == null) {
		try {
			
		java.sql.Statement stm = cnx.createStatement(); 
		int insert = stm.executeUpdate("INSERT INTO utilisateur(nom,prenom) VALUES ('" + user.getNom() +"','" + user.getPrenom() +"')");
		System.out.println("Utilisateur ajouté");
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
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
			System.out.println("Utilisateur mis à jour");
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

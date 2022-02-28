

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;



public class manager extends Utilisateur {
	private String username = "phpmailerdugny@gmail.com";
	private String password = "Mailer1234";

	Bdd co = new Bdd();

	private Connection cnx = co.connexion();
	Utilisateur user = new Utilisateur();


	public String connexion (Utilisateur user) {
		id="";
		
		System.out.println(user.getMail());
		
		try {
        	// Prï¿½paration de la requï¿½te
			java.sql.Statement stm = cnx.createStatement();

			
			ResultSet resultat = stm.executeQuery("SELECT * FROM utilisateur where mail='" + user.getMail() +"' AND password='" + user.getPassword() +"'");

			while(resultat.next()) {
				user.setId(resultat.getString("id"));
				user.setNom(resultat.getString("Nom"));
				user.setPrenom(resultat.getString("Prenom"));
				user.setRole(resultat.getString("role"));
				
				System.out.println("Vous etes connectï¿½, bonjour "+user.getNom()+"");
				
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
        	// Prï¿½paration de la requï¿½te
			java.sql.Statement stm = cnx.createStatement();


			ResultSet resultat = stm.executeQuery("SELECT * FROM utilisateur where nom='" + user.getNom() +"' AND prenom='" + user.getPrenom() +"'");

			while(resultat.next()) {
				user.setId(this.id = resultat.getString("id"));
				System.out.println("Erreur votre utilisateur est dï¿½jï¿½ existant");
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
		System.out.println("Utilisateur ajoutï¿½");
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
			System.out.println("Utilisateur mis ï¿½ jour");
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

	public String admincreaprofil(Utilisateur user2) {
		try {
        	// Prï¿½paration de la requï¿½te
			java.sql.Statement stm = cnx.createStatement();


			ResultSet resultat = stm.executeQuery("SELECT * FROM utilisateur where nom='" + user.getNom() +"' AND prenom='" + user.getPrenom() +"'");

			while(resultat.next()) {
				user.setId(this.id = resultat.getString("id"));
				System.out.println("Erreur votre utilisateur est dï¿½jï¿½ existant");
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
		System.out.println("Utilisateur ajoutï¿½");
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		String result = "gg";
		return result;
	}
	public void envoyermail(String mail) {
		

		Random randopass = new Random();

		int randpass = randopass.nextInt(99999);
		
		try {
        	// Prï¿½paration de la requï¿½te
			java.sql.Statement stm = cnx.createStatement();


			ResultSet resultat = stm.executeQuery("SELECT * FROM utilisateur where mail='" + mail +"'");

			while(resultat.next()) {
				user.setId(this.id = resultat.getString("id"));
				System.out.println("Utilisateur existant");
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(user.getId() != null) {
		try {
		System.out.println(user);
		java.sql.Statement stm = cnx.createStatement();
		int insert = stm.executeUpdate("UPDATE utilisateur SET token='" + randpass + "' where mail='"+mail+"'");
		System.out.println("Token modif");
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
		  
		//Creation de session
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		
		System.out.println(session);
		try {
			Message message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress("phpmailerdugny@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
			message.setSubject("Test javaMail API");
			message.setText("Voici le code que vous devez entrer dans la page JAVA : "+ randpass);
			
			Transport.send(message);
			System.out.println("Message envoyé");
			
			
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
			
		
		
	}

	public void validercode(Utilisateur user) {
		try {
        	// Prï¿½paration de la requï¿½te
			java.sql.Statement stm = cnx.createStatement();

			
			ResultSet resultat = stm.executeQuery("SELECT id FROM utilisateur where token='" + user.getToken() +"'");

			while(resultat.next()) {
				
				
				System.out.println("Token existant");
				
				
				
			}
			
			java.sql.Statement stm = cnx.createStatement();
			int insert = stm.executeUpdate("UPDATE utilisateur SET mail='" + textFieldValidermdp.getText() + "' where token='"+user.getToken()+"'");
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
	}

}

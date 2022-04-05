package accueil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

	private ResultSet resultat;






	public Utilisateur connexion (Utilisateur user) {
		id="";

		System.out.println(user.getMail());

		try {
			// Pr�paration de la requ�te
			java.sql.Statement stm = cnx.createStatement();


			ResultSet resultat = stm.executeQuery("SELECT * FROM utilisateur INNER JOIN maclasse ON maclasse.iduser = utilisateur.id INNER JOIN classe ON maclasse.idclasse = classe.id  where mail='" + user.getMail() +"' AND password='" + user.getPassword() +"'");

			while(resultat.next()) {
				user.setId(resultat.getString("id"));
				user.setNom(resultat.getString("Nom"));
				user.setPrenom(resultat.getString("Prenom"));
				user.setRole(resultat.getString("role"));
				user.setPseudo(resultat.getString("username"));
				user.setPassword(resultat.getString("Password"));
				user.setDate_naissance(resultat.getString("date_naissance"));
				user.setValidation(resultat.getString("validation"));
				user.setClasse(resultat.getString("libelle"));
				user.setClasseid(resultat.getString("classe.id"));





			}

			if(user.getId()==null) {




				ResultSet resultat1 = stm.executeQuery("SELECT * FROM utilisateur where mail='" + user.getMail() +"' AND password='" + user.getPassword() +"'");

				while(resultat1.next()) {
					user.setId(resultat1.getString("id"));
					user.setNom(resultat1.getString("Nom"));
					user.setPrenom(resultat1.getString("Prenom"));
					user.setRole(resultat1.getString("role"));
					user.setPseudo(resultat1.getString("username"));
					user.setPassword(resultat1.getString("Password"));
					user.setDate_naissance(resultat1.getString("date_naissance"));
					user.setValidation(resultat1.getString("validation"));





				}


			}




		}
		catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		return user;

	}

	public void envoyermail(String mail) {


		Random randopass = new Random();

		int randpass = randopass.nextInt(99999);

		try {
			// Pr�paration de la requ�te
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
			System.out.println("Message envoy�");



		} catch (Exception e) {
			throw new RuntimeException();
		}



	}

	public void validercode(Utilisateur user) {
		try {
			// Pr�paration de la requ�te
			java.sql.Statement stm = cnx.createStatement();


			ResultSet resultat = stm.executeQuery("SELECT id FROM utilisateur where token='" + user.getToken() +"'");

			while(resultat.next()) {


				System.out.println("Token existant");



			}

			int insert = stm.executeUpdate("UPDATE utilisateur SET password='" + user.getPasswordmodif() + "' where token='"+user.getToken()+"'");

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

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
	public Utilisateur modificationprofil (Utilisateur user) throws SQLException {

		String sql;
		PreparedStatement stmp;

		sql = "UPDATE utilisateur SET nom ='" + user.getNom() + "',  prenom ='" +
				user.getPrenom() + "', username ='" + user.getPseudo() + "' ,password ='" +
				user.getPassword() + "', mail ='" + user.getMail() + "', date_naissance ='" +
				user.getDate_naissance() + "' WHERE id ='" + user.getId() + "'";

		stmp =  cnx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);



		System.out.println(user.getNommodif());
		System.out.println(user);
		stmp.executeUpdate();
		ResultSet rs = stmp.getGeneratedKeys();
		if(rs.next())
		{
			int last_inserted_id = rs.getInt(1);
			user.setIdmodif(Integer.toString(last_inserted_id));
		}




		System.out.println("Utilisateur mis � jour");

		user.setPopup("modificationprofil");

		System.out.println(user.toString());



		return user;

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

	public ResultSet toutlessusers() {


		System.out.println(user.getMail());

		try {
			// Pr�paration de la requ�te
			java.sql.Statement stm = cnx.createStatement();


			resultat = stm.executeQuery("SELECT * FROM utilisateur LEFT JOIN maclasse ON maclasse.idclasse = utilisateur.id LEFT JOIN classe ON maclasse.idclasse = classe.id");



		}




		catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

		return resultat;
	}

	public ResultSet eleveclasse(Utilisateur user) {




		try {
			// Pr�paration de la requ�te
			java.sql.Statement stm = cnx.createStatement();


			resultat = stm.executeQuery("SELECT * FROM utilisateur INNER JOIN maclasse ON maclasse.iduser = utilisateur.id INNER JOIN classe ON maclasse.idclasse = classe.id where utilisateur.role = 'eleve' AND maclasse.idclasse = "+user.getClasseid());




		}




		catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

		return resultat;
	}

	public void selectmodifprofiladmin (Utilisateur user) {


		try {
			java.sql.Statement stm = cnx.createStatement();

			System.out.println("testclasse"+user.getClassemodif());
			System.out.println("test"+user);

			int resultat1 = stm.executeUpdate("UPDATE utilisateur SET nom ='" + user.getNommodif() + "',  prenom ='" +
					user.getPrenommodif() + "', username ='" + user.getPseudomodif() + "' ,password ='" +
					user.getPasswordmodif() + "', mail ='" + user.getMailmodif() + "', date_naissance ='" +
					user.getDate_naissancemodif() + "',  validation = '"+user.getValidationmodif()+"', "
					+ "role ='"+user.getRolemodif()+"'  "
					+ "WHERE id ='" + user.getIdmodif() + "'");

			System.out.println("aaaa"+user.getClassemodif());
			int resultat11 = stm.executeUpdate("INSERT INTO maclasse (idclasse,iduser) VALUES ((select id from classe where id ='"+user.getClassemodif()+"'),(select id from utilisateur where id ='"+user.getIdmodif()+"'))");


			System.out.println("Utilisateur mis � jour");

			user.setPopup("modificationprofil");

			System.out.println(user.toString());
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();


		}}

	public ResultSet afficherclasse () {


		System.out.println(user.getMail());

		try {
			// Pr�paration de la requ�te
			java.sql.Statement stm = cnx.createStatement();


			resultat = stm.executeQuery("SELECT * FROM classe ");




		}




		catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

		return resultat;
	}

	public void ajoutretard(Utilisateur monuser) throws SQLException {
		System.out.println(monuser.getIdmodif());
		System.out.println(monuser.getDuree());
		java.sql.Statement stm = cnx.createStatement();
		int insert = stm.executeUpdate("INSERT INTO absence(id_eleve,ars,date_heure,duree) VALUES ('" + monuser.getIdmodif() +"','"+ 1 +"','"+monuser.getDate()+"','"+monuser.getDuree()+"')");
	}

	public void ajoutabsence(Utilisateur monuser) throws SQLException {
		System.out.println(monuser.getIdmodif());
		System.out.println(monuser.getDuree());
		java.sql.Statement stm = cnx.createStatement();
		int insert = stm.executeUpdate("INSERT INTO absence(id_eleve,ars,date_heure) VALUES ('" + monuser.getIdmodif() +"','"+ 2 +"','"+monuser.getDate()+"')");
	}


	public void ajoutrdvprofprinc(Utilisateur monuser) throws SQLException {
		System.out.println(monuser.getDatee());
		java.sql.Statement stm = cnx.createStatement();
		int insert = stm.executeUpdate("INSERT INTO `rdv` (`date_rdv`, `id_participant`, `id_organisateur`) VALUES ('" + monuser.getDatee() +"','"+ monuser.getId() +"','"+ monuser.getIdmodif() +"')");
	}

	public void ajoutsanction(Utilisateur monuser) throws SQLException {
		java.sql.Statement stm = cnx.createStatement();
		int insert = stm.executeUpdate("INSERT INTO absence(id_eleve,ars,commentaire) VALUES ('" + monuser.getIdmodif() +"','"+ 3 +"','"+monuser.getSanction()+"')");

	}

	public ResultSet touteslessanctions(Utilisateur monuser) {
		System.out.println(user.getMail());

		try {
			// Pr�paration de la requ�te
			java.sql.Statement stm = cnx.createStatement();

			resultat = stm.executeQuery("SELECT * FROM utilisateur LEFT JOIN maclasse ON maclasse.idclasse = utilisateur.id LEFT JOIN classe ON maclasse.idclasse = classe.id");

		}


		catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

		return resultat;
	}
	public ResultSet touslesretards(Utilisateur monuser) {
		System.out.println(user.getMail());

		try {
			// Pr�paration de la requ�te
			java.sql.Statement stm = cnx.createStatement();

			resultat = stm.executeQuery("SELECT * FROM utilisateur LEFT JOIN maclasse ON maclasse.idclasse = utilisateur.id LEFT JOIN classe ON maclasse.idclasse = classe.id");

		}


		catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

		return resultat;
	}

	public ResultSet touteslesabsences(Utilisateur monuser) {
		System.out.println(user.getMail());

		try {
			// Pr�paration de la requ�te
			java.sql.Statement stm = cnx.createStatement();

			resultat = stm.executeQuery("SELECT * FROM utilisateur LEFT JOIN maclasse ON maclasse.idclasse = utilisateur.id LEFT JOIN classe ON maclasse.idclasse = classe.id");

		}


		catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

		return resultat;
	}



}

package accueil;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class Connexiontest {
	
	private static Utilisateur mdp;
	private static Utilisateur mail;
	private static Utilisateur teste;
	private static Utilisateur teste2;
	static Connection connexion;
	private static Connexion user;
	private static Connexion url;
	private static Connexion password;
	private static Connection cnx;
    
	@BeforeAll
	static void initUtilisateur() throws SQLException {
		teste = new Utilisateur("test@test.com","test");
		teste2 = new Utilisateur(null,"test");
		Bdd bdd = new Bdd();
		
		try {
			connexion = bdd.connexion();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Statement stm = cnx.createStatement();
		stm.executeUpdate("INSERT INTO utilisateur(nom,prenom,date_naissance, role, mail, username, password, validation) VALUES ('test','test','2021-12-01','Admin','test@test.com,'test','test','Active')");
		
	}
	
	
	@Test @Order(1)
	void seConnecte() {	
		assertNotNull("Test mail de la connexion Utilisateur", teste.getMail());
		assertNotNull("Test mdp de la connexion Utilisateur", teste.getPassword());
	}
	
	@Test @Order(2)
	void seConnecteVide() {	
		assertNull("Test vide initiale du TextField", teste2.getMail());
		
	}
	
	@Test @Order(3)
	void seConnectebdd() throws SQLException {
		java.sql.Statement stm = cnx.createStatement();
		ResultSet info = stm.executeQuery("SELECT * FROM utilisateur where mail = '"+teste.getMail()+"'");
       assertEquals("Test de mail identique","test@test.com",info.getString("Mail"));

		
	}

}

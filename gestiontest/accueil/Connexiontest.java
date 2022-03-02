package accueil;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class Connexiontest {
	
	private static Utilisateur mdp;
	private static Utilisateur mail;
	private static Utilisateur teste;
	private static Utilisateur teste2;
	static Connection connexion;
	private static Utilisateur Monuser;
	private static Connexion user;
	private static Connexion url;
	private static Connexion password;
	private static Connection cnx;
	private static String testmodif;
	
    
	@BeforeAll
	static void initUtilisateur() throws SQLException {
		teste = new Utilisateur("test@test.com","test");
		teste2 = new Utilisateur(null,"test");
		Monuser = new Utilisateur();
		Monuser.setMail("test@test.com");
		Monuser.setPassword("test");
		Monuser.setNom("test");
		Monuser.setPrenom("test");
		Monuser.setDate_naissance("2021-12-01");
		Monuser.setRole("Admin");
		Monuser.setPseudo("test");
		Monuser.setValidation("Active");


		manager man = new manager();
		
		man.inscription(Monuser);
		
		
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
		
		Monuser.setMail("test@test.com");
		Monuser.setPassword("test");

		manager man = new manager();
		
		Monuser = man.connexion(Monuser);
		
       assertEquals("test@test.com",Monuser.getMail(),"Test de mail identique");
       assertEquals("test",Monuser.getPassword(),"Test de password identique");
		
	}
		
		@Test @Order(4)
		void nepasSeConnectebddmail() throws SQLException {
			Monuser.setMail("");
			Monuser.setPassword("test");

			manager man = new manager();
			
			Monuser = man.connexion(Monuser);
	       assertNotEquals("test@test.com",Monuser.getMail(),"Test de mail vide mais password non vide");
	       assertEquals("test",Monuser.getPassword(),"Test de mail vide mais password non vide");

	
			
	}
		@Test @Order(5)
		void nepasSeConnectebddpass() throws SQLException {
			Monuser.setMail("test@test.com");
			Monuser.setPassword("");

			manager man = new manager();
			
			Monuser = man.connexion(Monuser);
	       assertEquals("test@test.com",Monuser.getMail(),"Test de mail non vide mais password vide");
	       assertNotEquals("test",Monuser.getPassword(),"Test de mail non vide mais password vide");

			
		}
			
	
		
		@Test @Order(5)
		void nepasSeConnectebddvide() throws SQLException {
			Monuser.setMail("");
			Monuser.setPassword("");

			manager man = new manager();
			
			Monuser = man.connexion(Monuser);
	       assertEquals("",Monuser.getMail(),"Test de mail vide et password vide");
	       assertEquals("",Monuser.getPassword(),"Test de mail vide et password vide");

			
		
			
	}
		@Test @Order(6)
		void Updatetest() throws SQLException {
			Monuser.setMail("test@testmodif.com");
			Monuser.setPassword("testmodif");
			Monuser.setNom("testmodif");
			Monuser.setPrenom("testmodif");
			Monuser.setDate_naissance("2021-12-02");
			Monuser.setRole("Prof");
			Monuser.setPseudo("testmodif");
			Monuser.setValidation("Desactive");


			manager man = new manager();
			man.modificationprofil(Monuser);
			assertEquals("test@testmodif.com",Monuser.getMail(),"Test de mail mis à jour");
			assertEquals("testmodif",Monuser.getPassword(),"Test de password mis à jour");
			assertEquals("testmodif",Monuser.getNom(),"Test de nom mis à jour");
			assertEquals("testmodif",Monuser.getPrenom(),"Test de prenom mis à jour");
			assertEquals("2021-12-02",Monuser.getDate_naissance(),"Test de date de naissance mis à jour");
			assertEquals("Prof",Monuser.getRole(),"Test de role mis à jour");
			assertEquals("testmodif",Monuser.getPseudo(),"Test de pseudo mis à jour");
			assertEquals("Desactive",Monuser.getValidation(),"Test de validation mis à jour");
			
	}
		@AfterAll public static void supprimer() throws SQLException{
			Bdd co = new Bdd();
			Connection cnx = co.connexion();
			java.sql.Statement stm = cnx.createStatement();
			stm.executeUpdate("DELETE FROM utilisateur where mail ='test@testmodif.com'");
		
		}
		}




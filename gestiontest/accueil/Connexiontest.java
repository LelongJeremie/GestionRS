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
	

	static Connection connexion;
	private static Utilisateur Monuser;
	private static Utilisateur contexte;
	private static Connection cnx;
	private static String testmodif;

	
    
	@BeforeAll
	static void initUtilisateur() throws SQLException {
		Monuser = new Utilisateur();
		contexte = new Utilisateur();
		
		
	}
	

	@Test @Order(1)
	void InscriptionTest() throws SQLException {

		contexte.setMail("test@test.com");
		contexte.setPassword("test");
		contexte.setNom("test");
		contexte.setPrenom("test");
		contexte.setDate_naissance("2021-12-01");
		contexte.setRole("Admin");
		contexte.setPseudo("test");
		contexte.setValidation("Active");

		manager man = new manager();
		
		man.inscription(contexte);
	}
	
	
	
	@Test @Order(2)
	void nepasSeConnectebddpass() throws SQLException {
		Monuser.setMail("test@test.com");
		Monuser.setPassword("mauvais_mdp");

		manager man = new manager();
       assertEquals(contexte.getMail(),Monuser.getMail(),"Test mauvais mdp");
       assertNotEquals(contexte.getPassword(),Monuser.getPassword(),"Test mauvais mdp");

		
	}
	@Test @Order(2)
	void nepasSeConnectebddmail() throws SQLException {
		Monuser.setMail("mauvais@mail.com");
		Monuser.setPassword("test");

		manager man = new manager();
		
		Monuser = man.connexion(Monuser);
       assertNotEquals(contexte.getMail(),Monuser.getMail(),"Test mauvais mail");
       assertEquals(contexte.getPassword(),Monuser.getPassword(),"Test mauvais mail");


		
}

	
	@Test @Order(3)
	void seConnectebdd() throws SQLException {
		
		Monuser.setMail("test@test.com");
		Monuser.setPassword("test");

		manager man = new manager();
		
		Monuser = man.connexion(Monuser);
		
       assertEquals(contexte.getMail(),Monuser.getMail(),"Test de mail identique");
       assertEquals(contexte.getPassword(),Monuser.getPassword(),"Test de password identique");
		
	}
		
		
			
	
		
		@Test @Order(5)
		void nepasSeConnectebddvide() throws SQLException {
			Monuser.setMail("");
			Monuser.setPassword("");

			manager man = new manager();
			
			Monuser = man.connexion(Monuser);
	       assertNotEquals(contexte.getMail(),Monuser.getMail(),"Test de mail vide et password vide");
	       assertNotEquals(contexte.getPassword(),Monuser.getPassword(),"Test de mail vide et password vide");

			
		
			
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
			Utilisateur verifModif = man.connexion(Monuser);
			assertEquals(Monuser.getMail(),verifModif.getMail(),"Test de mail mis à jour");
			assertEquals(Monuser.getPassword(),verifModif.getPassword(),"Test de password mis à jour");
			assertEquals(Monuser.getNom(),verifModif.getNom(),"Test de nom mis à jour");
			assertEquals(Monuser.getPrenom(),verifModif.getPrenom(),"Test de prenom mis à jour");
			assertEquals(Monuser.getDate_naissance(),verifModif.getDate_naissance(),"Test de date de naissance mis à jour");
			assertEquals(Monuser.getRole(),verifModif.getRole(),"Test de role mis à jour");
			assertEquals(Monuser.getPseudo(),verifModif.getPseudo(),"Test de pseudo mis à jour");
			assertEquals(Monuser.getValidation(),verifModif.getValidation(),"Test de validation mis à jour");
			
	}
		@AfterAll public static void supprimer() throws SQLException{
			Bdd co = new Bdd();
			Connection cnx = co.connexion();
			java.sql.Statement stm = cnx.createStatement();
			stm.executeUpdate("DELETE FROM utilisateur where mail ='test@testmodif.com'");
		
		}
		}




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
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
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
	private String iddelete;


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
		Monuser = man.connexion(Monuser);
		assertEquals(null,Monuser.getId()," N'as pas reussi a se connecter");

	}
	@Test @Order(3)
	void nepasSeConnectebddmail() throws SQLException {
		
		contexte.setMail("mauvais@mail.com");
		contexte.setPassword("test");

		manager man = new manager();
		Monuser= man.connexion(contexte);
		assertEquals(null,Monuser.getId()," N'as pas reussi a se connecter");


	}


	@Test @Order(5)
	void seConnectebdd() throws SQLException {

		Monuser.setMail("test@test.com");
		Monuser.setPassword("test");


		manager man = new manager();
		Monuser= man.connexion(Monuser);
		assertNotEquals(null,Monuser.getId()," Connexion reussi ");
		contexte.setId(Monuser.getId());
	}





	@Test @Order(4)
	void nepasSeConnectebddvide() throws SQLException {
		Monuser.setMail("");
		Monuser.setPassword("");


		manager man = new manager();
		Monuser= man.connexion(Monuser);
		assertEquals(null,Monuser.getId()," N'as pas reussi a se connecter");
		
	}
	@Test @Order(6)
	void Updatetest() throws SQLException {
		contexte.setMail("test@testmodif.com");
		contexte.setPassword("testmodif");
		contexte.setNom("testmodif");
		contexte.setPrenom("testmodif");
		contexte.setDate_naissance("2021-12-02");
		contexte.setRole("Prof");
		contexte.setPseudo("testmodif");
		contexte.setValidation("Desactive");


		manager man = new manager();
		contexte = man.modificationprofil(contexte);
		
		contexte.setIdmodif(contexte.getId());
		System.out.println("test"+contexte.getIdmodif());
		
		Utilisateur verifModif = man.connexion(contexte);
		System.out.println("Id -->"+verifModif.getId());
		System.out.println("Nom -->"+verifModif.getNom()+ " / "+ contexte.getNom());

		assertEquals(contexte.getMail(),verifModif.getMail(),"Test de mail mis à jour");
		assertEquals(contexte.getPassword(),verifModif.getPassword(),"Test de password mis à jour");
		assertEquals(contexte.getNom(),verifModif.getNom(),"Test de nom mis à jour");
		assertEquals(contexte.getPrenom(),verifModif.getPrenom(),"Test de prenom mis à jour");
		assertEquals(contexte.getDate_naissance(),verifModif.getDate_naissance(),"Test de date de naissance mis à jour");
		assertEquals(contexte.getRole(),verifModif.getRole(),"Test de role mis à jour");
		assertEquals(contexte.getPseudo(),verifModif.getPseudo(),"Test de pseudo mis à jour");
		assertEquals(contexte.getValidation(),verifModif.getValidation(),"Test de validation mis à jour");

	}
	@AfterAll public static void supprimer() throws SQLException{
		Bdd co = new Bdd();
		Connection cnx = co.connexion();
		java.sql.Statement stm = cnx.createStatement();
		//System.out.println("DELETE FROM utilisateur where id="+ Monuser.getIdmodif());
		stm.executeUpdate("DELETE FROM utilisateur where id="+ contexte.getId());

	}

}




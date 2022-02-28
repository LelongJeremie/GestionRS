package accueil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC { 
	public static void main(String[] args) { 
		Connection cnx = null; 
		int id = 0;
		String prenom = null; 
		String nom = null;
		String age = null;
		String mail = null;
		Scanner scan = new Scanner(System.in);
		// On stock dans des variables l'URL de connexion à la base de données avec les identifiants  
		 String url="jdbc:mysql://localhost/siteschuman?serverTimezone=UTC";  
        String user="root";  
        String password="";  
        // Test pour vérifier si nous arrivons à nous connecter
        try {  
       	 // On créé une variable cnx de type Connection 
       	 // cnx contiendra la connextion à la base de données
        	cnx = DriverManager.getConnection(url,  user, password);  
            System.out.println("Etat de la connexion :");  
		// Forme ternaire du if. Si la condition à échoué alors on affiche « fermé » sinon on affiche « ouverte » 
            System.out.println(cnx.isClosed()?"fermée":"ouverte");  
                 
        } 
        // Si on arrive pas à se connetcer on attrape l'erreur pour l'afficher ensuite
			catch (SQLException e) {  
            System.out.println("Une erreur est survenue lors de la connexion à la base de données");  
            e.printStackTrace();  
        } 
        try { 
        	// Préparation de la requête 
			java.sql.Statement stm = cnx.createStatement(); 
			
			
			ResultSet resultat = stm.executeQuery("SELECT *  FROM etudiant"); 
			// On parcours toute les lignes de la requête tant qu'il y a des lignes
			while(resultat.next()){ 
			// Affichage des lignes à la colonne "id" 
			id = resultat.getInt("id");
			id++;
		} 
			
			
			
			 
			System.out.print("Saisir votre nom");
			nom = scan.next(); 			// On exécute la requête
			System.out.print("Saisir votre prenom");
			prenom = scan.next(); 			// On exécute la requête
			System.out.print("Saisir votre age");
			age = scan.next(); 			// On exécute la requête
			System.out.print("Saisir votre mail");
			mail = scan.next(); 			// On exécute la requête
			int insert = stm.executeUpdate("INSERT INTO etudiant VALUES ('" + id +"','" + nom +"','" + prenom +"','" + age +"','" + mail +"')"); 
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}	 
          
          
	} 

} 
 

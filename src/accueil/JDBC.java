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
		// On stock dans des variables l'URL de connexion � la base de donn�es avec les identifiants  
		 String url="jdbc:mysql://localhost/siteschuman?serverTimezone=UTC";  
        String user="root";  
        String password="";  
        // Test pour v�rifier si nous arrivons � nous connecter
        try {  
       	 // On cr�� une variable cnx de type Connection 
       	 // cnx contiendra la connextion � la base de donn�es
        	cnx = DriverManager.getConnection(url,  user, password);  
            System.out.println("Etat de la connexion :");  
		// Forme ternaire du if. Si la condition � �chou� alors on affiche � ferm� � sinon on affiche � ouverte � 
            System.out.println(cnx.isClosed()?"ferm�e":"ouverte");  
                 
        } 
        // Si on arrive pas � se connetcer on attrape l'erreur pour l'afficher ensuite
			catch (SQLException e) {  
            System.out.println("Une erreur est survenue lors de la connexion � la base de donn�es");  
            e.printStackTrace();  
        } 
        try { 
        	// Pr�paration de la requ�te 
			java.sql.Statement stm = cnx.createStatement(); 
			
			
			ResultSet resultat = stm.executeQuery("SELECT *  FROM etudiant"); 
			// On parcours toute les lignes de la requ�te tant qu'il y a des lignes
			while(resultat.next()){ 
			// Affichage des lignes � la colonne "id" 
			id = resultat.getInt("id");
			id++;
		} 
			
			
			
			 
			System.out.print("Saisir votre nom");
			nom = scan.next(); 			// On ex�cute la requ�te
			System.out.print("Saisir votre prenom");
			prenom = scan.next(); 			// On ex�cute la requ�te
			System.out.print("Saisir votre age");
			age = scan.next(); 			// On ex�cute la requ�te
			System.out.print("Saisir votre mail");
			mail = scan.next(); 			// On ex�cute la requ�te
			int insert = stm.executeUpdate("INSERT INTO etudiant VALUES ('" + id +"','" + nom +"','" + prenom +"','" + age +"','" + mail +"')"); 
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}	 
          
          
	} 

} 
 

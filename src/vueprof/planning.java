package vueprof; 

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Statement;

import accueil.Bdd;
import accueil.Utilisateur;

import java.awt.Color;
import java.awt.Font;

public class planning {

	JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void run(Utilisateur user) {
		try {
			planning window = new planning(user);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 * @param user 
	 */
	public planning(Utilisateur user) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Planning");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 480, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(30, 264, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Planning");
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(173, 37, 94, 23);
		frame.getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 71, 397, 169);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table);
		ListSelectionModel listMod =  table.getSelectionModel();
		listMod.addListSelectionListener(table);

		try{
			Bdd co = new Bdd();
			Connection co_bdd = co.connexion(); 

			java.sql.Connection cnx = co.connexion();
			java.sql.Statement stmt1 = cnx.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs1;
			rs1 = stmt1.executeQuery("SELECT * FROM `planning` INNER JOIN classe on idClasse = classe.id");

			int i=0;
			int k=0;
			if(rs1.next()){
				rs1.last();
				k=rs1.getRow();
				rs1.beforeFirst();
			}
			Object[][] t=new Object[k][6];
			//resultat de la requete dans un tableau
			while (rs1.next()){

				t[i][0]=rs1.getString(2);
				t[i][1]=rs1.getString(3);
				t[i][2]=rs1.getString(4);
				t[i][3]=rs1.getString(5);
				t[i][4]=rs1.getString(8);

				i++;

			}
			System.out.println(i);
			String[][] ligne=new String[18-8][6];//12
			for(int heure = 8; heure < 17 ;heure++) {
				ligne[heure-8][0] = String.valueOf(heure) +" - " +String.valueOf(heure+1);
				for (int planning = 0 ; planning < i ; planning ++) {
					int jour = Integer.parseInt(String.valueOf(t[planning][0]));
					if(heure >= Integer.parseInt(String.valueOf(t[planning][1])) && Integer.parseInt(String.valueOf(t[planning][1]))+Integer.parseInt(String.valueOf(t[planning][2])) > heure  )
						ligne[heure-8][jour] = String.valueOf(t[planning][4]);

				}
			}

			rs1.close();
			// affiche le tableau dans le jtable
			final String columnNames[] = {"Heure","lundi","mardi","mercredi","jeudi","vendredi"};
			listMod.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setModel(new DefaultTableModel(ligne,columnNames));

			JLabel lblNewLabel_2 = new JLabel("LprsNote");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lblNewLabel_2.setBounds(10, 10, 153, 51);
			frame.getContentPane().add(lblNewLabel_2);


		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	
}
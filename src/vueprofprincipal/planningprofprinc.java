package vueprofprincipal;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import accueil.Administrateur;
import accueil.Prof;
import accueil.Profprinc;
import accueil.Utilisateur;
import accueil.manager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Color;
import javax.swing.SwingConstants;

public class planningprofprinc {

	private JFrame frame;
	private ResultSet resultat;
	private int i;
	private Utilisateur Monuser= new Utilisateur();
	private JTextField textFieldsanction;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(Utilisateur user) {
				try {
					planningprofprinc window = new planningprofprinc(user);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
	}

	/**
	 * Create the application.
	 * @param user 
	 */
	public planningprofprinc(Utilisateur user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Utilisateur user) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 676, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		manager man = new manager();

		
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 122, 306, 130);
		planningprofprinc.getContentPane().add(scrollPane);

		try {
			Statement stm = coBdd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet info = stm.executeQuery(
					"SELECT nom, prenom, heureDebut, heureFin FROM Utilisateur AS U INNER JOIN Professeur AS P ON P.refUtil = U.id INNER JOIN Planning AS Pl ON Pl.refProf = P.id WHERE statut IN (1, 3);");
			String columns[] = { "Professeur", "Horaire début", "Horaire fin" };
			DefaultTableModel model = new DefaultTableModel(columns, 0);
			model.setColumnIdentifiers(columns);
			while (info.next()) {
				String titre = info.getString("Nom") + " " + info.getString("Prenom");
				String heureDeb = info.getString("HeureDebut");
				String heureFin = info.getString("HeureFin");
				String[] test = { titre, heureDeb, heureFin };
				model.addRow(test);
			}

			JTable tableProf = new JTable(model);
			tableProf.setEnabled(false);
			tableProf.setBounds(21, 122, 200, 100);
			profPresent.getContentPane().add(tableProf);
			scrollPane.setViewportView(tableProf);
			profPresent.repaint();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		
		

	}
	public void run(Utilisateur user) {
		try {
			planningprofprinc window = new planningprofprinc(user);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

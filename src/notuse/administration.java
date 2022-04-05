package notuse;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import vueprof.absence;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class administration {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					administration window = new administration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public administration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1022, 665);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMINISTRATION");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(367, 11, 251, 77);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnClasse = new JButton("CLASSE");
		btnClasse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    ClasseA v=new ClasseA(user);
					v.run(user);
					frame.setVisible(false);
					this.dispose();
				
			
			}
		});
		btnClasse.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnClasse.setBounds(600, 99, 251, 60);
		frame.getContentPane().add(btnClasse);
		
		JButton btnEleve = new JButton("ELEVE");
		btnEleve.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnEleve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnEleve.setBounds(367, 174, 251, 60);
		frame.getContentPane().add(btnEleve);
		
		JButton btnFourniture = new JButton("FOURNITURE");
		btnFourniture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnFourniture.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnFourniture.setBounds(367, 258, 251, 60);
		frame.getContentPane().add(btnFourniture);
	}
}

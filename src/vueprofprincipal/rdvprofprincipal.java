package vueprofprincipal;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Container; 

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

import accueil.Administrateur;
import accueil.Profprinc;

import accueil.Utilisateur;
import accueil.manager;
import vueadmin.PopupAdmin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
 
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Bean to display a month calendar in a JPanel. Only works for the Western
 * calendar.
 *
 * @author Ian F. Darwin, http://www.darwinsys.com/
 * @version $Id: Cal.java,v 1.5 2004/02/09 03:33:45 ian Exp $
 */
public class rdvprofprincipal extends JPanel {
	public Utilisateur Monuser= new Utilisateur();
	manager man = new manager();

	 /** The currently-interesting year (not modulo 1900!) */
	  protected int yy;
	 
	  /** Currently-interesting month and day */
	  protected int mm, dd;
	 
	  /** The buttons to be displayed */
	  protected JButton labs[][];
	  public String date2;
	  public String dateajd;
	 
	  /** The number of day squares to leave blank at the start of this month */
	  protected int leadGap = 0;
	 
	  /** A Calendar object used throughout */
	  Calendar calendar = new GregorianCalendar();
	 
	  /** Today's year */
	  protected final int thisYear = calendar.get(Calendar.YEAR);
	 
	  /** Today's month */
	  protected final int thisMonth = calendar.get(Calendar.MONTH);
	 
	  /** One of the buttons. We just keep its reference for getBackground(). */
	  private JButton b0;
	 
	  /** The month choice */
	  private JComboBox monthChoice;
	 
	  /** The year choice */
	  private JComboBox yearChoice;
	 
	  /**
	   * Construct a Cal, starting with today.
	   */
	  rdvprofprincipal() {
	    super();
	    setYYMMDD(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
	        calendar.get(Calendar.DAY_OF_MONTH));
	    buildGUI();
	    recompute();
	  }
	 
	  /**
	   * Construct a Cal, given the leading days and the total days
	   *
	   * @exception IllegalArgumentException
	   *                If year out of range
	   */
	  rdvprofprincipal(int year, int month, int today) {
	    super();
	    setYYMMDD(year, month, today);
	    buildGUI();
	    recompute();
	  }
	 
	  public void setYYMMDD(int year, int month, int today) {
	    yy = year;
	    mm = month;
	    dd = today;
	  }
	 
	  String[] months = { "Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin",
	      "Juillet", "Aout", "Septembre", "Octobre", "Novembre", "Decembre" };

	public static String date;
	 
	  /** Build the GUI. Assumes that setYYMMDD has been called. */
	  private void buildGUI() {
	    getAccessibleContext().setAccessibleDescription(
	        "Calendar not accessible yet. Sorry!");
	    setBorder(BorderFactory.createEtchedBorder());
	 
	    setLayout(new BorderLayout());
	 
	    JPanel tp = new JPanel();
	    tp.setBackground(Color.WHITE);
	    tp.add(monthChoice = new JComboBox());
	    for (int i = 0; i < months.length; i++)
	      monthChoice.addItem(months[i]);
	    monthChoice.setSelectedItem(months[mm]);
	    monthChoice.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent ae) {
	        int i = monthChoice.getSelectedIndex();
	        if (i >= 0) {
	          mm = i;
	          // System.out.println("Month=" + mm);
	          recompute();
	        }
	      }
	    });
	    monthChoice.getAccessibleContext().setAccessibleName("Months");
	    monthChoice.getAccessibleContext().setAccessibleDescription(
	        "Choose a month of the year");
	 
	    tp.add(yearChoice = new JComboBox());
	    yearChoice.setEditable(true);
	    for (int i = yy - 5; i < yy + 5; i++)
	      yearChoice.addItem(Integer.toString(i));
	    yearChoice.setSelectedItem(Integer.toString(yy));
	    yearChoice.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent ae) {
	        int i = yearChoice.getSelectedIndex();
	        if (i >= 0) {
	          yy = Integer.parseInt(yearChoice.getSelectedItem()
	              .toString());
	          // System.out.println("Year=" + yy);
	          recompute();
	        }
	      }
	    });
	    add(BorderLayout.CENTER, tp);
	 
	    JPanel bp = new JPanel();
	    bp.setBackground(Color.WHITE);
	    bp.setLayout(new GridLayout(7, 7));
	    labs = new JButton[6][7]; // first row is days
	 
	    bp.add(b0 = new JButton("D"));
	    b0.setForeground(Color.BLACK);
	    bp.add(new JButton("L"));
	    JButton button = new JButton("M");
	    button.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    bp.add(button);
	    bp.add(new JButton("M"));
	    bp.add(new JButton("J"));
	    bp.add(new JButton("V"));
	    bp.add(new JButton("S"));
	 
	    ActionListener dateSetter = new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        String num = e.getActionCommand();
	        if (!num.equals("")) {
	          // set the current day highlighted
	          setDayActive(Integer.parseInt(num));
	          // When this becomes a Bean, you can
	          // fire some kind of DateChanged event here.
	          // Also, build a similar daySetter for day-of-week btns.
	          System.out.println(yy+"  "+mm+"  "+dd);
	          date = yy+"-"+mm+"-"+dd;
	          
	          
	          Monuser.setDate(date);
	          Monuser.getDate();
	        
	        }
	      }
	    
	    };
	    
	    System.out.println(date);
	 
	    // Construct all the buttons, and add them.
	    for (int i = 0; i < 6; i++)
	      for (int j = 0; j < 7; j++) {
	        bp.add(labs[i][j] = new JButton(""));
	        labs[i][j].addActionListener(dateSetter);
	      }
	 
	    add(BorderLayout.SOUTH, bp);
	  }
	 
	  public final static int dom[] = { 31, 28, 31, 30, /* jan feb mar apr */
	  31, 30, 31, 31, /* may jun jul aug */
	  30, 31, 30, 31 /* sep oct nov dec */
	  };
	 
	  /** Compute which days to put where, in the Cal panel */
	  protected void recompute() {
	    // System.out.println("Cal::recompute: " + yy + ":" + mm + ":" + dd);
	    if (mm < 0 || mm > 11)
	      throw new IllegalArgumentException("Month " + mm
	          + " bad, must be 0-11");
	    clearDayActive();
	    calendar = new GregorianCalendar(yy, mm, dd);
	 
	    // Compute how much to leave before the first.
	    // getDay() returns 0 for Sunday, which is just right.
	    leadGap = new GregorianCalendar(yy, mm, 1).get(Calendar.DAY_OF_WEEK) - 1;
	    // System.out.println("leadGap = " + leadGap);
	 
	    int daysInMonth = dom[mm];
	    if (isLeap(calendar.get(Calendar.YEAR)) && mm > 1)
	      ++daysInMonth;
	 
	    // Blank out the labels before 1st day of month
	    for (int i = 0; i < leadGap; i++) {
	      labs[0][i].setText("");
	    }
	 
	    // Fill in numbers for the day of month.
	    for (int i = 1; i <= daysInMonth; i++) {
	      JButton b = labs[(leadGap + i - 1) / 7][(leadGap + i - 1) % 7];
	      b.setText(Integer.toString(i));
	    }
	 
	    // 7 days/week * up to 6 rows
	    for (int i = leadGap + 1 + daysInMonth; i < 6 * 7; i++) {
	      labs[(i) / 7][(i) % 7].setText("");
	    }
	 
	    // Shade current day, only if current month
	    if (thisYear == yy && mm == thisMonth)
	      setDayActive(dd); // shade the box for today
	 
	    // Say we need to be drawn on the screen
	    repaint();
	  }
	 
	  /**
	   * isLeap() returns true if the given year is a Leap Year.
	   *
	   * "a year is a leap year if it is divisible by 4 but not by 100, except
	   * that years divisible by 400 *are* leap years." -- Kernighan &#038; Ritchie,
	   * _The C Programming Language_, p 37.
	   */
	  public boolean isLeap(int year) {
	    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
	      return true;
	    return false;
	  }
	 
	  /** Set the year, month, and day */
	  public void setDate(int yy, int mm, int dd) {
	    // System.out.println("Cal::setDate");
	    this.yy = yy;
	    this.mm = mm; // starts at 0, like Date
	    this.dd = dd;
	    recompute();
	  }
	  
	  public static String getDate() {
		  return date;
	  }
	 
	  /** Unset any previously highlighted day */
	  private void clearDayActive() {
	    JButton b;
	 
	    // First un-shade the previously-selected square, if any
	    if (activeDay > 0) {
	      b = labs[(leadGap + activeDay - 1) / 7][(leadGap + activeDay - 1) % 7];
	      b.setBackground(b0.getBackground());
	      b.repaint();
	      activeDay = -1;
	    }
	  }
	 
	  private int activeDay = -1;
	 
	  /** Set just the day, on the current month */
	  public void setDayActive(int newDay) {
	 
	    clearDayActive();
	 
	    // Set the new one
	    if (newDay <= 0)
	      dd = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
	    else
	      dd = newDay;
	    // Now shade the correct square
	    Component square = labs[(leadGap + newDay - 1) / 7][(leadGap + newDay - 1) % 7];
	    square.setBackground(Color.red);
	    square.repaint();
	    activeDay = newDay;
	    
	    
	
	  }
	 
	 


	JFrame frame;
	private ResultSet resultat;
	private ResultSet resultatclasse;
	private int i;

 

	/**
	 * Launch the application.
	 */

	public void run1(Utilisateur user) {
		try {
			rdvprofprincipal window = new rdvprofprincipal(user);
			window.frame.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		// TODO Auto-generated method stub

	}



	/**
	 * Create the application.
	 * @param user 
	 */
	public rdvprofprincipal(Utilisateur user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param user 
	 */
	private void initialize(Utilisateur user) {

		
		
		manager man = new manager();

		resultat = man.eleveclasse(user);

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 909, 601);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JComboBox<Utilisateur> comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);

		comboBox.setBounds(10, 49, 975, 54);
		frame.getContentPane().add(comboBox);

		

		try {
			i=0;
			while(resultat.next()){

				

				Monuser.setIdmodif(resultat.getString("id"));
				Monuser.setNommodif(resultat.getString("nom"));
				Monuser.setPrenommodif(resultat.getString("prenom"));
				Monuser.setMailmodif(resultat.getString("mail"));
				Monuser.setPasswordmodif(resultat.getString("password"));
				Monuser.setRolemodif(resultat.getString("role"));
				Monuser.setClassemodif(resultat.getString("classe"));
				Monuser.setDate_naissancemodif(resultat.getString("date_naissance"));
				Monuser.setPseudomodif(resultat.getString("username"));
				Monuser.setValidationmodif(resultat.getString("Validation"));

				System.out.println("ID = "+Monuser.getIdmodif()+"i= "+i);
				i=i+1;
				comboBox.addItem(Monuser);  



			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			resultat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comboBox.addActionListener(new ActionListener() {     
			public void actionPerformed(ActionEvent e) {

				System.out.println("Valeur: " + comboBox.getSelectedItem().toString());      
			}
		});


		frame.getContentPane().add(comboBox); 
		frame.setSize(1009, 450); 
		frame.show();


	JButton btnSelect = new JButton("Selectionner");
		btnSelect.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				
			
				
				Monuser.setIdmodif(((Utilisateur) comboBox.getSelectedItem()).getIdmodif());
				Monuser.setClassemodif(((Utilisateur) comboBox.getSelectedItem()).getClassemodif());
				Monuser.setNommodif(((Utilisateur) comboBox.getSelectedItem()).getNommodif());
				Monuser.setPrenommodif(((Utilisateur) comboBox.getSelectedItem()).getPrenommodif());
				Monuser.setMailmodif(((Utilisateur) comboBox.getSelectedItem()).getMailmodif());
				Monuser.setPasswordmodif(((Utilisateur) comboBox.getSelectedItem()).getPasswordmodif());
				Monuser.setRolemodif(((Utilisateur) comboBox.getSelectedItem()).getRolemodif());
				Monuser.setDate_naissancemodif(((Utilisateur) comboBox.getSelectedItem()).getDate_naissancemodif());
				Monuser.setPseudomodif(((Utilisateur) comboBox.getSelectedItem()).getPseudomodif());
			
				 JFrame f = new JFrame("Mon Calendrier");
				    Container c = f.getContentPane();
				    c.setLayout(new FlowLayout());
				 
				  
					
				    // and beside it, the current month.
				    c.add(new rdvprofprincipal());
				 
				    f.pack();
				    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				    f.setVisible(true);


				

			

				JButton btnModificationadmin = new JButton("Prendre rendez-vous");
				btnModificationadmin.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
					
						System.out.println("rentre");
						
						 DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("YYYY-MM-DD");
						dateajd = dtf5.format(LocalDateTime.now());
						  try {
					            SimpleDateFormat dateFormat = new
					                SimpleDateFormat ("yyyy-MM-dd");
					            System.out.println(date);
					            System.out.println("rentre2");
					            Date date1 = dateFormat.parse(date);
					            System.out.println("rentre3");
					            Date date2 = dateFormat.parse(dateajd);
					            System.out.println("rentre4");
					            System.out.println("Date-1: " + 
					            
					                               dateFormat.format(date1));
					            System.out.println("Date-2: " +
					                               dateFormat.format(date2));
					            if(date1.before(date2)){
					                System.out.println(
					                    "Date-1 is before Date-2");
					            } 
					            
					            else {
					            	Monuser.setDate(date);
					            	Monuser.setId( user.getId());
					            	
					            	try {
										man.ajoutrdvprofprinc(Monuser);
										PopupProfprinc u=new PopupProfprinc(user);
										u.run(user);
										frame.setVisible(true);
										
										
										rdvprofprincipal u1=new rdvprofprincipal(user);
										u1.run(user);
										frame.setVisible(false);
										f.setVisible(false);
										this.dispose();
									} catch (SQLException e1) {
										System.out.println("erreur");
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
					            	
					            	
									
									
								
									
									
								}
					        } catch (ParseException ex) {
					        }
						  
						

					}

					

					private void dispose() {
						// TODO Auto-generated method stub

					}






				});
				btnModificationadmin.setBounds(331, 231, 147, 37);
				frame.getContentPane().add(btnModificationadmin);

				frame.repaint();

			}
		});
		btnSelect.setBounds(488, 114, 147, 37);
		frame.getContentPane().add(btnSelect);

		JButton btnretour = new JButton("retour");
	btnretour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profprinc u=new Profprinc(user);
				u.run(user);
				frame.setVisible(false);
				this.dispose();

			}

			private void dispose() {
				// TODO Auto-generated method stub

			}

		});
		btnretour.setBounds(0, 0, 89, 38);
		frame.getContentPane().add(btnretour);
		
		JButton btnRefresh = new JButton("Deselectionner");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdvprofprincipal u=new rdvprofprincipal(user);
				u.run(user);
				frame.setVisible(false);
				this.dispose();
				
				
				
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		btnRefresh.setBounds(331, 114, 147, 38);
		frame.getContentPane().add(btnRefresh);
		
		JLabel lblNewLabel = new JLabel("New label"+Monuser);
		lblNewLabel.setBounds(126, 12, 550, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBackground(Color.GRAY);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(0, 0, 995, 38);
		frame.getContentPane().add(lblNewLabel_1);





	}

	public void run(Utilisateur user) {
		try {
			rdvprofprincipal window = new rdvprofprincipal(user);
			window.frame.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

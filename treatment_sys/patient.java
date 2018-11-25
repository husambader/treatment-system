import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class patient{
	JFrame patient;
	JPanel p = new JPanel();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel pinsert = new JPanel();
	JPanel pselect = new JPanel();
	JPanel pupdate = new JPanel();
	JPanel pdelete = new JPanel();
	JComboBox<String> ids = new JComboBox<>();
	JButton table = new JButton("See Table");
	JButton select = new JButton("Select");
	JButton select1 = new JButton("Select");
	JButton update = new JButton("Update");
	JButton insert = new JButton("Insert");
	JButton delete = new JButton("Delete");
	JButton delete1 = new JButton("Delete");
	JButton add = new JButton("Add");
	JButton update1 = new JButton("Update");
	JTextField t2 = new JTextField();
	JTextField t3 = new JTextField();
	JTextField t6 = new JTextField();
	JTextField t7 = new JTextField();
	JTextField t8 = new JTextField();
	JComboBox<String> t5 = new JComboBox<>();
	JComboBox<String> selectCombo = new JComboBox<>();
	JButton back = new JButton("Back");
	JButton clear = new JButton("Clear all");
	JButton clear1 = new JButton("Clear all");
	JButton exit = new JButton("Exit");
	JLabel l = new JLabel(" Show All patient Info ");
	JLabel l1 = new JLabel(" Select patient ");
	JLabel l2 = new JLabel(" Insert patient  ");
	JLabel l3 = new JLabel("Update patient ");
	JLabel l4 = new JLabel("Delete patient ");
	JTextArea b = new JTextArea();
	JTextArea b1 = new JTextArea();
	JRadioButton c1 = new JRadioButton("patient Name");
	JRadioButton c2 = new JRadioButton("patient Address");

	public patient() {
		patient = new JFrame("patient");
		patient.setSize(800, 500);
		patient.setLayout(new BorderLayout());
		patient.setResizable(false);
		patient.setLocation(400, 70);
		p.setBorder(new TitledBorder(""));
		p2.setBorder(new TitledBorder(""));
		l.setBorder(new TitledBorder(""));
		l1.setBorder(new TitledBorder(""));
		l2.setBorder(new TitledBorder(""));
		l3.setBorder(new TitledBorder(""));
		l4.setBorder(new TitledBorder(""));
		patient.add(p, BorderLayout.NORTH);
		patient.add(p1);
		patient.add(p2, BorderLayout.SOUTH);
		p.setLayout(new GridLayout(5, 5, 5, 5));
		p.add(l);
		p.add(table);
		p.add(l1);
		p.add(select);
		p.add(l2);
		p.add(insert);
		p.add(l3);
		p.add(update);
		p.add(l4);
		p.add(delete);

		p2.setLayout(new FlowLayout());
		p2.add(back);
		p2.add(exit);

		pinsert.setBorder(new TitledBorder("Add Patient"));
		pinsert.setLayout(new GridLayout(4, 5,5,5));
		pinsert.add(new JLabel("Patient ID"));
		pinsert.add(t6);
		pinsert.add(new JLabel("Patient Name"));
		pinsert.add(t7);
		pinsert.add(new JLabel("Patient Adress"));
		pinsert.add(t8);
		pinsert.add(clear1);
		pinsert.add(add);
		JPanel ppselect = new JPanel();
		pselect.setLayout(new BorderLayout());
		pselect.add(selectCombo, BorderLayout.NORTH);
		pselect.add(ppselect);
		ppselect.setBorder(new TitledBorder("Choose "));
		ppselect.setLayout(new GridLayout(1, 4,5,5));
		ButtonGroup z = new ButtonGroup();
		z.add(c1);
		z.add(c2);
		ppselect.add(c1);
		ppselect.add(c2);
		ppselect.add(select1);
		selectCombo.setBorder(new TitledBorder("Patient  ID"));
		pselect.add(b1, BorderLayout.SOUTH);
		b1.setVisible(false);
		b1.setEditable(false);
		pdelete.setLayout(new FlowLayout());
		pdelete.setBorder(new TitledBorder(""));
		pdelete.add(new JLabel("Choose Patient ID"));
		pdelete.add(t5);
		pdelete.add(delete1);

		pupdate.setBorder(new TitledBorder("Update Patient"));
		pupdate.setLayout(new GridLayout(4, 5,5,5));
		pupdate.add(new JLabel("Patient ID"));
		pupdate.add(ids);
		pupdate.add(new JLabel("Patient Name"));
		pupdate.add(t2);
		pupdate.add(new JLabel("Patient Address"));
		pupdate.add(t3);
		pupdate.add(clear);
		pupdate.add(update1);

		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t2.setText("");
				t3.setText("");
			}
		});
		clear1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t6.setText("");
				t7.setText("");
				t8.setText("");
			}
		});
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				invisible();
				cover cover=new cover();

			}
		});
		table.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1.removeAll();
				p1.updateUI();
				b.setText("");
				b.setEditable(false);
				try {
					String x = "select *  from patient";
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					Statement statement = connection.createStatement();
					ResultSet select = statement.executeQuery(x);
					while (select.next())
						b.append("\t" + select.getString(1) + "\t"
								+ select.getString(2) + "\t"
								+ select.getString(3) + "\t\n");
					p1.add(b);
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null,
							"CAN'T CONNECT TO DATABASE , TRY AGAIN");
				}
			}
		});
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null,
						" Are you sure you want to exit ?", "Exit ", 2) == 0)
					System.exit(0);

			}
		});
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1.removeAll();
				p1.updateUI();
				p1.add(pinsert);
			}
		});
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p1.removeAll();
				p1.updateUI();
				p1.add(pselect);
				selectCombo.removeAllItems();
				try {
					String x = "select d.idPatient  from patient d ";
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					Statement statement = connection.createStatement();
					ResultSet select = statement.executeQuery(x);
					while (select.next())
						selectCombo.addItem(select.getString(1));
					selectCombo.addItem("All patients");
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {

				}
			}
		});
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p1.removeAll();
				p1.updateUI();
				p1.add(pdelete);
				t5.removeAllItems();
				try {
					String x = "select d.idPatient  from patient d ";
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					Statement statement = connection.createStatement();
					ResultSet select = statement.executeQuery(x);
					while (select.next())
						t5.addItem(select.getString(1));
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {

				}
			}
		});
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1.removeAll();
				p1.updateUI();
				p1.add(pupdate);
				ids.removeAllItems();
				try {
					String x = "select d.idPatient  from patient d ";
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					Statement statement = connection.createStatement();
					ResultSet select = statement.executeQuery(x);
					while (select.next())
						ids.addItem(select.getString(1));
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {

				}

			}
		});
		select1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = (String) selectCombo.getSelectedItem();
				b1.setVisible(true);
				if (!s.equals("All patients")) {
					b1.setText("");
					if (c1.isSelected()) {
						try {
							b1.setText("");
							String x = "SELECT d.PatientName FROM patient d where d.idPatient="
									+ s;
							Class.forName("com.mysql.jdbc.Driver");
							Connection connection = DriverManager
									.getConnection(
											"jdbc:mysql://localhost:3306/project",
											"root", "wisam");
							Statement statement = connection.createStatement();
							ResultSet select = statement.executeQuery(x);
							while (select.next())
								b1.append(select.getString(1));
							connection.close();
							b1.setVisible(true);
						} catch (ClassNotFoundException | SQLException e1) {
							JOptionPane.showMessageDialog(null,
									"ERROR , TRY AGAIN");
						}
					} else if (c2.isSelected()) {
						try {
							b1.setText("");
							String x = "SELECT d.PatientAddress FROM patient d where d.idPatient="
									+ s;
							Class.forName("com.mysql.jdbc.Driver");
							Connection connection = DriverManager
									.getConnection(
											"jdbc:mysql://localhost:3306/project",
											"root", "wisam");
							Statement statement = connection.createStatement();
							ResultSet select = statement.executeQuery(x);
							while (select.next()) {
								b1.append(select.getString(1));
							}
							connection.close();
							b1.setVisible(true);
						} catch (ClassNotFoundException | SQLException e1) {
							JOptionPane.showMessageDialog(null,
									"ERROR , TRY AGAIN");
						}
					} 

				} else {
					b1.setText("");
					 if (c1.isSelected()) {
						try {
							String x = "SELECT d.PatientName FROM patient d";
							Class.forName("com.mysql.jdbc.Driver");
							Connection connection = DriverManager
									.getConnection(
											"jdbc:mysql://localhost:3306/project",
											"root", "wisam");
							Statement statement = connection.createStatement();
							ResultSet select = statement.executeQuery(x);
							while (select.next()) {
								b1.append("\t" + select.getString(1) + "\n");
							}
							connection.close();
							b1.setVisible(true);
						} catch (ClassNotFoundException | SQLException e1) {
							JOptionPane.showMessageDialog(null,
									"ERROR , TRY AGAIN");
						}
					} else if (c2.isSelected()) {
						try {
							String x = "SELECT d.PatientAddress FROM patient d";
							Class.forName("com.mysql.jdbc.Driver");
							Connection connection = DriverManager
									.getConnection(
											"jdbc:mysql://localhost:3306/project",
											"root", "wisam");
							Statement statement = connection.createStatement();
							ResultSet select = statement.executeQuery(x);
							while (select.next()) {
								b1.append("\t" + select.getString(1) + "\n");
							}
							connection.close();
							b1.setVisible(true);
						} catch (ClassNotFoundException | SQLException e1) {
							JOptionPane.showMessageDialog(null,
									"ERROR , TRY AGAIN");
						}
					} 
				}

			}
		});
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					String sql = "INSERT INTO patient (idPatient , PatientName ,PatientAddress) VALUES (?, ?, ?)";
					PreparedStatement statement = connection
							.prepareStatement(sql);
					statement.setString(1, t6.getText());
					statement.setString(2, t7.getText());
					statement.setString(3, t8.getText());
					statement.execute();
					JOptionPane.showMessageDialog(null, "Done");
					connection.close();
				} catch (Exception e1) {
					JOptionPane
							.showMessageDialog(null,
									"CAN'T ADD THIS PATIENT , CHECK YOUR INPUT DATA , TRY AGAIN");
				}

			}
		});
		update1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					String sql = "UPDATE patient SET PatientName=?, PatientAddress=? WHERE idPatient=?";
					PreparedStatement statement = connection
							.prepareStatement(sql);
					statement.setString(3, ids.getSelectedItem() + "");
					statement.setString(1, t2.getText());
					statement.setString(2, t3.getText());
					statement.execute();
					connection.close();
					JOptionPane.showMessageDialog(null, "Done");
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null, "PATIENT NOT FOUND");
				}

			}
		});

		delete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					String sql = "DELETE from patient  WHERE idPatient=?";
					PreparedStatement statement = connection
							.prepareStatement(sql);
					String x = (String) t5.getSelectedItem();
					statement.setString(1, x);
					statement.execute();
					JOptionPane.showMessageDialog(null,
							"Patient ID = " + x + " Is Deleted");
					connection.close();
				} catch (ClassNotFoundException | SQLException e) {
					JOptionPane.showMessageDialog(null,
							"CAN'T DELETE , ITS A FOREIGN KEY ");
				}
			}
		});

		visible();
	}

	public void visible() {
		patient.setVisible(true);
	}

	public void invisible() {
		patient.setVisible(false);
	}

	public static void main(String[] args) {
		patient d = new patient();
	}

}

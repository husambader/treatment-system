import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class appointment {
	JFrame appointment;
	JPanel p = new JPanel();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel pinsert = new JPanel();
	JPanel pselect = new JPanel();
	JPanel pupdate = new JPanel();
	JPanel pdelete = new JPanel();
	JComboBox<String> docids = new JComboBox<>();
	JComboBox<String> patids = new JComboBox<>();
	JButton table = new JButton("See Table");
	JButton select = new JButton("Select");
	JButton select1 = new JButton("Select");
	JButton update = new JButton("Update");
	JButton insert = new JButton("Insert");
	JButton delete = new JButton("Delete");
	JButton delete1 = new JButton("Delete");
	JButton add = new JButton("Add");
	JButton update1 = new JButton("Update");
	JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();
	JTextField t3 = new JTextField();
	JTextField t4=new JTextField();
	JTextField t5=new JTextField();
	JTextField t6=new JTextField();
	JTextField t7=new JTextField();
	JComboBox<String> updateCombo = new JComboBox<>();
	JComboBox<String> updateCombo1 = new JComboBox<>();
	JComboBox<String> updateCombo2 = new JComboBox<>();
	JComboBox<String> deleteCombo = new JComboBox<>();
	JComboBox<String> selectCombo = new JComboBox<>();
	JButton back = new JButton("Back");
	JButton clear = new JButton("Clear All");
	JButton clear1 = new JButton("Clear All");
	JButton exit = new JButton("Exit");
	JLabel l = new JLabel(" Show All appointment Info ");
	JLabel l1 = new JLabel(" Select appointment ");
	JLabel l2 = new JLabel(" Insert appointment ");
	JLabel l3 = new JLabel("Update appointment ");
	JLabel l4 = new JLabel("Delete appointment ");
	JTextArea b = new JTextArea();
	JTextArea b1 = new JTextArea();
	JRadioButton c1 = new JRadioButton("Patient ID");
	JRadioButton c2=new JRadioButton("Department ID");
	JRadioButton c3=new JRadioButton("appointment Details");
	JRadioButton c4 = new JRadioButton("appointment Date");
	JRadioButton c5 = new JRadioButton("appointment Hour");
	
	public appointment() {

		appointment = new JFrame("appointment");
		appointment.setSize(800, 500);
		appointment.setLayout(new BorderLayout());
		appointment.setResizable(false);
		appointment.setLocation(400, 70);
		p.setBorder(new TitledBorder(""));
		p2.setBorder(new TitledBorder(""));
		l.setBorder(new TitledBorder(""));
		l1.setBorder(new TitledBorder(""));
		l2.setBorder(new TitledBorder(""));
		l3.setBorder(new TitledBorder(""));
		l4.setBorder(new TitledBorder(""));
		appointment.add(p, BorderLayout.NORTH);
		appointment.add(p1);
		appointment.add(p2, BorderLayout.SOUTH);
		p.setLayout(new GridLayout(5, 5,5,5));
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
		
		pinsert.setBorder(new TitledBorder("Add appointment"));
		pinsert.setLayout(new GridLayout(7, 2,5,5));
		pinsert.add(new JLabel("Patient ID"));
		pinsert.add(patids);
		pinsert.add(new JLabel("Doctor ID"));
		pinsert.add(docids);
		pinsert.add(new JLabel("appointment ID"));
		pinsert.add(t1);
		pinsert.add(new JLabel("appointment Details"));
		pinsert.add(t2);
		pinsert.add(new JLabel("appointment Date"));
		pinsert.add(t3);
		pinsert.add(new JLabel("appointment Hour"));
		pinsert.add(t4);
		pinsert.add(add);
		pinsert.add(clear1);
		JPanel ppselect = new JPanel();
		pselect.setLayout(new BorderLayout());
		pselect.add(selectCombo, BorderLayout.NORTH);
		pselect.add(ppselect);
		ppselect.setBorder(new TitledBorder("Choose "));
		ppselect.setLayout(new GridLayout(2, 5,5,5));
		ButtonGroup z=new ButtonGroup();
		z.add(c1);
		z.add(c2);
		z.add(c3);
		z.add(c4);
		z.add(c5);
		ppselect.add(c1);
		ppselect.add(c2);
		ppselect.add(c3);
		ppselect.add(c4);
		ppselect.add(c5);
		ppselect.add(select1);
		selectCombo.setBorder(new TitledBorder("appointment ID"));
		pselect.add(b1, BorderLayout.SOUTH);
		b1.setVisible(false);
		b1.setEditable(false);
		pdelete.setLayout(new FlowLayout());
		pdelete.setBorder(new TitledBorder("Delete appointment"));
		pdelete.add(new JLabel("Select appointment ID"));
		pdelete.add(deleteCombo);
		pdelete.add(delete1);

		pupdate.setBorder(new TitledBorder("Update appointment"));
		pupdate.setLayout(new GridLayout(7, 2,5,5));
		pupdate.add(new JLabel("Patient ID"));
		pupdate.add(updateCombo2);
		pupdate.add(new JLabel("Doctor ID"));
		pupdate.add(updateCombo1);
		pupdate.add(new JLabel("appointment ID"));
		pupdate.add(updateCombo);
		pupdate.add(new JLabel("appointment Details"));
		pupdate.add(t5);
		pupdate.add(new JLabel("appointment Date"));
		pupdate.add(t6);
		pupdate.add(new JLabel("appointment Hour"));
		pupdate.add(t7);
		pupdate.add(clear);
		pupdate.add(update1);

		clear1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
			}
		});

		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t5.setText("");
				t6.setText("");
				t7.setText("");
			}
		});

		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				invisible();
				cover cover=new cover();
			}
		});

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null,
						" Are you sure you want to exit ?", "Exit ", 2) == 0)
					System.exit(0);

			}
		});

		table.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1.removeAll();
				p1.updateUI();
				b.setText("");
				b.setEditable(false);
				try {
					String x = "select *  from appointment";
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					Statement statement = connection.createStatement();
					ResultSet select = statement.executeQuery(x);
					while (select.next())
						b.append("\t" + select.getString(1) + "\t"
								+ select.getString(2) + "\t"
								+ select.getString(3) +"\t"
								+select.getString(4) +"\t"
								+select.getString(5)+"\t"
								+select.getString(6)+"\t\n");
					p1.add(b);
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null,
							"CAN'T CONNECT TO DATEBASE , TRY AGAIN");
				}
			}
		});

		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1.removeAll();
				p1.updateUI();
				p1.add(pinsert);
				docids.removeAllItems();
				try {
					String x = "select d.doctorID  from doctor d ";
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					Statement statement = connection.createStatement();
					ResultSet select = statement.executeQuery(x);
					while (select.next())
						docids.addItem(select.getString(1));
					connection.close();

				} catch (ClassNotFoundException | SQLException e1) {

				}
				patids.removeAllItems();
				try {
					String x = "select d.idPatient  from patient d ";
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					Statement statement = connection.createStatement();
					ResultSet select = statement.executeQuery(x);
					while (select.next())
						patids.addItem(select.getString(1));
					connection.close();
				} catch (ClassNotFoundException | SQLException e2) {
					
				}
			}
		});

		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p1.removeAll();
				p1.updateUI();
				p1.add(pselect);
				selectCombo.removeAllItems();
				try {
					String x = "select d.appointmentID  from appointment d ";
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					Statement statement = connection.createStatement();
					ResultSet select = statement.executeQuery(x);
					while (select.next())
						selectCombo.addItem(select.getString(1));
					selectCombo.addItem("All appointments");
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
				deleteCombo.removeAllItems();
				try {
					String x = "select d.appointmentID from appointment d ";
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					Statement statement = connection.createStatement();
					ResultSet select = statement.executeQuery(x);
					while (select.next())
						deleteCombo.addItem(select.getString(1));
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {

				}
			}
		});

		select1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = (String) selectCombo.getSelectedItem();
				b1.setVisible(true);
				if (!s.equals("All appointments")) {
					b1.setText("");
					if (c1.isSelected()) {
						try {
							b1.setText("");
							String x = "SELECT d.idPatient FROM appointment d where d.appointmentID="
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

						} catch (ClassNotFoundException | SQLException e1) {
							JOptionPane.showMessageDialog(null,
									"ERROR , TRY AGAIN");
						}
					}if (c2.isSelected()) {
						try {
							b1.setText("");
							String x = "SELECT d.doctorID FROM appointment d where d.appointmentID="
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

						} catch (ClassNotFoundException | SQLException e1) {
							JOptionPane.showMessageDialog(null,
									"ERROR , TRY AGAIN");
						}
					}if (c3.isSelected()) {
						try {
							b1.setText("");
							String x = "SELECT d.appointmentDetails FROM appointment d where d.appointmentID="
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

						} catch (ClassNotFoundException | SQLException e1) {
							JOptionPane.showMessageDialog(null,
									"ERROR , TRY AGAIN");
						}
					} 
					else if (c4.isSelected()) {
						try {
							b1.setText("");
							String x = "SELECT d.appointmentDate FROM appointment d where d.appointmentID="
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

						} catch (ClassNotFoundException | SQLException e1) {
							JOptionPane.showMessageDialog(null,
									"ERROR , TRY AGAIN");
						}
					}else if (c5.isSelected()) {
						try {
							b1.setText("");
							String x = "SELECT d.appointmentHour FROM appointment d where d.appointmentID="
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

						} catch (ClassNotFoundException | SQLException e1) {
							JOptionPane.showMessageDialog(null,
									"ERROR , TRY AGAIN");
						}
					}

					

				} else if (c1.isSelected()) {
					try {
						b1.setText("");
						String x = "SELECT d.idPatient FROM appointment d";
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

					} catch (ClassNotFoundException | SQLException e1) {
						JOptionPane.showMessageDialog(null,
								"ERROR , TRY AGAIN");
					}
				}else if (c2.isSelected()) {
					try {
						b1.setText("");
						String x = "SELECT d.doctorID FROM appointment d";
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

					} catch (ClassNotFoundException | SQLException e1) {
						JOptionPane.showMessageDialog(null,
								"ERROR , TRY AGAIN");
					}
				}else if (c3.isSelected()) {
					try {
						b1.setText("");
						String x = "SELECT d.appointmentDetails FROM appointment d";
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

					} catch (ClassNotFoundException | SQLException e1) {
						JOptionPane.showMessageDialog(null,
								"ERROR , TRY AGAIN");
					}
				} 
				else if (c4.isSelected()) {
					try {
						b1.setText("");
						String x = "SELECT d.appointmentDate FROM appointment d";
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

					} catch (ClassNotFoundException | SQLException e1) {
						JOptionPane.showMessageDialog(null,
								"ERROR , TRY AGAIN");
					}
				}else if (c5.isSelected()) {
					try {
						b1.setText("");
						String x = "SELECT d.appointmentHour FROM appointment d";
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

					} catch (ClassNotFoundException | SQLException e1) {
						JOptionPane.showMessageDialog(null,
								"ERROR , TRY AGAIN");
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
					String sql = "INSERT INTO appointment (patientID , doctorID ,appointmentID,appointmentDetails,appointmentDate,appointmentHour) VALUES (?,?,?,?,?,?)";
					PreparedStatement statement = connection
							.prepareStatement(sql);
					statement.setString(1, patids.getSelectedItem()+"");
					statement.setString(2, docids.getSelectedItem()+"");
					statement.setString(3, t1.getText());
					statement.setString(4, t2.getText());
					statement.setString(5, t3.getText());
					statement.setString(6, t4.getText());
					statement.execute();
					JOptionPane.showMessageDialog(null, "done");
					connection.close();
				} catch (Exception e1) {
					JOptionPane
							.showMessageDialog(null,
									"CAN'T ADD THIS appointment , CHECK YOUR INPUT DATA , TRY AGAIN");
				}

			}
		});

		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1.removeAll();
				p1.updateUI();
				p1.add(pupdate);
				updateCombo.removeAllItems();
				try {
					String x = "select d.appointmentID  from appointment d ";
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					Statement statement = connection.createStatement();
					ResultSet select = statement.executeQuery(x);
					while (select.next())
						updateCombo.addItem(select.getString(1));
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {

				}
				updateCombo1.removeAllItems();
				try {
					String x = "select d.doctorID  from doctor d ";
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					Statement statement = connection.createStatement();
					ResultSet select = statement.executeQuery(x);
					while (select.next())
						updateCombo1.addItem(select.getString(1));
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {

				}
				updateCombo2.removeAllItems();
				try {
					String x = "select d.idPatient  from patient d ";
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					Statement statement = connection.createStatement();
					ResultSet select = statement.executeQuery(x);
					while (select.next())
						updateCombo2.addItem(select.getString(1));
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {

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
					String sql = "UPDATE appointment SET patientID=?,doctorID=?,appointmentDetails=?, appointmentDate=?,appointmentHour=? WHERE appointmentID=?";
					PreparedStatement statement = connection
							.prepareStatement(sql);
					statement.setString(1, updateCombo2.getSelectedItem()+"");
					statement.setString(2, updateCombo1.getSelectedItem()+"");
					statement.setString(3, t5.getText());
					statement.setString(4, t6.getText());
					statement.setString(5, t7.getText());
					statement.setString(6, updateCombo.getSelectedItem()+"");

					statement.execute();
					connection.close();
					JOptionPane.showMessageDialog(null, "done");
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null, "PLEASE FILL ALL TEXTS");

				}

			}
		});

		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p1.removeAll();
				p1.updateUI();
				p1.add(pdelete);
				deleteCombo.removeAllItems();
				try {
					String x = "select d.appointmentID  from appointment d ";
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					Statement statement = connection.createStatement();
					ResultSet select = statement.executeQuery(x);
					while (select.next())
						deleteCombo.addItem(select.getString(1));
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {

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
					String sql = "DELETE from appointment  WHERE appointmentID=?";
					PreparedStatement statement = connection
							.prepareStatement(sql);
					String x = (String) deleteCombo.getSelectedItem();
					statement.setString(1, x);
					statement.execute();
					JOptionPane.showMessageDialog(null, "appointment with ID = " + x
							+ " is deleted");
					connection.close();
				} catch (ClassNotFoundException | SQLException e) {
					JOptionPane.showMessageDialog(null,
							"CAN'T DELETE , ITS A FOREIGN KEY ");
				}
			}
		});

		visible();
	}

	public static void main(String[] args) {
		appointment d = new appointment();
	}

	public void visible() {
		appointment.setVisible(true);
	}

	public void invisible() {
		appointment.setVisible(false);
	}

}

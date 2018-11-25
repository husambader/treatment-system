import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class pharmacy {

	JFrame pharmacy;
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
	JTextField id = new JTextField(" ");
	JTextField name = new JTextField(" ");
	JTextField details = new JTextField(" ");
	JTextField price = new JTextField(" ");
	JTextField updateName = new JTextField(" ");
	JTextField updateDetails = new JTextField(" ");
	JTextField updatePrice = new JTextField(" ");
	JComboBox<String> updateCombo = new JComboBox<>();
	JComboBox<String> deleteCombo = new JComboBox<>();
	JComboBox<String> selectCombo = new JComboBox<>();
	JButton back = new JButton("Back");
	JButton clear = new JButton("Clear All");
	JButton clear1 = new JButton("Clear All");
	JButton exit = new JButton("Exit");
	JLabel l = new JLabel(" Show All medication Info ");
	JLabel l1 = new JLabel(" Select medication ");
	JLabel l2 = new JLabel(" Insert medication  ");
	JLabel l3 = new JLabel("Update medication ");
	JLabel l4 = new JLabel("Delete medication ");
	JTextArea b = new JTextArea();
	JTextArea b1 = new JTextArea();
	JRadioButton c = new JRadioButton("medication Name");
	JRadioButton c1 = new JRadioButton("medication Details");
	JRadioButton c2 = new JRadioButton("medication Price");

	public pharmacy() {
		pharmacy = new JFrame("Pharmacy");
		pharmacy.setSize(800, 500);
		pharmacy.setLayout(new BorderLayout());
		pharmacy.setResizable(false);
		pharmacy.setLocation(400, 70);
		p.setBorder(new TitledBorder(""));
		p2.setBorder(new TitledBorder(""));
		l.setBorder(new TitledBorder(""));
		l1.setBorder(new TitledBorder(""));
		l2.setBorder(new TitledBorder(""));
		l3.setBorder(new TitledBorder(""));
		l4.setBorder(new TitledBorder(""));
		pharmacy.add(p, BorderLayout.NORTH);
		pharmacy.add(p1);
		pharmacy.add(p2, BorderLayout.SOUTH);
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

		pinsert.setBorder(new TitledBorder("Add medication"));
		pinsert.setLayout(new GridLayout(5, 2, 5, 5));
		pinsert.add(new JLabel("medication ID"));
		pinsert.add(id);
		pinsert.add(new JLabel("medication Name"));
		pinsert.add(name);
		pinsert.add(new JLabel("medication Details"));
		pinsert.add(details);
		pinsert.add(new JLabel("medication Price"));
		pinsert.add(price);
		pinsert.add(clear1);
		pinsert.add(add);

		JPanel ppselect = new JPanel();
		pselect.setLayout(new BorderLayout());
		pselect.add(selectCombo, BorderLayout.NORTH);
		pselect.add(ppselect);
		ppselect.setBorder(new TitledBorder("Choose"));
		ppselect.setLayout(new GridLayout(1, 5));
		ButtonGroup z = new ButtonGroup();
		z.add(c);
		z.add(c1);
		z.add(c2);
		ppselect.add(c);
		ppselect.add(c1);
		ppselect.add(c2);
		ppselect.add(select1);
		selectCombo.setBorder(new TitledBorder("medication ID"));
		pselect.add(b1, BorderLayout.SOUTH);
		b1.setVisible(false);
		b1.setEditable(false);
		pdelete.setLayout(new FlowLayout());
		pdelete.setBorder(new TitledBorder("Delete medication"));
		pdelete.add(new JLabel("Select medication ID"));
		pdelete.add(deleteCombo);
		pdelete.add(delete1);

		pupdate.setBorder(new TitledBorder("Update medication"));
		pupdate.setLayout(new GridLayout(5, 2,5,5));
		pupdate.add(new JLabel("medication ID"));
		pupdate.add(updateCombo);
		pupdate.add(new JLabel("medication Name"));
		pupdate.add(updateName);
		pupdate.add(new JLabel("medication Details"));
		pupdate.add(updateDetails);
		pupdate.add(new JLabel("medication Price"));
		pupdate.add(updatePrice);

		pupdate.add(clear);
		pupdate.add(update1);

		clear1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				id.setText("");
				name.setText("");
				details.setText("");
				price.setText("");

			}
		});
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateName.setText("");
				updateDetails.setText("");
				updatePrice.setText("");

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
					String x = "select *  from pharmacy";
					Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root","wisam");
					Statement statement = connection.createStatement();
					ResultSet select = statement.executeQuery(x);
					while (select.next())
						b.append("\t" + select.getString(1) + "\t"
								+ select.getString(2) + "\t"
								+ select.getString(3) + "\t"
								+ select.getString(4) + "\t\n");
					p1.add(b);
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null,
							"CAN'T CONNECT TO DATABASE , TRY AGAIN ");
				}
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
					String x = "select d.medicationid  from pharmacy d ";
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					Statement statement = connection.createStatement();
					ResultSet select = statement.executeQuery(x);
					while (select.next())
						selectCombo.addItem(select.getString(1));
					selectCombo.addItem("All medication");
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
					String x = "select d.medicationid  from pharmacy d ";
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
				if (!s.equals("All medication")) {
					b1.setText("");
					if (c.isSelected()) {
						try {
							b1.setText("");
							String x = "SELECT d.medecationname FROM pharmacy d where d.medicationid="
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
					} else if (c1.isSelected()) {
						try {
							b1.setText("");
							String x = "SELECT d.medecationdetails FROM pharmacy d where d.medicationid="
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
					} else if (c2.isSelected()) {
						try {
							b1.setText("");
							String x = "SELECT d.medecationprice FROM pharmacy d where d.medicationid="
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
				} else {
					b1.setText("");

					if (c.isSelected()) {
						try {
							String x = "SELECT d.medecationname FROM pharmacy d";
							Class.forName("com.mysql.jdbc.Driver");
							Connection connection = DriverManager
									.getConnection(
											"jdbc:mysql://localhost:3306/project",
											"root", "wisam");
							Statement statement = connection.createStatement();
							ResultSet select = statement.executeQuery(x);
							while (select.next())
								b1.append("\t" + select.getString(1) + "\n");
							connection.close();
							b1.setVisible(true);
						} catch (ClassNotFoundException | SQLException e1) {
							JOptionPane.showMessageDialog(null,
									"ERROR , TRY AGAIN");
						}
					} else if (c1.isSelected()) {
						try {
							String x = "SELECT d.medecationdetails FROM pharmacy d";
							Class.forName("com.mysql.jdbc.Driver");
							Connection connection = DriverManager
									.getConnection(
											"jdbc:mysql://localhost:3306/project",
											"root", "wisam");
							Statement statement = connection.createStatement();
							ResultSet select = statement.executeQuery(x);
							while (select.next())
								b1.append("\t" + select.getString(1) + "\n");
							connection.close();
							b1.setVisible(true);
						} catch (ClassNotFoundException | SQLException e1) {
							JOptionPane.showMessageDialog(null,
									"ERROR , TRY AGAIN");
						}
					} else if (c2.isSelected()) {
						try {
							String x = "SELECT d.medecationprice FROM pharmacy d";
							Class.forName("com.mysql.jdbc.Driver");
							Connection connection = DriverManager
									.getConnection(
											"jdbc:mysql://localhost:3306/project",
											"root", "wisam");
							Statement statement = connection.createStatement();
							ResultSet select = statement.executeQuery(x);
							while (select.next())
								b1.append("\t" + select.getString(1) + "\n");
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
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root","wisam");
					String sql = "INSERT INTO pharmacy (medicationid , medecationname ,medecationdetails, medecationprice) VALUES (?, ?, ?, ?)";
					PreparedStatement statement = connection
							.prepareStatement(sql);
					statement.setString(1, id.getText());
					statement.setString(2, name.getText());
					statement.setString(3, details.getText());
					statement.setString(4, price.getText());
					statement.execute();
					JOptionPane.showMessageDialog(null, "done");
					connection.close();

				} catch (Exception args) {
					JOptionPane
							.showMessageDialog(null,
									"can not add this medication , check your input data , try again");
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
					String x = "select d.medicationid  from pharmacy d ";
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
			}
		});
		update1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					String sql = "UPDATE pharmacy SET medecationname=?, medecationdetails=?, medecationprice=? WHERE medicationid=?";
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setString(4, updateCombo.getSelectedItem() + "");
					statement.setString(1, updateName.getText());
					statement.setString(2, updateDetails.getText());
					statement.setString(3, updatePrice.getText());
					statement.execute();
					connection.close();
					JOptionPane.showMessageDialog(null, "Done");
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane
							.showMessageDialog(null, "Please fill all texts");

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
					String x = "select d.medicationid  from pharmacy d ";
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
					String sql = "DELETE from pharmacy  WHERE medicationid=?";
					PreparedStatement statement = connection
							.prepareStatement(sql);
					String x = (String) deleteCombo.getSelectedItem();
					statement.setString(1, x);
					statement.execute();
					JOptionPane.showMessageDialog(null, "The Medication ID = " + x
							+ " Is Deleted");
					connection.close();
				} catch (ClassNotFoundException | SQLException e) {
					JOptionPane.showMessageDialog(null,
							"Can't delete , its foreign key ");
				}
			}
		});

		visible();

	}

	public void visible() {
		pharmacy.setVisible(true);
	}
	
	

	public void invisible() {
		pharmacy.setVisible(false);
	}

	public static void main(String[] args) {
		pharmacy d = new pharmacy();
	}

}

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Diagnose {

	JFrame diagonse;
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
	JTextField idtxt = new JTextField();
	JTextField nametxt = new JTextField();
	JTextField detailstxt = new JTextField();
	JTextField pricetxt = new JTextField();
	JTextField updateNametxt = new JTextField();
	JTextField updateDetailstxt = new JTextField();
	JTextField updatePricetxt = new JTextField();
	JComboBox<String> updateCombo = new JComboBox<>();
	// JComboBox<String>updateCombo1=new JComboBox<>();
	JComboBox<String> deleteCombo = new JComboBox<>();
	JComboBox<String> selectCombo = new JComboBox<>();
	JButton back = new JButton("Back");
	JButton clear = new JButton("Clear All");
	JButton clear1 = new JButton("Clear All");
	JButton exit = new JButton("Exit");
	JLabel l = new JLabel(" Show All Diagonse Info ");
	JLabel l1 = new JLabel(" Select Diagonse ");
	JLabel l2 = new JLabel(" Insert Diagonse  ");
	JLabel l3 = new JLabel("Update Diagonse ");
	JLabel l4 = new JLabel("Delete Diagonse ");
	JTextArea b = new JTextArea();
	JTextArea b1 = new JTextArea();
	JRadioButton c = new JRadioButton("Diagonse Type");
	JRadioButton c1 = new JRadioButton("Diagonse Details");
	JRadioButton c2 = new JRadioButton("Diagonse Price");

	public Diagnose() {
		diagonse = new JFrame("Diagonse");
		diagonse.setSize(800, 500);
		diagonse.setLayout(new BorderLayout());
		diagonse.setResizable(false);
		diagonse.setLocation(400, 70);
		p.setBorder(new TitledBorder(""));
		p2.setBorder(new TitledBorder(""));
		l.setBorder(new TitledBorder(""));
		l1.setBorder(new TitledBorder(""));
		l2.setBorder(new TitledBorder(""));
		l3.setBorder(new TitledBorder(""));
		l4.setBorder(new TitledBorder(""));
		diagonse.add(p, BorderLayout.NORTH);
		diagonse.add(p1);
		diagonse.add(p2, BorderLayout.SOUTH);
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

		pinsert.setBorder(new TitledBorder("Add Diagonse"));
		pinsert.setLayout(new GridLayout(5, 2, 5, 5));
		pinsert.add(new JLabel("Diagonse ID"));
		pinsert.add(idtxt);
		pinsert.add(new JLabel("Diagonse Name"));
		pinsert.add(nametxt);
		pinsert.add(new JLabel("Diagonse Details"));
		pinsert.add(detailstxt);
		pinsert.add(new JLabel("Diagonse Price"));
		pinsert.add(pricetxt);
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
		selectCombo.setBorder(new TitledBorder("Diagonse ID"));
		pselect.add(b1, BorderLayout.SOUTH);
		b1.setVisible(false);
		b1.setEditable(false);
		pdelete.setLayout(new FlowLayout());
		pdelete.setBorder(new TitledBorder("Delete Diagonse"));
		pdelete.add(new JLabel("Select Diagonse ID"));
		pdelete.add(deleteCombo);
		pdelete.add(delete1);
		pupdate.setBorder(new TitledBorder("Update Diagonse"));
		pupdate.setLayout(new GridLayout(5, 2,5,5));
		pupdate.add(new JLabel("Diagonse ID"));
		pupdate.add(updateCombo);
		pupdate.add(new JLabel("Diagonse Name"));
		pupdate.add(updateNametxt);
		pupdate.add(new JLabel("Diagonse Details"));
		pupdate.add(updateDetailstxt);
		pupdate.add(new JLabel("Diagonse Price"));
		pupdate.add(updatePricetxt);
		pupdate.add(clear);
		pupdate.add(update1);

		clear1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				idtxt.setText("");
				nametxt.setText("");
				detailstxt.setText("");
				pricetxt.setText("");

			}
		});
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateNametxt.setText("");
				updateDetailstxt.setText("");
				updatePricetxt.setText("");

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
					String x = "select *  from diagnose";
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					Statement statement = connection.createStatement();
					ResultSet select = statement.executeQuery(x);
					while (select.next())
						b.append("\t" + select.getString(1) + "\t"
								+ select.getString(2) + "\t"
								+ select.getString(3) + "\t"
								+ select.getString(4)+ "\t\n");
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
				ids.removeAllItems();
				try {
					String x = "select d.idDiagnose  from diagnose d ";
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

		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p1.removeAll();
				p1.updateUI();
				p1.add(pselect);
				selectCombo.removeAllItems();
				try {
					String x = "select d.idDiagnose  from diagnose d ";
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					Statement statement = connection.createStatement();
					ResultSet select = statement.executeQuery(x);
					while (select.next())
						selectCombo.addItem(select.getString(1));
					selectCombo.addItem("All Diagnose");
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
					String x = "select d.idDiagnose  from diagnose d ";
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
				if (!s.equals("All Diagnose")) {
					b1.setText("");
					if (c.isSelected()) {
						try {
							b1.setText("");
							String x = "SELECT d.DiagnoseType FROM diagnose d where d.idDiagnose="
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
							String x = "SELECT d.DiagnoseDetails FROM diagnose d where d.idDiagnose="
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
							String x = "SELECT d.DiagnosePrice FROM diagnose d where d.idDiagnose="
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
							String x = "SELECT d.DiagnoseType FROM diagnose d";
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
							String x = "SELECT d.DiagnoseDetails FROM diagnose d";
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
							String x = "SELECT d.DiagnosePrice FROM diagnose d";
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
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					String sql = "INSERT INTO diagnose (idDiagnose , DiagnoseType , DiagnoseDetails , DiagnosePrice) VALUES (? , ? , ? , ?)";
					PreparedStatement statement = connection
							.prepareStatement(sql);
					statement.setString(1, idtxt.getText());
					statement.setString(2, nametxt.getText());
					statement.setString(3, detailstxt.getText());
					statement.setString(4, pricetxt.getText());
					statement.execute();
					JOptionPane.showMessageDialog(null, "done");
					connection.close();

				} catch (Exception e1) {
					JOptionPane
							.showMessageDialog(null,
									"can not add this diagnose, check your input data , try again");
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
					String x = "select d.idDiagnose  from diagnose d ";
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
				ids.removeAllItems();
				try {
					String x = "select d.idDiagnose  from diagnose d ";
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
		update1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					String sql = "UPDATE diagnose SET DiagnoseType=?, DiagnoseDetails=?, DiagnosePrice=?  WHERE idDiagnose=?";
					PreparedStatement statement = connection
							.prepareStatement(sql);
					statement.setString(4, updateCombo.getSelectedItem() + "");
					statement.setString(1, updateNametxt.getText());
					statement.setString(2, updateDetailstxt.getText());
					statement.setString(3, updatePricetxt.getText());

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
					String x = "select d.idDiagnose  from diagnose d ";
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
					String sql = "DELETE from diagnose  WHERE idDiagnose=?";
					PreparedStatement statement = connection
							.prepareStatement(sql);
					String x = (String) deleteCombo.getSelectedItem();
					statement.setString(1, x);
					statement.execute();
					JOptionPane.showMessageDialog(null, "The Diagnose ID = " + x
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
		diagonse.setVisible(true);
	}

	public void invisible() {
		diagonse.setVisible(false);
	}

	public static void main(String[] args) {
		Diagnose d = new Diagnose();
	}

}

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class test {

	JFrame test;
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
	JLabel l = new JLabel(" Show All Test Info ");
	JLabel l1 = new JLabel(" Select Test ");
	JLabel l2 = new JLabel(" Insert Test  ");
	JLabel l3 = new JLabel("Update Test ");
	JLabel l4 = new JLabel("Delete Test ");
	JTextArea b = new JTextArea();
	JTextArea b1 = new JTextArea();
	JRadioButton c = new JRadioButton("Test Name");
	JRadioButton c1 = new JRadioButton("Test Details");
	JRadioButton c2 = new JRadioButton("Test Price");

	public test() {
		test = new JFrame("Test");
		test.setSize(800, 500);
		test.setLayout(new BorderLayout());
		test.setResizable(false);
		test.setLocation(400, 70);
		p.setBorder(new TitledBorder(""));
		p2.setBorder(new TitledBorder(""));
		l.setBorder(new TitledBorder(""));
		l1.setBorder(new TitledBorder(""));
		l2.setBorder(new TitledBorder(""));
		l3.setBorder(new TitledBorder(""));
		l4.setBorder(new TitledBorder(""));
		test.add(p, BorderLayout.NORTH);
		test.add(p1);
		test.add(p2, BorderLayout.SOUTH);
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

		pinsert.setBorder(new TitledBorder("Add Test"));
		pinsert.setLayout(new GridLayout(5, 2, 5, 5));
		pinsert.add(new JLabel("Test ID"));
		pinsert.add(idtxt);
		pinsert.add(new JLabel("Test Name"));
		pinsert.add(nametxt);
		pinsert.add(new JLabel("Test Details"));
		pinsert.add(detailstxt);
		pinsert.add(new JLabel("Test Price"));
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
		selectCombo.setBorder(new TitledBorder("Test ID"));
		pselect.add(b1, BorderLayout.SOUTH);
		b1.setVisible(false);
		b1.setEditable(false);
		pdelete.setLayout(new FlowLayout());
		pdelete.setBorder(new TitledBorder("Delete Test"));
		pdelete.add(new JLabel("Select Test ID"));
		pdelete.add(deleteCombo);
		pdelete.add(delete1);
		pupdate.setBorder(new TitledBorder("Update Test"));
		pupdate.setLayout(new GridLayout(5, 2,5,5));
		pupdate.add(new JLabel("Test ID"));
		pupdate.add(updateCombo);
		pupdate.add(new JLabel("Test Name"));
		pupdate.add(updateNametxt);
		pupdate.add(new JLabel("Test Details"));
		pupdate.add(updateDetailstxt);
		pupdate.add(new JLabel("Test Price"));
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
					String x = "select *  from test";
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
					String x = "select d.testId  from test d ";
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
					String x = "select d.testId  from test d ";
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					Statement statement = connection.createStatement();
					ResultSet select = statement.executeQuery(x);
					while (select.next())
						selectCombo.addItem(select.getString(1));
					selectCombo.addItem("All Tests");
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
					String x = "select d.testId  from test d ";
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
				if (!s.equals("All Tests")) {
					b1.setText("");
					if (c.isSelected()) {
						try {
							b1.setText("");
							String x = "SELECT d.testName FROM test d where d.testId="
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
							String x = "SELECT d.testDetail FROM test d where d.testId="
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
							String x = "SELECT d.testPrice FROM test d where d.testId="
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
							String x = "SELECT d.testName FROM test d";
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
							String x = "SELECT d.testDetail FROM test d";
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
							String x = "SELECT d.testPrice FROM test d";
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
					String sql = "INSERT INTO test (testId , testName , testDetail , testPrice) VALUES (? , ? , ? , ?)";
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
									"can not add this test, check your input data , try again");
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
					String x = "select d.testId  from test d ";
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
					String x = "select d.testId  from test d ";
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
					String sql = "UPDATE test SET testName=?, testDetail=?, testPrice=?  WHERE testId=?";
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
					String x = "select d.testId  from test d ";
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
					String sql = "DELETE from test  WHERE testId=?";
					PreparedStatement statement = connection
							.prepareStatement(sql);
					String x = (String) deleteCombo.getSelectedItem();
					statement.setString(1, x);
					statement.execute();
					JOptionPane.showMessageDialog(null, "The Test ID = " + x
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
		test.setVisible(true);
	}

	public void invisible() {
		test.setVisible(false);
	}

	public static void main(String[] args) {
		test d = new test();
	}

}

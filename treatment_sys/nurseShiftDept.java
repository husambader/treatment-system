import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class nurseShiftDept {
	JFrame appdiagnose;
	JPanel p = new JPanel();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel pinsert = new JPanel();
	JPanel pselect = new JPanel();
	JPanel pupdate = new JPanel();
	JPanel pdelete = new JPanel();
	JButton table = new JButton("see table");
	JButton select = new JButton("select");
	JButton select1 = new JButton("select");
	// JButton update=new JButton("update");
	JButton insert = new JButton("insert");
	JButton delete = new JButton("delete");
	JButton delete1 = new JButton("delete");
	JButton add = new JButton("add");
	JButton update1 = new JButton("update");
	JComboBox<String> insertCombo = new JComboBox<>();
	JComboBox<String> insertCombo1 = new JComboBox<>();
	JComboBox<String> insertCombo2 = new JComboBox<>();

	JComboBox<String> updateCombo = new JComboBox<>();
	JComboBox<String> updateCombo1 = new JComboBox<>();
	JComboBox<String> updateCombo2 = new JComboBox<>();

	JComboBox<String> deleteCombo = new JComboBox<>();
	JComboBox<String> deleteCombo1 = new JComboBox<>();
	JComboBox<String> deleteCombo2 = new JComboBox<>();

	JComboBox<String> selectCombo = new JComboBox<>();

	JButton back = new JButton("Back");
	JButton exit = new JButton("Exit");
	JLabel l = new JLabel(" show all Nurse - Shift - Department  ");
	JLabel l1 = new JLabel(" select Nurse - Shift - Department ");
	JLabel l2 = new JLabel(" insert Nurse - Shift - Department ");
	JLabel l3 = new JLabel("update Nurse - Shift - Department");
	JLabel l4 = new JLabel("delete Nurse - Shift - Department ");
	JTextArea b = new JTextArea();
	JTextArea b1 = new JTextArea();

	public nurseShiftDept() {

		appdiagnose = new JFrame("Nurse - Shift - Department");
		appdiagnose.setSize(800, 500);
		appdiagnose.setLayout(new BorderLayout());
		appdiagnose.setResizable(false);
		appdiagnose.setLocation(400, 70);
		p.setBorder(new TitledBorder(""));
		p2.setBorder(new TitledBorder(""));
		l.setBorder(new TitledBorder(""));
		l1.setBorder(new TitledBorder(""));
		l2.setBorder(new TitledBorder(""));
		l3.setBorder(new TitledBorder(""));
		l4.setBorder(new TitledBorder(""));
		appdiagnose.add(p, BorderLayout.NORTH);
		appdiagnose.add(p1);
		appdiagnose.add(p2, BorderLayout.SOUTH);
		p.setLayout(new GridLayout(4, 5, 5, 5));
		p.add(l);
		p.add(table);
		p.add(l1);
		p.add(select);
		p.add(l2);
		p.add(insert);
		// p.add(l3);
		// p.add(update);
		p.add(l4);
		p.add(delete);

		p2.setLayout(new FlowLayout());
		p2.add(back);
		p2.add(exit);

		pinsert.setBorder(new TitledBorder("add Nurse - Shift - Department"));
		pinsert.setLayout(new GridLayout(4, 2));
		pinsert.add(new JLabel("Nurse ID"));
		pinsert.add(insertCombo);
		pinsert.add(new JLabel("Shift ID"));
		pinsert.add(insertCombo1);
		pinsert.add(new JLabel("Department ID"));
		pinsert.add(insertCombo2);
		pinsert.add(add);

		JPanel ppselect = new JPanel();
		pselect.setLayout(new GridLayout(5, 5));
		pselect.add(new JLabel("Nurse - Shift - Department ID"));
		pselect.add(selectCombo);
		pselect.add(ppselect);
		ppselect.add(select1);

		pselect.add(b1, BorderLayout.SOUTH);
		b1.setVisible(false);
		b1.setEditable(false);

		pdelete.setLayout(new GridLayout(5, 5));
		pdelete.setBorder(new TitledBorder("delete Nurse - Shift - Department"));
		pdelete.add(new JLabel("select Nurse ID"));
		pdelete.add(deleteCombo);
		pdelete.add(new JLabel("select  Shift ID"));
		pdelete.add(deleteCombo1);
		pdelete.add(new JLabel("Select Department ID"));
		pdelete.add(deleteCombo2);
		pdelete.add(delete1);

		pupdate.setBorder(new TitledBorder("update Appointment - diagnose"));
		pupdate.setLayout(new GridLayout(5, 5));
		pupdate.add(new JLabel("Appointment ID"));
		pupdate.add(updateCombo);
		pupdate.add(new JLabel("diagnose ID"));
		pupdate.add(updateCombo1);
		pupdate.add(new JLabel("new diagnose ID"));
		pupdate.add(updateCombo2);
		pupdate.add(update1);

		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				invisible();
				cover cover = new cover();

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
					String x = "select *  from nurseshiftdept";
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					Statement statement = connection.createStatement();
					ResultSet select = statement.executeQuery(x);
					while (select.next())
						b.append("\t" + select.getString(1) + "\t"
								+ select.getString(2) + "\t"
								+ select.getString(3)+"\t\n");
					p1.add(b);
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null,
							"can not connect to data base , try again ");
				}
			}
		});

		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1.removeAll();
				p1.updateUI();
				p1.add(pinsert);
				insertCombo.removeAllItems();
				insertCombo1.removeAllItems();
				insertCombo2.removeAllItems();
				try {
					String x = "select distinct d.NID from nurse d";
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					Statement statement = connection.createStatement();
					ResultSet select = statement.executeQuery(x);
					while (select.next())
						insertCombo.addItem(select.getString(1));

					String y = "select distinct d.ShiftNO from shift d";
					ResultSet select1 = statement.executeQuery(y);

					while (select1.next()) {
						insertCombo1.addItem(select1.getString(1));
					}

					String n= "select distinct d.DepartmentId from department d";
					ResultSet select2 = statement.executeQuery(n);

					while (select2.next()) {
						insertCombo2.addItem(select2.getString(1));
					}
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null, "");
				}
			}
		});

		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p1.removeAll();
				p1.updateUI();
				p1.add(pdelete);
				deleteCombo.removeAllItems();
				deleteCombo1.removeAllItems();
				deleteCombo2.removeAllItems();
				try {
					String x = "select distinct d.NID from nurseshiftdept d";
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					Statement statement = connection.createStatement();
					ResultSet select = statement.executeQuery(x);
					while (select.next())
						deleteCombo.addItem(select.getString(1));

					String y = "select distinct d.ShiftNo from nurseshiftdept d";
					ResultSet select1 = statement.executeQuery(y);

					while (select1.next()) {
						deleteCombo1.addItem(select1.getString(1));
					}

					String n = "select distinct d.DepartmentID from nurseshiftdept d";
					ResultSet select2 = statement.executeQuery(n);

					while (select2.next()) {
						deleteCombo2.addItem(select2.getString(1));
					}
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null, "");
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
					String x = "select  distinct d.NID  from nurseshiftdept d ";
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					Statement statement = connection.createStatement();
					ResultSet select = statement.executeQuery(x);
					while (select.next())
						selectCombo.addItem(select.getString(1));
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {

				}
			}
		});
		select1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = (String) selectCombo.getSelectedItem();
				b1.setVisible(true);
				try {
					b1.setText("");
					String x = "SELECT  d.ShiftNo FROM nurseshiftdept d where d.NID="
							+ s;
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					Statement statement = connection.createStatement();
					ResultSet select = statement.executeQuery(x);
					String z = "SELECT  d.DepartmentID FROM nurseshiftdept d where d.NID="
							+ s;
					Statement statement1 = connection.createStatement();
					ResultSet select2 = statement1.executeQuery(z);
					while (select.next() && select2.next())
						b1.append(select.getString(1) + "\t"
								+ select2.getString(1) + "\n");

					connection.close();

				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null, "error , try again");

				}

			}
		});
		delete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String x = (String) deleteCombo.getSelectedItem();
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/project", "root",
							"wisam");
					String sql = "DELETE from nurseshiftdept  WHERE  NID=? and ShiftNo=? and DepartmentID=? ";
					PreparedStatement statement = connection
							.prepareStatement(sql);
					statement.setString(1, x);
					statement.setString(2, deleteCombo1.getSelectedItem() + "");
					statement.setString(3, deleteCombo2.getSelectedItem() + "");

					statement.execute();
					JOptionPane.showMessageDialog(null, "done");
					connection.close();
				} catch (ClassNotFoundException | SQLException e) {
					JOptionPane.showMessageDialog(null,
							"can not delete  ");
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
					String sql = "INSERT INTO nurseshiftdept (NID ,ShiftNo, DepartmentID ) VALUES (?,?,?)";
					PreparedStatement statement = connection
							.prepareStatement(sql);
					statement.setString(1, insertCombo.getSelectedItem() + "");
					statement.setString(2, insertCombo1.getSelectedItem() + "");
					statement.setString(3, insertCombo2.getSelectedItem() + "");

					statement.execute();
					JOptionPane.showMessageDialog(null, "done");
					connection.close();
				} catch (Exception e1) {
					JOptionPane
							.showMessageDialog(null,
									"can not add this nurse shift department , check your input data , try again");
				}

			}
		});
		/*
		 * update.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { p1.removeAll(); p1.updateUI();
		 * p1.add(pupdate); updateCombo.removeAllItems(); try { String
		 * x="select distinct d.appointmentid from appointmentdiagnose d";
		 * Class.forName("com.mysql.jdbc.Driver"); Connection connection =
		 * DriverManager
		 * .getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
		 * Statement statement = connection.createStatement(); ResultSet select
		 * = statement.executeQuery(x); while(select.next())
		 * updateCombo.addItem(select.getString(1));
		 * 
		 * String y="select distinct d.diagnoseid from appointmentdiagnose d";
		 * ResultSet select1=statement.executeQuery(y);
		 * 
		 * while (select1.next()) { updateCombo1.addItem(select1.getString(1));
		 * }
		 * 
		 * String z="select distinct d.diagnoseid from appointmentdiagnose d";
		 * ResultSet select2=statement.executeQuery(z);
		 * 
		 * while (select2.next()) { updateCombo2.addItem(select2.getString(1));
		 * }
		 * 
		 * connection.close(); } catch (ClassNotFoundException | SQLException
		 * e1) {
		 * 
		 * }
		 * 
		 * } });
		 * 
		 * 
		 * update1.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { try {
		 * Class.forName("com.mysql.jdbc.Driver"); Connection connection =
		 * DriverManager
		 * .getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
		 * String sql =
		 * "UPDATE appointmentdiagnose SET diagnoseid=? WHERE diagnoseid=? and appointmentid=?"
		 * ; PreparedStatement statement= connection.prepareStatement(sql);
		 * statement.setString(3, updateCombo.getSelectedItem()+"");
		 * statement.setString(1,updateCombo1.getSelectedItem()+"");
		 * statement.setString(2,updateCombo2.getSelectedItem()+"");
		 * statement.execute(); connection.close();
		 * JOptionPane.showMessageDialog(null,"done"); } catch
		 * (ClassNotFoundException | SQLException e1){
		 * JOptionPane.showMessageDialog(null,"can not add");
		 * 
		 * }
		 * 
		 * } });
		 */

		visible();
	}

	public static void main(String[] args) {
		nurseShiftDept appdiagnose = new nurseShiftDept();
	}

	public void visible() {
		appdiagnose.setVisible(true);
	}

	public void invisible() {
		appdiagnose.setVisible(false);
	}
}
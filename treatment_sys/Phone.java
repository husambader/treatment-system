import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Phone {
	
	JFrame phone;
	 JPanel p=new JPanel();
	 JPanel p1=new JPanel();
	 JPanel p2=new JPanel();
	 JPanel pinsert=new JPanel();
	 JPanel pselect=new JPanel();
	 JPanel pdelete=new JPanel();
	 JButton table=new JButton("see table");
	 JButton select=new JButton("select");
	 JButton select1=new JButton("select");
	 JButton insert=new JButton("insert");
	 JButton delete=new JButton("delete");
	 JButton delete1=new JButton("delete");
	 JButton back=new JButton("Back");
		JButton clear=new JButton("clear all");
		JButton clear1=new JButton("clear all");
		JButton exit=new JButton("Exit");
	 JButton add=new JButton("add");
	 JComboBox<String>selectCombo=new JComboBox<>();
	 JComboBox<String>addcombo=new JComboBox<>();
	 JComboBox<String>deletecombo=new JComboBox<>();
	 JTextField t1=new JTextField(" ");
	 JTextField t2=new JTextField(" ");
	 JLabel l=new JLabel(" show all phones info ");
	 JLabel l1=new JLabel(" select phone ");
	 JLabel l2=new JLabel(" insert phone  ");
	 JLabel l4=new JLabel("delete phone ");
	 JTextArea b=new  JTextArea();
	 JTextArea b1=new  JTextArea();
		
		public Phone(){
			 phone =new JFrame("phone");
			 phone.setSize(800, 500);
			 phone.setLayout(new BorderLayout());
			 phone.setResizable(false);
			 phone.setLocation(400, 70);
			 p.setBorder(new TitledBorder(""));
			 p2.setBorder(new TitledBorder(""));
			l.setBorder(new TitledBorder(""));
			l1.setBorder(new TitledBorder(""));
			l2.setBorder(new TitledBorder(""));
			l4.setBorder(new TitledBorder(""));
			 phone.add(p,BorderLayout.NORTH);
			 phone.add(p1);
			 phone.add(p2,BorderLayout.SOUTH);
			 p.setLayout(new GridLayout(5,5));
			 p.add(l);
			 p.add(table);
			 p.add(l1);
			 p.add(select);
			 p.add(l2);
			 p.add(insert);
			 p.add(l4);
			 p.add(delete);
			 
			 p2.setLayout(new FlowLayout());
			 p2.add(back);
			 p2.add(exit);
		
			 JPanel ppinsert=new JPanel();
			 pinsert.setBorder(new TitledBorder("add person / department"));
			 pinsert.setLayout(new GridLayout(5,5));
			 pinsert.add(new JLabel("person / department ID"));
			 pinsert.add(addcombo);
			 pinsert.add(new JLabel("phone number"));
			 pinsert.add(t1);
			 pinsert.add(clear1);
			 pinsert.add(add);
			 JPanel ppselect=new JPanel();
			 pselect.setLayout(new BorderLayout());
			 pselect.add(selectCombo,BorderLayout.NORTH);
			 pselect.add(ppselect);
			 ppselect.setBorder(new TitledBorder(""));
			 ppselect.setLayout(new GridLayout(1,4));
			 ppselect.add(select1);
			 selectCombo.setBorder(new TitledBorder(" ID"));
			pselect.add(b1,BorderLayout.SOUTH);
			b1.setVisible(false);
			b1.setEditable(false);
				
				
				pdelete.setLayout(new FlowLayout());
				pdelete.setBorder(new TitledBorder(""));
				pdelete.add(new JLabel("select person / department ID"));
				pdelete.add(deletecombo);
				pdelete.add(delete1);
				
				
				 
				 clear.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							t2.setText("");
							
						}
					});
					clear1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							t1.setText("");	
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
									String x="select *  from phone";
									Class.forName("com.mysql.jdbc.Driver");
								    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
								    Statement statement = connection.createStatement();
								    ResultSet select = statement.executeQuery(x);
										while(select.next())
										b.append("\t"+select.getString(2)+"\t"+select.getString(1)+"\t\n");
										p1.add(b);
								    connection.close();			
								    }
								catch (ClassNotFoundException | SQLException e1) {
								JOptionPane.showMessageDialog(null,"can not connect to data base , try again ");
								}
							}
						});
						 exit.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if(JOptionPane.showConfirmDialog(null, " Are you sure you want to exit ?", "Exit ", 2)==0)
									System.exit(0);
								
							}
						});
						 insert.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								p1.removeAll();
								p1.updateUI();
								p1.add(pinsert);
								addcombo.removeAllItems();
								try {
									String x="select d.departmentid  from  department d";
									Class.forName("com.mysql.jdbc.Driver");
								    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
								    Statement statement = connection.createStatement();
								    ResultSet select = statement.executeQuery(x);
										while(select.next())
										addcombo.addItem("1"+select.getString(1));
										
										String y="select d.doctorid  from doctor d ";
										ResultSet select1=statement.executeQuery(y);
										while(select1.next())
											addcombo.addItem("2"+select1.getString(1));
										
										String v="select d.nid  from nurse d ";
										ResultSet select2=statement.executeQuery(v);
										while(select2.next())
											addcombo.addItem("3"+select2.getString(1));
										
										String p="select d.idpatient  from patient d ";
										ResultSet select3=statement.executeQuery(p);
										while(select3.next())
											addcombo.addItem("4"+select3.getString(1));
								    connection.close();			
								    }
								catch (ClassNotFoundException | SQLException e1) {
									
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
										String x="select d.idperson  from phone d ";
										Class.forName("com.mysql.jdbc.Driver");
									    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
									    Statement statement = connection.createStatement();
									    ResultSet select = statement.executeQuery(x);
											while(select.next())
											selectCombo.addItem(select.getString(1));
									    connection.close();			
									    }
									catch (ClassNotFoundException | SQLException e1) {
										
										}
								}
							});
						 
						 delete.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									p1.removeAll();
									p1.updateUI();
									p1.add(pdelete);
									deletecombo.removeAllItems();
									try {
										String x="select d.idperson  from phone d ";
										Class.forName("com.mysql.jdbc.Driver");
									    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
									    Statement statement = connection.createStatement();
									    ResultSet select = statement.executeQuery(x);
											while(select.next())
											deletecombo.addItem(select.getString(1));
									    connection.close();			
									    }
									catch (ClassNotFoundException | SQLException e1) {
										
										}
								}
							});
						 
						 
						 select1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
									try {
											String s=(String) selectCombo.getSelectedItem();
										b1.setText("");
										String x="SELECT d.phonenumber FROM phone d where d.idperson="+s;
										Class.forName("com.mysql.jdbc.Driver");
									    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
									    Statement statement = connection.createStatement();
									    ResultSet select = statement.executeQuery(x);
											while(select.next())
												b1.append(select.getString(1)+"\n");						
											connection.close();	
									  b1.setVisible(true);
									    }
									catch (ClassNotFoundException | SQLException e1) {
									JOptionPane.showMessageDialog(null,"error , try again");
									}
								}
								
							
						});
						 
						 add.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									try {
										 Class.forName("com.mysql.jdbc.Driver");
										Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
										String sql = "INSERT INTO phone (phonenumber , idperson ) VALUES (?, ?)";
										PreparedStatement statement = connection.prepareStatement(sql);
										statement.setString(2, addcombo.getSelectedItem()+"");
										statement.setString(1, t1.getText());
										statement.execute();
									    JOptionPane.showMessageDialog(null, "done");
									    connection.close();	
									} catch (Exception e1) {
										JOptionPane.showMessageDialog(null, "can not add this phone number, check your input data , try again");
									}
								
								}
							});
						
						
						 delete1.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									try {
									    Class.forName("com.mysql.jdbc.Driver");
										Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
										String sql = "DELETE from phone  WHERE idperson=?";
										PreparedStatement statement = connection.prepareStatement(sql);
										String x=(String) deletecombo.getSelectedItem();
										statement.setString(1,x );
										statement.execute();
									    JOptionPane.showMessageDialog(null, "the  # where   id = "+x+ " is deleted");
									    connection.close();			
									    }
									catch (ClassNotFoundException | SQLException e) {
									JOptionPane.showMessageDialog(null,"can not delete , its foreign key ");
									}
								}
							});
							 
						 
						 visible(); 
			 
		}
		public static void main(String[] args) {
			Phone phone=new Phone();
		}
		
		public void visible(){
			phone.setVisible(true);
		}
		
public void invisible(){
			phone.setVisible(false);
		}

}

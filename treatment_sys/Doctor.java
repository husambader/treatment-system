import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Doctor {
	
	JFrame doctor;
	 JPanel p=new JPanel();
	 JPanel p1=new JPanel();
	 JPanel p2=new JPanel();
	 JPanel pinsert=new JPanel();
	 JPanel pselect=new JPanel();
	 JPanel pupdate=new JPanel();
	 JPanel pdelete=new JPanel();
	 JComboBox<String> ids=new JComboBox<>();
	JButton table=new JButton("see table");
	JButton select=new JButton("select");
	JButton select1=new JButton("select");
	JButton update=new JButton("update");
	JButton insert=new JButton("insert");
	JButton delete=new JButton("delete");
	JButton delete1=new JButton("delete");
	JButton add=new JButton("add");
	JButton update1=new JButton("update");
	JTextField t1=new JTextField(" ");
	JTextField t2=new JTextField(" ");
	JTextField t3=new JTextField(" ");
	JTextField t4=new JTextField(" ");
	JTextField t6=new JTextField(" ");
	JTextField t7=new JTextField(" ");
	JTextField t8=new JTextField(" ");
	//JTextField t9=new JTextField(" ");
	JComboBox<String>updateCombo=new JComboBox<>();
	JComboBox<String>updateCombo1=new JComboBox<>();
	JComboBox<String>deleteCombo=new JComboBox<>();
	JComboBox<String>selectCombo=new JComboBox<>();
	JButton back=new JButton("Back");
	JButton clear=new JButton("clear all");
	JButton clear1=new JButton("clear all");
	JButton exit=new JButton("Exit");
	JLabel l=new JLabel(" show all doctor info ");
	JLabel l1=new JLabel(" select doctor ");
	JLabel l2=new JLabel(" insert doctor  ");
	JLabel l3=new JLabel("update doctor ");
	JLabel l4=new JLabel("delete doctor ");
	JTextArea b=new  JTextArea();
	JTextArea b1=new  JTextArea();
	JCheckBox c1=new JCheckBox("Doctor Name");
	JCheckBox c2=new JCheckBox("Work Hours");
	JCheckBox c3=new JCheckBox("HireDate");
	JCheckBox c4=new JCheckBox("department ID");
	
	
	public Doctor() {
		 doctor =new JFrame("Doctor");
		 doctor.setSize(800, 500);
		 doctor.setLayout(new BorderLayout());
		 doctor.setResizable(false);
		 doctor.setLocation(400, 70);
		 p.setBorder(new TitledBorder(""));
		 p2.setBorder(new TitledBorder(""));
		l.setBorder(new TitledBorder(""));
		l1.setBorder(new TitledBorder(""));
		l2.setBorder(new TitledBorder(""));
		l3.setBorder(new TitledBorder(""));
		l4.setBorder(new TitledBorder(""));
		doctor.add(p,BorderLayout.NORTH);
		doctor.add(p1);
		doctor.add(p2,BorderLayout.SOUTH);
		 p.setLayout(new GridLayout(5,5));
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
	
		 JPanel ppinsert=new JPanel();
		 pinsert.setBorder(new TitledBorder("add Doctor"));
		 pinsert.setLayout(new GridLayout(6,2));
		 pinsert.add(new JLabel("Doctor ID"));
		 pinsert.add(t1);
		 pinsert.add(new JLabel("Doctor Name"));
		 pinsert.add(t2);
		 pinsert.add(new JLabel("Work Hours"));
		 pinsert.add(t3);
		 pinsert.add(new JLabel("Hire Date"));
		 pinsert.add(t4);
		 pinsert.add(new JLabel("Department ID"));
		 pinsert.add(ids);
		 pinsert.add(clear1);
		 pinsert.add(add);
		 
		 
		 
		 JPanel ppselect=new JPanel();
		 pselect.setLayout(new BorderLayout());
		 pselect.add(selectCombo,BorderLayout.NORTH);
		 pselect.add(ppselect);
		 ppselect.setBorder(new TitledBorder("choose "));
		 ppselect.setLayout(new GridLayout(1,4));
		 ButtonGroup z = new ButtonGroup();
			z.add(c1);
			z.add(c2);
			z.add(c3);
			z.add(c4);
		 ppselect.add(c1);
		 ppselect.add(c2);
		 ppselect.add(c3);
		 ppselect.add(c4);
		 ppselect.add(select1);
		 selectCombo.setBorder(new TitledBorder("Doctor ID"));
		pselect.add(b1,BorderLayout.SOUTH);
		b1.setVisible(false);
		b1.setEditable(false);
		pdelete.setLayout(new FlowLayout());
		pdelete.setBorder(new TitledBorder("delete doctor"));
		pdelete.add(new JLabel("select Doctor ID"));
		pdelete.add(deleteCombo);
		pdelete.add(delete1);
		
		
		
		pupdate.setBorder(new TitledBorder("update Doctor"));
		 pupdate.setLayout(new GridLayout(6, 2));
		 pupdate.add(new JLabel("Doctor ID"));
		 pupdate.add(updateCombo);
		 pupdate.add(new JLabel("Doctor Name"));
		 pupdate.add(t6);
		 pupdate.add(new JLabel("Work Hours"));
		 pupdate.add(t7);
		 pupdate.add(new JLabel("Hire Date"));
		 pupdate.add(t8);
		 pupdate.add(new JLabel("Department ID"));
		 pupdate.add(updateCombo1);
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
	
			 exit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(JOptionPane.showConfirmDialog(null, " Are you sure you want to exit ?", "Exit ", 2)==0)
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
							String x="select *  from doctor";
							Class.forName("com.mysql.jdbc.Driver");
						    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
						    Statement statement = connection.createStatement();
						    ResultSet select = statement.executeQuery(x);
								while(select.next())
								b.append("\t"+select.getString(1)+"\t"+select.getString(2)+"\t"+select.getString(3)+"\t"+select.getString(4)+"\t"+select.getString(5)+"\t\n");
								p1.add(b);
						    connection.close();			
						    }
						catch (ClassNotFoundException | SQLException e1) {
						JOptionPane.showMessageDialog(null,"can not connect to data base , try again ");
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
							String x="select d.departmentid  from department d ";
							Class.forName("com.mysql.jdbc.Driver");
						    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
						    Statement statement = connection.createStatement();
						    ResultSet select = statement.executeQuery(x);
								while(select.next())
								ids.addItem(select.getString(1));
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
							String x="select d.doctorid  from doctor d ";
							Class.forName("com.mysql.jdbc.Driver");
						    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
						    Statement statement = connection.createStatement();
						    ResultSet select = statement.executeQuery(x);
								while(select.next())
								selectCombo.addItem(select.getString(1));
								selectCombo.addItem("all doctor");
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
						deleteCombo.removeAllItems();
						try {
							String x="select d.doctorid  from doctor d ";
							Class.forName("com.mysql.jdbc.Driver");
						    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
						    Statement statement = connection.createStatement();
						    ResultSet select = statement.executeQuery(x);
								while(select.next())
								deleteCombo.addItem(select.getString(1));
						    connection.close();			
						    }
						catch (ClassNotFoundException | SQLException e1) {
							
							}
					}
				});
			 
			 select1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					String  s=(String) selectCombo.getSelectedItem();
						b1.setVisible(true);
					if(!s.equals("all doctor")){
							b1.setText("");
							if(c1.isSelected())
							{
								try {
									b1.setText("");
									String x="SELECT d.doctorname FROM doctor d where d.doctorid="+s;
									Class.forName("com.mysql.jdbc.Driver");
								    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
								    Statement statement = connection.createStatement();
								    ResultSet select = statement.executeQuery(x);
										while(select.next())
											b1.append(select.getString(1));						
										connection.close();	
								  
								    }
								catch (ClassNotFoundException | SQLException e1) {
								JOptionPane.showMessageDialog(null,"error , try again");
								}
							}
							else if(c2.isSelected())
							{
								try {
									b1.setText("");
									String x="SELECT workhour FROM doctor d where d.doctorid="+s;
									Class.forName("com.mysql.jdbc.Driver");
								    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
								    Statement statement = connection.createStatement();
								    ResultSet select = statement.executeQuery(x);
										while(select.next())
											b1.append(select.getString(1));						   
										connection.close();	
								   
								    }
								catch (ClassNotFoundException | SQLException e1) {
								JOptionPane.showMessageDialog(null,"error , try again");
								}
							}
							else if(c3.isSelected())
							{
								try {
									b1.setText("");
									String x="SELECT hiredate FROM doctor d where d.doctorid="+s;
									Class.forName("com.mysql.jdbc.Driver");
								    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
								    Statement statement = connection.createStatement();
								    ResultSet select = statement.executeQuery(x);
										while(select.next())
											b1.append(select.getString(1));					
										connection.close();	
								   
								    }
								catch (ClassNotFoundException | SQLException e1) {
								JOptionPane.showMessageDialog(null,"error , try again");
								}
							}
							else if(c4.isSelected())
							{
								try {
									b1.setText("");
									String x="SELECT d.did FROM doctor d where d.doctorid="+s;
									Class.forName("com.mysql.jdbc.Driver");
								    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
								    Statement statement = connection.createStatement();
								    ResultSet select = statement.executeQuery(x);
										while(select.next())
											b1.append(select.getString(1));					
										connection.close();	
								   
								    }
								catch (ClassNotFoundException | SQLException e1) {
								JOptionPane.showMessageDialog(null,"error , try again");
								}
							}
							
							else 
								JOptionPane.showMessageDialog(null,"plz select just one ");
						
						}
						else
						{	b1.setText("");
							
							 if(c1.isSelected())
							{
								try {
									String x="SELECT d.doctorname FROM doctor d";
									Class.forName("com.mysql.jdbc.Driver");
								    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
								    Statement statement = connection.createStatement();
								    ResultSet select = statement.executeQuery(x);
										while(select.next())
										b1.append("\t"+select.getString(1)+"\n");
								    connection.close();	
								    b1.setVisible(true);
								    }
								catch (ClassNotFoundException | SQLException e1) {
								JOptionPane.showMessageDialog(null,"error , try again");
								}
							}
							else if(c2.isSelected())
							{
								try {
									String x="SELECT d.workhour FROM doctor d";
									Class.forName("com.mysql.jdbc.Driver");
								    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
								    Statement statement = connection.createStatement();
								    ResultSet select = statement.executeQuery(x);
										while(select.next())
										b1.append("\t"+select.getString(1)+"\n");
								    connection.close();	
								    b1.setVisible(true);
								    }
								catch (ClassNotFoundException | SQLException e1) {
								JOptionPane.showMessageDialog(null,"error , try again");
								}
							}
							else if(c3.isSelected())
							{
								try {
									String x="SELECT d.hiredate FROM doctor d";
									Class.forName("com.mysql.jdbc.Driver");
								    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
								    Statement statement = connection.createStatement();
								    ResultSet select = statement.executeQuery(x);
										while(select.next())
										b1.append("\t"+select.getString(1)+"\n");
								    connection.close();	
								    b1.setVisible(true);
								    }
								catch (ClassNotFoundException | SQLException e1) {
								JOptionPane.showMessageDialog(null,"error , try again");
								}
							}
							else if(c4.isSelected())
							{
								try {
									b1.setText("");
									String x1="SELECT d.did FROM doctor d ";
									Class.forName("com.mysql.jdbc.Driver");
								    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
								    Statement statement = connection.createStatement();
								    ResultSet select = statement.executeQuery(x1);
										while(select.next())
											b1.append("\t"+select.getString(1)+"\n");					
										connection.close();	
								   
								    }
								catch (ClassNotFoundException | SQLException e1) {
								JOptionPane.showMessageDialog(null,"error , try again");
								}
							}
							 
							else
								JOptionPane.showMessageDialog(null,"plz select just one ");
						}
							
							
					}
				});

			 
			 add.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							 Class.forName("com.mysql.jdbc.Driver");
							Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
							String sql = "INSERT INTO doctor (doctorid , doctorname ,workhour, hiredate ,did) VALUES (?,?, ?, ?, ?)";
							PreparedStatement statement = connection.prepareStatement(sql);
							statement.setString(1, t1.getText());
							statement.setString(2, t2.getText());
							statement.setString(3, t3.getText());
							statement.setString(4, t4.getText());
							statement.setString(5, ids.getSelectedItem()+"");
							statement.execute();
						    JOptionPane.showMessageDialog(null, "done");
						    connection.close();	
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "can not add this doctor , check your input data , try again");
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
							String x="select d.doctorid  from doctor d ";
							Class.forName("com.mysql.jdbc.Driver");
						    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
						    Statement statement = connection.createStatement();
						    ResultSet select = statement.executeQuery(x);
								while(select.next())
								updateCombo.addItem(select.getString(1));
						    connection.close();			
						    }
						catch (ClassNotFoundException | SQLException e1) {
							
							}
						updateCombo1.removeAllItems();
						try {
							String x="select d.departmentid  from department d ";
							Class.forName("com.mysql.jdbc.Driver");
						    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
						    Statement statement = connection.createStatement();
						    ResultSet select = statement.executeQuery(x);
								while(select.next())
								updateCombo1.addItem(select.getString(1));
						    connection.close();			
						    }
						catch (ClassNotFoundException | SQLException e1) {
							
							}
						
					}
				});
		 update1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Class.forName("com.mysql.jdbc.Driver");
							Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
							String sql = "UPDATE doctor SET doctorname=?, workhour=?, hiredate=? , did=? WHERE doctorid=?";
							PreparedStatement statement= connection.prepareStatement(sql);
						    statement.setString(5, updateCombo.getSelectedItem()+"");
							statement.setString(1, t6.getText());
							statement.setString(2, t7.getText());
							statement.setString(3, t8.getText());
							 statement.setString(4, ids.getSelectedItem()+"");
						    statement.execute();
						    connection.close();	
						    JOptionPane.showMessageDialog(null,"done");
						} catch (ClassNotFoundException | SQLException e1){
							JOptionPane.showMessageDialog(null,"plz full all text");
								
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
						String x="select d.doctorid  from doctor d ";
						Class.forName("com.mysql.jdbc.Driver");
					    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
					    Statement statement = connection.createStatement();
					    ResultSet select = statement.executeQuery(x);
							while(select.next())
							deleteCombo.addItem(select.getString(1));
					    connection.close();			
					    }
					catch (ClassNotFoundException | SQLException e1) {
						
						}
				}
			});
		 delete1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
					    Class.forName("com.mysql.jdbc.Driver");
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
						String sql = "DELETE from doctor  WHERE doctorid=?";
						PreparedStatement statement = connection.prepareStatement(sql);
						String x=(String) deleteCombo.getSelectedItem();
						statement.setString(1,x );
						statement.execute();
					    JOptionPane.showMessageDialog(null, "the  doctor  id = "+x+ " is deleted");
					    connection.close();			
					    }
					catch (ClassNotFoundException | SQLException e) {
					JOptionPane.showMessageDialog(null,"can not delete , its foreign key ");
					}
				}
			});
			 
			 visible();
	
	
	}
	
	
	
	
	
public void visible (){
		doctor.setVisible(true);
	}
public void invisible (){
		doctor.setVisible(false);
	}

public static void main(String[] args) {
	Doctor d=new Doctor();
}

	

}

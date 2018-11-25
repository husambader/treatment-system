import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Treatment {
	JFrame treatment;
	 JPanel p=new JPanel();
	 JPanel p1=new JPanel();
	 JPanel p2=new JPanel();
	 JPanel pinsert=new JPanel();
	 JPanel pselect=new JPanel();
	 JPanel pupdate=new JPanel();
	 JPanel pdelete=new JPanel();
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
	JComboBox<String>updateCombo=new JComboBox<>();
	JComboBox<String>deleteCombo=new JComboBox<>();
	JComboBox<String>selectCombo=new JComboBox<>();
	JButton back=new JButton("Back");
	JButton clear=new JButton("clear all");
	JButton clear1=new JButton("clear all");
	JButton exit=new JButton("Exit");
	JLabel l=new JLabel(" show all treatments  ");
	JLabel l1=new JLabel(" select treatment ");
	JLabel l2=new JLabel(" insert treatment ");
	JLabel l3=new JLabel("update treatment ");
	JLabel l4=new JLabel("delete treatment ");
	JTextArea b=new  JTextArea();
	JTextArea b1=new  JTextArea();
	JCheckBox c1=new JCheckBox("treatment Details");
	
public Treatment(){
	treatment =new JFrame("treatment");
	 treatment.setSize(800, 500);
	 treatment.setLayout(new BorderLayout());
	 treatment.setResizable(false);
	 treatment.setLocation(400, 70);
	 p.setBorder(new TitledBorder(""));
	 p2.setBorder(new TitledBorder(""));
	l.setBorder(new TitledBorder(""));
	l1.setBorder(new TitledBorder(""));
	l2.setBorder(new TitledBorder(""));
	l3.setBorder(new TitledBorder(""));
	l4.setBorder(new TitledBorder(""));
	treatment.add(p,BorderLayout.NORTH);
	treatment.add(p1);
	treatment.add(p2,BorderLayout.SOUTH);
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
	 
	 pinsert.setBorder(new TitledBorder("add treatment"));
	 pinsert.setLayout(new GridLayout(3,2));
	 pinsert.add(new JLabel("treatment ID"));
	 pinsert.add(t1);
	 pinsert.add(new JLabel("treatment details"));
	 pinsert.add(t2);
	 pinsert.add(add);
	 pinsert.add(clear1);
	 
	 JPanel ppselect=new JPanel();
	 pselect.setLayout(new BorderLayout());
	 pselect.add(selectCombo,BorderLayout.NORTH);
	 pselect.add(ppselect);
	 ppselect.setBorder(new TitledBorder("choose "));
	 ppselect.setLayout(new GridLayout(1,4));
	 ppselect.add(c1);
	 ppselect.add(select1);
	 selectCombo.setBorder(new TitledBorder("treatment ID"));
	pselect.add(b1,BorderLayout.SOUTH);
	b1.setVisible(false);
	b1.setEditable(false);
	pdelete.setLayout(new FlowLayout());
	pdelete.setBorder(new TitledBorder("delete treatment"));
	pdelete.add(new JLabel("select treatment ID"));
	pdelete.add(deleteCombo);
	pdelete.add(delete1);
	
	pupdate.setBorder(new TitledBorder("update treatment"));
	 pupdate.setLayout(new GridLayout(3, 2));
	 pupdate.add(new JLabel("treatment ID"));
	 pupdate.add(updateCombo);
	 pupdate.add(new JLabel("treatment details"));
	 pupdate.add(t3);
	 pupdate.add(clear);
	 pupdate.add(update1);
	 

	 clear1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t1.setText("");	
				t2.setText("");
			}
		});

	 
	 clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t3.setText("");		
			}
		});
	 
	 back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				invisible();
				cover c=new cover();
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
						String x="select *  from treatment";
						Class.forName("com.mysql.jdbc.Driver");
					    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
					    Statement statement = connection.createStatement();
					    ResultSet select = statement.executeQuery(x);
							while(select.next())
							b.append("\t"+select.getString(1)+"\t"+select.getString(2)+"\t\n");
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
				}
			});
	  
		 select.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					p1.removeAll();
					p1.updateUI();
					p1.add(pselect);
					selectCombo.removeAllItems();
					try {
						String x="select d.idtreatment  from treatment d ";
						Class.forName("com.mysql.jdbc.Driver");
					    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
					    Statement statement = connection.createStatement();
					    ResultSet select = statement.executeQuery(x);
							while(select.next())
							selectCombo.addItem(select.getString(1));
							selectCombo.addItem("all treatment");
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
						String x="select d.idtreatment  from treatment d ";
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
				if(!s.equals("all treatment")){
						b1.setText("");
						if(c1.isSelected())
						{
							try {
								b1.setText("");
								String x="SELECT d.treatmentdetails FROM treatment d where d.idtreatment="+s;
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
							JOptionPane.showMessageDialog(null,"plz select  ");
					
					}
					else
					{	b1.setText("");
						
						 if(c1.isSelected())
						{
							try {
								String x="SELECT d.treatmentdetails FROM treatment d ";
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
						 
						else
							JOptionPane.showMessageDialog(null,"plz select ");
					}
						
						
				}
			});

		 add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						 Class.forName("com.mysql.jdbc.Driver");
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
						String sql = "INSERT INTO treatment (idtreatment ,treatmentdetails ) VALUES (?,?)";
						PreparedStatement statement = connection.prepareStatement(sql);
						statement.setString(1, t1.getText());
						statement.setString(2, t2.getText());;
						statement.execute();
					    JOptionPane.showMessageDialog(null, "done");
					    connection.close();	
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "can not add this treatment , check your input data , try again");
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
						String x="select d.idtreatment  from treatment d ";
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
					
				}
			});

		 update1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
						String sql = "UPDATE treatment SET treatmentdetails=? WHERE idtreatment=?";
						PreparedStatement statement= connection.prepareStatement(sql);
					    statement.setString(2, updateCombo.getSelectedItem()+"");
						statement.setString(1, t3.getText());
					    statement.execute();
					    connection.close();	
					    JOptionPane.showMessageDialog(null,"done");
					} catch (ClassNotFoundException | SQLException e1){
						JOptionPane.showMessageDialog(null,"plz add treatment details");
							
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
						String x="select d.idtreatment  from treatment d ";
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
						String sql = "DELETE from treatment  WHERE idtreatment=?";
						PreparedStatement statement = connection.prepareStatement(sql);
						String x=(String) deleteCombo.getSelectedItem();
						statement.setString(1,x );
						statement.execute();
					    JOptionPane.showMessageDialog(null, "the  treatment  id = "+x+ " is deleted");
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
	Treatment d=new Treatment();
}
public void visible (){
	treatment.setVisible(true);
}
public void invisible (){
	treatment.setVisible(false);
}

	
}

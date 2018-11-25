import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Shift {
	
	JFrame shift;
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
	JTextField t4=new JTextField(" ");
	JTextField t5=new JTextField(" ");
	JComboBox<String>updateCombo=new JComboBox<>();
	JComboBox<String>deleteCombo=new JComboBox<>();
	JComboBox<String>selectCombo=new JComboBox<>();
	JButton back=new JButton("Back");
	JButton clear=new JButton("clear all");
	JButton clear1=new JButton("clear all");
	JButton exit=new JButton("Exit");
	JLabel l=new JLabel(" show all shift info ");
	JLabel l1=new JLabel(" select shift ");
	JLabel l2=new JLabel(" insert shift ");
	JLabel l3=new JLabel("update shift ");
	JLabel l4=new JLabel("delete shift ");
	JTextArea b=new  JTextArea();
	JTextArea b1=new  JTextArea();
	JCheckBox c1=new JCheckBox("shift Time");
	JCheckBox c2=new JCheckBox("shift description");

	public Shift(){
		
		shift =new JFrame("shift");
		 shift.setSize(800, 500);
		 shift.setLayout(new BorderLayout());
		 shift.setResizable(false);
		 shift.setLocation(400, 70);
		 p.setBorder(new TitledBorder(""));
		 p2.setBorder(new TitledBorder(""));
		l.setBorder(new TitledBorder(""));
		l1.setBorder(new TitledBorder(""));
		l2.setBorder(new TitledBorder(""));
		l3.setBorder(new TitledBorder(""));
		l4.setBorder(new TitledBorder(""));
		shift.add(p,BorderLayout.NORTH);
		shift.add(p1);
		shift.add(p2,BorderLayout.SOUTH);
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
		 
		 
		 pinsert.setBorder(new TitledBorder("add Shift"));
		 pinsert.setLayout(new GridLayout(4,2));
		 pinsert.add(new JLabel("Shift ID"));
		 pinsert.add(t1);
		 pinsert.add(new JLabel("Shift Time"));
		 pinsert.add(t2);
		 pinsert.add(new JLabel("Discription"));
		 pinsert.add(t4);
		 pinsert.add(add);
		 pinsert.add(clear1);
		 
		 JPanel ppselect=new JPanel();
		 pselect.setLayout(new BorderLayout());
		 pselect.add(selectCombo,BorderLayout.NORTH);
		 pselect.add(ppselect);
		 ppselect.setBorder(new TitledBorder("choose "));
		 ppselect.setLayout(new GridLayout(1,4));
		 ButtonGroup group= new ButtonGroup();
			group.add(c1);
			group.add(c2);
		 ppselect.add(c1);
		 ppselect.add(c2);
		 ppselect.add(select1);
		 selectCombo.setBorder(new TitledBorder("Shift ID"));
		pselect.add(b1,BorderLayout.SOUTH);
		b1.setVisible(false);
		b1.setEditable(false);
		pdelete.setLayout(new FlowLayout());
		pdelete.setBorder(new TitledBorder("delete shift"));
		pdelete.add(new JLabel("select nurse ID"));
		pdelete.add(deleteCombo);
		pdelete.add(delete1);
		 
		pupdate.setBorder(new TitledBorder("update shift"));
		 pupdate.setLayout(new GridLayout(4, 2));
		 pupdate.add(new JLabel("Shift ID"));
		 pupdate.add(updateCombo);
		 pupdate.add(new JLabel("Shift Time"));
		 pupdate.add(t3);
		 pupdate.add(new JLabel("Shift Description"));
		 pupdate.add(t5);
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
					t5.setText("");
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
							String x="select *  from shift";
							Class.forName("com.mysql.jdbc.Driver");
						    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
						    Statement statement = connection.createStatement();
						    ResultSet select = statement.executeQuery(x);
								while(select.next())
								b.append("\t"+select.getString(1)+"\t"+select.getString(2)+"\t"+select.getString(3)+"\t\n");
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
							String x="select d.shiftno  from shift d ";
							Class.forName("com.mysql.jdbc.Driver");
						    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
						    Statement statement = connection.createStatement();
						    ResultSet select = statement.executeQuery(x);
								while(select.next())
								selectCombo.addItem(select.getString(1));
								selectCombo.addItem("all shift");
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
							String x="select d.shiftno from shift d ";
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
					if(!s.equals("all shift")){
							b1.setText("");
							if(c1.isSelected())
							{
								try {
									b1.setText("");
									String x="SELECT d.shifttime FROM shift d where d.shiftno="+s;
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
									String x="SELECT d.shiftdescreption FROM shift d where d.shiftno="+s;
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
									String x="SELECT d.shifttime FROM shift d ";
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
									String x="SELECT d.shiftdescreption FROM shift d";
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
								JOptionPane.showMessageDialog(null,"plz select just one ");
						}
							
							
					}
				});

			 add.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							 Class.forName("com.mysql.jdbc.Driver");
							Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
							String sql = "INSERT INTO shift (shiftno , shifttime ,shiftdescreption) VALUES (?,?, ?)";
							PreparedStatement statement = connection.prepareStatement(sql);
							statement.setString(1, t1.getText());
							statement.setString(2, t2.getText());;
							statement.setString(3, t4.getText());
							statement.execute();
						    JOptionPane.showMessageDialog(null, "done");
						    connection.close();	
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "can not add this shift , check your input data , try again");
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
							String x="select d.shiftno  from shift d ";
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
							String sql = "UPDATE shift SET shifttime=?, shiftdescreption=? WHERE shiftno=?";
							PreparedStatement statement= connection.prepareStatement(sql);
						    statement.setString(3, updateCombo.getSelectedItem()+"");
							statement.setString(1, t3.getText());
							 statement.setString(2, t5.getText());
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
							String x="select d.shiftno  from nurse d ";
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
							String sql = "DELETE from shift  WHERE shiftno=?";
							PreparedStatement statement = connection.prepareStatement(sql);
							String x=(String) deleteCombo.getSelectedItem();
							statement.setString(1,x );
							statement.execute();
						    JOptionPane.showMessageDialog(null, "the  shift  id = "+x+ " is deleted");
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
		Shift d=new Shift();
	}
	public void visible (){
		shift.setVisible(true);
	}
	public void invisible (){
		shift.setVisible(false);
	}


	
}

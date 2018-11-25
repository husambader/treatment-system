import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Department {
	JFrame department;
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
	JTextField t9=new JTextField(" ");
	JComboBox<String>t5=new JComboBox<>();
	JComboBox<String>selectCombo=new JComboBox<>();
	JButton back=new JButton("Back");
	JButton clear=new JButton("clear all");
	JButton clear1=new JButton("clear all");
	JButton exit=new JButton("Exit");
	JLabel l=new JLabel(" show all departments info ");
	JLabel l1=new JLabel(" select department ");
	JLabel l2=new JLabel(" insert department  ");
	JLabel l3=new JLabel("update department ");
	JLabel l4=new JLabel("delete department ");
	JTextArea b=new  JTextArea();
	JTextArea b1=new  JTextArea();
	//JCheckBox c=new JCheckBox("Department ID");
	JCheckBox c1=new JCheckBox("Department Name");
	JCheckBox c2=new JCheckBox("Department Description");
	JCheckBox c3=new JCheckBox("Department Fax");
	
	public Department() {
		 department =new JFrame("Department");
		 department.setSize(800, 500);
		 department.setLayout(new BorderLayout());
		 department.setResizable(false);
		 department.setLocation(400, 70);
		 p.setBorder(new TitledBorder(""));
		 p2.setBorder(new TitledBorder(""));
		l.setBorder(new TitledBorder(""));
		l1.setBorder(new TitledBorder(""));
		l2.setBorder(new TitledBorder(""));
		l3.setBorder(new TitledBorder(""));
		l4.setBorder(new TitledBorder(""));
		 department.add(p,BorderLayout.NORTH);
		 department.add(p1);
		 department.add(p2,BorderLayout.SOUTH);
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
		 pinsert.setBorder(new TitledBorder("add Department"));
		 pinsert.setLayout(new GridLayout(5,5));
		 pinsert.add(new JLabel("Department ID"));
		 pinsert.add(t6);
		 pinsert.add(new JLabel("Department Name"));
		 pinsert.add(t7);
		 pinsert.add(new JLabel("Department Description"));
		 pinsert.add(t8);
		 pinsert.add(new JLabel("Dpeartment Fax"));
		 pinsert.add(t9);
		 pinsert.add(clear1);
		 pinsert.add(add);
		 JPanel ppselect=new JPanel();
		 pselect.setLayout(new BorderLayout());
		 pselect.add(selectCombo,BorderLayout.NORTH);
		 pselect.add(ppselect);
		 ppselect.setBorder(new TitledBorder("choose "));
		 ppselect.setLayout(new GridLayout(1,4));
			ButtonGroup group= new ButtonGroup();
			group.add(c1);
			group.add(c2);
			group.add(c3);
			ppselect.add(c1);
			ppselect.add(c2);
			ppselect.add(c3);
		 ppselect.add(select1);
		 selectCombo.setBorder(new TitledBorder("Department  ID"));
		pselect.add(b1,BorderLayout.SOUTH);
		b1.setVisible(false);
		b1.setEditable(false);
		pdelete.setLayout(new FlowLayout());
		pdelete.setBorder(new TitledBorder(""));
		pdelete.add(new JLabel("select department ID"));
		pdelete.add(t5);
		pdelete.add(delete1);
		
		
		
		pupdate.setBorder(new TitledBorder("update Department"));
		 pupdate.setLayout(new GridLayout(5,5));
		 pupdate.add(new JLabel("Department ID"));
		 pupdate.add(ids);
		 pupdate.add(new JLabel("Department Name"));
		 pupdate.add(t2);
		 pupdate.add(new JLabel("Department Description"));
		 pupdate.add(t3);
		 pupdate.add(new JLabel("Dpeartment Fax"));
		 pupdate.add(t4);
		 pupdate.add(clear);
		 pupdate.add(update1);
		
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t1.setText("");	
				t2.setText("");
				t3.setText("");
				t4.setText("");
			}
		});
		clear1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t6.setText("");	
				t7.setText("");
				t8.setText("");
				t9.setText("");
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
					String x="select *  from department";
					Class.forName("com.mysql.jdbc.Driver");
				    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
				    Statement statement = connection.createStatement();
				    ResultSet select = statement.executeQuery(x);
						while(select.next())
						b.append("\t"+select.getString(1)+"\t"+select.getString(2)+"\t"+select.getString(3)+"\t"+select.getString(4)+"\t\n");
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
			}
		});
		 select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p1.removeAll();
				p1.updateUI();
				p1.add(pselect);
				selectCombo.removeAllItems();
				try {
					String x="select d.departmentid  from department d ";
					Class.forName("com.mysql.jdbc.Driver");
				    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
				    Statement statement = connection.createStatement();
				    ResultSet select = statement.executeQuery(x);
						while(select.next())
						selectCombo.addItem(select.getString(1));
						selectCombo.addItem("all department");
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
				t5.removeAllItems();
				try {
					String x="select d.departmentid  from department d ";
					Class.forName("com.mysql.jdbc.Driver");
				    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
				    Statement statement = connection.createStatement();
				    ResultSet select = statement.executeQuery(x);
						while(select.next())
						t5.addItem(select.getString(1));
				    connection.close();			
				    }
				catch (ClassNotFoundException | SQLException e1) {
					
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
		 select1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String  s=(String) selectCombo.getSelectedItem();
				b1.setVisible(true);
			if(!s.equals("all department")){
					b1.setText("");
					if(c1.isSelected())
					{
						try {
							b1.setText("");
							String x="SELECT d.departmentname FROM department d where d.departmentid="+s;
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
							String x="SELECT departmentdescription FROM department d where d.departmentid="+s;
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
							String x="SELECT departmentfax FROM department d where d.departmentid="+s;
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
							String x="SELECT d.departmentname FROM department d";
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
							String x="SELECT departmentdescription FROM department d";
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
							String x="SELECT departmentfax FROM department d";
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
					String sql = "INSERT INTO department (departmentid , departmentname ,departmentdescription, departmentfax) VALUES (?, ?, ?, ?)";
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setString(1, t6.getText());
					statement.setString(2, t7.getText());
					statement.setString(3, t8.getText());
					statement.setString(4, t9.getText());
					statement.execute();
				    JOptionPane.showMessageDialog(null, "done");
				    connection.close();	
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "can not add this department , check your input data , try again");
				}
			
			}
		});
		 update1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
					String sql = "UPDATE department SET departmentname=?, departmentdescription=?, departmentfax=? WHERE departmentid=?";
					PreparedStatement statement= connection.prepareStatement(sql);
				    statement.setString(4, ids.getSelectedItem()+"");
					statement.setString(1, t2.getText());
					statement.setString(2, t3.getText());
					statement.setString(3, t4.getText());
				    statement.execute();
				    connection.close();	
				    JOptionPane.showMessageDialog(null,"done");
				} catch (ClassNotFoundException | SQLException e1){
					JOptionPane.showMessageDialog(null,"the department not found");
				} 
				
			}
		});
		 delete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				    Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","wisam");
					String sql = "DELETE from department  WHERE departmentid=?";
					PreparedStatement statement = connection.prepareStatement(sql);
					String x=(String) t5.getSelectedItem();
					statement.setString(1,x );
					statement.execute();
				    JOptionPane.showMessageDialog(null, "the  department  id = "+x+ " is deleted");
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
		department.setVisible(true);
	}
public void invisible (){
		department.setVisible(false);
	}

public static void main(String[] args) {
	Department d=new Department();
}



}

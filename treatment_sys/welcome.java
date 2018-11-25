import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class welcome extends JFrame{
	private JFrame frame;
	private ImageIcon image;
	private JButton clear;
	private JButton login;
	private JLabel l;
	private JTextField idtxt;
	private JPasswordField passtxt;
	public welcome(){
		frame = new JFrame("Welcome To Al-Shifa' Hospital ");
		frame.setForeground(Color.WHITE);
		frame.setSize(500, 300);
		frame.setResizable(false);
		JPanel pID=new JPanel();
		frame.add(pID,BorderLayout.CENTER);
		JPanel pPass=new JPanel();
		pPass.setLayout(new GridLayout(4, 3, 10, 10));
		pPass.add(new JLabel("Enter ID"));
		pPass.add(new JLabel(""));
		pPass.add(idtxt=new JTextField(10));
		pPass.add(new JLabel("Password:"));
		pPass.add(new JLabel(""));
		pPass.add(passtxt=new JPasswordField(10));
		pPass.add(new JLabel(""));
		pPass.add(login=new JButton("Log In"));
		pPass.add(new JLabel(""));
		pPass.add(new JLabel(""));
		pPass.add(clear=new JButton("Clear"));
		pPass.add(new JLabel(""));
		l=new JLabel();
		image=new ImageIcon("4.jpg");
		l.setIcon(image);
		pID.add(l,BorderLayout.CENTER);
		frame.add(pPass,BorderLayout.NORTH);
		frame.setBackground(Color.WHITE);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				idtxt.setText("");
				passtxt.setText("");
			}
		});
		
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id=idtxt.getText();
				String pass=passtxt.getText();
				if(id.equals("1")&&pass.equals("user")){
					cover c=new cover();
					frame.setVisible(false);
				}
				else 
					JOptionPane.showMessageDialog(null, "Incorrect ID or Password");
			}
		});
	}
	public static void main(String[] args) {
		welcome w=new welcome();
	
	}
}

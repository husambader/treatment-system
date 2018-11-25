
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.border.TitledBorder;
import javax.swing.event.MenuListener;

public class cover{
	JMenuBar menuBar = createMenuBar();
	JFrame project;
	
	 JButton exit=new JButton("Exit");
	 JButton about=new JButton("about");
	 JButton appointment1=new JButton("Appointment");
	 JButton apptreat=new JButton("Appointment - Treatment");
	 JButton apptest=new JButton("Appointment - Test");
	 JButton appdiagnose=new JButton("Appointment - Diagnose");
	 JButton apppharmacy=new JButton("Appointment - Pharmacy");
	 JButton bill=new JButton("Bill");
	 JButton department=new JButton("Department");
	 JButton diagnose=new JButton("Diagnose");
	 JButton doctor=new JButton("Doctor");
	 JButton nurse=new JButton("Nurse");
	 JButton nsd=new JButton("Nurse Shift Department");
	 JButton patient=new JButton("Patient");
	 JButton pharmacy=new JButton("Pharmacy");
	 JButton shift=new JButton("Shift");
	 JButton phone=new JButton("Phone");
	 JButton test=new JButton("test");
	 JButton treatment=new JButton("Treatment");
	 
	 
	 
	public static void main(String[] args) {
		cover t = new cover();
		

	}

	cover() {
		project = new JFrame("Data Base Final Project");
		project.setSize(650, 500);
		project.setLocation(400,70);
		project.setResizable(false);
		project.setLayout(new BorderLayout());
		project.setJMenuBar(menuBar);
		JPanel p=new JPanel();
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		JPanel p4=new JPanel();
		JLabel l=new JLabel();
		JLabel l1=new JLabel("select table");
		ImageIcon image=new ImageIcon("1.jpg");
		l.setIcon(image);
		p.setLayout(new FlowLayout());
		p3.setLayout(new FlowLayout());
		
		project.add(p,BorderLayout.NORTH);
		project.add(p1,BorderLayout.WEST);
		project.add(p4);
		project.add(p2,BorderLayout.EAST);
		project.add(p3,BorderLayout.SOUTH);
		p.add(l);
		p.setBorder(new TitledBorder(""));
		p1.setBorder(new TitledBorder(""));
		p2.setBorder(new TitledBorder(""));
		p3.setBorder(new TitledBorder(""));
		p4.setBorder(new TitledBorder(""));
		
		p4.setLayout(new GridLayout(19,2));
		p4.add(department);
		p4.add(new JLabel());
		p4.add(doctor);
		p4.add(new JLabel());
		p4.add(patient);
		p4.add(new JLabel());
		p4.add(nurse);
		p4.add(new JLabel());
		p4.add(test);
		p4.add(new JLabel());
		p4.add(shift);
		p4.add(new JLabel());
		p4.add(diagnose);
		p4.add(new JLabel());
		p4.add(treatment);
		p4.add(new JLabel());
		p4.add(appointment1);
		p4.add(new JLabel());
		p4.add(pharmacy);
		p4.add(new JLabel());
		p4.add(phone);
		p4.add(new JLabel());
		p4.add(apptest);
		p4.add(new JLabel());
		p4.add(apptreat);
		p4.add(new JLabel());
		p4.add(appdiagnose);
		p4.add(new JLabel());
		p4.add(apppharmacy);
		p4.add(new JLabel());
		p4.add(nsd);
		p4.add(new JLabel());
		p4.add(bill);
		p4.add(new JLabel());
		
		
		p1.add(l1);
		p3.add(about);
		p3.add(exit);
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, " Are you sure you want to exit ?", "Exit ", 2)==0)
					System.exit(0);
				
			}
		});
appointment1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				invisible();
				appointment a=new appointment();
		
			}
		});
diagnose.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		invisible();
		Diagnose d=new Diagnose();
	}
});
this.bill.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		invisible();
		Bill b=new Bill();
	}
});
this.treatment.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		invisible();
		Treatment t=new Treatment();
	}
});
this.test.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		invisible();
		test t=new test();
	}
});
this.shift.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		invisible();
		Shift s=new Shift();
	}
});
pharmacy.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		invisible();
		pharmacy p=new pharmacy();
	}
});
department.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		invisible();
		Department d=new Department();
	}
});
this.phone.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		invisible();
		Phone phone=new Phone();
	}
});
this.doctor.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		invisible();
		Doctor d=new Doctor();
	}
});
this.nurse.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		invisible();
		Nurse n=new Nurse();
	}
});
this.patient.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		invisible();
		patient p=new patient();
	}
});
appdiagnose.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		invisible();
		AppointmentDiagnose d=new AppointmentDiagnose();
	}
});
apptest.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		invisible();
		AppointmentTest d=new AppointmentTest();
		
	}
});
apptreat.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		AppointmentTreatment d=new AppointmentTreatment();
	}
});
apppharmacy.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		AppointmentPharmacy d=new AppointmentPharmacy();
	}
});
nsd.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		invisible();
		nurseShiftDept n=new nurseShiftDept();
	}
});

about.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null,"Data Base Final Project \n Done by :\n \t  Wisam Assi \t 1120539 \n \t Weam Bader \t 1120230 \n \t Mohammad Smri \t 1121274 \n Thanks to Dr. Wahbeh Mousa");
	}
});

visible();
	}

	public JMenuBar createMenuBar() {
		JMenuItem assi = new JMenuItem("Wisam Assi");
		JMenuItem smri = new JMenuItem("Mohammad Smri");
		JMenuItem bader = new JMenuItem("Weam Bader");
		JMenuItem exit = new JMenuItem("exit");
		JMenuItem appointment=new JMenuItem("Appointment");
		JMenuItem dept=new JMenuItem("Department");
		JMenuItem doctor=new JMenuItem("Doctor");
		JMenuItem nurse=new JMenuItem("Nurse");
		JMenuItem patient=new JMenuItem("Patient");
		JMenuItem pharm=new JMenuItem("Pharmacy");
		JMenuItem shift=new JMenuItem("Shift");
		JMenuItem test=new JMenuItem("Test");
		JMenuItem treatment=new JMenuItem("Treatment");
		JMenuItem bill=new JMenuItem("Bill");
		JMenuItem dia=new JMenuItem("Diagnose");
		JMenuItem phone=new JMenuItem("phone");
		JMenuItem appphar=new JMenuItem("Appointment - Pharmacy");
		JMenuItem appptest1=new JMenuItem("Appointment - Test ");
		JMenuItem apppdiagnose=new JMenuItem("Appointment - Diagnose");
		JMenuItem appptreatment=new JMenuItem("Appointment - Treatment");
		JMenuItem nurseshift=new JMenuItem("Nurse - shift - Department");
		JMenuItem exit1=new JMenuItem("Exit");

		JMenu TableMenu = new JMenu("Tables");
		TableMenu.add(dept);
		TableMenu.add(doctor);
		TableMenu.add(nurse);
		TableMenu.add(patient);
		TableMenu.add(shift);
		TableMenu.add(phone);
		TableMenu.add(appointment);
		TableMenu.add(treatment);
		TableMenu.add(dia);
		TableMenu.add(test);
		TableMenu.add(pharm);
		TableMenu.add(appphar);
		TableMenu.add(appptest1);
		TableMenu.add(apppdiagnose);
		TableMenu.add(appptreatment);
		TableMenu.add(nurseshift);
		TableMenu.add(bill);
		TableMenu.add(exit1);
		JMenuBar bar = new JMenuBar();
		bar.add(TableMenu);
		JMenu aboutMenuItem = new JMenu("About");
		bar.add(aboutMenuItem);
		aboutMenuItem.add(assi);
		appointment.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				invisible();
				appointment a=new appointment();
		
			}
		});
		
		dia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				invisible();
				Diagnose d=new Diagnose();
			}
		});

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null,
						" Are you sure you want to exit ?", "Exit ", 2) == 0)
					System.exit(0);

			}
		});
		
		bill.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				invisible();
				Bill b=new Bill();
			}
		});

		treatment.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				invisible();
				Treatment t=new Treatment();
			}
		});

		test.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				invisible();
				test t=new test();
			}
		});

		shift.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				invisible();
				Shift s=new Shift();
			}
		});

		pharm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				invisible();
				pharmacy p=new pharmacy();
			}
		});

		dept.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				invisible();
				Department d=new Department();
			}
		});

		phone.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				invisible();
				Phone phone=new Phone();
			}
		});

		doctor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				invisible();
				Doctor d=new Doctor();
			}
		});

		nurse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				invisible();
				Nurse n=new Nurse();
			}
		});

		patient.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				invisible();
				patient p=new patient();
			}
		});

		assi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				aboutAssi();
			}
		});
		aboutMenuItem.add(smri);
		aboutMenuItem.add(bader);

		smri.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				aboutSmri();
			}
		});

		bader.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				aboutBader();

			}
		});

			appphar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					invisible();
					AppointmentPharmacy phar=new AppointmentPharmacy();
				}
			});
			
			appptest1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					invisible();
					AppointmentTest test=new AppointmentTest();
				}
			});
			
			
			apppdiagnose.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					invisible();
					AppointmentDiagnose d=new AppointmentDiagnose();
				}
			});
			
			appptreatment.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					invisible();
					AppointmentTreatment d=new AppointmentTreatment();
				}
			});
			nurseshift.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					invisible();
					nurseShiftDept d=new  nurseShiftDept();
				}
			});
			exit1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(JOptionPane.showConfirmDialog(null, " Are you sure you want to exit ?", "Exit ", 2)==0)
						System.exit(0);
					
				}
			});
		return bar;

	}

	public void aboutAssi() {
		String about = "Data Base Final Project"
				+ "\n By Wisam Assi \n std ID no. 1120539"
				+ "\nInstructor Dr Wahbeh Mousa";
		JOptionPane.showMessageDialog(null, about, "about Wisam Assi",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void aboutSmri() {
		String about = "Data Base Final Project"
				+ "\n By Mohammad Smri \n std ID no. 1121274"
				+ "\nInstructor Dr Wahbeh Mousa";
		JOptionPane.showMessageDialog(null, about, "about Mohammad Smri",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void aboutBader() {
		String about = "Data Base Final Project"
				+ "\n By Weam Bader \n std ID no. 1120230"
				+ "\nInstructor Dr Wahbeh Mousa";
		JOptionPane.showMessageDialog(null, about, "about Weam Bader",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void visible() {
		project.setVisible(true);
	}

	public void invisible() {
		project.setVisible(false);
	}
}

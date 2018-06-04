package main;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class MainMenu extends JFrame implements ActionListener,MouseListener{


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JLabel lblIconDPs,lblIconEmployees,lblTitle;
	Style s = new Style();
	JPanel pnDPs,pnEmployees,pnEditPuesto;
	EmployeesMenu em = new EmployeesMenu();
	JButton btnDPs,btnEmployees,btn,btnBack;
	MenuPuestos mp = new MenuPuestos();
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 236, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		s.mdPanel(contentPane);
		
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 219, 262);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		s.mdPanel(mainPanel);
		
		lblTitle = new JLabel("");
		lblTitle.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(42, 11, 167, 34);
		mainPanel.add(lblTitle);
		
		pnEmployees = new JPanel();
		pnEmployees.setBounds(10, 74, 199, 45);
		mainPanel.add(pnEmployees);
		pnEmployees.setLayout(null);
		s.mdPanel(pnEmployees);
		
		lblIconEmployees = new JLabel("");
		lblIconEmployees.setBounds(12, 0, 46, 45);
		pnEmployees.add(lblIconEmployees);
		lblIconEmployees.setIcon(new ImageIcon("views/employees32.png"));
		
		JLabel lblEmployees = new JLabel("Empleados");
		lblEmployees.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		lblEmployees.setBounds(68, 0, 131, 45);
		pnEmployees.add(lblEmployees);
		
		btnEmployees = new JButton("");
		btnEmployees.setBounds(0, 0, 199, 45);
		pnEmployees.add(btnEmployees);
		
		pnDPs = new JPanel();
		pnDPs.setBounds(10, 130, 199, 45);
		mainPanel.add(pnDPs);
		pnDPs.setLayout(null);
		s.mdPanel(pnDPs);
		
		lblIconDPs = new JLabel("");
		lblIconDPs.setBounds(11, 0, 46, 45);
		pnDPs.add(lblIconDPs);
		lblIconDPs.setIcon(new ImageIcon("views/curriculum32.png"));
		
		JLabel lblDPs = new JLabel("Puestos");
		lblDPs.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		lblDPs.setBounds(67, 0, 132, 45);
		pnDPs.add(lblDPs);
		
		btnDPs = new JButton("");
		btnDPs.setBounds(0, 0, 199, 45);
		pnDPs.add(btnDPs);
		
		pnEditPuesto = new JPanel();
		pnEditPuesto.setBounds(10, 186, 199, 45);
		mainPanel.add(pnEditPuesto);
		pnEditPuesto.setLayout(null);
		s.mdPanel(pnEditPuesto);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(10, 0, 46, 45);
		pnEditPuesto.add(label_1);
		
		JLabel label_3 = new JLabel("");
		label_3.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		label_3.setBounds(56, 0, 143, 45);
		pnEditPuesto.add(label_3);
		
		btn = new JButton("");
		btn.setBounds(0, 0, 199, 45);
		pnEditPuesto.add(btn);
		
		
		s.btnTransparent(btnEmployees);
		s.btnTransparent(btnDPs);
		s.btnTransparent(btn);
		
		btnBack = new JButton("");
		btnBack.setBounds(10, 11, 24, 24);
		mainPanel.add(btnBack);
		s.btnIcon(btnBack, "views/back.png");
		btnBack.addMouseListener(this);
		
		pnEmployees.addMouseListener(this);
		pnDPs.addMouseListener(this);
		btnEmployees.addActionListener(this);
		btnDPs.addActionListener(this);
		btnDPs.addMouseListener(this);
		btnEmployees.addMouseListener(this);
		em.btnBack.addActionListener(this);
		mp.btnBack.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnEmployees) {
			this.setVisible(false);
			em.setVisible(true);
		}else if(e.getSource() == em.btnBack) {
			this.setVisible(true);
			em.setVisible(false);
		}else if(e.getSource() == btnDPs) {
			this.setVisible(false);
			mp.setVisible(true);
		}else if(e.getSource() == mp.btnBack) {
			this.setVisible(true);
			mp.setVisible(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == btnEmployees || e.getSource() == pnEmployees) {
			s.btnPointer(btnEmployees);
			s.panelPointer(pnEmployees);
		}else if(e.getSource() == btnDPs || e.getSource() == pnDPs) {
			s.btnPointer(btnDPs);
			s.panelPointer(pnDPs);
		}else if(e.getSource() == btnBack) {
			s.btnPointer(btnBack);
		}
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

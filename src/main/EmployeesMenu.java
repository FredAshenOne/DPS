package main;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class EmployeesMenu extends JFrame implements ActionListener,MouseListener{

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JPanel mainPanel,pnCreateEmployee,pnRemoveEmployee,pnConsultEmployee;
	Style s = new Style();
	JButton btnAdd,btnQuery,btnRemove,btnBack;
	ImageIcon aicon = new ImageIcon("views/back.png");
	AddEmployee ae = new AddEmployee();
	QueryEmployee qe = new QueryEmployee();

	public EmployeesMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 237, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 221, 261);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		s.mdPanel(mainPanel);
		
		pnCreateEmployee = new JPanel();
		pnCreateEmployee.setBounds(10, 59, 195, 51);
		mainPanel.add(pnCreateEmployee);
		pnCreateEmployee.setLayout(null);
		s.mdPanel(pnCreateEmployee);
		
		JLabel lblIconAddEmployee = new JLabel("");
		lblIconAddEmployee.setBounds(0, 0, 55, 51);
		pnCreateEmployee.add(lblIconAddEmployee);
		lblIconAddEmployee.setIcon(new ImageIcon("views/adduser32.png"));
		
		JLabel lblAddEmployee = new JLabel("Nuevo Empleado");
		lblAddEmployee.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		lblAddEmployee.setBounds(53, 0, 119, 51);
		pnCreateEmployee.add(lblAddEmployee);
		
		btnAdd = new JButton("");
		btnAdd.setBounds(0, 0, 195, 51);
		pnCreateEmployee.add(btnAdd);
		s.btnTransparent(btnAdd);
		
		pnConsultEmployee = new JPanel();
		pnConsultEmployee.setBounds(10, 121, 195, 51);
		mainPanel.add(pnConsultEmployee);
		pnConsultEmployee.setLayout(null);
		s.mdPanel(pnConsultEmployee);
		
		JLabel lblIconQueryEmployee = new JLabel("");
		lblIconQueryEmployee.setBounds(0, 0, 55, 51);
		pnConsultEmployee.add(lblIconQueryEmployee);
		lblIconQueryEmployee.setIcon(new ImageIcon("views/search32.png"));
		
		JLabel lblQueryEmployee = new JLabel("Consultar Empleado");
		lblQueryEmployee.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		lblQueryEmployee.setBounds(54, 0, 119, 51);
		pnConsultEmployee.add(lblQueryEmployee);
		
		btnQuery = new JButton("");
		btnQuery.setBounds(0, 0, 195, 51);
		pnConsultEmployee.add(btnQuery);
		s.btnTransparent(btnQuery);
		
		pnRemoveEmployee = new JPanel();
		pnRemoveEmployee.setBounds(10, 183, 195, 51);
		mainPanel.add(pnRemoveEmployee);
		pnRemoveEmployee.setLayout(null);
		s.mdPanel(pnRemoveEmployee);
		
		JLabel lblIconRemoveEmployee = new JLabel("");
		lblIconRemoveEmployee.setBounds(0, 0, 55, 51);
		pnRemoveEmployee.add(lblIconRemoveEmployee);
		
		JLabel lblRemoveEmployee = new JLabel("Remover Empleado");
		lblRemoveEmployee.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		lblRemoveEmployee.setBounds(53, 0, 119, 51);
		pnRemoveEmployee.add(lblRemoveEmployee);
		lblIconRemoveEmployee.setIcon(new ImageIcon("views/minus32.png"));
		
		btnRemove = new JButton("");
		btnRemove.setBounds(0, 0, 195, 51);
		pnRemoveEmployee.add(btnRemove);
		s.btnTransparent(btnRemove);
		
		
		JLabel lblHeader = new JLabel("Selecciona movimiento");
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		lblHeader.setBounds(46, 11, 159, 33);
		mainPanel.add(lblHeader);
		
		btnBack = new JButton("");
		btnBack.setBounds(10, 11, 24, 24);
		mainPanel.add(btnBack);
		s.btnIcon(btnBack, "views/back.png");
		btnBack.addActionListener(this);
		btnBack.addMouseListener(this);
		
		btnAdd.addActionListener(this);
		btnAdd.addMouseListener(this);
		btnQuery.addActionListener(this);
		btnQuery.addMouseListener(this);
		btnRemove.addMouseListener(this);
		ae.btnBack.addActionListener(this);
		qe.btnBack.addActionListener(this);
		ae.btnInsert.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdd) {
			ae.setVisible(true);
			this.setVisible(false);
		}else if(e.getSource() == ae.btnBack) {
			this.setVisible(true);
			ae.setVisible(false);
		}else if(e.getSource() == btnQuery) {
			qe.setVisible(true);
			this.setVisible(false);
		}else if(e.getSource() == qe.btnBack) {
			this.setVisible(true);
			qe.setVisible(false);
		}else if(e.getSource() == ae.btnInsert) {
			if(ae.insert) {
				this.setVisible(true);
				ae.setVisible(false);
			}
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == pnCreateEmployee || e.getSource() == btnAdd) {
			s.btnPointer(btnAdd);
			s.panelPointer(pnCreateEmployee);
		}else if(e.getSource() == pnConsultEmployee || e.getSource() == btnQuery) {
			s.btnPointer(btnQuery);
			s.panelPointer(pnConsultEmployee);
		}else if(e.getSource() == pnRemoveEmployee || e.getSource() == btnRemove) {
			s.btnPointer(btnRemove);
			s.panelPointer(pnRemoveEmployee);
		}else if(e.getSource() == btnBack) {
			s.btnPointer(btnBack);
		}		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;

public class MenuPuestos extends JFrame implements MouseListener,ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JButton btnBack;
	JPanel pnAddDp,pnBuscarDp;
	JLabel lblIconAddDp,lblAddDp,lblHeader,lblIconQueryDp,lblBuscarDp;
	Style s = new Style();
	private JButton btnAddDp;
	private JButton btnBuscarDp;
	public MenuPuestos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 230, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 214, 260);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		s.mdPanel(mainPanel);
		
		btnBack = new JButton("");
		btnBack.setBounds(10, 11, 24, 24);
		mainPanel.add(btnBack);
		s.btnIcon(btnBack, "views/back.png");
		
		
		lblHeader = new JLabel("Seleccione movimiento");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		lblHeader.setBounds(44, 11, 140, 24);
		mainPanel.add(lblHeader);
		
		pnAddDp = new JPanel();
		pnAddDp.setBounds(10, 68, 194, 39);
		mainPanel.add(pnAddDp);
		pnAddDp.setLayout(null);
		s.mdPanel(pnAddDp);
		
		lblIconAddDp = new JLabel("");
		lblIconAddDp.setBounds(0, 0, 46, 39);
		pnAddDp.add(lblIconAddDp);
		lblIconAddDp.setIcon( new ImageIcon("views/addDp32.png"));
		
		
		lblAddDp = new JLabel("Nueva DP");
		lblAddDp.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		lblAddDp.setBounds(46, 0, 148, 39);
		pnAddDp.add(lblAddDp);
		
		btnAddDp = new JButton("");
		btnAddDp.setBounds(0, 0, 194, 39);
		pnAddDp.add(btnAddDp);
		s.btnTransparent(btnAddDp);
		
		pnBuscarDp = new JPanel();
		pnBuscarDp.setBounds(10, 118, 194, 39);
		mainPanel.add(pnBuscarDp);
		pnBuscarDp.setLayout(null);
		s.mdPanel(pnBuscarDp);
		
		lblIconQueryDp = new JLabel("");
		lblIconQueryDp.setBounds(0, 0, 46, 39);
		pnBuscarDp.add(lblIconQueryDp);
		lblIconQueryDp.setIcon(new ImageIcon("views/searchDp32.png"));
		
		lblBuscarDp = new JLabel("Buscar DP");
		lblBuscarDp.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		lblBuscarDp.setBounds(46, 0, 148, 39);
		pnBuscarDp.add(lblBuscarDp);
		
		btnBuscarDp = new JButton("");
		btnBuscarDp.setBounds(0, 0, 194, 39);
		pnBuscarDp.add(btnBuscarDp);
		s.btnTransparent(btnBuscarDp);
		btnBuscarDp.addActionListener(this);
		btnBuscarDp.addMouseListener(this);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 168, 194, 39);
		mainPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 0, 46, 39);
		panel_2.add(label_1);
		
		JLabel label = new JLabel("Buscar DP");
		label.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		label.setBounds(46, 0, 148, 39);
		panel_2.add(label);
	
		btnBack.addMouseListener(this);
		btnAddDp.addMouseListener(this);
		btnAddDp.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == btnBack) {
			s.btnPointer(btnBack);
		}else if(e.getSource() == btnAddDp || e.getSource() == pnAddDp) {
			s.btnPointer(btnAddDp);
			s.panelPointer(pnAddDp);
		}else if(e.getSource() == btnBuscarDp || e.getSource() == pnBuscarDp) {
			s.btnPointer(btnBuscarDp);
			s.panelPointer(pnBuscarDp);
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

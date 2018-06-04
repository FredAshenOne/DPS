package main;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class QueryEmployee extends JFrame implements MouseListener,ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextField txtId,txtName,txtApp,txtApm;
	Style s = new Style();
	JButton btnBack,btnQuery;

	public QueryEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 227, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 211, 279);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		s.mdPanel(mainPanel);
		
		JLabel lblHeader = new JLabel("Consultar Empleado");
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		lblHeader.setBounds(54, 11, 119, 22);
		mainPanel.add(lblHeader);
		
		btnBack = new JButton("");
		btnBack.setBounds(10, 12, 24, 24);
		mainPanel.add(btnBack);
		s.btnIcon(btnBack, "views/back.png");
		
		txtId = new JTextField();
		txtId.setBounds(10, 64, 191, 31);
		mainPanel.add(txtId);
		txtId.setColumns(10);
		txtId.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.LIGHT_GRAY));
		TextPrompt tpId = new TextPrompt("Id Empleado",txtId);
		tpId.setHorizontalAlignment(SwingConstants.CENTER);
		tpId.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 12));
		tpId.setForeground(Color.gray);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(10, 121, 191, 31);
		mainPanel.add(txtName);
		txtName.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.LIGHT_GRAY));
		TextPrompt tpName = new TextPrompt("Nombre(s)",txtName);
		tpName.setHorizontalAlignment(SwingConstants.CENTER);
		tpName.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 12));
		tpName.setForeground(Color.gray);
		
		txtApp = new JTextField();
		txtApp.setColumns(10);
		txtApp.setBounds(10, 163, 191, 31);
		mainPanel.add(txtApp);
		txtApp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.LIGHT_GRAY));
		TextPrompt tpApp = new TextPrompt("Apellido Paterno",txtApp);
		tpApp.setHorizontalAlignment(SwingConstants.CENTER);
		tpApp.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 12));
		tpApp.setForeground(Color.gray);
		
		txtApm = new JTextField();
		txtApm.setColumns(10);
		txtApm.setBounds(10, 205, 191, 31);
		mainPanel.add(txtApm);
		txtApm.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.LIGHT_GRAY));
		TextPrompt tpApm = new TextPrompt("Apellido Materno",txtApm);
		tpApm.setHorizontalAlignment(SwingConstants.CENTER);
		tpApm.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 12));
		tpApm.setForeground(Color.gray);
		
		JLabel lblNewLabel = new JLabel("- o -");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 96, 191, 22);
		mainPanel.add(lblNewLabel);
		
		btnQuery = new JButton("Buscar");
		btnQuery.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		btnQuery.setBounds(10, 247, 191, 21);
		mainPanel.add(btnQuery);
		s.mdButton(btnQuery, Color.decode("#0091EA"));
		btnQuery.addMouseListener(this);
		btnQuery.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnQuery) {
			
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == btnQuery) {
			s.btnPointer(btnQuery);
			s.btnHover(btnQuery, Color.decode("#0091EA"), Color.WHITE, Color.decode("#0091EA"));
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == btnQuery) {
			s.mdButton(btnQuery, Color.decode("#0091EA"));
		}
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

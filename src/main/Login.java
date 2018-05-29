package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class Login extends JFrame implements ActionListener,MouseListener{

	private JPanel contentPane;
	private JTextField txtCorreo;
	private JPasswordField txtPassword;
	JButton btnRecupera,btnIngresar;
	Style s = new Style();
	JRadioButton rbtnView;

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 259, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 244, 262);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.WHITE);
		JLabel lblIniciarSesin = new JLabel("Iniciar Sesi\u00F3n");
		lblIniciarSesin.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciarSesin.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblIniciarSesin.setBounds(10, 11, 224, 20);
		mainPanel.add(lblIniciarSesin);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(10, 42, 224, 46);
		mainPanel.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		TextPrompt tpCorreo = new TextPrompt("Correo Electrónico",txtCorreo);
		
		txtPassword = new JPasswordField();
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setBounds(10, 99, 224, 46);
		mainPanel.add(txtPassword);
		tpCorreo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tpCorreo.setForeground(Color.gray);
		TextPrompt tpPass = new TextPrompt("Contraseña", txtPassword);
		
		btnRecupera = new JButton("Recupera la contrase\u00F1a");
		btnRecupera.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnRecupera.setBounds(10, 182, 224, 23);
		mainPanel.add(btnRecupera);
		tpPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tpPass.setForeground(Color.gray);
		
		
		btnRecupera.setOpaque(true);
		btnRecupera.setForeground(Color.decode("#039BE5"));
		btnRecupera.setBackground(null);
		btnRecupera.setBorder(null);
		
		rbtnView = new JRadioButton("Ver contrase\u00F1a");
		rbtnView.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rbtnView.setBounds(10, 152, 109, 23);
		mainPanel.add(rbtnView);
		rbtnView.setOpaque(true);
		rbtnView.setBackground(null);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(10, 216, 224, 35);
		mainPanel.add(btnIngresar);
		tpPass.setHorizontalAlignment(JLabel.CENTER);
		tpCorreo.setHorizontalAlignment(JLabel.CENTER);
		btnRecupera.addMouseListener(this);
		
		s.mdButton(btnIngresar, Color.decode("#0091EA"));
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == btnRecupera) {
			s.btnPointer(btnRecupera);
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
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class Login extends JFrame implements ActionListener,MouseListener{

	private JPanel contentPane;
	private JTextField txtCorreo;
	private JPasswordField txtPassword;
	JButton btnRecupera,btnIngresar;
	Style s = new Style();
	JLabel lblLook;
	MainMenu mm = new MainMenu();
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
		lblIniciarSesin.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblIniciarSesin.setBounds(10, 11, 224, 20);
		mainPanel.add(lblIniciarSesin);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		txtCorreo.setBounds(10, 42, 224, 46);
		mainPanel.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		TextPrompt tpCorreo = new TextPrompt("Correo Electrónico",txtCorreo);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		txtPassword.setBounds(10, 99, 195, 46);
		mainPanel.add(txtPassword);
		tpCorreo.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 15));
		tpCorreo.setForeground(Color.gray);
		TextPrompt tpPass = new TextPrompt("Contraseña", txtPassword);
		
		btnRecupera = new JButton("Recupera la contrase\u00F1a");
		btnRecupera.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnRecupera.setBounds(10, 182, 224, 23);
		mainPanel.add(btnRecupera);
		tpPass.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 15));
		tpPass.setForeground(Color.gray);
		
		
		btnRecupera.setOpaque(true);
		btnRecupera.setForeground(Color.decode("#039BE5"));
		btnRecupera.setBackground(null);
		btnRecupera.setBorder(null);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		btnIngresar.setBounds(10, 216, 224, 35);
		mainPanel.add(btnIngresar);
		btnRecupera.addMouseListener(this);
		btnIngresar.addMouseListener(this);
		btnIngresar.addActionListener(this);
		s.mdButton(btnIngresar, Color.decode("#0091EA"));
		
		lblLook = new JLabel();
		lblLook.setBounds(204, 99, 30, 46);
		mainPanel.add(lblLook);
		lblLook.setIcon(new ImageIcon("views/eye24.png"));
		txtPassword.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0,Color.gray));
		lblLook.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.gray));
		lblLook.addMouseListener(this);
		mm.btnBack.addActionListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == btnIngresar) {
			s.btnPointer(btnIngresar);
			s.btnHover(btnIngresar,Color.decode("#0091EA"),Color.white, Color.decode("#0091EA"));
		}else if(e.getSource() == btnRecupera) {
			s.btnPointer(btnRecupera);
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==btnIngresar) {
			s.mdButton(btnIngresar, Color.decode("#0091EA"));
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource()==lblLook) {
			txtPassword.setEchoChar((char)0);
		}		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource() == lblLook) {
			txtPassword.setEchoChar(('•'));
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnIngresar) {
			this.setVisible(false);
			mm.setVisible(true);
		}else if(e.getSource() == mm.btnBack) {
			this.setVisible(true);
			mm.setVisible(false);
		}
	}
}

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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Login extends JFrame implements ActionListener,MouseListener{

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCorreo;
	private JPasswordField txtPassword;
	JButton btnRecupera,btnIngresar;
	Style s = new Style();
	ResultSet res;
	String contraseña;
	Conexion c = new Conexion();
	JLabel lblLook,lblWarning;
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
		txtCorreo.setBorder(BorderFactory.createCompoundBorder(txtCorreo.getBorder(),BorderFactory.createEmptyBorder(5,5,5,5)));
		TextPrompt tpCorreo = new TextPrompt("Correo Electrónico",txtCorreo);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		txtPassword.setBounds(10, 99, 195, 46);
		mainPanel.add(txtPassword);
		tpCorreo.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 15));
		tpCorreo.setForeground(Color.gray);
		TextPrompt tpPass = new TextPrompt("Contraseña", txtPassword);
		txtPassword.setBorder(BorderFactory.createCompoundBorder(txtPassword.getBorder(),BorderFactory.createEmptyBorder(10,10,10,10)));
		
		
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
		
		lblWarning = new JLabel("");
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 11));
		lblWarning.setBounds(10, 157, 224, 14);
		mainPanel.add(lblWarning);
		lblWarning.setForeground(Color.RED);
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
			contraseña = new String(txtPassword.getPassword());
			//if(isAnEmail(txtCorreo.getText())) {
				res = c.query("Select * from empleados where Correo ='"+txtCorreo.getText()+"' and contraseña = '"+contraseña+"'");
				try {
					if(res.next()) {
						lblWarning.setText("");
						this.setVisible(false);
						mm.lblTitle.setText("Bienvenido "+res.getString("nombre"));
						mm.setVisible(true);
					}else {
						lblWarning.setText("Usuario o contraseña no validos");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
					lblWarning.setText("No se pudo conectar");
				}
			//}else {
				//lblWarning.setText("Correo no valido");
			//}
		}else if(e.getSource() == mm.btnBack) {
			this.setVisible(true);
			mm.setVisible(false);
		}
	}
	
	public boolean isAnEmail(String email) {
		Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(email);
		return m.find();
	}
}

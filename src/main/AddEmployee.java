package main;

import java.awt.Color;
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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddEmployee extends JFrame implements ActionListener,MouseListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextField txtName,txtApp,txtApm,txtAge,txtWeight,txtHeight,txtDep,txtDia,txtMes,txtAno,
	txtCorreo,txtPass1,txtPass2,txtPuesto;
	JButton btnBack,btnCompetencias,btnInsert;
	Conexion c = new Conexion();
	Style s = new Style();
	int id =0,puestoId,depId;
	JLabel lblPhoto,lblCompetencias,lblWarning,lblFecha,lblCheck,lblCheckMail;
	JPanel pnCompentencias;
	JRadioButton rdComp1,rdComp2,rdComp3,rdComp4,rdComp5,rdComp6,rdComp7,rdComp8,rdComp9,rdComp10,
	rdComp11,rdComp12,rdComp13,rdComp14,rdComp15,rdComp16,rdComp17,rdComp18,rdComp19,rdComp20,
	rdComp21,rdComp22,rdComp23,rdComp24,rdComp25,rdComp26,rdComp27,rdComp28,rdComp29,rdComp30,rdComp31,rdComp32,rdComp33;
	List<JRadioButton> listB = new ArrayList<JRadioButton>();
	boolean arrow = true,puestocheck = false,insert = true;
	String fecha;
	String[] compArray;
	Employees e = new Employees();
	
	
	public AddEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 472, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 456, 760);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		s.mdPanel(mainPanel);
		
		JLabel lblHeader = new JLabel("Registrar nuevo empleado");
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(44, 13, 366, 23);
		mainPanel.add(lblHeader);
		
		btnBack = new JButton();
		btnBack.setBounds(10, 12, 24, 24);
		mainPanel.add(btnBack);
		s.btnIcon(btnBack, "views/back.png");
		btnBack.addActionListener(this);
		btnBack.addMouseListener(this);
		
		txtName = new JTextField();
		txtName.setBounds(138, 43, 272, 20);
		mainPanel.add(txtName);
		txtName.setColumns(10);
		TextPrompt tpName = new TextPrompt("Nombre(s)", txtName);
		tpName.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpName.setForeground(Color.gray);
		txtName.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.LIGHT_GRAY));
		
		txtApp = new JTextField();
		txtApp.setBounds(138, 74, 180, 20);
		mainPanel.add(txtApp);
		txtApp.setColumns(10);
		txtApp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.LIGHT_GRAY));
		TextPrompt tpApp = new TextPrompt("Apellido Paterno",txtApp);
		tpApp.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpApp.setForeground(Color.gray);
		
		txtApm = new JTextField();
		txtApm.setBounds(138, 105, 180, 20);
		mainPanel.add(txtApm);
		txtApm.setColumns(10);
		txtApm.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.LIGHT_GRAY));
		TextPrompt tpApm = new TextPrompt("Apellido Materno",txtApm);
		tpApm.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpApm.setForeground(Color.gray);
		
		txtAge = new JTextField();
		txtAge.setBounds(374, 74, 36, 20);
		mainPanel.add(txtAge);
		txtAge.setColumns(10);
		
		JLabel lblAge = new JLabel("Edad:");
		lblAge.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblAge.setBounds(328, 73, 36, 20);
		mainPanel.add(lblAge);
		
		txtWeight = new JTextField();
		txtWeight.setColumns(10);
		txtWeight.setBounds(374, 136, 36, 20);
		mainPanel.add(txtWeight);
		
		txtHeight = new JTextField();
		txtHeight.setColumns(10);
		txtHeight.setBounds(374, 105, 36, 20);
		mainPanel.add(txtHeight);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblPeso.setBounds(328, 135, 36, 20);
		mainPanel.add(lblPeso);
		
		JLabel lblHeight = new JLabel("Altura:");
		lblHeight.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblHeight.setBounds(328, 104, 36, 20);
		mainPanel.add(lblHeight);
		
		lblPhoto = new JLabel("<html><body>Agregar<br>Fotografía</body></html>");
		lblPhoto.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblPhoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoto.setBounds(39, 41, 89, 115);
		mainPanel.add(lblPhoto);
		lblPhoto.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.LIGHT_GRAY));
		
		txtDep = new JTextField();
		txtDep.setColumns(10);
		txtDep.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.LIGHT_GRAY));
		txtDep.setBounds(138, 136, 180, 20);
		mainPanel.add(txtDep);
		TextPrompt tpDep= new TextPrompt("Departamento",txtDep);
		tpDep.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpDep.setForeground(Color.gray);
		
		pnCompentencias = new JPanel();
		pnCompentencias.setBounds(22, 319, 410, 31);
		mainPanel.add(pnCompentencias);
		pnCompentencias.setLayout(null);
		s.mdPanel(pnCompentencias);
		
		lblCompetencias = new JLabel("Competencias");
		lblCompetencias.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblCompetencias.setBounds(20, 8, 76, 14);
		pnCompentencias.add(lblCompetencias);
		
		btnCompetencias = new JButton("");
		btnCompetencias.setBounds(94, 8, 18, 18);
		pnCompentencias.add(btnCompetencias);
		s.btnIcon(btnCompetencias, "views/downArr.png");
		
		rdComp1 = new JRadioButton("Adaptabilidad");
		rdComp1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp1.setBounds(20, 31, 97, 23);
		pnCompentencias.add(rdComp1);
		s.mdRdbtn(rdComp1);
		listB.add(rdComp1);
		
		rdComp2 = new JRadioButton("Anal. Problema");
		rdComp2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp2.setBounds(20, 57, 97, 23);
		pnCompentencias.add(rdComp2);
		s.mdRdbtn(rdComp2);
		listB.add(rdComp2);
		
		rdComp3 = new JRadioButton("Anal. Numerico");
		rdComp3.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp3.setBounds(20, 83, 97, 23);
		pnCompentencias.add(rdComp3);
		s.mdRdbtn(rdComp3);
		listB.add(rdComp3);
		
		rdComp4 = new JRadioButton("<html><body>Asuncion <br>Riesgos</body></html>");
		rdComp4.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp4.setBounds(119, 187, 97, 28);
		pnCompentencias.add(rdComp4);
		s.mdRdbtn(rdComp4);
		listB.add(rdComp4);
		
		rdComp5 = new JRadioButton("Automovitacion");
		rdComp5.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp5.setBounds(20, 109, 97, 23);
		pnCompentencias.add(rdComp5);
		s.mdRdbtn(rdComp5);
		listB.add(rdComp5);
		
		rdComp6 = new JRadioButton("<html><body>Atenci\u00F3n<br>Cliente</body></html>");
		rdComp6.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp6.setBounds(20, 214, 97, 28);
		pnCompentencias.add(rdComp6);
		s.mdRdbtn(rdComp6);
		listB.add(rdComp6);
		
		rdComp7 = new JRadioButton("Control");
		rdComp7.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp7.setBounds(20, 135, 97, 23);
		pnCompentencias.add(rdComp7);
		s.mdRdbtn(rdComp7);
		listB.add(rdComp7);
		
		rdComp33 = new JRadioButton("<html><body>Capacidad<br>Critica</body></html>");
		rdComp33.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp33.setBounds(20, 187, 97, 28);
		pnCompentencias.add(rdComp33);
		s.mdRdbtn(rdComp33);
		listB.add(rdComp33);
		
		rdComp8 = new JRadioButton("Creatividad");
		rdComp8.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp8.setBounds(119, 32, 97, 23);
		pnCompentencias.add(rdComp8);
		s.mdRdbtn(rdComp8);
		listB.add(rdComp8);
		
		rdComp9 = new JRadioButton("<html><body>Comunicaci\u00F3n<br>No verbal</body></html>");
		rdComp9.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp9.setBounds(119, 218, 97, 28);
		pnCompentencias.add(rdComp9);
		s.mdRdbtn(rdComp9);
		listB.add(rdComp9);
		
		rdComp10 = new JRadioButton("Compromiso");
		rdComp10.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp10.setBounds(119, 58, 97, 23);
		pnCompentencias.add(rdComp10);
		s.mdRdbtn(rdComp10);
		listB.add(rdComp10);
		
		rdComp11 = new JRadioButton("Delegaci\u00F3n");
		rdComp11.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp11.setBounds(119, 84, 97, 23);
		pnCompentencias.add(rdComp11);
		s.mdRdbtn(rdComp11);
		listB.add(rdComp11);
		
		rdComp12 = new JRadioButton("Decisi\u00F3n");
		rdComp12.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp12.setBounds(119, 110, 97, 23);
		pnCompentencias.add(rdComp12);
		listB.add(rdComp12);
		
		rdComp13 = new JRadioButton("Escucha");
		rdComp13.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp13.setBounds(119, 135, 97, 23);
		pnCompentencias.add(rdComp13);
		s.mdRdbtn(rdComp13);
		listB.add(rdComp13);
		
		rdComp14 = new JRadioButton("Energ\u00EDa");
		rdComp14.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp14.setBounds(218, 32, 97, 23);
		pnCompentencias.add(rdComp14);
		s.mdRdbtn(rdComp14);
		listB.add(rdComp14);
		
		rdComp15 = new JRadioButton("Flexibilidad");
		rdComp15.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp15.setBounds(218, 58, 97, 23);
		pnCompentencias.add(rdComp15);
		s.mdRdbtn(rdComp15);
		listB.add(rdComp15);
		
		rdComp16 = new JRadioButton("Independencia");
		rdComp16.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp16.setBounds(218, 84, 97, 23);
		pnCompentencias.add(rdComp16);
		s.mdRdbtn(rdComp16);
		listB.add(rdComp16);
		
		rdComp17 = new JRadioButton("Integridad");
		rdComp17.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp17.setBounds(218, 110, 97, 23);
		pnCompentencias.add(rdComp17);
		s.mdRdbtn(rdComp17);
		listB.add(rdComp17);
		
		rdComp18 = new JRadioButton("Impacto");
		rdComp18.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp18.setBounds(218, 136, 97, 23);
		pnCompentencias.add(rdComp18);
		s.mdRdbtn(rdComp18);
		listB.add(rdComp18);
		
		rdComp19 = new JRadioButton("Liderazgo");
		rdComp19.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp19.setBounds(317, 32, 97, 23);
		pnCompentencias.add(rdComp19);
		s.mdRdbtn(rdComp19);
		listB.add(rdComp19);
		
		rdComp20 = new JRadioButton("Iniciativa");
		rdComp20.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp20.setBounds(317, 58, 97, 23);
		pnCompentencias.add(rdComp20);
		s.mdRdbtn(rdComp20);
		listB.add(rdComp20);
		
		rdComp21 = new JRadioButton("Meticulosidad");
		rdComp21.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp21.setBounds(317, 84, 97, 23);
		pnCompentencias.add(rdComp21);
		s.mdRdbtn(rdComp21);
		listB.add(rdComp21);
		
		rdComp22 = new JRadioButton("Resistencia");
		rdComp22.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp22.setBounds(317, 110, 97, 23);
		pnCompentencias.add(rdComp22);
		s.mdRdbtn(rdComp22);
		listB.add(rdComp22);
		
		rdComp31 = new JRadioButton("Sociabilidad");
		rdComp31.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp31.setBounds(317, 136, 97, 18);
		pnCompentencias.add(rdComp31);
		s.mdRdbtn(rdComp31);
		listB.add(rdComp31);
		
		rdComp30 = new JRadioButton("Tenacidad");
		rdComp30.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp30.setBounds(20, 161, 97, 23);
		pnCompentencias.add(rdComp30);
		s.mdRdbtn(rdComp30);
		listB.add(rdComp30);
		
		rdComp23 = new JRadioButton("Equipo");
		rdComp23.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp23.setBounds(119, 161, 97, 23);
		pnCompentencias.add(rdComp23);
		s.mdRdbtn(rdComp23);
		listB.add(rdComp23);
		
		rdComp24 = new JRadioButton("<html><body>Sensibilidad<br>Interpersonal</body></html>");
		rdComp24.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp24.setBounds(218, 183, 97, 28);
		pnCompentencias.add(rdComp24);
		s.mdRdbtn(rdComp24);
		listB.add(rdComp24);
		
		rdComp25 = new JRadioButton("<html><body>Sensibilidad<br>Organizacional</body></html>");
		rdComp25.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp25.setBounds(218, 214, 97, 28);
		pnCompentencias.add(rdComp25);
		s.mdRdbtn(rdComp25);
		listB.add(rdComp25);
		
		rdComp26 = new JRadioButton("<html><body>Planificacion<br>Organizacion</body></html>");
		rdComp26.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp26.setBounds(317, 183, 97, 28);
		pnCompentencias.add(rdComp26);
		s.mdRdbtn(rdComp26);
		listB.add(rdComp26);
		
		rdComp27 = new JRadioButton("<html><body>Niveles<br>Trabajo</body></html>");
		rdComp27.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp27.setBounds(317, 214, 97, 28);
		pnCompentencias.add(rdComp1);
		s.mdRdbtn(rdComp27);
		listB.add(rdComp27);
		
		rdComp28 = new JRadioButton("<html><body>Tolerancia<br>al  Estres</body></html>");
		rdComp28.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp28.setBounds(218, 156, 97, 28);
		pnCompentencias.add(rdComp28);
		s.mdRdbtn(rdComp28);
		listB.add(rdComp28);
		
		rdComp29 = new JRadioButton("<html><body>Sensibilidad<br>Organizacional</body></html>");
		rdComp29.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp29.setBounds(317, 156, 97, 28);
		pnCompentencias.add(rdComp29);
		s.mdRdbtn(rdComp29);
		listB.add(rdComp29);
		
		btnInsert = new JButton("Registrar");
		btnInsert.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnInsert.setBounds(313, 361, 119, 31);
		mainPanel.add(btnInsert);
		s.mdButton(btnInsert, Color.decode("#0091EA"));
		
		lblWarning = new JLabel("");
		lblWarning.setForeground(Color.RED);
		lblWarning.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 11));
		lblWarning.setBounds(39, 294, 393, 14);
		mainPanel.add(lblWarning);
		
		lblFecha = new JLabel("Fecha Inicio");
		lblFecha.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblFecha.setBounds(308, 167, 62, 14);
		mainPanel.add(lblFecha);
		
		txtDia = new JTextField();
		txtDia.setBounds(271, 192, 36, 20);
		mainPanel.add(txtDia);
		txtDia.setColumns(10);
		TextPrompt tpDia = new TextPrompt("DD",txtDia);
		tpDia.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpDia.setForeground(Color.gray);
		
		txtMes = new JTextField();
		txtMes.setColumns(10);
		txtMes.setBounds(313, 192, 36, 20);
		mainPanel.add(txtMes);
		TextPrompt tpMes = new TextPrompt("MM",txtMes);
		tpMes.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpMes.setForeground(Color.gray);
		
		txtAno = new JTextField();
		txtAno.setColumns(10);
		txtAno.setBounds(357, 192, 53, 20);
		TextPrompt tpAno = new TextPrompt("AAAA",txtAno);
		mainPanel.add(txtAno);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(39, 192, 206, 20);
		mainPanel.add(txtCorreo);
		txtCorreo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				existingEmail(txtCorreo.getText());
			}
		});
		txtCorreo.setColumns(10);
		TextPrompt tpCorreo = new TextPrompt("Correo",txtCorreo);
		tpCorreo.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpCorreo.setForeground(Color.gray);
		
		txtPass1 = new JTextField();
		txtPass1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				passMatch();
			}
		});
		txtPass1.setColumns(10);
		txtPass1.setBounds(39, 223, 206, 20);
		mainPanel.add(txtPass1);
		TextPrompt tpPass1 = new TextPrompt("Contraseña",txtPass1);
		tpPass1.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpPass1.setForeground(Color.gray);
		
		txtPass2 = new JTextField();
		txtPass2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				passMatch();
			}
		});
		txtPass2.setColumns(10);
		txtPass2.setBounds(39, 254, 206, 20);
		mainPanel.add(txtPass2);
		TextPrompt tpPass2 = new TextPrompt("Confirme contraseña",txtPass2);
		tpPass2.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpPass2.setForeground(Color.gray);
		
		lblCheck = new JLabel("");
		lblCheck.setForeground(Color.RED);
		lblCheck.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 11));
		lblCheck.setBounds(255, 251, 180, 23);
		mainPanel.add(lblCheck);
		
		lblCheckMail = new JLabel("");
		lblCheckMail.setForeground(Color.RED);
		lblCheckMail.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 11));
		lblCheckMail.setBounds(255, 220, 180, 23);
		mainPanel.add(lblCheckMail);
		
		txtPuesto = new JTextField();
		txtPuesto.setBounds(39, 167, 206, 20);
		mainPanel.add(txtPuesto);
		txtPuesto.setColumns(10);
		tpAno.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpAno.setForeground(Color.gray);
		TextPrompt tpPuesto = new TextPrompt("Puesto",txtPuesto);
		tpPuesto.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpPuesto.setForeground(Color.gray);
		
		btnInsert.addActionListener(this);
		btnInsert.addMouseListener(this);		
		btnCompetencias.addActionListener(this);
		btnCompetencias.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == btnCompetencias) {
			s.btnPointer(btnCompetencias);
		}else if(e.getSource() == btnInsert) {
			s.btnPointer(btnInsert);
			s.btnHover(btnInsert, Color.decode("#0091EA"), Color.white, Color.decode("#0091EA"));
		}else if(e.getSource() == btnBack) {
			s.btnPointer(btnBack);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		s.mdButton(btnInsert, Color.decode("#0091EA"));
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCompetencias) {
			if(arrow) {			
				pnCompentencias.setBounds(22, 319, 410, 261);
				btnInsert.setBounds(313, 586, 119, 31);
				setBounds(50, 50, 472, 664);
				arrow = false;
				btnCompetencias.setIcon(new ImageIcon("views/upArr.png"));
			}else {
				pnCompentencias.setBounds(22, 319, 410, 31);
				btnInsert.setBounds(313, 361, 119, 31);
				setBounds(50, 50, 472, 439);
				arrow = true;
				btnCompetencias.setIcon(new ImageIcon("views/downArr.png"));
			}
		}else if(e.getSource() == btnInsert) {
			if(!emptyFields()) {
				if(!existingEmployee(txtName.getText(),txtApp.getText(),txtApm.getText())) {
					insertEmployee(txtName.getText(),txtApp.getText(),txtApm.getText());		
					if(existingEmployee(txtName.getText(),txtApp.getText(),txtApm.getText())) {
						insert = true;
					}else{
						insert = false;
					}
				}				
			}
			
		}
		
	}
	
	public boolean emptyFields(){
		if(txtName.getText().length()>0&&txtApp.getText().length()>0&&txtApm.getText().length()>0&&txtDep.getText().length()>0
			&&txtDia.getText().length()>0&&txtMes.getText().length()>0&&txtAno.getText().length()>0&&txtCorreo.getText().length()>0
			&&txtPass1.getText().length()>0&&txtPass2.getText().length()>0) {
			if(getCompetencias().length>0) {
				return false;
			}else {
				lblWarning.setText("Selecciona por lo menos una competencia");
			}
		}else {
			lblWarning.setText("Aun hay campos vacíos");
			return true;
		}
		return true;
	}
	
	public String[] getCompetencias() {
		int cont =0,cont1=0;
		
		Iterator<JRadioButton> iterr = listB.iterator();
		while(iterr.hasNext()) {
			JRadioButton rd = iterr.next();
			if(rd.isSelected()) {
				cont++;
			}
		}
		Iterator<JRadioButton> iterr1 = listB.iterator();
		compArray = new String[cont];
		while(iterr1.hasNext()) {
			JRadioButton rd1 = iterr1.next();
			if(rd1.isSelected()) {
				System.out.println(rd1.getText());
				compArray[cont1] = rd1.getText();
				cont1++;
			}
		}
		return compArray;
	}
	
	public void insertCompetencias(String[] arr,int id) {
		ResultSet resid;
		
		try{
			for(int i =0;i<arr.length;i++) {
				resid = c.query("SELECT id FROM competencias WHERE descripcion = '"+arr[i]+"'");
				if(resid.next()) {
					System.out.println(arr[i]+" "+id);
					c.update("INSERT INTO habilidades (id_Empleado,id_Competencia) VALUES ("+id+","+Integer.parseInt(resid.getString("id"))+")");
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	public boolean existingEmployee(String name,String App,String Apm) {
		ResultSet rs;
		try {
			rs = c.query("SELECT * FROM empleados where nombre ='"+name+"' AND apellido_Paterno = '"+App+"' AND apellido_Materno = '"+Apm+"'");
			if(rs.next()) {
				lblWarning.setText("Empleado ya registrado");
				return true;				
			}else {
				return false;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public Boolean isDate(String day,String mes,String año) {
		Pattern dayMonth = Pattern.compile("[0-9][0-9]");
		Pattern year = Pattern.compile("[0-9][0-9][0-9][0-9]");
		Matcher md = dayMonth.matcher(day);
		Matcher mm = dayMonth.matcher(mes);
		Matcher my = year.matcher(año);
		return (md.matches()&&mm.matches()&&my.matches());
		
	}

	public boolean puestoExists() {
		ResultSet rs;
		try {
			rs = c.query("SELECT id FROM puesto WHERE descripcion = '"+txtPuesto.getText()+"'");
			if(rs.next()) {
				puestoId = rs.getInt("id");
				return true;
			}else {
				lblWarning.setText("Puesto no valido");
				return false;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public boolean depExists() {
		ResultSet rs;
		try {
			rs = c.query("SELECT id FROM departamento WHERE descripcion = '"+txtDep.getText()+"'");
			if(rs.next()) {
				depId = rs.getInt("id");
				return true;
			}else {
				lblWarning.setText("Departamento no valido");
				return false;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public void insertEmployee(String name,String app, String apm) {

		if(isDate(txtDia.getText(),txtMes.getText(),txtAno.getText())) {
			fecha = txtAno.getText()+txtMes.getText()+txtDia.getText();
		}else {
			lblWarning.setText("La fecha no es valida");
		}
		try {
			if(!existingEmail(txtCorreo.getText())&&passMatch()&&puestoExists()&&depExists()) {
				c.update("INSERT INTO empleados (id_Puesto,edad,altura,peso,id_Departamento,nombre,apellido_Paterno,apellido_Materno"
						+ ",FechaInicio,Correo,Contraseña) VALUES ("+puestoId+","+Integer.parseInt(txtAge.getText())+
						","+Integer.parseInt(txtHeight.getText())+","+Integer.parseInt(txtWeight.getText())+
								","+depId+",'"+name+"','"+app+"','"+apm+"','"+fecha+"','"+txtCorreo.getText()+"','"+txtPass1.getText()+"');");
				System.out.println(getCompetencias()[0]+" "+e.getIdByName(name,app,apm));
				insertCompetencias(getCompetencias(),e.getIdByName(name,app,apm));
				lblWarning.setText("");
			}

		} catch (Exception e) {
			
		}
	}
	
	public boolean existingEmail(String email) {
		ResultSet rs;
		Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(email);
		if(m.find()) {
			try {
				rs = c.query("SELECT * FROM empleados WHERE correo ='"+email+"'");
				if(rs.next()) {
					lblCheckMail.setForeground(Color.decode("#DD2C00"));
					lblCheckMail.setText("Ese correo ya esta registrado");
					return true;
				}else {
					lblCheckMail.setForeground(Color.decode("#00C853"));
					lblCheckMail.setText("Correo Disponible");
					return false;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else{
			lblCheckMail.setForeground(Color.decode("#DD2C00"));
			lblCheckMail.setText("Correo no valido");
			return true;
		}
		return true;
	}
	
	public void clearFields() {
		txtName.setText("");txtApp.setText("");txtApm.setText("");txtAge.setText("");txtWeight.setText("");txtHeight.setText("");
		txtDep.setText("");txtDia.setText("");txtMes.setText("");txtAno.setText("");txtCorreo.setText("");txtPass1.setText("");
		txtPass2.setText("");txtPuesto.setText("");
		Iterator<JRadioButton> iter = listB.iterator();
		while(iter.hasNext()) {
			JRadioButton btn = iter.next();
			btn.setSelected(false);
		}
		lblWarning.setText("");lblCheck.setText("");lblCheckMail.setText("");
		
	}
	
	
	public boolean passMatch() {
		if(txtPass1.getText().equals(txtPass2.getText())){
			lblCheck.setForeground(Color.decode("#00C853"));
			lblCheck.setText("Las contraseñas coinciden");
			return true;
		}else {
			lblCheck.setForeground(Color.decode("#DD2C00"));
			lblCheck.setText("Las contraseñas no coinciden");
			return false;
		}
	}
}

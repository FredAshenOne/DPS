package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class EditEmployee extends JFrame implements ActionListener,MouseListener {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextField txtName,txtApp,txtApm,txtEdad,txtWeight,txtHeight,txtDep,txtDia,txtMes,txtAno,
	txtCorreo,txtPass1,txtPass2,txtPuesto;
	JButton btnBack,btnCompetencias;
	Conexion c = new Conexion();
	Style s = new Style();
	int id =0,puestoId,depId;
	JLabel lblPhoto,lblCompetencias,lblWarning,lblFecha,lblCheck,lblCheckMail;
	JPanel pnCompentencias;
	JRadioButton rdComp1,rdComp2,rdComp3,rdComp4,rdComp5,rdComp6,rdComp7,rdComp8,rdComp9,rdComp10,
	rdComp11,rdComp12,rdComp13,rdComp14,rdComp15,rdComp16,rdComp17,rdComp18,rdComp19,rdComp20,
	rdComp21,rdComp22,rdComp23,rdComp24,rdComp25,rdComp26,rdComp27,rdComp28,rdComp29,rdComp30,rdComp31,rdComp32,rdComp33;
	List<JRadioButton> listB = new ArrayList();
	boolean arrow = true,puestocheck = false,insert = true;
	String fecha;
	String[] compArray;
	private JTextField txtFecha;
	
	public EditEmployee()  {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 472, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 456, 624);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		s.mdPanel(mainPanel);
		
		JLabel lblHeader = new JLabel("Registrar nuevo empleado");
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(44, 13, 366, 23);
		mainPanel.add(lblHeader);
		
		btnBack = new JButton();
		btnBack.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnBack.setBounds(10, 12, 24, 24);
		mainPanel.add(btnBack);
		s.btnIcon(btnBack, "views/back.png");
		btnBack.addActionListener(this);
		btnBack.addMouseListener(this);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		txtName.setBounds(138, 43, 272, 20);
		mainPanel.add(txtName);
		txtName.setColumns(10);
		TextPrompt tpName = new TextPrompt("Nombre(s)", txtName);
		tpName.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpName.setForeground(Color.gray);
		txtName.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.LIGHT_GRAY));
		
		txtApp = new JTextField();
		txtApp.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		txtApp.setBounds(138, 74, 180, 20);
		mainPanel.add(txtApp);
		txtApp.setColumns(10);
		txtApp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.LIGHT_GRAY));
		TextPrompt tpApp = new TextPrompt("Apellido Paterno",txtApp);
		tpApp.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpApp.setForeground(Color.gray);
		
		txtApm = new JTextField();
		txtApm.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		txtApm.setBounds(138, 105, 180, 20);
		mainPanel.add(txtApm);
		txtApm.setColumns(10);
		txtApm.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.LIGHT_GRAY));
		TextPrompt tpApm = new TextPrompt("Apellido Materno",txtApm);
		tpApm.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpApm.setForeground(Color.gray);
		
		txtEdad = new JTextField();
		txtEdad.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		txtEdad.setBounds(374, 74, 36, 20);
		mainPanel.add(txtEdad);
		txtEdad.setColumns(10);
		
		JLabel lblAge = new JLabel("Edad:");
		lblAge.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblAge.setBounds(328, 73, 36, 20);
		mainPanel.add(lblAge);
		
		txtWeight = new JTextField();
		txtWeight.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		txtWeight.setColumns(10);
		txtWeight.setBounds(374, 136, 36, 20);
		mainPanel.add(txtWeight);
		
		txtHeight = new JTextField();
		txtHeight.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
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
		txtDep.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		txtDep.setColumns(10);
		txtDep.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.LIGHT_GRAY));
		txtDep.setBounds(138, 136, 180, 20);
		mainPanel.add(txtDep);
		TextPrompt tpDep= new TextPrompt("Departamento",txtDep);
		tpDep.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpDep.setForeground(Color.gray);
		
		pnCompentencias = new JPanel();
		pnCompentencias.setBounds(22, 223, 410, 31);
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
		
		rdComp6 = new JRadioButton("<html><body>Atencion<br>Cliente</body></html>");
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
		
		rdComp9 = new JRadioButton("<html><body>Comunicacion<br>No verbal</body></html>");
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
		
		rdComp11 = new JRadioButton("Delegacion");
		rdComp11.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp11.setBounds(119, 84, 97, 23);
		pnCompentencias.add(rdComp11);
		s.mdRdbtn(rdComp11);
		listB.add(rdComp11);
		
		rdComp12 = new JRadioButton("Decision");
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
		
		rdComp14 = new JRadioButton("Energia");
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
		
		rdComp24 = new JRadioButton("<html><body>Comunicacion<br>Verbal</body></html>");
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
		
		rdComp29 = new JRadioButton("Organizacion");
		rdComp29.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdComp29.setBounds(317, 156, 97, 28);
		pnCompentencias.add(rdComp29);
		s.mdRdbtn(rdComp29);
		listB.add(rdComp29);
		
		lblWarning = new JLabel("");
		lblWarning.setForeground(Color.RED);
		lblWarning.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 11));
		lblWarning.setBounds(39, 294, 393, 14);
		mainPanel.add(lblWarning);
		
		lblFecha = new JLabel("Fecha Inicio");
		lblFecha.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblFecha.setBounds(308, 167, 62, 14);
		mainPanel.add(lblFecha);
		
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		txtCorreo.setBounds(39, 192, 206, 20);
		mainPanel.add(txtCorreo);
		txtCorreo.setColumns(10);
		TextPrompt tpCorreo = new TextPrompt("Correo",txtCorreo);
		tpCorreo.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpCorreo.setForeground(Color.gray);
		
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
		txtPuesto.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		txtPuesto.setBounds(39, 167, 206, 20);
		mainPanel.add(txtPuesto);
		txtPuesto.setColumns(10);
		
		TextPrompt tpPuesto = new TextPrompt("Puesto",txtPuesto);
		
		txtFecha = new JTextField();
		txtFecha.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		txtFecha.setBounds(255, 192, 180, 20);
		mainPanel.add(txtFecha);
		txtFecha.setColumns(10);
		tpPuesto.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 13));
		tpPuesto.setForeground(Color.gray);
		btnCompetencias.addActionListener(this);
		btnCompetencias.addMouseListener(this);
	}
	
	
	


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == btnCompetencias) {
			s.btnPointer(btnCompetencias);
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


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCompetencias) {
			
			if(arrow) {			
				pnCompentencias.setBounds(22, 223, 410, 261);
				setBounds(50, 50, 472, 540);
				arrow = false;
				btnCompetencias.setIcon(new ImageIcon("views/upArr.png"));
			}else {
				pnCompentencias.setBounds(22, 223, 410, 31);
				setBounds(50, 50, 472, 308);
				arrow = true;
				btnCompetencias.setIcon(new ImageIcon("views/downArr.png"));
			}
		}
			
	}
	
	public void editableFields(Boolean b) {
		txtName.setEditable(b);txtApp.setEditable(b);txtApm.setEditable(b);txtEdad.setEditable(b);txtWeight.setEditable(b);
		txtHeight.setEditable(b);txtDep.setEditable(b);txtDia.setEditable(b);txtMes.setEditable(b);txtAno.setEditable(b);
		txtCorreo.setEditable(b);txtPass1.setEditable(b);txtPass2.setEditable(b);txtPuesto.setEditable(b);
		Iterator<JRadioButton> iter = listB.iterator();
		while(iter.hasNext()) {
			JRadioButton btn = iter.next();
			btn.setEnabled(b);
		}		
	}
	
	public void fillFields(ResultSet rs) {
		try {
			rs.next(); 
		
			txtName.setText(rs.getString("nombre"));
			txtApp.setText(rs.getString("apellido_paterno"));
			txtEdad.setText(rs.getString("edad"));
			txtHeight.setText(rs.getString("altura"));
			txtWeight.setText(rs.getString("Peso"));
			txtApm.setText(rs.getString("apellido_Materno"));
			txtDep.setText(rs.getString("departamento"));
			txtPuesto.setText(rs.getString("puesto"));
			txtCorreo.setText(rs.getString("Correo"));
			txtFecha.setText(rs.getString("FechaInicio"));
			fillCompetencias(rs.getString("id"));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void fillCompetencias(String ids) {
		id = Integer.parseInt(ids);
		ResultSet rs;
		try {
			
			Iterator<JRadioButton> iter = listB.iterator();
			
			while(iter.hasNext()) {
				JRadioButton rd = iter.next();
				rs = c.query("SELECT c.descripcion competencia FROM habilidades h LEFT JOIN competencias c ON h.id_Competencia = c.id WHERE h.id_Empleado = "+id+";");
				while(rs.next()) {
					System.out.println(rs.getString("competencia")+" y "+rd.getText());
					if(rs.getString("competencia").equals(rd.getText())) {
						System.out.println(rs.getString("competencia")+" y "+rd.getText()+" coinciden");
						rd.setSelected(true);
					}
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}

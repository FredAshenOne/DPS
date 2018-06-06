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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class QueryEmployee extends JFrame implements MouseListener,ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JPanel namePanel;
	JTextField txtId,txtName,txtApp,txtApm;
	Style s = new Style();
	JLabel lblWarning;
	JButton btnBack,btnQuery;
	Conexion c = new Conexion();
	EditEmployee ee = new EditEmployee();
	Employees em = new Employees();
	JComboBox cbSelect;


	public QueryEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 227, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 211, 279);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		s.mdPanel(mainPanel);
		
		JLabel lblHeader = new JLabel("Buscar por: ");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		lblHeader.setBounds(54, 11, 96, 22);
		mainPanel.add(lblHeader);
		
		btnBack = new JButton("");
		btnBack.setBounds(10, 12, 24, 24);
		mainPanel.add(btnBack);
		s.btnIcon(btnBack, "views/back.png");
		
		txtId = new JTextField();
		txtId.setHorizontalAlignment(SwingConstants.CENTER);
		txtId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
			}
		});
		txtId.setBounds(10, 105, 191, 31);
		mainPanel.add(txtId);
		txtId.setColumns(10);
		txtId.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.LIGHT_GRAY));
		TextPrompt tpId = new TextPrompt("Id Empleado",txtId);
		tpId.setHorizontalAlignment(SwingConstants.CENTER);
		tpId.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 12));
		tpId.setForeground(Color.gray);
		
		btnQuery = new JButton("Buscar");
		btnQuery.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		btnQuery.setBounds(10, 147, 191, 31);
		mainPanel.add(btnQuery);
		s.mdButton(btnQuery, Color.decode("#0091EA"));
		
		lblWarning = new JLabel("");
		lblWarning.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 11));
		lblWarning.setBounds(10, 47, 191, 14);
		mainPanel.add(lblWarning);
		
		namePanel = new JPanel();
		namePanel.setBounds(0, 105, 211, 126);
		mainPanel.add(namePanel);
		namePanel.setLayout(null);
		namePanel.setVisible(false);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setBounds(10, 11, 191, 31);
		namePanel.add(txtName);
		txtName.setColumns(10);
		txtName.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.LIGHT_GRAY));
		TextPrompt tpName = new TextPrompt("Nombre(s)",txtName);
		
		txtApp = new JTextField();
		txtApp.setHorizontalAlignment(SwingConstants.CENTER);
		txtApp.setBounds(10, 47, 191, 31);
		namePanel.add(txtApp);
		txtApp.setColumns(10);
		txtApp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.LIGHT_GRAY));
		TextPrompt tpApp = new TextPrompt("Apellido Paterno",txtApp);
		
		txtApm = new JTextField();
		txtApm.setHorizontalAlignment(SwingConstants.CENTER);
		txtApm.setBounds(10, 85, 191, 31);
		namePanel.add(txtApm);
		txtApm.setColumns(10);
		txtApm.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.LIGHT_GRAY));
		TextPrompt tpApm = new TextPrompt("Apellido Materno",txtApm);		
		
		cbSelect = new JComboBox();
		cbSelect.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					if(cbSelect.getSelectedIndex() == 0) {
						btnQuery.setBounds(10,147,191,31);
						setBounds(100,100,227,228);
						txtId.setVisible(true);
						namePanel.setVisible(false);
					}else if(cbSelect.getSelectedIndex() == 1) {
						btnQuery.setBounds(10,233,191,31);
						setBounds(100,100,227,328);
						txtId.setVisible(false);
						namePanel.setVisible(true);
					}
				}
			}
		});
		cbSelect.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		cbSelect.setModel(new DefaultComboBoxModel(new String[] {"Id Empleado", "Nombre "}));
		cbSelect.setBounds(10, 63, 191, 31);
		mainPanel.add(cbSelect);
		tpApm.setHorizontalAlignment(SwingConstants.CENTER);
		tpApm.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 12));
		tpApm.setForeground(Color.gray);
		tpApp.setHorizontalAlignment(SwingConstants.CENTER);
		tpApp.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 12));
		tpApp.setForeground(Color.gray);
		tpName.setHorizontalAlignment(SwingConstants.CENTER);
		tpName.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 12));
		tpName.setForeground(Color.gray);
		btnQuery.addMouseListener(this);
		btnQuery.addActionListener(this);
		ee.btnBack.addActionListener(this);
		s.mdPanel(namePanel);
		s.mdCombo(cbSelect);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnQuery) {
			System.out.println(cbSelect.getSelectedIndex());
			if(em.empleadoExists(cbSelect.getSelectedIndex(),txtId.getText(),txtName.getText(),txtApp.getText(),txtApm.getText())) {
				System.out.println("siwA");
				if(cbSelect.getSelectedIndex() == 1) {
					
					ee.fillFields(getInfoByName());
					this.setVisible(false);
					ee.setVisible(true);
				}else if(cbSelect.getSelectedIndex() == 0){
					ee.fillFields(getInfoById(txtId.getText()));
					this.setVisible(false);
					ee.setVisible(true);
				}
				
			}else {
				lblWarning.setText("Empleado No registrado");
			}
		}else if(e.getSource() == ee.btnBack) {
			ee.setVisible(false);
			this.setVisible(true);
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
	
	public ResultSet getInfoById(String id) {
		if(em.empleadoExists(cbSelect.getSelectedIndex(),txtId.getText(), txtName.getText(), txtApp.getText(),txtApm.getText())) {
			int ids = Integer.parseInt(id);
			return c.query("SELECT e.id,e.edad,e.altura,e.peso,e.nombre,e.apellido_Paterno,e.apellido_Materno,e.FechaInicio,e.Correo,d.descripcion departamento,p.descripcion puesto"+ 
					" FROM empleados e LEFT JOIN departamento d on d.id = id_departamento LEFT JOIN puesto p on e.id_Puesto = p.id WHERE e.id = "+ids+";");
		}else {
			lblWarning.setText("Empleado no registrado");
		}
		return null;
	}
	
	public ResultSet getInfoByName() {
		if(em.empleadoExists(cbSelect.getSelectedIndex(),txtId.getText(), txtName.getText(), txtApp.getText(),txtApm.getText())) {
			return c.query("SELECT e.id,e.edad,e.altura,e.peso,e.nombre,e.apellido_Paterno,e.apellido_Materno,e.FechaInicio,e.Correo,d.descripcion departamento,p.descripcion puesto"
					+ " FROM empleados e LEFT JOIN departamento d on d.id = id_departamento LEFT JOIN puesto p on e.id_Puesto = p.id WHERE nombre = '"+txtName.getText()+"' AND apellido_Paterno ='"+txtApp.getText()+"' AND apellido_Materno ='"+txtApm.getText()+"' ;");
		}else {
			lblWarning.setText("Empleado no registrado");
		}
		return null;
	}
	
	public void isNumber(String id) {
		
	}
}

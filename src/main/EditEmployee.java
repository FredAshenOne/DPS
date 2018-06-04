package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class EditEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtApp;
	private JTextField txtApm;
	private JTextField txtEdad;
	private JTextField txtHeight;
	private JTextField txtWeight;
	private JTextField txtAno;
	private JTextField txtDia;
	private JTextField txtMes;
	private JTextField txtPuesto;
	private JTextField txtDep;
	private JComboBox comboBox;
	private JLabel lblComp;

	public EditEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 437, 277);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lblPhoto = new JLabel("<html><body>Agregar<br>Fotograf\u00EDa</body></html>");
		lblPhoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoto.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblPhoto.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.LIGHT_GRAY));
		lblPhoto.setBounds(28, 44, 89, 115);
		mainPanel.add(lblPhoto);
		
		JLabel lblHeader = new JLabel("");
		lblHeader.setBounds(100, 11, 257, 22);
		mainPanel.add(lblHeader);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.LIGHT_GRAY));
		txtName.setBounds(127, 44, 272, 20);
		mainPanel.add(txtName);
		
		txtApp = new JTextField();
		txtApp.setColumns(10);
		txtApp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.LIGHT_GRAY));
		txtApp.setBounds(127, 71, 180, 20);
		mainPanel.add(txtApp);
		
		txtApm = new JTextField();
		txtApm.setColumns(10);
		txtApm.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.LIGHT_GRAY));
		txtApm.setBounds(127, 96, 180, 20);
		mainPanel.add(txtApm);
		
		JLabel lblAge = new JLabel("Edad:");
		lblAge.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblAge.setBounds(317, 70, 36, 20);
		mainPanel.add(lblAge);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(363, 71, 36, 20);
		mainPanel.add(txtEdad);
		
		JLabel lblHeight = new JLabel("Altura:");
		lblHeight.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblHeight.setBounds(317, 98, 36, 20);
		mainPanel.add(lblHeight);
		
		txtHeight = new JTextField();
		txtHeight.setColumns(10);
		txtHeight.setBounds(363, 99, 36, 20);
		mainPanel.add(txtHeight);
		
		JLabel lblWeight = new JLabel("Peso:");
		lblWeight.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblWeight.setBounds(317, 129, 36, 20);
		mainPanel.add(lblWeight);
		
		txtWeight = new JTextField();
		txtWeight.setColumns(10);
		txtWeight.setBounds(363, 130, 36, 20);
		mainPanel.add(txtWeight);
		
		JLabel lblFecha = new JLabel("Fecha Inicio");
		lblFecha.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblFecha.setBounds(297, 161, 62, 14);
		mainPanel.add(lblFecha);
		
		txtAno = new JTextField();
		txtAno.setColumns(10);
		txtAno.setBounds(346, 186, 53, 20);
		mainPanel.add(txtAno);
		
		txtDia = new JTextField();
		txtDia.setColumns(10);
		txtDia.setBounds(261, 186, 36, 20);
		mainPanel.add(txtDia);
		
		txtMes = new JTextField();
		txtMes.setColumns(10);
		txtMes.setBounds(303, 186, 36, 20);
		mainPanel.add(txtMes);
		
		txtPuesto = new JTextField();
		txtPuesto.setColumns(10);
		txtPuesto.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.LIGHT_GRAY));
		txtPuesto.setBounds(127, 130, 180, 20);
		mainPanel.add(txtPuesto);
		
		txtDep = new JTextField();
		txtDep.setColumns(10);
		txtDep.setBounds(28, 186, 206, 20);
		mainPanel.add(txtDep);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "asd"}));
		comboBox.setBounds(28, 230, 206, 20);
		mainPanel.add(comboBox);
		
		lblComp = new JLabel("Competencias");
		lblComp.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		lblComp.setHorizontalAlignment(SwingConstants.CENTER);
		lblComp.setBounds(26, 206, 208, 22);
		mainPanel.add(lblComp);
	}
	
	
	public void fillFields(ResultSet rs) {
		try {
			rs.next();
		
			txtName.setText(rs.getString("nombre"));
			txtApp.setText(rs.getString("apellido_paterno"));
			txtApm.setText(rs.getString("apellido_Materno"));
			txtEdad.setText(rs.getString("edad"));
			txtHeight.setText(rs.getString("altura"));
			txtW
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}

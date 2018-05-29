package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MainMenu extends JFrame {

	private JPanel contentPane;

	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 236, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 219, 262);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lblTitle = new JLabel("");
		lblTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 11, 199, 34);
		mainPanel.add(lblTitle);
		
		JPanel pnCreateDP = new JPanel();
		pnCreateDP.setBounds(10, 74, 199, 45);
		mainPanel.add(pnCreateDP);
		
		JPanel pnConsultDP = new JPanel();
		pnConsultDP.setBounds(10, 130, 199, 45);
		mainPanel.add(pnConsultDP);
		
		JPanel pnEditPuesto = new JPanel();
		pnEditPuesto.setBounds(10, 186, 199, 45);
		mainPanel.add(pnEditPuesto);
	}
}

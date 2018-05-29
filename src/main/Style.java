package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Style {
	
	public void btnPointer(JButton btn) {
		btn.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
		new ImageIcon("views/cursor.png").getImage(),
		new Point(0,0), "custom cursor"));
	}
	
	public void transparent(Component c) {
		
		c.setBackground(null);
	}
	
	
	public void mdButton(JButton btn,Color c) {
		btn.setOpaque(true);
		btn.setBorder(null);
		btn.setBackground(c);
		btn.setForeground(Color.WHITE);
	}
}

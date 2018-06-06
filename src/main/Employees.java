package main;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Employees {
	
	private String name,app,apm,status;
	private int edad,altura,peso;
	String[] competencias;
	ResultSet rs;
	Conexion c = new Conexion();
	
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getApp() {
		return app;
	}
	public void setApp(String app) {
		this.app = app;
	}
	public String getApm() {
		return apm;
	}
	public void setApm(String apm) {
		this.apm = apm;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public ResultSet getEmpleadoByName(String name,String app,String Apm) {
		return c.query("SELECT * FROM empleados WHERE nombre ='"+name+"' AND apellido_Paterno = '"+app+"' AND apellido_Materno = '"+apm+"';");	
	}
	
	public int getIdByName(String name,String App,String Apm) {
		ResultSet rs;
		int id = 0;
		try {
			rs = c.query("SELECT id FROM empleados where nombre ='"+name+"' AND apellido_Paterno = '"+App+"' AND apellido_Materno = '"+Apm+"'");
			rs.next();
			id = rs.getInt("id");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return id;
	}

	public boolean empleadoExists(int index,String id,String name,String App,String Apm) {
		
		try {
			if(index == 0) {
				if(c.query("SELECT * FROM empleados WHERE id = "+Integer.parseInt(id)+";").next()) {
					return true;
				}
			}else if(index == 1) {
				if(c.query("SELECT * FROM empleados WHERE nombre ='"+name+"' AND apellido_Paterno = '"+App+"' AND apellido_Materno = '"+Apm+"';").next()) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return false;
	}
	
}

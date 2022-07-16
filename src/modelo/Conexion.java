package src.modelo;

import java.sql.DriverManager;
import java.sql.*;

public class Conexion {
	private String url = "jdbc:mysql://localhost:3306/";
	private String password = "73123732";
	private String dataBaseName = "DATOS_PERSONALES";
	private String userName = "root";
	private Connection con;

	public void conectar(){
		System.out.println("Conectando a " + dataBaseName + " ...");

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url + dataBaseName, userName, password);
			System.out.println("Base de datos conectada");
		}catch(Exception e){
			System.out.println("No se pudo conectar a la base de datos");
		}
	}

	public void desconectar(){
		try{
			con.close();
			System.out.println("Conexion cerrada");

		}catch(SQLException e){
			System.out.println("No se pudo desconectar");
			e.printStackTrace();
		}
	}

	public Connection getConnection(){
		return con;
	}
}

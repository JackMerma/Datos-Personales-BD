package src.modelo.datosGenerales;

import java.sql.Connection;
import java.sql.*;
import java.util.*;

//import src.modelo.DAO;

public class DatosGeneralesDAO extends DAO<DatosGenerales> {

	private Conexion con = new Conexion();
	private PreparedStatement ps; 
	private ResultSet rs;
	private Connection bd;  

	// constructor
	public DatosGeneralesDAO() {
		super();
	}

	// Listar
	public ArrayList<DatosGenerales> listar(){
		ArrayList<DatosGenerales> listDatosGenerales = new ArrayList<DatosGenerales>();
		String sql = "SELECT * FROM `DATOS_GENERALES`";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			rs = ps.executeQuery();
			// recibimos los resultados
			while(rs.next()){
				classNormal = new DatosGenerales();
				classNormal.setCod(rs.getInt(1));
				classNormal.setPrimerNombre(rs.getString(2));
				classNormal.setSegundoNombre(rs.getString(3));
				classNormal.setPrimerApellido(rs.getString(4));
				classNormal.setSegundoApellido(rs.getString(5));
				classNormal.setFechaNacimiento(rs.getString(6));
				classNormal.setEstadoRegistro(rs.getString(7).charAt(0));
				listDatosGenerales.add(classNormal);
			}
			System.out.println("DatosGeneralesDAO Listar:CORRECTO");

		}catch(Exception e){
			System.out.println("DatosGeneralesDAO listar:ERROR");
			System.err.println(e);
		}finally{
			con.desconectar();
		}

		return listDatosGenerales;
	}

	// agregar
	public int add(DatosGenerales datosGenerales){
		int state = 0;
		String sql = "INSERT INTO `DATOS_GENERALES` (`cod`, `primerNombre`, `segundoNombre`, `primerApellido`, `segundoApellido`, `fechaNacimiento`, `estaRegis`) VALUES (?, ?, ?, ?, ?, ?, ?);";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos los datos
			ps.setString(1,datosGenerales.getCod()+"");
			ps.setString(2,datosGenerales.getPrimerNombre()+"");
			ps.setString(3,datosGenerales.getSegundoNombre()+"");
			ps.setString(4,datosGenerales.getPrimerApellido()+"");
			ps.setString(5,datosGenerales.getSegundoApellido()+"");
			ps.setString(6,datosGenerales.getFechaNacimiento()+"");
			ps.setString(7, "A");

			state = ps.executeUpdate();
			System.out.println("DatosGeneralesDAO Add: CORRECTO");

		}catch(SQLException e){
			System.out.println("DatosGeneralesDAO add: ERROR"); 
			System.out.println(e);
		}finally{
			con.desconectar();
		}
		return state;
	}

	// modificar
	public int modificar(DatosGenerales datosGenerales){
		int state = 0;
		String sql = "UPDATE `DATOS_GENERALES` SET `primerNombre` = ?, `segundoNombre` = ?, `primerApellido` = ?, ``segundoApellido = ?, `fechaNacimiento` = ?, `estaRegis` = ? WHERE `DATOS_GENERALES`.`cod` = ?;";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos datos
			ps.setString(1,datosGenerales.getPrimerNombre()+"");
			ps.setString(2,datosGenerales.getSegundoNombre()+"");
			ps.setString(3,datosGenerales.getPrimerApellido()+"");
			ps.setString(4,datosGenerales.getSegundoApellido()+"");
			ps.setString(5,datosGenerales.getFechaNacimiento()+"");
			ps.setString(6,datosGenerales.getEstadoRegistro()+"");
			ps.setString(7,datosGenerales.getCod()+"");

			state = ps.executeUpdate(); 
			System.out.println("DatosGeneralesDAO ModificarInter: CORRECTO");

		}catch (SQLException e){
			System.out.println("DatosGeneralesDAO ModificarInter: ERROR");
			System.out.println(e);
		}finally{
			con.desconectar();
		}

		return state;
	}
}

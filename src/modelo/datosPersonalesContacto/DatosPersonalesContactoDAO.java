package src.modelo.datosPersonalesContacto;

import java.sql.Connection;
import java.sql.*;
import java.util.*;

//import src.modelo.DAO;

public class DatosPersonalesContactoDAO extends DAO<DatosPersonalesContacto> {

	private Conexion con = new Conexion();
	private PreparedStatement ps; 
	private ResultSet rs;
	private Connection bd;  

	// constructor
	public DatosPersonalesContactoDAO() {
		super();
	}

	// Listar
	public ArrayList<DatosPersonalesContacto> listar(){
		ArrayList<DatosPersonalesContacto> listDatosPersonalesContacto = new ArrayList<DatosPersonalesContacto>();
		String sql = "SELECT * FROM `DATOS_PERSONALES_CONTACTO`";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			rs = ps.executeQuery();
			// recibimos los resultados
			while(rs.next()){
				classNormal = new DatosPersonalesContacto();
				classNormal.setCod(rs.getInt(1));
				classNormal.setContactoCod(rs.getInt(2));
				classNormal.setEstadoRegistro(rs.getString(3).charAt(0));
				listDatosPersonalesContacto.add(classNormal);
			}
			System.out.println("DatosPersonalesContactoDAO Listar:CORRECTO");

		}catch(Exception e){
			System.out.println("DatosPersonalesContactoDAO listar:ERROR");
			System.err.println(e);
		}finally{
			con.desconectar();
		}

		return listDatosPersonalesContacto;
	}

	// agregar
	public int add(DatosPersonalesContacto datosPersonalesContacto){
		int state = 0;
		String sql = "INSERT INTO `DATOS_PERSONALES_CONTACTO` (`cod`, `contactoCod`, `estaRegis`) VALUES (?, ?, ?);";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos los datos
			ps.setString(1,datosPersonalesContacto.getCod()+"");
			ps.setString(2,datosPersonalesContacto.getContactoCod()+"");
			ps.setString(3, "A");

			state = ps.executeUpdate();
			System.out.println("DatosPersonalesContactoDAO Add: CORRECTO");

		}catch(SQLException e){
			System.out.println("DatosPersonalesContactoDAO add: ERROR"); 
			System.out.println(e);
		}finally{
			con.desconectar();
		}
		return state;
	}

	// modificar
	public int modificar(DatosPersonalesContacto datosPersonalesContacto){
		int state = 0;
		String sql = "UPDATE `DATOS_PERSONALES_CONTACTO` SET `contactoCod` = ?, `estaRegis` = ? WHERE `DATOS_PERSONALES_CONTACTO`.`cod` = ?;";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos datos
			ps.setString(1,datosPersonalesContacto.getContactoCod()+"");
			ps.setString(2,datosPersonalesContacto.getEstadoRegistro()+"");
			ps.setString(3,datosPersonalesContacto.getCod()+"");

			state = ps.executeUpdate(); 
			System.out.println("DatosPersonalesContactoDAO ModificarInter: CORRECTO");

		}catch (SQLException e){
			System.out.println("DatosPersonalesContactoDAO ModificarInter: ERROR");
			System.out.println(e);
		}finally{
			con.desconectar();
		}

		return state;
	}
}

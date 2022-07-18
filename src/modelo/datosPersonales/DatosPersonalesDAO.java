package src.modelo.datosPersonales;

import java.sql.Connection;
import java.sql.*;
import java.util.*;

import src.modelo.*;

public class DatosPersonalesDAO extends DAO<DatosPersonales> {

	private Conexion con = new Conexion();
	private PreparedStatement ps; 
	private ResultSet rs;
	private Connection bd;  

	// constructor
	public DatosPersonalesDAO() {
		super();
	}

	// Listar
	public ArrayList<DatosPersonales> listar(){
		ArrayList<DatosPersonales> listDatosPersonales = new ArrayList<DatosPersonales>();
		String sql = "SELECT * FROM `DATOS_PERSONALES`";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			rs = ps.executeQuery();
			// recibimos los resultados
			while(rs.next()){
				classNormal = new DatosPersonales();
				classNormal.setCod(rs.getInt(1));
				classNormal.setDatosGeneralesCodigo(rs.getInt(2));
				classNormal.setDatosImportantesCodigo(rs.getInt(3));
				classNormal.setEstadoRegistro(rs.getString(4).charAt(0));
				listDatosPersonales.add(classNormal);
			}
			System.out.println("DatosPersonalesDAO Listar:CORRECTO");

		}catch(Exception e){
			System.out.println("DatosPersonalesDAO listar:ERROR");
			System.err.println(e);
		}finally{
			con.desconectar();
		}

		return listDatosPersonales;
	}

	// agregar
	public int add(DatosPersonales datosPersonales){
		int state = 0;
		String sql = "INSERT INTO `DATOS_PERSONALES` (`cod`, `datosGeneralCod`, `datosImportCod`, `estaRegis`) VALUES (?, ?, ?, ?);";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos los datos
			ps.setString(1,datosPersonales.getCod()+"");
			ps.setString(2,datosPersonales.getDatosGeneralesCodigo()+"");
			ps.setString(3,datosPersonales.getDatosImportantesCodigo()+"");
			ps.setString(4, "A");

			state = ps.executeUpdate();
			System.out.println("DatosPersonalesDAO Add: CORRECTO");

		}catch(SQLException e){
			System.out.println("DatosPersonalesDAO add: ERROR"); 
			System.out.println(e);
		}finally{
			con.desconectar();
		}
		return state;
	}

	// modificar
	public int modificar(DatosPersonales datosPersonales){
		int state = 0;
		String sql = "UPDATE `DATOS_PERSONALES` SET `datosGeneralCod` = ?, `datosImportCod` = ?, `estaRegis` = ? WHERE `DATOS_PERSONALES`.`cod` = ?;";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos datos
			ps.setString(1,datosPersonales.getDatosGeneralesCodigo()+"");
			ps.setString(2,datosPersonales.getDatosImportantesCodigo()+"");
			ps.setString(3,datosPersonales.getEstadoRegistro()+"");
			ps.setString(4,datosPersonales.getCod()+"");

			state = ps.executeUpdate(); 
			System.out.println("DatosPersonalesDAO ModificarInter: CORRECTO");

		}catch (SQLException e){
			System.out.println("DatosPersonalesDAO ModificarInter: ERROR");
			System.out.println(e);
		}finally{
			con.desconectar();
		}

		return state;
	}
}

package src.modelo.procedencia;

import java.sql.Connection;
import java.sql.*;
import java.util.*;

import src.modelo.*;

public class ProcedenciaDAO extends DAO<Procedencia> {

	private Conexion con = new Conexion();
	private PreparedStatement ps; 
	private ResultSet rs;
	private Connection bd;  

	// constructor
	public ProcedenciaDAO() {
		super();
	}

	// Listar
	public ArrayList<Procedencia> listar(){
		ArrayList<Procedencia> listProcedencia = new ArrayList<Procedencia>();
		String sql = "SELECT * FROM `PROCEDENCIA`";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			rs = ps.executeQuery();
			// recibimos los resultados
			while(rs.next()){
				classNormal = new Procedencia();
				classNormal.setCod(rs.getInt(1));
				classNormal.setPais(rs.getString(2));
				classNormal.setDepartamento(rs.getString(3));
				classNormal.setProvincia(rs.getString(4));
				classNormal.setDistrito(rs.getString(5));
				classNormal.setEstadoRegistro(rs.getString(6).charAt(0));
				listProcedencia.add(classNormal);
			}
			System.out.println("ProcedenciaDAO Listar:CORRECTO");

		}catch(Exception e){
			System.out.println("ProcedenciaDAO listar:ERROR");
			System.err.println(e);
		}finally{
			con.desconectar();
		}

		return listProcedencia;
	}

	// agregar
	public int add(Procedencia procedencia){
		int state = 0;
		String sql = "INSERT INTO `PROCEDENCIA` (`cod`, `pais`, `departamento`, `provincia`, `distrito`, `estaRegis`) VALUES (?, ?, ?, ?, ?, ?);";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos los datos
			ps.setString(1,procedencia.getCod()+"");
			ps.setString(2,procedencia.getPais()+"");
			ps.setString(3,procedencia.getDepartamento()+"");
			ps.setString(4,procedencia.getProvincia()+"");
			ps.setString(5,procedencia.getDistrito()+"");
			ps.setString(6, "A");

			state = ps.executeUpdate();
			System.out.println("ProcedenciaDAO Add: CORRECTO");

		}catch(SQLException e){
			System.out.println("ProcedenciaDAO add: ERROR"); 
			System.out.println(e);
		}finally{
			con.desconectar();
		}
		return state;
	}

	// modificar
	public int modificar(Procedencia procedencia){
		int state = 0;
		String sql = "UPDATE `PROCEDENCIA` SET `pais` = ?, `departamento` = ?, `provincia` = ?, `distrito` = ?, `estaRegis` = ? WHERE `PROCEDENCIA`.`cod` = ?;";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos datos
			ps.setString(1,procedencia.getPais()+"");
			ps.setString(2,procedencia.getDepartamento()+"");
			ps.setString(3,procedencia.getProvincia()+"");
			ps.setString(4,procedencia.getDistrito()+"");
			ps.setString(5,procedencia.getEstadoRegistro()+"");
			ps.setString(6,procedencia.getCod()+"");

			state = ps.executeUpdate(); 
			System.out.println("ProcedenciaDAO ModificarInter: CORRECTO");

		}catch (SQLException e){
			System.out.println("ProcedenciaDAO ModificarInter: ERROR");
			System.out.println(e);
		}finally{
			con.desconectar();
		}

		return state;
	}
}

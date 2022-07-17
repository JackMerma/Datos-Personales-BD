package src.modelo.datosImportantes;

import java.sql.Connection;
import java.sql.*;
import java.util.*;

//import src.modelo.DAO;

public class DatosImportantesDAO extends DAO<DatosImportantes> {

	private Conexion con = new Conexion();
	private PreparedStatement ps; 
	private ResultSet rs;
	private Connection bd;  

	// constructor
	public DatosImportantesDAO() {
		super();
	}

	// Listar
	public ArrayList<DatosImportantes> listar(){
		ArrayList<DatosImportantes> listDatosImportantes = new ArrayList<DatosImportantes>();
		String sql = "SELECT * FROM `DATOS_IMPORTANTES`";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			rs = ps.executeQuery();
			// recibimos los resultados
			while(rs.next()){
				classNormal = new DatosImportantes();
				classNormal.setCod(rs.getInt(1));
				classNormal.setDni(rs.getInt(2));
				classNormal.setEstadoCivil(rs.getInt(3));
				classNormal.setProcedencia(rs.getInt(4));
				classNormal.setEstadoRegistro(rs.getString(5).charAt(0));
				listDatosImportantes.add(classNormal);
			}
			System.out.println("DatosImportantesDAO Listar:CORRECTO");

		}catch(Exception e){
			System.out.println("DatosImportantesDAO listar:ERROR");
			System.err.println(e);
		}finally{
			con.desconectar();
		}

		return listDatosImportantes;
	}

	// agregar
	public int add(DatosImportantes datosImportantes){
		int state = 0;
		String sql = "INSERT INTO `DATOS_IMPORTANTES` (`cod`, `dni`, `estadoCivil`, `procedenciaCod`, `estaRegis`) VALUES (?, ?, ?, ?, ?);";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos los datos
			ps.setString(1,datosImportantes.getCod()+"");
			ps.setString(2,datosImportantes.getDni()+"");
			ps.setString(3,datosImportantes.getEstadoCivil()+"");
			ps.setString(4,datosImportantes.getProcedencia()+"");
			ps.setString(5, "A");

			state = ps.executeUpdate();
			System.out.println("DatosImportantesDAO Add: CORRECTO");

		}catch(SQLException e){
			System.out.println("DatosImportantesDAO add: ERROR"); 
			System.out.println(e);
		}finally{
			con.desconectar();
		}
		return state;
	}

	// modificar
	public int modificar(DatosImportantes datosImportantes){
		int state = 0;
		String sql = "UPDATE `DATOS_IMPORTANTES` SET `dni` = ?, `estadoCivil` = ?, `procedenciaCod` = ?, `estaRegis` = ? WHERE `DATOS_IMPORTANTES`.`cod` = ?;";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos datos
			ps.setString(1,datosImportantes.getDni()+"");
			ps.setString(2,datosImportantes.getEstadoCivil()+"");
			ps.setString(3,datosImportantes.getProcedencia()+"");
			ps.setString(4,datosImportantes.getEstadoRegistro()+"");
			ps.setString(5,datosImportantes.getCod()+"");

			state = ps.executeUpdate(); 
			System.out.println("DatosImportantesDAO ModificarInter: CORRECTO");

		}catch (SQLException e){
			System.out.println("DatosImportantesDAO ModificarInter: ERROR");
			System.out.println(e);
		}finally{
			con.desconectar();
		}

		return state;
	}
}

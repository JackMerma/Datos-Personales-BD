package src.modelo.datosElectronicos;

import java.sql.Connection;
import java.sql.*;
import java.util.*;

import src.modelo.*;

public class DatosElectronicosDAO extends DAO<DatosElectronicos> {

	private Conexion con = new Conexion();
	private PreparedStatement ps; 
	private ResultSet rs;
	private Connection bd;  

	// constructor
	public DatosElectronicosDAO() {
		super();
	}

	// Listar
	public ArrayList<DatosElectronicos> listar(){
		ArrayList<DatosElectronicos> listDatosElectronicos = new ArrayList<DatosElectronicos>();
		String sql = "SELECT * FROM `DATOS_ELECTRONICOS`";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			rs = ps.executeQuery();
			// recibimos los resultados
			while(rs.next()){
				classNormal = new DatosElectronicos();
				classNormal.setCod(rs.getInt(1));
				classNormal.setCorreo(rs.getString(2));
				classNormal.setPaginaWeb(rs.getString(3));
				classNormal.setEstadoRegistro(rs.getString(4).charAt(0));
				listDatosElectronicos.add(classNormal);
			}
			System.out.println("DatosElectronicosDAO Listar:CORRECTO");

		}catch(Exception e){
			System.out.println("DatosElectronicosDAO listar:ERROR");
			System.err.println(e);
		}finally{
			con.desconectar();
		}

		return listDatosElectronicos;
	}

	// agregar
	public int add(DatosElectronicos datosElectronicos){
		int state = 0;
		String sql = "INSERT INTO `DATOS_ELECTRONICOS` (`cod`, `correo`, `paginaWeb`, `estaRegis`) VALUES (?, ?, ?, ?);";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos los datos
			ps.setString(1,datosElectronicos.getCod()+"");
			ps.setString(2,datosElectronicos.getCorreo()+"");
			ps.setString(3,datosElectronicos.getPaginaWeb()+"");
			ps.setString(4, "A");

			state = ps.executeUpdate();
			System.out.println("DatosElectronicosDAO Add: CORRECTO");

		}catch(SQLException e){
			System.out.println("DatosElectronicosDAO add: ERROR"); 
			System.out.println(e);
		}finally{
			con.desconectar();
		}
		return state;
	}

	// modificar
	public int modificar(DatosElectronicos datosElectronicos){
		int state = 0;
		String sql = "UPDATE `DATOS_ELECTRONICOS` SET `correo` = ?, `paginaWeb` = ?, `estaRegis` = ? WHERE `DATOS_ELECTRONICOS`.`cod` = ?;";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos datos
			ps.setString(1,datosElectronicos.getCorreo()+"");
			ps.setString(2,datosElectronicos.getPaginaWeb()+"");
			ps.setString(3,datosElectronicos.getEstadoRegistro()+"");
			ps.setString(4,datosElectronicos.getCod()+"");

			state = ps.executeUpdate(); 
			System.out.println("DatosElectronicosDAO ModificarInter: CORRECTO");

		}catch (SQLException e){
			System.out.println("DatosElectronicosDAO ModificarInter: ERROR");
			System.out.println(e);
		}finally{
			con.desconectar();
		}

		return state;
	}
}

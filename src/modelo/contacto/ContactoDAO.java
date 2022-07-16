package src.modelo.Contacto;

import java.sql.Connection;
import java.sql.*;
import java.util.*;

//import src.modelo.DAO;

public class ContactoDAO extends DAO<Contacto> {

	private Conexion con = new Conexion();
	private PreparedStatement ps; 
	private ResultSet rs;
	private Connection bd;  

	// constructor
	public ContactoDAO() {
		super();
	}

	// Listar
	public ArrayList<Contacto> listar(){
		ArrayList<Contacto> listContacto = new ArrayList<Contacto>();
		String sql = "SELECT * FROM `CONTACTO`";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);
			rs = ps.executeQuery();
			// recibimos los resultados
			while(rs.next()){
				classNormal = new Contacto();
				classNormal.setCod(rs.getInt(1));
				classNormal.setContactoElectronico(rs.getInt(2));
				classNormal.setNumero(rs.getInt(3));
				classNormal.setDireccion(rs.getString(4));
				classNormal.setEstadoRegistro(rs.getString(5).charAt(0));
				listContacto.add(classNormal);
			}
			System.out.println("ContactoDAO Listar:CORRECTO");

		}catch(Exception e){
			System.out.println("ContactoDAO listar:ERROR");
			System.err.println(e);
		}finally{
			con.desconectar();
		}

		return listContacto;
	}

	// agregar
	public int add(Contacto contacto){
		int state = 0;
		String sql = "INSERT INTO `CONTACTO` (`cod`, `contElectronico`, `numero`, `direccion`, `estaRegis`) VALUES (?, ?, ?, ?, ?);";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos los datos
			ps.setString(1,contacto.getCod()+"");
			ps.setString(2,contacto.getcontactoElectronico()+"");
			ps.setString(3,contacto.getNumero()+"");
			ps.setString(4,contacto.getDireccion()+"");
			ps.setString(5, "A");

			state = ps.executeUpdate();
			System.out.println("ContactoDAO Add: CORRECTO");

		}catch(SQLException e){
			System.out.println("ContactoDAO add: ERROR"); 
			System.out.println(e);
		}finally{
			con.desconectar();
		}
		return state;
	}

	// modificar
	public int modificar(Contacto contacto){
		int state = 0;
		String sql = "UPDATE `CONTACTO` SET `contElectronico` = ?, `numero` = ?, `direccion` = ?, `estaRegis` = ? WHERE `CONTACTO`.`cod` = ?;";

		try{
			con.conectar();
			bd = con.getConnection();
			ps = bd.prepareStatement(sql);

			// llenamos datos
			ps.setString(1,contacto.getcontactoElectronico()+"");
			ps.setString(2,contacto.getNumero()+"");
			ps.setString(3,contacto.getDireccion()+"");
			ps.setString(4,contacto.getEstadoRegistro()+"");
			ps.setString(5,contacto.getCod()+"");

			state = ps.executeUpdate(); 
			System.out.println("ContactoDAO ModificarInter: CORRECTO");

		}catch (SQLException e){
			System.out.println("ContactoDAO ModificarInter: ERROR");
			System.out.println(e);
		}finally{
			con.desconectar();
		}

		return state;
	}

}

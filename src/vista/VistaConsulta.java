package src.vista;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.sql.Connection;
import java.sql.*;
import src.modelo.Conexion;

public class VistaConsulta {
	public JPanel content;

	//paneles
	public JPanel inputPanel = new JPanel(new BorderLayout());
	public JPanel optionPanel = new JPanel(new BorderLayout());

	//opciones
	public JButton ide = new JButton("Por ide");
	public JButton nombre = new JButton("Por nombre");

	//entrada
	public JTextField input = new JTextField();

	//conexion
	private Conexion con = new Conexion();
	private PreparedStatement ps; 
	private ResultSet rs;
	private Connection bd;  

	public JPanel getContent() {
		content = new JPanel(new GridLayout(2,1,5,5));

		createInputContent();
		createOptionContent();

		content.add(inputPanel);
		content.add(optionPanel);
		return content;
	}

	public void createInputContent(){
		JPanel gridContentPanel = new JPanel(new GridLayout(1,2,5,5));
		JLabel option = new JLabel("Busqueda:");

		gridContentPanel.add(option);
		gridContentPanel.add(input);

		inputPanel.add(gridContentPanel);
	}

	public void createOptionContent(){
		JPanel gridContentPanel = new JPanel(new GridLayout(1,2,5,5));

		//listeners
		ide.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String sql = "CALL Consulta_byIde(?);";

				try{
					con.conectar();
					bd = con.getConnection();
					ps = bd.prepareStatement(sql);
					ps.setString(1, input.getText());//input
					rs = ps.executeQuery();

					String[] cols = {"Código", "Nombre", "Apellido", "Pais", "Numero", "Correo"};
					Object[][] objetos = new Object[1][6];

					//resultado
					int i = 0;
					while(rs.next()){
						objetos[i][0] = rs.getInt(1);
						objetos[i][1] = rs.getString(2);
						objetos[i][2] = rs.getString(3);
						objetos[i][3] = rs.getString(4);
						objetos[i][4] = rs.getInt(5);
						objetos[i][5] = rs.getString(6);
						i++;
					}

					JTable tabla = new JTable(objetos, cols);
					JScrollPane barra = new JScrollPane(tabla);

					showNewFrame(barra);

					System.out.println("Procedimiento almacenado Consulta_byIde:CORRECTO");
				}catch(Exception ex){
					System.out.println("Procedimiento almacenado Consulta_byIde:ERROR");
					System.err.println(e);
				}finally{
					con.desconectar();
				}
			}
		});

		nombre.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String sql = "CALL Consulta_byNombre(?);";

				try{
					con.conectar();
					bd = con.getConnection();
					ps = bd.prepareStatement(sql);
					ps.setString(1, input.getText());//input
					rs = ps.executeQuery();

					String[] cols = {"Código", "Nombre", "Apellido", "Pais", "Numero", "Correo"};
					Object[][] objetos = new Object[20][6];//primeros 20

					//resultado
					int i = 0;
					while(rs.next()){
						objetos[i][0] = rs.getInt(1);
						objetos[i][1] = rs.getString(2);
						objetos[i][2] = rs.getString(3);
						objetos[i][3] = rs.getString(4);
						objetos[i][4] = rs.getInt(5);
						objetos[i][5] = rs.getString(6);
						i++;
					}

					JTable tabla = new JTable(objetos, cols);
					JScrollPane barra = new JScrollPane(tabla);

					showNewFrame(barra);

					System.out.println("Procedimiento almacenado Consulta_byNombre:CORRECTO");
				}catch(Exception ex){
					System.out.println("Procedimiento almacenado Consulta_byNombre:ERROR");
					System.err.println(e);
				}finally{
					con.desconectar();
				}
			}
		});
		//agregando botones
		gridContentPanel.add(ide);
		gridContentPanel.add(nombre);

		optionPanel.add(gridContentPanel);
	}

	// metodo auxiliar (ni entiendo para que sirve xd)
	public void createPanelWidth(JPanel panel, boolean n, boolean s, boolean e, boolean w) {
		if (n)
			panel.add(new JLabel("\n"), BorderLayout.NORTH);
		if (s)
			panel.add(new JLabel("\n"), BorderLayout.SOUTH);
		if (e)
			panel.add(new JLabel("   "), BorderLayout.EAST);
		if (w)
			panel.add(new JLabel("   "), BorderLayout.WEST);
	}

	public void centrarCeldas(JTable tabla) {
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < tabla.getColumnCount(); i++) {
			tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
		}
	}

	public void showNewFrame(JScrollPane scroll){
		JFrame newFrame = new JFrame("Consulta");
		newFrame.setLocationRelativeTo(null);
		newFrame.setLayout(new FlowLayout());
		newFrame.setVisible(true);
		newFrame.setSize(500,400);

		newFrame.add(scroll);
	}
}

package src.vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class Vista {
	public JPanel content;
	public String nombreTabla = "";
	protected String[] columnas = {};

	// 3 paneles principales
	public JPanel addPanel = new JPanel(new BorderLayout());
	public JPanel viewPanel = new JPanel(new BorderLayout());
	public JPanel optionPanel = new JPanel(new BorderLayout());

	// view Panel
	public JTable tabla;
	public JScrollPane miBarra;
	public DefaultTableModel modelo;

	// option Panel
	public JButton adicionar = new JButton("Adicionar");
	public JButton modificar = new JButton("Modificar");
	public JButton eliminar = new JButton("Eliminar");
	public JButton cancelar = new JButton("Cancelar");
	public JButton inactivar = new JButton("Inactivar");
	public JButton reactivar = new JButton("Reactivar");
	public JButton actualizar = new JButton("Actualizar");
	public JButton salir = new JButton("Salir");

	// constructor
	public Vista(String nombreTabla, String[] columnas) {
		this.nombreTabla = nombreTabla;
		this.columnas = columnas;

		rellenarContent(columnas);
	}

	// llenamos el contenido
	protected void rellenarContent(String[] columnas) {
		content = new JPanel(new BorderLayout());
		JPanel centerContent = new JPanel(new GridLayout(3, 1, 5, 3));

		// relleno (bordes) en panel

		createPanelWidth(content, true, true, true, true);

		// creación de contenido en cada panel

		createAddPanelContent();
		createViewPanelContent(columnas);
		createOptionPanelContent();
		JScrollPane scroll = new JScrollPane(addPanel);

		// agregación de los paneles

		centerContent.add(scroll);
		centerContent.add(viewPanel);
		centerContent.add(optionPanel);

		content.add(centerContent);
		content.add(new JLabel(this.nombreTabla), BorderLayout.NORTH);// nombre de tabla
	}

	// obtenemos el contenido del panel central
	public JPanel getContent() {
		if (content == null) {
			rellenarContent(this.columnas);
		}
		return content;
	}

	// Se implementa en cada clase
	public abstract void createAddPanelContent();

	// crea la tabla y la agrega al panel
	public void createViewPanelContent(String[] columnas) {

		// crea la tabla y no permite editarla
		tabla = new JTable() {
			// para evitar que sea editabue
			public boolean isCellEditable(int fila, int col) {
				return false;
			}
		};

		modelo = (DefaultTableModel) tabla.getModel();
		miBarra = new JScrollPane(tabla);

		tabla.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
		tabla.setModel(new javax.swing.table.DefaultTableModel(
				null,
				columnas));

		tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		tabla.setFocusable(false);
		tabla.getTableHeader().setReorderingAllowed(false);

		tabla.setRowMargin(4);

		tabla.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = tabla.rowAtPoint(e.getPoint());
				int columna = tabla.columnAtPoint(e.getPoint());
				System.out.println("fila:" + fila + ", Col:" + columna);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		viewPanel.add(miBarra, BorderLayout.CENTER);
	}

	// llena la tabla de opcines
	public void createOptionPanelContent() {
		JPanel optionPanelContent = new JPanel(new BorderLayout());		
		JPanel optionPanelContentContent = new JPanel(new GridLayout(2, 4, 10, 35));

		optionPanelContentContent.add(adicionar);
		optionPanelContentContent.add(modificar);
		optionPanelContentContent.add(eliminar);
		optionPanelContentContent.add(cancelar);
		optionPanelContentContent.add(inactivar);
		optionPanelContentContent.add(reactivar);
		optionPanelContentContent.add(actualizar);
		optionPanelContentContent.add(salir);

		optionPanelContent.add(optionPanelContentContent);
		createPanelWidth(optionPanelContent, true, true, true, true);
		createPanelWidth(optionPanel, true, true, true, true);
		optionPanel.add(optionPanelContent);
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
}

package src.vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
}

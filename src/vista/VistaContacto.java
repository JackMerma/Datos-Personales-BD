package src.vista;

import java.awt.*;
import javax.swing.*;

public class VistaContacto extends Vista {

	// add Panel
	public JTextField cod;
	public JTextField contElectronico;
	public JTextField numero;
	public JTextField direccion;
	public JTextField estaRegis;

	public VistaContacto() {
		super("TABLA CONTACTO", new String[] { "Codigo", "ContactoElect", "Numero", "Direccion", "EstadoRegistro" });
	}

	/*
	 * Metodos a implementar
	 */

	@Override
	public void createAddPanelContent() {
		
		JPanel addPanelContent = new JPanel(new BorderLayout());

		JPanel addPanelContentContent = new JPanel(new GridLayout(5, 1, 5, 10));

		// instaciomos Atributos
		cod = new JTextField(20);
		contElectronico = new JTextField(20);
		numero = new JTextField(20);
		direccion = new JTextField(20);
		estaRegis = new JTextField("", 20);

		// cod field
		JPanel codPanel = addComponente(cod, "Codigo:");

		// contact electronico field
		JPanel contElectronicoPanel = addComponente(contElectronico, "Contacto Electronico:");

		// numero field
		JPanel numeroPanel = addComponente(numero, "Numero:");

		// direccion field
		JPanel direccionPanel = addComponente(direccion, "Direccion:");

		// estaRegis field
		JPanel estaRegisPanel = addComponente(estaRegis, "Estado de registro:");
	

		// agregando paneles
		addPanelContentContent.add(codPanel);
		addPanelContentContent.add(contElectronicoPanel);
		addPanelContentContent.add(numeroPanel);
		addPanelContentContent.add(direccionPanel);
		addPanelContentContent.add(estaRegisPanel);

		createPanelWidth(addPanelContent, true, true, true, true);
		addPanelContent.add(addPanelContentContent);
		addPanel.add(addPanelContent);
	}

	private JPanel addComponente(JTextField txtField, String name) {
		JPanel panel = new JPanel(new GridLayout(1, 2));
		JLabel label = new JLabel(name);
		label.setHorizontalAlignment(JLabel.CENTER);

		panel.add(label);

		JPanel buttonPanel = new JPanel(new FlowLayout());

		buttonPanel.add(txtField);
		panel.add(buttonPanel);
		return panel;
	}

}

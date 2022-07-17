package src.vista;

import java.awt.*;
import javax.swing.*;

public class VistaDatosPersonalesContacto extends Vista {

	// add Panel
	public JTextField cod;
	public JTextField contactoCod;
	public JTextField estaRegis;

	public VistaDatosPersonalesContacto() {
		super("TABLA DATOS PERSONALES CONTACTO", new String[] { "Codigo", "ContactoCod", "EstadoRegistro" });
	}

	/*
	 * Metodos a implementar
	 */

	@Override
	public void createAddPanelContent() {
		
		JPanel addPanelContent = new JPanel(new BorderLayout());

		JPanel addPanelContentContent = new JPanel(new GridLayout(3, 1, 5, 10));

		// instaciomos Atributos
		cod = new JTextField(20);
		contactoCod = new JTextField(20);
		estaRegis = new JTextField("", 20);

		// cod field
		JPanel codPanel = addComponente(cod, "Codigo:");

		// direccion field
		JPanel contactoCodPanel = addComponente(contactoCod, "Contacto Codigo:");

		// estaRegis field
		JPanel estaRegisPanel = addComponente(estaRegis, "Estado de registro:");
	

		// agregando paneles
		addPanelContentContent.add(codPanel);
		addPanelContentContent.add(contactoCodPanel);
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


package src.vista;

import java.awt.*;
import javax.swing.*;

public class VistaDatosElectronicos extends Vista {

	// add Panel
	public JTextField cod;
	public JTextField correo;
	public JTextField paginaWeb;
	public JTextField estaRegis;

	public VistaDatosElectronicos() {
		super("TABLA DATOS ELECTRONICOS", new String[] { "Codigo", "Correo", "PaginaWeb", "EstadoRegistro" });
	}

	/*
	 * Metodos a implementar
	 */

	@Override
	public void createAddPanelContent() {
		
		JPanel addPanelContent = new JPanel(new BorderLayout());

		JPanel addPanelContentContent = new JPanel(new GridLayout(4, 1, 5, 10));

		// instaciomos Atributos
		cod = new JTextField(20);
		correo = new JTextField(20);
		paginaWeb = new JTextField(20);
		estaRegis = new JTextField("", 20);

		// cod field
		JPanel codPanel = addComponente(cod, "Codigo:");

		// correo field
		JPanel correoPanel = addComponente(correo, "Correo:");

		// paginaWeb field
		JPanel paginaWebPanel = addComponente(paginaWeb, "Pagin Web:");

		// estaRegis field
		JPanel estaRegisPanel = addComponente(estaRegis, "Estado de registro:");
	

		// agregando paneles
		addPanelContentContent.add(codPanel);
		addPanelContentContent.add(correoPanel);
		addPanelContentContent.add(paginaWebPanel);
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

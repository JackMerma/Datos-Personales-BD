package src.vista;

import java.awt.*;
import javax.swing.*;

public class VistaProcedencia extends Vista {

	// add Panel
	public JTextField cod;
	public JTextField pais;
	public JTextField departamento;
	public JTextField provincia;
	public JTextField distrito;
	public JTextField estaRegis;

	public VistaProcedencia() {
		super("TABLA PROCEDENCIA", new String[] { "Codigo", "Pais", "Departamento", "Provincia", "Distrito", "EstadoRegistro" });
	}

	/*
	 * Metodos a implementar
	 */

	@Override
	public void createAddPanelContent() {
		
		JPanel addPanelContent = new JPanel(new BorderLayout());

		JPanel addPanelContentContent = new JPanel(new GridLayout(6, 1, 5, 10));

		// instaciomos Atributos
		cod = new JTextField(20);
		pais = new JTextField(20);
		departamento = new JTextField(20);
		provincia = new JTextField(20);
		distrito = new JTextField(20);
		estaRegis = new JTextField("", 20);

		// cod field
		JPanel codPanel = addComponente(cod, "Codigo:");

		// pais field
		JPanel paisPanel = addComponente(pais, "Pais:");

		// departamento field
		JPanel departamentoPanel = addComponente(departamento, "Departamento:");

		// provincia field
		JPanel provinciaPanel = addComponente(provincia, "Provincia:");
		
		// provincia field
		JPanel distritoPanel = addComponente(distrito, "Distrito:");

		// estaRegis field
		JPanel estaRegisPanel = addComponente(estaRegis, "Estado de registro:");
	

		// agregando paneles
		addPanelContentContent.add(codPanel);
		addPanelContentContent.add(paisPanel);
		addPanelContentContent.add(departamentoPanel);
		addPanelContentContent.add(provinciaPanel);
		addPanelContentContent.add(distritoPanel);
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

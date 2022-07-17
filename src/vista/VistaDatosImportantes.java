package src.vista;

import java.awt.*;
import javax.swing.*;

public class VistaDatosImportantes extends Vista {

	// add Panel
	public JTextField cod;
	public JTextField dni;
	public JTextField estadoCivil;
	public JTextField procedenciaCod;
	public JTextField estaRegis;

	public VistaDatosImportantes() {
		super("TABLA DATOS IMPORTANTES", new String[] { "Codigo", "Dni", "EstadoCivil", "ProcedenciaCod", "EstadoRegistro" });
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
		dni = new JTextField(20);
		estadoCivil = new JTextField(20);
		procedenciaCod = new JTextField(20);
		estaRegis = new JTextField("", 20);

		// cod field
		JPanel codPanel = addComponente(cod, "Codigo:");

		// dni field
		JPanel dniPanel = addComponente(dni, "Dni:");

		// estado civil field
		JPanel estadoCivilPanel = addComponente(estadoCivil, "Estado Civil:");

		// procedencia cod field
		JPanel procedenciaCodPanel = addComponente(procedenciaCod, "Codigo Procedencia:");

		// estaRegis field
		JPanel estaRegisPanel = addComponente(estaRegis, "Estado de registro:");
	

		// agregando paneles
		addPanelContentContent.add(codPanel);
		addPanelContentContent.add(dniPanel);
		addPanelContentContent.add(estadoCivilPanel);
		addPanelContentContent.add(procedenciaCodPanel);
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

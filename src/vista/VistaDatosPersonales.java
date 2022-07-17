package src.vista;

import java.awt.*;
import javax.swing.*;

public class VistaDatosPersonales extends Vista {

	// add Panel
	public JTextField cod;
	public JTextField datosGeneralCod;
	public JTextField datosImpCod;
	public JTextField estaRegis;

	public VistaDatosPersonales() {
		super("TABLA DATOS PERSONALES", new String[] { "Codigo", "DatosGeneralesCod", "DatosImportantesCod", "EstadoRegistro" });
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
		datosGeneralCod = new JTextField(20);
		datosImpCod = new JTextField(20);
		estaRegis = new JTextField("", 20);

		// cod field
		JPanel codPanel = addComponente(cod, "Codigo:");

		// datos generales cod field
		JPanel datosGeneralCodPanel = addComponente(datosGeneralCod, "Datos Generales Codigo:");

		// datos importantes cod field
		JPanel datosImpCodPanel = addComponente(datosImpCod, "Datos Importantes Codigo:");

		// estaRegis field
		JPanel estaRegisPanel = addComponente(estaRegis, "Estado de registro:");
	

		// agregando paneles
		addPanelContentContent.add(codPanel);
		addPanelContentContent.add(datosGeneralCodPanel);
		addPanelContentContent.add(datosImpCodPanel);
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

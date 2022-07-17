package src.vista;

import java.awt.*;
import javax.swing.*;

public class VistaDatosGenerales extends Vista {

	// add Panel
	public JTextField cod;
	public JTextField primerNombre;
	public JTextField segundoNombre;
	public JTextField primerApellido;
	public JTextField segundoApellido;
	public JTextField fechaNacimiento;
	public JTextField estaRegis;

	public VistaDatosGenerales() {
		super("TABLA DatosGenerales", new String[] { "Codigo", "PrimerNombre", "SegundoNombre", "PrimerApellido", "SegundoApellido", "FechaNacimiento", "EstadoRegistro" });
	}

	/*
	 * Metodos a implementar
	 */

	@Override
	public void createAddPanelContent() {
		
		JPanel addPanelContent = new JPanel(new BorderLayout());

		JPanel addPanelContentContent = new JPanel(new GridLayout(7, 1, 5, 0));

		// instaciomos Atributos
		cod = new JTextField(20);
		primerNombre = new JTextField(20);
		segundoNombre = new JTextField(20);
		primerApellido = new JTextField(20);
		segundoApellido = new JTextField(20);
		fechaNacimiento = new JTextField(20);
		estaRegis = new JTextField("", 20);

		// cod field
		JPanel codPanel = addComponente(cod, "Codigo:");

		// primerNombre field
		JPanel primerNombrePanel = addComponente(primerNombre, "Primer Nombre:");

		// segundoNombre field
		JPanel segundoNombrePanel = addComponente(segundoNombre, "Segundo Nombre:");

		// primerApellido field
		JPanel primerApellidoPanel = addComponente(primerApellido, "Primer Apellido:");

		// segundoApellido field
		JPanel segundoApellidoPanel = addComponente(segundoApellido, "Segundo Apellido:");

		// fechaNacimiento field
		JPanel fechaNacimientoPanel = addComponente(fechaNacimiento, "Fecha Nacimiento:");

		// estaRegis field
		JPanel estaRegisPanel = addComponente(estaRegis, "Estado de registro:");
	

		// agregando paneles
		addPanelContentContent.add(codPanel);
		addPanelContentContent.add(primerNombrePanel);
		addPanelContentContent.add(segundoNombrePanel);
		addPanelContentContent.add(primerApellidoPanel);
		addPanelContentContent.add(segundoApellidoPanel);
		addPanelContentContent.add(fechaNacimientoPanel);
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
package src.vista;

import java.awt.*;
import javax.swing.*;

public class VistaDatosGenerales extends Vista {

	// add Panel
	public JTextField cod;
	public JTextField contElectronico;
	public JTextField numero;
	public JTextField direccion;
	public JTextField estaRegis;

	public VistaDatosGenerales() {
		super("TABLA DatosGenerales", new String[] { "Codigo", "DatosGeneralesElect", "Numero", "Direccion", "EstadoRegistro" });
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
		JPanel contElectronicoPanel = addComponente(contElectronico, "DatosGenerales Electronico:");

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

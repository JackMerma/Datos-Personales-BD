package src.controlador;

import java.awt.event.ActionEvent;
import javax.swing.*;
import src.modelo.datosGenerales.DatosGenerales;
import src.modelo.datosGenerales.DatosGeneralesDAO;
import src.vista.VistaDatosGenerales;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ControladorDatosGenerales extends Controlador<DatosGenerales> {

	public VistaDatosGenerales vista = (VistaDatosGenerales) vistaSuper;
	public static DatosGeneralesDAO datosGeneralesDAO = new DatosGeneralesDAO();

	private int CarFlaAct = 0;
	private int action; // 1: agregar,

	// constructor de la clase, se pasan los parametros de la vistaEspecifica
	public ControladorDatosGenerales(VistaDatosGenerales v) {
		super(v, datosGeneralesDAO);
		this.vista = v;
		listar(vista.tabla);
	}

	// metodo auxiliar para obtener un objeto con los datos de la vista
	@Override
	public DatosGenerales getOficinaDetalle() {
		DatosGenerales classInterna = new DatosGenerales();
		String cod = vista.cod.getText();
		String primerNombre = vista.primerNombre.getText();
		String segundoNombre = vista.segundoNombre.getText();
		String primerApellido = vista.primerApellido.getText();
		String segundoApellido = vista.segundoApellido.getText();
		String fechaNacimiento = vista.fechaNacimiento.getText();
		String estaRegis = vista.estaRegis.getText();

		// Creamos un objeto
		classInterna.setCod(Integer.parseInt(cod));
		classInterna.setPrimerNombre(primerNombre);
		classInterna.setSegundoNombre(segundoNombre);
		classInterna.setPrimerApellido(primerApellido);
		classInterna.setSegundoApellido(segundoApellido);
		classInterna.setFechaNacimiento(fechaNacimiento);
		classInterna.setEstadoRegistro(estaRegis.charAt(0));

		return classInterna;
	}

	// lista los nuevos datos
	@Override
	public void listar(JTable tabla) {
		centrarCeldas(tabla);
		modelo = (DefaultTableModel) tabla.getModel();
		tabla.setModel(modelo);

		// Tenemos que cambiar esta parte
		ArrayList<DatosGenerales> lista = datosGeneralesDAO.listar();
		Object[] objeto = new Object[7]; // cambiar segun el numero de atributos


		for (int i = 0; i < lista.size(); i++) {
			objeto[0] = lista.get(i).getCod();
			objeto[1] = lista.get(i).getPrimerNombre();
			objeto[2] = lista.get(i).getSegundoNombre();
			objeto[3] = lista.get(i).getPrimerApellido();
			objeto[4] = lista.get(i).getSegundoApellido();
			objeto[5] = lista.get(i).getFechaNacimiento();
			objeto[6] = lista.get(i).getEstadoRegistro();
			modelo.addRow(objeto);
		}
	}

	// metodo para llenar los campos de la vista, trabaja con la fila 'fila', y el estado de registro, si el estado de registro se quiere matener
	// se pasa 'DEFAULT'
	@Override
	public void llenarDatosDeTablaSelecionada(int fila, String estadoRegistro) {

		String cod = (String) vista.tabla.getValueAt(fila, 0).toString();
		String primerNombre = (String) vista.tabla.getValueAt(fila, 1).toString();
		String segundoNombre = (String) vista.tabla.getValueAt(fila, 2).toString();
		String primerApellido = (String) vista.tabla.getValueAt(fila, 3).toString();
		String segundoApellido = (String) vista.tabla.getValueAt(fila, 4).toString();
		String fechaNacimiento = (String) vista.tabla.getValueAt(fila, 5).toString();
		String estareg = (String) vista.tabla.getValueAt(fila, 6).toString();

		vista.cod.setText(cod);
		vista.primerNombre.setText(primerNombre);
		vista.segundoNombre.setText(segundoNombre);
		vista.primerApellido.setText(primerApellido);
		vista.segundoApellido.setText(segundoApellido);
		vista.fechaNacimiento.setText(fechaNacimiento);
		vista.estaRegis.setText(estareg);

		if (estadoRegistro.equals("DEFAULT")) {
			vista.estaRegis.setText(estareg);
		} else {
			vista.estaRegis.setText(estadoRegistro);
		}
	}

	// limpia la entrada de texto de la vista
	@Override
	public void limpiar() {
		vista.cod.setText("");
		vista.primerNombre.setText("");
		vista.segundoNombre.setText("");
		vista.primerApellido.setText("");
		vista.segundoApellido.setText("");
		vista.fechaNacimiento.setText("");
		vista.estaRegis.setText("");

		vista.cod.setEditable(true);
		vista.primerNombre.setEditable(true);
		vista.segundoNombre.setEditable(true);
		vista.primerApellido.setEditable(true);
		vista.segundoApellido.setEditable(true);
		vista.fechaNacimiento.setEditable(true);
		vista.estaRegis.setEditable(true);
	}

	// Metodo para las acciones
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.adicionar) {
			System.out.println("Apreto: adicionar");
			// limpiar();
			vista.estaRegis.setText("A");
			vista.estaRegis.setEditable(false);

			CarFlaAct = 1;
			action = 1;

		} else if (e.getSource() == vista.modificar) {
			System.out.println("Apreto: modificar");
			int fila = vista.tabla.getSelectedRow();

			if (fila == -1) {
				JOptionPane.showMessageDialog(null, "Debe Seleccionar Una fila..!!");
			} else {

				llenarDatosDeTablaSelecionada(fila, "DEFAULT");

				// se tiene que cambiar estas partes (casi en todas es igual xd)
				vista.cod.setEditable(false);
				vista.estaRegis.setEditable(false);

				CarFlaAct = 1;
				action = 2;
			}

		} else if (e.getSource() == vista.eliminar) {
			System.out.println("Apreto: eliminar");

			int fila = vista.tabla.getSelectedRow();
			if (fila == -1) {
				JOptionPane.showMessageDialog(null, "Debe Seleccionar Una fila..!!");
			} else {

				llenarDatosDeTablaSelecionada(fila, "*");

				vista.cod.setEditable(false);
				vista.primerNombre.setEditable(false);
				vista.segundoNombre.setEditable(false);
				vista.primerApellido.setEditable(false);
				vista.segundoApellido.setEditable(false);
				vista.fechaNacimiento.setEditable(false);
				vista.estaRegis.setEditable(false);

				CarFlaAct = 1;
				action = 3;

			}
		} else if (e.getSource() == vista.cancelar) {
			System.out.println("Apreto: cancelar");
			CarFlaAct = 0;
			limpiar();

		} else if (e.getSource() == vista.inactivar) {
			System.out.println("Apreto: inactivar");

			int fila = vista.tabla.getSelectedRow();
			if (fila == -1) {
				JOptionPane.showMessageDialog(null, "Debe Seleccionar Una fila..!!");
			} else {

				llenarDatosDeTablaSelecionada(fila, "I");

				vista.cod.setEditable(false);
				vista.primerNombre.setEditable(false);
				vista.segundoNombre.setEditable(false);
				vista.primerApellido.setEditable(false);
				vista.segundoApellido.setEditable(false);
				vista.fechaNacimiento.setEditable(false);
				vista.estaRegis.setEditable(false);

				CarFlaAct = 1;
				action = 4;

			}
		} else if (e.getSource() == vista.reactivar) {
			System.out.println("Apreto: reactivar");

			int fila = vista.tabla.getSelectedRow();
			if (fila == -1) {
				JOptionPane.showMessageDialog(null, "Debe Seleccionar Una fila..!!");
			} else {

				llenarDatosDeTablaSelecionada(fila, "A");

				vista.cod.setEditable(false);
				vista.primerNombre.setEditable(false);
				vista.segundoNombre.setEditable(false);
				vista.primerApellido.setEditable(false);
				vista.segundoApellido.setEditable(false);
				vista.fechaNacimiento.setEditable(false);
				vista.estaRegis.setEditable(false);

				CarFlaAct = 1;
				action = 5;

			}
		} else if (e.getSource() == vista.actualizar) {
			System.out.println("Apreto: actualizar");
			if (CarFlaAct == 1) {
				if (JOptionPane.showConfirmDialog(null, "Está seguro que desea realizar esta acción", "WARNING",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.out.println("Afecta a la bd");

					if (action == 1) { // Agregar
						agregar();
					} else if (action == 2) { // Modificar
						modificar();
					} else if (action == 3) { // Eliminar
						eliminar();
					} else if (action == 4) { // Inavilitar
						inavilitar();
					} else if (action == 5) { // Reactivar
						reactivar();
					}

					CarFlaAct = 0;
				}

			} else {
				JOptionPane.showMessageDialog(null, "Opción no es válida", "Alerta", JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getSource() == vista.salir) {
			System.out.println("Apreto: salir ");
			System.exit(0);
		}
	}
}

package src.controlador;

import java.awt.event.ActionListener;
import javax.swing.*;

import src.modelo.DAO;
import src.vista.Vista;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public abstract class Controlador<CLASS> implements ActionListener {
    public CLASS classInterna;
    public DAO classDAO;
    public Vista vistaSuper;
    // public OficinaDetalleDAO oficinaDetalleDAO = new OficinaDetalleDAO();
    // public OficinaDetalle ofiDetalle = new OficinaDetalle();
    DefaultTableModel modelo = new DefaultTableModel();

    // Contructor
    public Controlador(Vista v, DAO dao) {
        classDAO = dao;
        vistaSuper = v;
        vistaSuper.adicionar.addActionListener(this);
        vistaSuper.modificar.addActionListener(this);
        vistaSuper.eliminar.addActionListener(this);
        vistaSuper.cancelar.addActionListener(this);
        vistaSuper.inactivar.addActionListener(this);
        vistaSuper.reactivar.addActionListener(this);
        vistaSuper.actualizar.addActionListener(this);
        vistaSuper.salir.addActionListener(this);
    }

    public abstract CLASS getOficinaDetalle();

    // metodo que agrera a una nueva categoria
    public void agregar() {

        // Obtenemos datos

        classInterna = getOficinaDetalle();

        // limpiamos la tabla anterior
        limpiarTabla();

        // agregamos
        int n = classDAO.add(classInterna);

        // verificamor resultado
        if (n == 1) {
            JOptionPane.showMessageDialog(null, "Agregado con Exito.");
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }

        // limpiamor entrada de texto
        limpiar();

        // listamor nueva tabla
        listar(vistaSuper.tabla);
    }

    public void modificar() {

        // Obtenemos datos

        classInterna = getOficinaDetalle();

        // limpiamos la tabla anterior
        limpiarTabla();

        // Modificamos
        int n = classDAO.modificar(classInterna);

        // verificamor resultado
        if (n == 1) {
            JOptionPane.showMessageDialog(null, "Modificado con Exito.");
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }

        // limpiamor entrada de texto
        limpiar();

        // listamor nueva tabla
        listar(vistaSuper.tabla);
    }

    // Para eliminar una categoria
    public void eliminar() {
        // Obtenemos datos

        classInterna = getOficinaDetalle();

        // limpiamos la tabla anterior
        limpiarTabla();

        // Modificamos
        int n = classDAO.modificar(classInterna);

        // verificamor resultado
        if (n == 1) {
            JOptionPane.showMessageDialog(null, "Eliminado con Exito.");
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }

        // limpiamor entrada de texto
        limpiar();

        // listamor nueva tabla
        listar(vistaSuper.tabla);
    }

    // Para inavilitar una categoria
    public void inavilitar() {
        // Obtenemos datos

        classInterna = getOficinaDetalle();

        // limpiamos la tabla anterior
        limpiarTabla();

        // Modificamos
        int n = classDAO.modificar(classInterna);

        // verificamor resultado
        if (n == 1) {
            JOptionPane.showMessageDialog(null, "Inavilitado con Exito.");
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }

        // limpiamor entrada de texto
        limpiar();

        // listamor nueva tabla
        listar(vistaSuper.tabla);
    }

    // Para reactivar una categoria
    public void reactivar() {
        // Obtenemos datos

        classInterna = getOficinaDetalle();

        // limpiamos la tabla anterior
        limpiarTabla();

        // Modificamos
        int n = classDAO.modificar(classInterna);

        // verificamor resultado
        if (n == 1) {
            JOptionPane.showMessageDialog(null, "Reavilitado con Exito.");
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }

        // limpiamor entrada de texto
        limpiar();

        // listamor nueva tabla
        listar(vistaSuper.tabla);
    }

    // Lista los nuevos datos
    public abstract void listar(JTable tabla);

    // Limpia la entrada de texto
    public abstract void limpiar();

    // limpia la tabla
    public void limpiarTabla() {
        for (int i = 0; i < vistaSuper.tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    // centra los numeros
    public void centrarCeldas(JTable tabla) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < vistaSuper.tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }

    // Llena los campos con los datos de la tabla
    public abstract void llenarDatosDeTablaSelecionada(int fila, String estadoRegistro);

}

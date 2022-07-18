import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.vista.*;
import src.modelo.*;
import src.controlador.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Main implements ActionListener {

	public static final String PROJECTNAME = "DATOS PERSONALES";
	public static JFrame frame, frameContent;
	public JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16;

	public Main() {
		frame = new JFrame(PROJECTNAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);

		b1 = new JButton("Contacto");
		b2 = new JButton("Datos Electronicos");
		b3 = new JButton("Datos Generales");
		b4 = new JButton("Datos Importantes");
		b5 = new JButton("Datos Personales");
		b6 = new JButton("Datos Personales Contacto");
		b7 = new JButton("Procedencia");

		b1.addActionListener((java.awt.event.ActionListener) this);
		b2.addActionListener((java.awt.event.ActionListener) this);
		b3.addActionListener((java.awt.event.ActionListener) this);
		b4.addActionListener((java.awt.event.ActionListener) this);
		b5.addActionListener((java.awt.event.ActionListener) this);
		b6.addActionListener((java.awt.event.ActionListener) this);
		b7.addActionListener((java.awt.event.ActionListener) this);

		JPanel panel = new JPanel();

		// creando el panel para los botones internos
		panel.setLayout(new GridLayout(4, 1, 10, 10));

		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
		panel.add(b7);

		frame.setSize(1000, 700);
		frame.add(panel);
		frame.pack();
	}

	public void actionPerformed(ActionEvent e) {
		Object E = e.getActionCommand();
		FrameContent();
		if (E.equals("Contacto")) {
			System.out.println("Contacto");
			generateContent_Contacto();
		} else if (E.equals("Datos Electronicos")) {
			System.out.println("Datos Electronicos");
			generateContent_DatElec();
		} else if (E.equals("Datos Generales")) {
			System.out.println("Datos Generales");
			generateContent_DatGen();

		} else if (E.equals("Datos Importantes")) {
			System.out.println("Datos Importantes");
			generateContent_DatImp();

		} else if (E.equals("Datos Personales")) {
			System.out.println("Datos Personales");
			generateContent_DatPer();

		} else if (E.equals("Datos Personales Contacto")) {
			System.out.println("Datos Personales Contacto");
			generateContent_DatPerCont();

		} else if (E.equals("Procedencia")) {
			System.out.println("Procedencia");
			generateContent_Procedencia();
		}
	}

	public static void FrameContent() {
		frameContent = new JFrame(PROJECTNAME);
		frameContent.setSize(800, 1000);
		frameContent.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frameContent.setLocationRelativeTo(frame);
		frameContent.setVisible(true);

	}

	// CONTACTO -------------------------------------
	public static void generateContent_Contacto() {
		VistaContacto vi = new VistaContacto();
		frameContent.add(vi.getContent());
		ControladorContacto con = new ControladorContacto(vi);
	}

	// DATOS ELECTRONICOS -------------------------------------
	public static void generateContent_DatElec() {
		VistaDatosElectronicos vi = new VistaDatosElectronicos();
		frameContent.add(vi.getContent());
		ControladorDatosElectronicos con = new ControladorDatosElectronicos(vi);
	}

	// DATOS GENERALES -------------------------------------
	public static void generateContent_DatGen() {
		VistaDatosGenerales vi = new VistaDatosGenerales();
		frameContent.add(vi.getContent());
		ControladorDatosGenerales con = new ControladorDatosGenerales(vi);
	}

	// DATOS IMPORTANTES -------------------------------------
	public static void generateContent_DatImp() {
		VistaDatosImportantes vi = new VistaDatosImportantes();
		frameContent.add(vi.getContent());
		ControladorDatosImportantes con = new ControladorDatosImportantes(vi);
	}

	// DATOS PERSONALES -------------------------------------
	public static void generateContent_DatPer() {
		VistaDatosPersonales vi = new VistaDatosPersonales();
		frameContent.add(vi.getContent());
	}

	// DATOS PERSONALES CONTACTO -------------------------------------
	public static void generateContent_DatPerCont() {
		VistaDatosPersonalesContacto vi = new VistaDatosPersonalesContacto();
		frameContent.add(vi.getContent());

	}

	// PROCEDENCIA -------------------------------------
	public static void generateContent_Procedencia() {
		VistaProcedencia vi = new VistaProcedencia();
		frameContent.add(vi.getContent());
	}

	public static void main(String[] args) {
		Main j = new Main();
	}
}

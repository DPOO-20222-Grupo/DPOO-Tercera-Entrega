package interfazEstudiante;

import java.awt.BorderLayout;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JPanel;

import interfaz.Aplicacion;
import interfazActividadesCompletadas.PanelActividadesDiarias;
import user.Estudiante;

@SuppressWarnings("serial")
public class VentanaEstudiante extends JFrame{
	
	private Aplicacion aplicacion;
	private Estudiante estudiante;
	private PanelOpcionesEstudiante panelOpciones; 
	private JPanel panelContenido;
	
	public VentanaEstudiante(Aplicacion app, Estudiante est) {
		this.aplicacion = app;
		this.estudiante = est;
		
		this.panelOpciones = new PanelOpcionesEstudiante(estudiante);

		this.setLayout(new BorderLayout());
		this.add(panelOpciones, BorderLayout.NORTH);

		this.add(panelOpciones);

		
		this.setVisible(true);

		
		this.setSize(600, 400);
		
		this.add(new PanelActividadesDiarias(app, LocalDate.now()), BorderLayout.SOUTH);

		
		
		
		

		this.setSize(800, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); 
        this.setResizable(true);

	}

}


package seguimientoEstudiantes;

import java.util.HashMap;
import java.util.Map;

import actividades.Quiz;
import preguntas.PreguntaCerrada;
import user.Estudiante;

public class SeguimientoQuiz extends SeguimientoActividad{
	
	private double nota;
	private Map<PreguntaCerrada, Integer> respuestas;
	private int numPreguntas;
	
	public SeguimientoQuiz (Quiz quiz, Estudiante estudiante) {
		 super(quiz, estudiante);
		 this.nota = -1;
		 this.respuestas = new HashMap<PreguntaCerrada, Integer>();
		 this.numPreguntas = quiz.getNumPreguntas();
		 
		 for (PreguntaCerrada pregunta: quiz.getPreguntas()) {
			 
			 respuestas.put(pregunta, -1);
			 
		 }
	}
	
	
	public double getNota() {
		return nota;
	}


	public int getNumPreguntas() {
		return numPreguntas;
	}


	private void setNota(double nota) {
		this.nota = nota;
	}
	
	public Map<PreguntaCerrada, Integer> getRespuestas() {
		return respuestas;
	}
	


	public void agregarRespuestaPregunta (PreguntaCerrada pregunta, int opcionEscogida) {
		this.respuestas.replace(pregunta, opcionEscogida);
	}
	
	public double calcularNota () {
		
		Map<PreguntaCerrada, Integer> respuestas = this.getRespuestas();
		int numPreguntas = this.getNumPreguntas();
		
		float nota = 0;
		
		for (Map.Entry<PreguntaCerrada, Integer> entry : respuestas.entrySet()) {
			PreguntaCerrada pregunta = entry.getKey();
			int opcionEscogida = entry.getValue();
			
			if (pregunta.verificarOpcionCorrecta(opcionEscogida)== true) {
				nota+=(1.0f/numPreguntas);
			}
		
			
		}
		
		return nota;
		
		
		
	}
	
	public void actualizarNota() {
		double nota = this.calcularNota();
		this.setNota(nota);
		
		Quiz quiz = (Quiz) this.getActividadSeguimiento();
		
		if (nota>=quiz.getCalificacionMinima()) {
			this.setEstado("Exitoso");
		}
		
		else {
			this.setEstado("No Exitoso");
		}
	}	

}

package exceptions;

import actividades.Actividad;

@SuppressWarnings("serial")
public class ModificarActividadesPreviasException extends Exception{
	
	private Actividad actividad;
	private String tipo;
	
	
	public ModificarActividadesPreviasException (Actividad actividad, String tipo) {
		super();
		this.actividad = actividad;
		this.tipo = tipo;
		
	}
	
	@Override
	
	public String getMessage () {
		
		if (tipo.equals("Agregar")) {
		
			String mensaje = String.format("La actividad '%1$s' del profesor %2$s (%3$s) ya existe en la lista de actividades previas.", 
					this.actividad.getTitulo(), actividad.getNombreProfesorCreador(), actividad.getLoginProfesorCreador());
			return mensaje;
			
		}
		
		else {
			String mensaje = String.format("La actividad '%1$s' del profesor %2$s (%3$s) no existe en la lista de actividades previas.", 
					this.actividad.getTitulo(), actividad.getNombreProfesorCreador(), actividad.getLoginProfesorCreador() );
			return mensaje;
		}
	}
	
	
}

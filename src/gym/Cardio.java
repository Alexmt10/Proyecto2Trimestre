package gym;

/**
 * La clase Cardio representa una actividad de tipo cardio en el gimnasio.
 * Extiende la clase Actividad y proporciona funcionalidad específica para actividades de cardio.
 */

public class Cardio extends Actividad {
	
	protected Tipo tipo;

	 /**
     * Constructor de la clase Cardio.
     * @param nombre El nombre de la actividad.
     * @param duracion La duración de la actividad en minutos.
     * @param tipo El tipo de actividad de cardio.
     */
	
	public Cardio(String nombre, double duracion, Tipo tipo) {
		super(nombre, duracion);
		this.tipo = tipo;
	}


	public Tipo getTipo() {
		return tipo;
	}


	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}


	@Override
	public String toString() {
		return "Cardio [tipo=" + tipo + ", nombre=" + nombre + ", duracion=" + duracion + "]";
	}


	
	}
	
	

	


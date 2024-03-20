package gym;

/**
 * La clase Levantamientopesas representa una actividad de levantamiento de pesas en el gimnasio.
 * Extiende la clase Actividad y proporciona funcionalidad específica para actividades de levantamiento de pesas.
 */
public class Levantamientopesas extends Actividad {
	
	protected Ejercicios ejercicio;

	
	  /**
     * Constructor de la clase Levantamientopesas.
     * @param nombre El nombre de la actividad.
     * @param duracion La duración de la actividad en minutos.
     * @param ejercicio El ejercicio específico de levantamiento de pesas.
     */
	public Levantamientopesas(String nombre, double duracion, Ejercicios ejercicio) {
		super(nombre, duracion);
		this.ejercicio = ejercicio;
	}

	public Ejercicios getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(Ejercicios ejercicio) {
		this.ejercicio = ejercicio;
	}

	@Override
	public String toString() {
		return "Levantamientopesas [ejercicio=" + ejercicio + ", nombre=" + nombre + ", duracion=" + duracion + "]";
	}
	

}

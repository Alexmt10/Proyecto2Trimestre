package gym;

public class Levantamientopesas extends Actividad {
	
	protected Ejercicios ejercicio;

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

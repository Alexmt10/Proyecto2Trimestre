package gym;

/**
 * La clase abstracta Persona representa a una personadel gimnasio.
 * @author alemolina
 * 
 */
 abstract class Persona {
	
	
	protected String nombre;
	protected String dni;
	protected String apellidos;
	protected String direccion;
	protected int numero_telefono;
	
	  /**
     * Constructor de la clase Persona.
     * @param nombre El nombre de la persona.
     * @param dni El DNI de la persona.
     * @param apellidos Los apellidos de la persona.
     * @param direccion La dirección de la persona.
     * @param numero_telefono El número de teléfono de la persona.
     */
	
	public Persona(String nombre, String dni, String apellidos, String direccion, int numero_telefono) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.numero_telefono = numero_telefono;
	}
	public Persona() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getNumero_telefono() {
		return numero_telefono;
	}
	public void setNumero_telefono(int numero_telefono) {
		this.numero_telefono = numero_telefono;
	}
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", dni=" + dni + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ ", numero_telefono=" + numero_telefono + "]";
	}
	/**
     * Método abstracto que debe ser implementado por las subclases para crear una persona.
     * @param personass Un arreglo de personas donde se almacenarán las nuevas personas creadas.
     */
	public abstract void crearpersona(Persona[] personass);
		
	

}

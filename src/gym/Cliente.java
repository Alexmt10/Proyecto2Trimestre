package gym;

import java.util.Scanner;

/**
 * La clase Cliente representa a un cliente del gimnasio.
 * Extiende la clase Persona e incluye atributos y métodos específicos para los clientes, como el bono y la estamina.
 */
public class Cliente extends Persona {

	protected Bono bono;
	protected int stamina;

	
	 /**
     * Constructor de la clase Cliente dependiendo del bono tendras mas o menos estamina.
     * @param nombre El nombre del cliente.
     * @param dni El DNI del cliente.
     * @param apellidos Los apellidos del cliente.
     * @param direccion La dirección del cliente.
     * @param numero_telefono El número de teléfono del cliente.
     * @param bono El bono del cliente.
     */
	public Cliente(String nombre, String dni, String apellidos, String direccion, int numero_telefono, Bono bono) {
		super(nombre, dni, apellidos, direccion, numero_telefono);
		switch (bono) {
        case ORO:
            this.stamina = 30;
            break;
        case PLATA:
            this.stamina = 25;
            break;
        case BRONCE:
            this.stamina = 20;
            break;
        default:
            System.out.println("Bono no válido. Se asignará BRONCE por defecto.");
            this.stamina = 20;
            
            
	}
		this.bono = bono;
	}


	public Bono getBono() {
		return bono;
	}

	public void setBono(Bono bono) {
		this.bono = bono;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	
	
	  @Override
	public String toString() {
		return "Cliente [bono=" + bono + ", stamina=" + stamina + ", nombre=" + nombre + ", dni=" + dni + ", apellidos="
				+ apellidos + ", direccion=" + direccion + ", numero_telefono=" + numero_telefono + "]";
	}
	/**
     * Método que permite crear un nuevo cliente y agregarlo al arreglo de personas.
     * Solicita al usuario que ingrese los datos del nuevo cliente y luego lo añade.
     * @param personass Un array de personas donde se almacenarán los nuevos clientes creados.
     */

	@Override
	public void crearpersona(Persona[] personass) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Ingrese el nombre del cliente: ");
		String nombreCliente = scanner.nextLine();
		System.out.print("Ingrese el DNI del cliente: ");
		String dniCliente = scanner.nextLine();
		System.out.print("Ingrese los apellidos del cliente: ");
		String apellidosCliente = scanner.nextLine();
		System.out.print("Ingrese la dirección del cliente: ");
		String direccionCliente = scanner.nextLine();
		System.out.print("Ingrese el número de teléfono del cliente: ");
		int numeroTelefonoCliente = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Ingrese el bono del cliente: ");
		String bonoClienteStr = scanner.nextLine().toUpperCase(); 
        Bono bonoCliente;
        switch (bonoClienteStr) {
        case "ORO":
            bonoCliente = Bono.ORO;
            break;
        case "PLATA":
            bonoCliente = Bono.PLATA;
            break;
        case "BRONCE":
            bonoCliente = Bono.BRONCE;
            break;
        default:
            System.out.println("Bono no válido. Se asignará BRONCE por defecto.");
            bonoCliente = Bono.BRONCE;
    }
		Persona nuevocliente = new Cliente(nombreCliente, dniCliente, apellidosCliente, direccionCliente,
				numeroTelefonoCliente, bonoCliente);

		for (int i = 0; i < personass.length; i++) {
			if (personass[i] == null) {
				personass[i] = nuevocliente;
				System.out.println("Cliente añadido correctamente:");
				return;
			}

		}
	}

}

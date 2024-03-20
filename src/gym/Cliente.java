package gym;

import java.util.Scanner;

public class Cliente extends Persona {

	protected String bono;
	protected int stamina;

	public Cliente(String nombre, String dni, String apellidos, String direccion, int numero_telefono, String bono) {
		super(nombre, dni, apellidos, direccion, numero_telefono);
		this.bono = bono;
		this.stamina = 20;
	}

	public String getBono() {
		return bono;
	}

	public void setBono(String bono) {
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
		return "nombre=" + nombre + ", dni=" + dni + ", apellidos="
				+ apellidos + ", direccion=" + direccion + ", numero_telefono=" + numero_telefono +"Cliente [bono=" + bono + ", stamina=" + stamina +  "]";
	}

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
		String bonoCliente = scanner.nextLine();
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

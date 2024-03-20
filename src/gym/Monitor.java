package gym;

import java.util.Scanner;

public class Monitor extends Persona {

	protected Tipo tipo;

	public Monitor(String nombre, String dni, String apellidos, String direccion, int numero_telefono, Tipo tipo) {
		super(nombre, dni, apellidos, direccion, numero_telefono);
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
		return "nombre=" + nombre + ", dni=" + dni + ", apellidos=" + apellidos
				+ ", direccion=" + direccion + ", numero_telefono=" + numero_telefono +"Monitor [tipo=" + tipo +  "]";
	}

	@Override
	public void crearpersona(Persona[] personass) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese el nombre del monitor: ");
		String nombre = scanner.nextLine();
		System.out.print("Ingrese el DNI del monitor: ");
		String dni = scanner.nextLine();
		System.out.print("Ingrese los apellidos del monitor: ");
		String apellidos = scanner.nextLine();
		System.out.print("Ingrese la dirección del monitor: ");
		String direccion = scanner.nextLine();
		System.out.print("Ingrese el número de teléfono del monitor: ");
		int numeroTelefono = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Ingrese la especialidad del monitor: 1. BODYPAM, 2. FUNCIONAL,3.  BOXEO, 4. OVERUP ");
		int opcion = scanner.nextInt();

		Tipo tipo;
		switch (opcion) {
		case 1:
			tipo = Tipo.BODYPAM;
			System.out.println("Se le ha asignado la clase de bodypum");
			break;
		case 2:
			tipo = Tipo.FUNCIONAL;
			break;
		case 3:
			tipo = Tipo.BOXEO;
			break;
		case 4:
			tipo = Tipo.OVERUP;
			break;
		default:
			System.out.println("Opción inválida. Se asignará BodyPump por defecto.");
			tipo = Tipo.BODYPAM;

			Persona nuevomonitor = new Monitor(nombre, dni, apellidos, direccion, numeroTelefono, tipo);

			scanner.close();

		}
	}
}

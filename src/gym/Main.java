package gym;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);

		Persona[] listapersonas = new Persona[100];

		listapersonas[0] = new Cliente("juan", "123456789", "perez", "123 Street", 123456789, "Gold");
		listapersonas[1] = new Cliente("pedro", "987654321", "molina", "456 Avenue", 987654321, "Silver");
		listapersonas[2] = new Monitor("maria", "123456789", "Sanchez", "123 Street", 123456789, Tipo.FUNCIONAL);
		listapersonas[3] = new Monitor("hugo", "987654321", "Escudero", "456 Avenue", 987654321, Tipo.BOXEO);
		int opcion;

		do {
			System.out.println("Menú Principal:");
			System.out.println("1. Crear Cliente");
			System.out.println("2. Crear Monitor");
			System.out.println("3. Listar los clientes");
			System.out.println("4. Listar los monitores");
			System.out.println("5. Eliminar clientes");
			System.out.println("6. Eliminar monitores");
			System.out.println("7. Seleccionar Actividad");
			System.out.println("8. Salir");

			opcion = sc.nextInt();

			switch (opcion) {

			case 1:
				listapersonas[0].crearpersona(listapersonas);
				break;
			case 2:
				listapersonas[2].crearpersona(listapersonas);
				break;
			case 3:
				listarclientes(listapersonas);
				break;
			case 4:
				listarmonitores(listapersonas);
				break;
			case 5:
				eliminarCliente(listapersonas);
				break;
			case 6:
				eliminarEmpleado(listapersonas);
				break;

			case 7:
				Actividad.elegirActividad(listapersonas);
				break;

			default:
				System.out.println("Opción inválida.");
			}
		} while (opcion != 8);

	}

	public static void listarclientes(Persona[] listapersonas) {

		System.out.println("\nClientes:");
		for (Persona p : listapersonas) {
			if (p instanceof Cliente) {
				System.out.println("Nombre: " + p.getNombre() + "estamina " + ((Cliente) p).getStamina() + ", Bono: "+ ((Cliente) p).getBono());
				System.out.println(p.toString());
			}
		}
	}

	public static void listarmonitores(Persona[] listapersonas) {
		System.out.println("Monitores:");
		for (Persona p : listapersonas) {
			if (p instanceof Monitor) {
				System.out.println("Nombre: " + p.getNombre() + "Especialidad: " + ((Monitor) p).tipo);
				System.out.println(p.toString());
			}

		}
	}

	public static void eliminarCliente(Persona[] listaPersonas) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Pon el nombre cel cliente que deseas eliminar");
		String nombreCliente = scanner.next();
		for (int i = 0; i < listaPersonas.length; i++) {
			if (listaPersonas[i] instanceof Cliente && listaPersonas[i].getNombre().equalsIgnoreCase(nombreCliente)) {
				listaPersonas[i] = null;
				System.out.println("Cliente eliminado correctamente.");
				return;
			}
		}
		System.out.println("Cliente no encontrado.");
	}

	public static void eliminarEmpleado(Persona[] listaPersonas) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Pon el nombre cel empleado que deseas eliminar");
		String nombreEmpleado = scanner.next();
		for (int i = 0; i < listaPersonas.length; i++) {
			if (listaPersonas[i] instanceof Monitor && listaPersonas[i].getNombre().equalsIgnoreCase(nombreEmpleado)) {
				listaPersonas[i] = null;
				System.out.println("Empleado eliminado correctamente.");
				return;
			}
		}
		System.out.println("Empleado no encontrado.");
	}
}

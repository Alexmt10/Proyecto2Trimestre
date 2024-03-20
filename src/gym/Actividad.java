package gym;

import java.util.Scanner;

public abstract class Actividad {
	protected String nombre;
	protected double duracion;

	public Actividad(String nombre, double duracion) {

		this.nombre = nombre;
		this.duracion = duracion;
	}

	public static void elegirActividad(Persona[] personass) {
		Scanner scanner = new Scanner(System.in);
		int opcionactividad;
		do {
            System.out.println("Que actividad quieres realizar: 1. Cardio, 2. Levantamiento de pesas, 3. Salir");
            opcionactividad = scanner.nextInt();

            switch (opcionactividad) {
                case 1:
                    realizarActividadCardio(personass);
                    break;
                case 2:
                    realizarLevantamientoPesas(personass);
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    return; // Salir del método si el usuario elige salir
                default:
                    System.out.println("Opción incorrecta. Por favor, selecciona una opción válida.");
                    break;
            }
        } while (true); // Bucle infinito, el usuario decide cuándo salir explícitamente
    }
	 private static void realizarActividadCardio(Persona[] personass) {
		 Scanner scanner = new Scanner(System.in);
				System.out.println("Que actividad de cardio quieres realizar: BODYPAM, FUNCIONAL, BOXEO, OVERUP");
				String opcionCardio1 = scanner.next().toUpperCase();
				Tipo tipo = null;

				if (opcionCardio1.equals("BOXEO")) {
					tipo = Tipo.BOXEO;

				} else if (opcionCardio1.equals("BODYPAM")) {
					tipo = Tipo.BODYPAM;

				} else if (opcionCardio1.equals("FUNCIONAL")) {
					tipo = Tipo.FUNCIONAL;

				} else if (opcionCardio1.equals("OVERUP")) {
					tipo = Tipo.OVERUP;

				}else {
					tipo = Tipo.FUNCIONAL;
					opcionCardio1 = "FUNCIONAL";
					System.out.println("No has seleccionado ningun valor correcto te hemos metido en funcional");
				}

				boolean monitorAsignado = false;
				for (Persona persona2 : personass) {
					if (persona2 instanceof Monitor && ((Monitor) persona2).getTipo() == tipo) {
						monitorAsignado = true;
						break;
					}
				}
				if (monitorAsignado) {
					System.out.println("Hay un monitor asignado a la clase de " + opcionCardio1);
					String nombreCliente;
				    Cliente persona3;
				    boolean clienteAsignado;
				    do {
				        System.out.println("¿Qué cliente desea asignar a esta actividad?");
				        nombreCliente = scanner.next();
				        clienteAsignado = false;
				        persona3 = null;
				        
				        for (Persona persona2 : personass) {
				            if (persona2 instanceof Cliente && persona2.getNombre().equalsIgnoreCase(nombreCliente)) {
				                clienteAsignado = true;
				                persona3 = (Cliente) persona2;
				                break;
				            }
				        }
				        
				        if (!clienteAsignado) {
				            System.out.println("El cliente especificado no se encuentra disponible. Por favor, inténtelo de nuevo.");
				        }
				    } while (!clienteAsignado);
					if (clienteAsignado) {
						System.out.println(
								"El cliente " + nombreCliente + " ha sido asignado a la actividad de " + opcionCardio1);
						double duracionActividad = tiempo(tipo);
						System.out.println(
								"La actividad de " + opcionCardio1 + " durará " + duracionActividad + " minutos.");
						int reduccionEstamina = 0;
						switch (tipo) {
						case BOXEO:
							reduccionEstamina = 4;
							break;
						case BODYPAM:
							reduccionEstamina = 5;
							break;
						case FUNCIONAL:
							reduccionEstamina = 3;
							break;
						case OVERUP:
							reduccionEstamina = 2;
							break;
						default:
							reduccionEstamina = 5;
							break;
						}
						if (persona3.getStamina() < reduccionEstamina) {
							System.out.println("Estás muy cansado para realizar esta actividad.");
						} else {
							persona3.setStamina(((Cliente) persona3).getStamina() - reduccionEstamina);
							System.out.println("Ha gastado: "+reduccionEstamina+ " de estamina te quedan: "+persona3.getStamina());
						}
					} else {
						System.out.println("El cliente especificado no se encuentra disponible.");
					}

				} else {
					System.out.println("Lo siento, no hay un monitor asignado a la clase de " + opcionCardio1
							+ " en este momento.");
				}
			}

	 private static void realizarLevantamientoPesas(Persona[] personass) {
		 Scanner scanner = new Scanner(System.in);
				System.out.println("¿Qué cliente deseas asignar a la actividad de levantamiento de pesas?");
				String nombreCliente = scanner.next();
				boolean clienteAsignado = false;
				Cliente clienteSeleccionado = null;
				for (Persona persona2 : personass) {
					if (persona2 instanceof Cliente && persona2.getNombre().equalsIgnoreCase(nombreCliente)) {
						clienteSeleccionado = (Cliente) persona2;
						clienteAsignado = true;
						break;
					}
				}
				if (clienteAsignado) {
					System.out.println("Cliente seleccionado: " + clienteSeleccionado.getNombre());
					System.out.println("Que ejercicio de fuerza quieres realizar: pressbanca, sentadilla, pesomuerto");
					String ejercicioSeleccionado = scanner.next().toUpperCase();
					Ejercicios ejercicio = null;

					int reduccionEstamina = 0;

					if (ejercicioSeleccionado.equals("PRESSBANCA")) {
						ejercicio = Ejercicios.PRESSBANCA;
						reduccionEstamina = 3;
					} else if (ejercicioSeleccionado.equals("SENTADILLA")) {
						ejercicio = Ejercicios.SENTADILLA;
						reduccionEstamina = 4;
					} else if (ejercicioSeleccionado.equals("PESOMUERTO")) {
						ejercicio = Ejercicios.PESOMUERTO;
						reduccionEstamina = 5;
					}
					else {
						System.out.println("opcion incorrecta se te a asignado el press banca");
						ejercicio = Ejercicios.PRESSBANCA;
						reduccionEstamina = 3;
						ejercicioSeleccionado = "PRESSBANCA";
					}

					System.out.println("Has elegido hacer pesas, te toca hacer 1RM");
					System.out
							.println("Para saber más o menos cuánto puedes levantar, necesitamos tu altura y tu peso");
					System.out.println("Primero, introduce tu altura en centimetros:");
					double altura = scanner.nextDouble();
					System.out.println("Ahora introduce tu peso en kilogramos:");
					double peso = scanner.nextDouble();
					double rm = 0;

					switch (ejercicio) {
					case PRESSBANCA:
						rm = (altura * peso) / 170;
						break;
					case SENTADILLA:
						rm = (altura * peso) / 130;
						break;
					case PESOMUERTO:
						rm = (altura * peso) / 110;
						break;
					}
					System.out.println(
							"¿Cuánto crees que es el peso que puedes levantar a una repetición en "+ ejercicioSeleccionado);
					double pesomaximo = scanner.nextDouble();

					int estaminaRequerida = reduccionEstamina;

					if (clienteSeleccionado.getStamina() < estaminaRequerida) {
						System.out.println(
								"No tienes suficiente estamina para realizar este ejercicio. Descansa un poco.");
					} else {
						if (pesomaximo > rm) {
							System.out.println("No has podido levantar el peso y te has lesionado.");
							clienteSeleccionado.setStamina(0);
							System.out.println("Estamina bajada a 0");
							System.out.println("Te hemos dado de baja en el gimnasio.");

							for (int i = 0; i < personass.length; i++) {
								if (personass[i] instanceof Cliente
										&& personass[i].getNombre().equalsIgnoreCase(nombreCliente)) {
									personass[i] = null;
									System.out.println("Cliente eliminado.");
									break;
								}
							}
						} else {
							System.out.println("¡Muy bien! Has conseguido levantar el peso. ¡Sigue así!");
							int nuevaEstamina = clienteSeleccionado.getStamina() - reduccionEstamina;
							clienteSeleccionado.setStamina(Math.max(nuevaEstamina, 0));
							System.out.println("Estamina que te queda " + nuevaEstamina);
						}
					}
				} else {
					System.out.println("El cliente especificado no se encuentra disponible.");
				}
			} 
		
	

	public static double tiempo(Tipo tipo) {
		switch (tipo) {
		case BOXEO:
			return 60;
		case BODYPAM:
			return 45;
		case FUNCIONAL:
			return 50;
		case OVERUP:
			return 55;
		default:
			return 0;
		}
	}
}

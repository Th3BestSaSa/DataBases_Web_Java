package JuegoRol;

import java.util.*;

public class Principal {
	private static final int OPCION_SALIR = 8;
	private static final int CANTIDAD_PERSONAJES = 200;
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int opc;
		ListaPersonajes listaPersonajes;

		listaPersonajes = crearListaPersonajes();

		do {
			mostrarMenu();
			opc = elegirOpcion();
			tratarMenu(opc, listaPersonajes);

		} while (opc != OPCION_SALIR);

	}

	private static ListaPersonajes crearListaPersonajes() {
		boolean hayFallo;
		ListaPersonajes listaPersonajes = null;
		do {
			try {
				listaPersonajes = new ListaPersonajes(CANTIDAD_PERSONAJES);
				hayFallo = false;
			} catch (PersonajeException ex) {
				hayFallo = true;
				System.out.println(ex.getMessage());
			}
		} while (hayFallo);
		return listaPersonajes;
	}

	/**
	 * Se encarga tratar el menu que se muestra por pantalla
	 * 
	 * @param opc             Entero con la opcion que se ha elegido
	 * @param listaPersonajes Objeto de listaPersonaje
	 * @throws MuerteException
	 */
	private static void tratarMenu(int opc, ListaPersonajes listaPersonajes) {

		Personaje personaje;
		String magoNombre, hechizoNombre, personajeNombre, clerigoNombre;

		try {
			switch (opc) {
			case 1: {
				personaje = introducirDatosPersonaje();
				listaPersonajes.annadirPersonaje(personaje);
				System.out.println("Personaje creado correctamente");
				break;
			}
			case 2: {
				magoNombre = introducirCadena("Introduzca el nombre del mago:");
				hechizoNombre = introducirCadena("Introduzca el nombre del hechizo que va aprender el personaje:");
				listaPersonajes.aprenderHechizoMago(magoNombre, hechizoNombre);
				System.out.println("Se ha aprendido el hechizo");
				break;
			}
			case 3: { // Lanzar hechizo
				magoNombre = introducirCadena("Introduzca el nombre del mago que lanza el hechizo:");
				hechizoNombre = introducirCadena(
						"Introduzca el nombre del hechizo que va utilizar " + magoNombre.toUpperCase() + ":");
				personajeNombre = introducirCadena("Introduzca el nombre del personaje que desea atacar:");
				listaPersonajes.lanzarHechizoPersonaje(magoNombre, personajeNombre, hechizoNombre);
				break;
			}
			case 4: {
				clerigoNombre = introducirCadena("Introduzca el nombre del clerigo:");
				magoNombre = introducirCadena("Introduzca el nombre del mago que deseas curar:");
				listaPersonajes.curarPersonaje(clerigoNombre, magoNombre);
				break;
			}
			case 5: {
				System.out.println(listaPersonajes);
				break;
			}
			case 6: {
				System.out.println(listaPersonajes.mostrarListadoPuntosActuales());
				break;
			}
			case 7: {
				System.out.println(listaPersonajes.vidaMinima());
				break;
			}
			case 8: {
				System.out.println("FIN DEL JUEGO DE ROL");
				break;
			}
			}
		} catch (PersonajeException ex) {
			System.out.println(ex.getMessage());
		}

		System.out.println();

	}

	/**
	 * Se encarga de introducir los datos del personaje he inicializar el objeto
	 * Mago o Clerigo
	 * 
	 * @return Objeto Personaje con los datos del mago
	 * @throws PersonajeException no hago el try-catch en este metodo porque
	 *                            prefiero tratarlo en el metodo tratarMenu
	 */
	private static Personaje introducirDatosPersonaje() throws PersonajeException {

		int fuerza, inteligencia, puntVidaMax;
		String nombre, tipoPersonaje, dios;
		TRaza raza;
		Personaje p = null;

		nombre = introducirCadena("Introduzca el nombre del personaje:");
		tipoPersonaje = introducirTipoPersonaje("Introduzca el tipo de " + nombre.toUpperCase() + " (MAGO o CLERIGO):");
		raza = introducirTipoRaza(
				"Introduzca la raza de " + nombre.toUpperCase() + Arrays.toString(TRaza.values()) + ":");
		fuerza = introducirEntero("Introduzca la fuerza de " + nombre.toUpperCase() + ":");
		inteligencia = introducirEntero("Introduzca la inteligencia de " + nombre.toUpperCase() + ":");
		puntVidaMax = introducirEntero("Introduzca los puntos de vida maximo de " + nombre.toUpperCase() + ":");

		switch (tipoPersonaje) {
		case "MAGO": {
			p = new Mago(nombre, raza, fuerza, inteligencia, puntVidaMax);
			break;
		}
		case "CLERIGO": {
			dios = introducirCadena("Introduzca el dios de " + nombre.toUpperCase() + ":");
			p = new Clerigo(nombre, raza, fuerza, inteligencia, puntVidaMax, dios);
			break;
		}
		}

		return p;
	}

	/**
	 * Se encarga del devolver un Entero y controlamos la excepcion de
	 * NumberFormatException
	 * 
	 * @param enunciado String con el enunciado por pantalla de lo que se va a
	 *                  introducir
	 * @return Entero con el numero a devolver
	 */
	private static int introducirEntero(String enunciado) {

		int entero = 0;
		boolean hayFallo;

		do {
			try {
				System.out.print(enunciado);
				entero = Integer.parseInt(teclado.nextLine());
				hayFallo = false;
			} catch (NumberFormatException ex) {
				hayFallo = true;
				System.out.println("ERRintroducirTipoRazaOR. Solo puedes introducir numeros");
			}
		} while (hayFallo);

		return entero;
	}

	/**
	 * Se encarga del devolver un String del tipo de personaje y controlamos que sea
	 * MAGO o CLERIGO
	 * 
	 * @param enunciado String con el enunciado por pantalla de lo que se va a
	 *                  introducir
	 * @return String con el tipo de Personaje
	 */
	private static String introducirTipoPersonaje(String enunciado) {

		boolean hayFallo;
		String cadena;

		do {
			System.out.print(enunciado);
			cadena = teclado.nextLine().toUpperCase();

			if (!cadena.equalsIgnoreCase("MAGO") && !cadena.equalsIgnoreCase("CLERIGO")) {
				hayFallo = true;
				System.out.println("ERROR. El tipo de personaje " + cadena + " no existe");
			} else {
				hayFallo = false;
			}
		} while (hayFallo);

		return cadena;
	}

	/**
	 * Se encarga del devolver un tipo enumerado de la clase TRaxa y controlamos la
	 * excepcion IllegalArgumentException
	 * 
	 * @param enunciado String con el enunciado por pantalla de lo que se va a
	 *                  introducir
	 * @return tipo enumerado de la clase TRaza
	 */
	private static TRaza introducirTipoRaza(String enunciado) {

		boolean hayFallo;
		String cadena = null;
		TRaza raza = null;

		do {
			try {
				System.out.print(enunciado);
				cadena = teclado.nextLine().toUpperCase();
				raza = TRaza.valueOf(cadena);
				hayFallo = false;
			} catch (IllegalArgumentException ex) {
				hayFallo = true;
				System.out.println("ERROR. El tipo de raza " + cadena + " no existe");
			}
		} while (hayFallo);

		return raza;
	}

	/**
	 * Se encarga del devolver un String
	 * 
	 * @param enunciado enunciado String con el enunciado por pantalla de lo que se
	 *                  va a introducir
	 * @return String con valor introducido en la cadena
	 */
	private static String introducirCadena(String enunciado) {

		String cadena;

		System.out.print(enunciado);
		cadena = teclado.nextLine();

		return cadena;
	}

	/**
	 * Este metodo se encarga de introducir una de la opciones por el cual controla
	 * que la opcion no se menor que 0 y mayor que 7 y tambien se controla una
	 * excepcion de NumberFormatException
	 * 
	 * @return Entero que es la opcion que se escoge
	 */
	private static int elegirOpcion() {

		int opc = 0;
		boolean hayFallo;

		do {
			try {
				System.out.print("Elige una opcion:");
				opc = Integer.parseInt(teclado.nextLine());
				hayFallo = false;
			} catch (NumberFormatException ex) {
				hayFallo = true;
				System.out.println("ERROR. Solo puedes introducir numeros");
			}
		} while (hayFallo || opc <= 0 || opc > OPCION_SALIR);

		return opc;
	}

	/**
	 * Se encarga de mostrar por pantalla las opciones del menu
	 */
	private static void mostrarMenu() {

		System.out.println("1. Alta personaje");
		System.out.println("2. Mago aprende hechizo");
		System.out.println("3. Mago lanza hechizo");
		System.out.println("4. Clerigo cura al mago");
		System.out.println("5. Mostrar el listado de personajes");
		System.out.println("6. Mostrar el listado ordenados por puntos actuales de mayor a menor");
		System.out.println("7. Mostrar vida minima");
		System.out.println("8. Salir");

	}

}

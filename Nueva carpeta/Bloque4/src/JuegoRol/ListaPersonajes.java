package JuegoRol;

import java.util.Arrays;

public class ListaPersonajes implements CreableEstadisticas {

	private Personaje listaPersonajes[];
	private int cantidadPersonajes;

	public int getCantidadPersonajes() {
		return cantidadPersonajes;
	}

	public void setCantidadPersonajes(int cantidadPersonajes) {
		this.cantidadPersonajes = cantidadPersonajes;
	}

	/**
	 * Se encarga de inicializar el array con la cantidad del array que se le pasa
	 * por parametro
	 * 
	 * @param capacidad Entero de la capacidad de espacio en el array, es decir, el
	 *                  número máximo de personajes que se pueden almacenar
	 * @throws PersonajeException Al comprobar que la cantidad del espacio del array
	 *                            no es negativo
	 */

	public ListaPersonajes(int capacidad) throws PersonajeException {
		if (capacidad <= 0) {
			throw new PersonajeException("Valores inválidos para Mago.");
		}
		listaPersonajes = new Personaje[capacidad];
		cantidadPersonajes = 0;
	}

	/**
	 * Se encarga de annadir en el array el personaje pasado por parametro
	 * 
	 * @param personajeAnnadir Objeto personaje que se va annadir
	 * @throws PersonajeException Al comprobar que el personaje ya existe y tambien
	 *                            si no hay mas espacio en el array
	 */

	public void annadirPersonaje(Personaje personajeAnnadir) throws PersonajeException {
		if (cantidadPersonajes >= listaPersonajes.length) {
			throw new PersonajeException("No hay espacio para más personajes.");
		}
		for (Personaje personaje : listaPersonajes) {
			if (personaje != null && personaje.equals(personajeAnnadir)) {
				throw new PersonajeException("El personaje ya existe en la lista.");
			}
		}
		listaPersonajes[cantidadPersonajes++] = personajeAnnadir;

	}

	/**
	 * Se encarga de añadir el hechizo al objeto personaje
	 * 
	 * @param nombreMago    String nombre del mago que aprende el hechizo
	 * @param nombreHechizo String nombre del hechizo que va a aprender el mago
	 * @throws PersonajeException En el metodo comprobarPersonajeExiste, cuando se
	 *                            comprueba que si el objeto de array es un mago
	 */

	public void aprenderHechizoMago(String nombreMago, String nombreHechizo) throws PersonajeException {
		Personaje personaje = encontrarPersonaje(nombreMago);
		if (personaje != null && personaje instanceof Mago) {
			((Mago) personaje).aprendeHechizo(nombreHechizo);

		} else {
			throw new PersonajeException("El personaje es un Clerigo");
		}
	}

	/**
	 * Se encarga de buscar el nombre del mago, su hechizo y nombre del personaje
	 * 
	 * @param nombreMagoAtaca         String nombre del mago que ataca
	 * @param nombrePersonajeDefiende String nombre del personaje que es atacado
	 * @param nombreHechizo           String del hechizo del mago que ataca
	 * @throws PersonajeException Se utiliza en el metodo comprobarPersonajeExiste,
	 *                            si nombreMagoAtaca es un mago y que si
	 *                            nombreMagoAtaca esta en la misma posicion
	 *                            nombrePersonajeDefiende no se ataca asi mismo
	 *                            comprobando la posicion en el array
	 * @throws MuerteException    s
	 */

	public void lanzarHechizoPersonaje(String nombreMagoAtaca, String nombreMago, String nombreHechizo)
			throws PersonajeException {
		Personaje mago = encontrarPersonaje(nombreMago);
		if (mago instanceof Mago) {
			((Mago) mago).lanzaHechizo(mago, nombreHechizo);

		} else {
			throw new PersonajeException("Ojala funcione");
		}
	}

	/**
	 * Se encarga de buscar un clerigo y buscar un personaje, y el clerigo cura al
	 * personaje.
	 * 
	 * @param nombreClerigo   String que contiene el nombre del clerigo que va a
	 *                        curar
	 * @param nombrePersonaje String que contiene el nombre del personaje que se va
	 *                        a curar
	 * @throws PersonajeException En el metodo comprobarPersonajeExiste, si es un
	 *                            clerigo en la posClerigo del array y si la
	 *                            posClerigo y posPersonaje no son iguales para
	 *                            comprobar que no se cura asi mismo
	 * 
	 */

	/**
	 * Busca un personaje por su nombre en el array
	 * 
	 * @param nombre String nombre del personaje a buscar
	 * @return null si no encuentra el personaje, y el personaje encontrado si se
	 *         encuentra
	 * @throws PersonajeException
	 *
	 */
	private Personaje encontrarPersonaje(String nombre) throws PersonajeException {
		for (Personaje personaje : listaPersonajes) {
			if (personaje.getNombre().equals(nombre)) {
				return personaje;
			}
		}
		throw new PersonajeException("Personaje no encontrado: " + nombre);
	}

	public void curarPersonaje(String nombreClerigo, String nombrePersonaje) throws PersonajeException {
		Personaje clerigo = encontrarPersonaje(nombreClerigo);
		Personaje objetivo = encontrarPersonaje(nombrePersonaje);

		if (clerigo instanceof Clerigo clerigoCura) {
			if (!clerigo.equals(objetivo)) {
				clerigoCura.curar(objetivo);
			} else {
				throw new PersonajeException("Un clérigo no puede curarse a sí mismo.");
			}
		} else {
			throw new PersonajeException("El personaje no es un clérigo.");
		}
	}

	/**
	 * Almacena en un String todos los personajes almacenados en el array
	 * 
	 * @return String de todos los personajes creados
	 */

	/**
	 * Ordena el array de personajes por el numero de vida actual de mayor a menor y
	 * luego lo muesta en forma de String
	 * 
	 * @return String del array ya ordenado
	 */

	public String mostrarListadoPuntosActuales() {
		Arrays.sort(listaPersonajes,
				(a, b) -> (a == null) ? 1 : (b == null) ? -1 : Integer.compare(b.getVidaActual(), a.getVidaActual()));
		return toString();
	}

	@Override
	public double vidaMinima() {
		double vida = listaPersonajes[0].getVidaActual();
		;
		for (int i = 0; i < cantidadPersonajes; i++) {
			if (listaPersonajes[i].getVidaActual() < vida) {
				vida = listaPersonajes[i].getVidaActual();
			}

		}
		return vida;
	}

	@Override
	public double vidaMaxima() {
		double vida = listaPersonajes[0].getVidaActual();
		;
		for (int i = 0; i < cantidadPersonajes; i++) {
			if (listaPersonajes[i].getVidaActual() > vida) {
				vida = listaPersonajes[i].getVidaActual();
			}
		}
		return vida;
	}

	@Override
	public double vidaMedia() {
		double vida = listaPersonajes[0].getVidaActual();
		;
		double suma = 0;
		double total = 0;
		for (int i = 0; i < cantidadPersonajes; i++) {
			if (listaPersonajes[i].getVidaActual() < vida) {
				vida = listaPersonajes[i].getVidaActual();
				suma = suma + vida;
			}
			total = suma / cantidadPersonajes;
		
			total = vida;
		}
		return vida;
	}
	// crear metodo para buscar null en añadir personaje
	public String toString() {
		return "ListaPersonajes [listaPersonajes=" + Arrays.toString(listaPersonajes) + ", cantidadPersonajes="
				+ cantidadPersonajes + "]";
	}

}

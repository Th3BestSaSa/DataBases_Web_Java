package JuegoRol;

public abstract class Personaje {

	private String nombre;
	private TRaza raza;
	private int fuerza, inteligencia, vidaActual, vidaMaxima;

	private static final int VIDA_MAX = 100, FUERZA_MAX = 20, INTELIGENCIA_MAX = 20;

	public Personaje(String nombre, TRaza raza, int fuerza, int inteligencia, int vidaMaxima)
			throws PersonajeException {
		setNombre(nombre);
		setRaza(raza);
		setFuerza(fuerza);
		setInteligencia(inteligencia);
		setVidaMaxima(vidaMaxima);
		setVidaActual(getVidaMaxima());
	}

	// Metodos Setter y Getter
	public TRaza getRaza() {
		return raza;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setRaza(TRaza raza2) {
		this.raza = raza2;
	}

	public int getFuerza() {
		return fuerza;
	}

	/**
	 * Modifica la fuerza del personaje, comprobando que est en el rango adecuado y
	 * si no lanzar la excepcion
	 * 
	 * @param fuerza Nueva fuerza
	 */

	public void setFuerza(int fuerza) throws PersonajeException {
		if (fuerza <= 0 || fuerza > FUERZA_MAX) {
			throw new PersonajeException("La fuerza tiene que estar entre 0 y " + FUERZA_MAX);
		}
		this.fuerza = fuerza;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	/**
	 * Modifica la inteligencia del personaje, comprobando que est en el rango
	 * adecuado y si no lanzar la excepcion
	 * 
	 * @param inteligencia Nueva inteligencia
	 */

	public void setInteligencia(int inteligencia) throws PersonajeException {
		if (inteligencia < 0 || inteligencia > INTELIGENCIA_MAX) {
			throw new PersonajeException("La inteligencia no puede superar " + INTELIGENCIA_MAX);
		}
		this.inteligencia = inteligencia;
	}

	public int getVidaActual() {
		return vidaActual;
	}

	/**
	 * Modifica la vida actual del personaje, contrololando que no supere la vida
	 * maxima
	 * 
	 * @param vidaActual
	 * @throws PersonajeException
	 */
	public void setVidaActual(int vidaActual) throws PersonajeException {
		if (vidaActual < 0)
			throw new PersonajeException("El personaje " + this.getNombre() + " no puede tener vida negativa ");

		if (vidaActual > vidaMaxima) // si le entra un valor mayor a la vida maxima, le doy el valor maximo
			vidaActual = vidaMaxima;

		this.vidaActual = vidaActual;
	}

	public int getVidaMaxima() {
		return vidaMaxima;
	}

	/**
	 * Modifica la vida M xima del personaje. No puede ser inferior a la vida actual
	 * , ni superar el l mite m ximo
	 * 
	 * @param vidaMaxima
	 * @throws PersonajeException
	 */
	public void setVidaMaxima(int vidaMaxima) throws PersonajeException {
		if (vidaMaxima > VIDA_MAX || vidaMaxima < vidaActual) {
			throw new PersonajeException("No puedes superar los " + VIDA_MAX
					+ " de vida, ni poner por debajo de la vida actual " + vidaActual);
		}
		this.vidaMaxima = vidaMaxima;
	}

	public boolean equals(Personaje otro) {
		return this.nombre.equals(otro.nombre);
	}

	@Override
	public String toString() {
		return "Nombre=" + nombre + ", raza=" + raza + ", fuerza=" + fuerza + ", inteligencia=" + inteligencia
				+ ", vidaActual=" + vidaActual + ", vidaMaxima=" + vidaMaxima + "]";
	}
}

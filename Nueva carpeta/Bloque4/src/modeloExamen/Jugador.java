package modeloExamen;

public class Jugador {

	private static final int RESISTENCIA_MAXIMA = 20;
	private static final int PUNTOS_COMBATE = 2;
	private String nombre;
	private int resistencia;

	public Jugador(String nombre, int resistencia) throws JuegoException {
		this.nombre = nombre;
		if (resistencia > RESISTENCIA_MAXIMA || resistencia <= 0)
			throw new JuegoException("No se puede crear un jugador con resistencia " + resistencia);
		this.resistencia = resistencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getResistencia() {
		return resistencia;
	}

	@Override
	public String toString() {
		return "NOMBRE " + nombre + "  RESISTENCIA " + resistencia;
	}

	public void combatir(Jugador otro) {
		int misPuntosCombate, otroPuntosCombate;
		misPuntosCombate = this.resistencia;
		otroPuntosCombate = otro.resistencia;
// metodo protegido (protected)
		ejecutarCombate(otro, misPuntosCombate, otroPuntosCombate);
	}

	/* Método privado del que se ayuda el método combate */

	protected void ejecutarCombate(Jugador otro, int misPuntosCombate, int otroPuntosCombate) {
		if (misPuntosCombate > otroPuntosCombate) { // gano yo, otro pierde
			otro.resistencia = otro.resistencia - PUNTOS_COMBATE;
		} else {
			if (misPuntosCombate < otroPuntosCombate) { // pierdo yo
				this.resistencia = this.resistencia - PUNTOS_COMBATE;
			}
		}

		if (this.resistencia < 0) {
			this.resistencia = 0;
		}
		if (otro.resistencia < 0) {
			otro.resistencia = 0;
		}
	}

}

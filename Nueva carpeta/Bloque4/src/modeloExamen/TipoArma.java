package modeloExamen;

public enum TipoArma {
	ESPADA_CORTA(Guerrero.DANO_ESPADA_CORTA), ESPADA_LARGA(Guerrero.DANO_ESPADA_LARGA), MANDOBLE(Guerrero.DANO_MANDOBLE), ARCO(Guerrero.DANO_ARCO);

	private final int puntos;

	// Constructor
	TipoArma(int puntos) {
		this.puntos = puntos;
	}

	// Método para obtener los puntos
	public int getPuntos() {
		return puntos;
	}
}
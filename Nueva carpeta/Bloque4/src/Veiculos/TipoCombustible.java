package Veiculos;

public enum TipoCombustible {
	GASOLINA(Coche.INCREMENTO_GASOLINA),
	DIESEL(Coche.INCREMENTO_DIESEL);
	
	private double incremento;
	
	TipoCombustible(double incremento) {
		this.incremento= incremento;
	}
	/**
	 * @return the incremento
	 */
	public double getIncremento() {
		return incremento;
	}
}

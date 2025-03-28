package Veiculos;

public class Coche extends Vehiculo {
	// Crea el Tipo de Combustible como enumerado

	private TipoCombustible combustible;
	
	public static final double INCREMENTO_GASOLINA = 3.5;
	public static final double INCREMENTO_DIESEL = 2;

	public Coche(String matricula, TipoGama gama, TipoCombustible combustible) {
		super(matricula, gama);
		this.combustible = combustible;
	}

	// M�todos gets y sets
	public TipoCombustible getCombustible() {
		return combustible;
	}

	public void setCombustible(TipoCombustible combustible) {
		this.combustible = combustible;
	}

	// Calcular el alquiler
	@Override
	public double calcularAlquiler(int dias) throws VehiculoException {
		double totalVariable = 0;
		if (dias <= 0)
			throw new VehiculoException("Dias de alquiler incorrecto");
		switch ( combustible) {
		case GASOLINA:
			totalVariable=INCREMENTO_GASOLINA*dias;
			break;
		case DIESEL:
			totalVariable=INCREMENTO_DIESEL*dias;
			break;
		}
		
		return totalVariable + calcularAlquilerBase(dias);
	}

	@Override
	public String toString() {
		return "Coche " + super.toString() + " [combustible=" + combustible + "]";
	}

	

}

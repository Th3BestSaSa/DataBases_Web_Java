package Veiculos;

public abstract class Vehiculo {

	private String matricula;
	private TipoGama gama;

	public static final double PRECIO_ALTA = 50;
	public static final double PRECIO_MEDIA = 40;
	public static final double PRECIO_BAJA = 30;

	public Vehiculo(String matricula, TipoGama gama) {
		this.matricula = matricula;
		this.gama = gama;

	}

	// M�todos gets y sets

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public TipoGama getGama() {
		return gama;
	}

	public void setGama(TipoGama gama) {
		this.gama = gama;
	}

	// m�todos alquiler
	public abstract double calcularAlquiler(int dias) throws VehiculoException;

	// M�todos calcular base

	protected double calcularAlquilerBase(int dias) {
		double precio=0;

		switch (gama) {
		case ALTA:
			precio = dias * PRECIO_ALTA;
			break;
		case MEDIA:
			precio = dias * PRECIO_MEDIA;
			break;
		case BAJA:
			precio = dias * PRECIO_BAJA;
			break;
		}
		return precio;

	}

	@Override
	public String toString() {
		return " Matricula=" + matricula + ", gama=" + gama + "]";
	}

}

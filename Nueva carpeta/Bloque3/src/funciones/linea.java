package funciones;

public class linea {
	private FuncionesPunto puntoA;
	private FuncionesPunto puntoB;
	
	public linea(FuncionesPunto puntoA, FuncionesPunto puntoB) {
		this.puntoA = puntoA;
		this.puntoB = puntoB;
	}

	public FuncionesPunto getPuntoA() {
		return puntoA;
	}

	public void setPuntoA(FuncionesPunto puntoA) {
		this.puntoA = puntoA;
	}

	public FuncionesPunto getPuntoB() {
		return puntoB;
	}

	public void setPuntoB(FuncionesPunto puntoB) {
		this.puntoB = puntoB;
	}
	public void moverDerecha(double movimiento) throws LineaException{
		double resultadoPuntoA, resultadoPuntoB;
		
		if (movimiento <=0) {
			throw new LineaException ("No se puede mover");
		}
	}
}

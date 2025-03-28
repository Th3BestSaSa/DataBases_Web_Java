package Deporte;



public class Oficina implements Edificio {
	
	private int numeroOficinas;
	private double superficieEdificio;
	

	

	// Constructor
	/**
	 * 
	 * @param numeroOficinasInicial
	 * @param anchoInicial
	 * @param largoInicial
	 * @throws RecintoDeportivoException
	 */
	public Oficina(int numeroOficinasInicial, double superficieEdificioInicial)  {
		setNumeroOficinas(numeroOficinasInicial);
		setSuperficieEdificio(superficieEdificioInicial);
		
	}

	// Metodos get y set
	public int getNumeroOficinas() {
		return numeroOficinas;
	}

	

	public void setNumeroOficinas(int numeroOficinasNuevo)  {

		
		this.numeroOficinas = numeroOficinasNuevo;
	}

	// Metodo heredado de la interface
	public double getSuperficieEdificio() {
		return superficieEdificio;
	
	}
	
	public void setSuperficieEdificio(double superficieEdificio) {
		this.superficieEdificio = superficieEdificio;
	}

	@Override
	public String toString() {
		return "Oficina [numeroOficinas=" + numeroOficinas + ", superficieEdificio=" + superficieEdificio + "]";
	}

	
	
}

	

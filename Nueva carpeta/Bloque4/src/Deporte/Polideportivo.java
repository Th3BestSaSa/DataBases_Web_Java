package Deporte;



public class Polideportivo implements InstalacionDeportiva, Edificio{

	private int tipoInstalacion;
	private String nombre;
	private double superficieEdificio;
	
	public Polideportivo(int tipoInicial, double superficieInicial, String nombreInicial) {
		setTipo(tipoInicial);
		setSuperficie(superficieInicial);
		setNombre(nombreInicial);
	}
	
	public int getTipo() {
		return tipoInstalacion;
	}

	public void setTipo(int tipo) {
		this.tipoInstalacion = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public void setSuperficie(double superficie) {
		this.superficieEdificio = superficie;
	}

	@Override
	public double getSuperficieEdificio() {
		
		return superficieEdificio;
	}

	@Override
	public int getTipoInstalacion() {
		
		return tipoInstalacion;
	}

	@Override
	public String toString() {
		return "Polideportivo [tipo=" + tipoInstalacion + ", nombre=" + nombre + ", superficie=" + superficieEdificio + "]";
	}

	
	
	

}

package Veiculos;

public class FlotaVehiculos {
	
	private Vehiculo vehiculos[];

	/**
	 *  Variable que guarda donde se insertará el siguiente vehiculo
	 *  Empieza con 0 y si vale vehiculos.length el almacen esta lleno
	 */
	private int numeroRealDeVehiculos;

	public FlotaVehiculos(int capacidadAlmacen) throws VehiculoException {
		if (capacidadAlmacen <= 0)
			throw new VehiculoException("Numero de vehiculos no puede ser negativo o cero");
		vehiculos = new Vehiculo[capacidadAlmacen];
		numeroRealDeVehiculos = 0;
	}

	public void introducirVehiculo(Vehiculo vehiculo) throws VehiculoException {
		if (vehiculo ==null) {
			throw new VehiculoException("no exixte");
		}
		
	}

	private Vehiculo buscarMatricula(String matricula) {

	    boolean existe = false;
	    int i = 0;
	    Vehiculo vehiculoEncontrado = null;

	    while (i < numeroRealDeVehiculos && existe == false) {

	        if (matricula.equalsIgnoreCase(vehiculos[i].getMatricula())) {

	            existe = true;
	            vehiculoEncontrado = vehiculos[i];
	        }
	        i++;
	    }

	    return vehiculoEncontrado;
	}


	public double precioAlquiler(String matricula, int dias) throws VehiculoException {

	    if (dias <= 0)
	        throw new VehiculoException("El número de días debe ser mayor a cero");

	    Vehiculo vehiculo = buscarMatricula(matricula);
	    if (vehiculo == null)
	        throw new VehiculoException("Vehículo no encontrado en la flota");

	    return vehiculo.calcularAlquilerBase(dias);
	}

	
	public String toString() {

	    StringBuilder sb = new StringBuilder();

	    sb.append("Flota de Vehículos:");

	    for (int i = 0; i < numeroRealDeVehiculos; i++) {
	        sb.append(vehiculos[i].toString());
	    }

	    return sb.toString();
	}
}

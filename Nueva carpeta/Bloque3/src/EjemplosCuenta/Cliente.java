package EjemplosCuenta;


public class Cliente {
	private String dni;
	private String nombreCompleto;
	private String direccion;
	private int edad;
	
	
	public Cliente(String dni, String nombreCompleto, String direccion, int edad) throws ClienteException {
		
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.direccion = direccion;
		setEdad(edad);
	}
	public void setEdad(int edad) throws ClienteException {
		if ( edad < 0 || edad > 100) {
			throw new ClienteException("La edad es incorrecta " + edad);
		}
		this.edad=edad;
		
	}
	
	public int getEdad( ) {
		return edad;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombreCompleto=" + nombreCompleto + ", direccion=" + direccion + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
	
	
	
	
	
}

package banco;

public abstract class Empleado {
	public static final int SUELDO_MINIMO=800;
	
	private String dni;
	private String nombre;
	private int sueldo;
	
	
	public Empleado(String dni, String nombre, int sueldo) throws EmpleadoException {
		super();
		this.dni = dni;
		this.nombre = nombre;
		setSueldo(sueldo);
	}
	public Empleado(String nombre2, double min) {
		// TODO Auto-generated constructor stub
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getSueldo() {
		return sueldo;
	}
	public void setSueldo(int sueldo) throws EmpleadoException {
		if (sueldo < SUELDO_MINIMO)
			throw new EmpleadoException(" Sueldo incorrecto");
		this.sueldo = sueldo;
	}
	@Override
	public String toString() {
		return "Empleado [dni=" + dni + ", nombre=" + nombre + ", sueldo=" + sueldo + "]";
	}
	public String mostrarInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}

package ejemplo;

public class Alumno {

	//Atributos
	private String dni;
	private String nombre;
	private int edad;
	private String domicilio;
	
	
	//Constructores
	
	public Alumno(String dniAlumno, String nombreAlumno,
			int edadAlumno) {
		dni=dniAlumno;
		nombre= nombreAlumno;
		edad= edadAlumno;
		
	}
	
	public Alumno(String dniAlumno, String nombreAlumno,
			int edadAlumno, String domicilioAlumno) {
		dni=dniAlumno;
		nombre= nombreAlumno;
		edad= edadAlumno;
		domicilio=domicilioAlumno;
	}
	//Métodos
	
	public String getDni() {
		return dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public String getDomicilio() {
		return domicilio;
	}
	
	public void setDomicilio ( String domicilioNuevo) {
		domicilio=domicilioNuevo;
	}
	
	public void setNombre ( String nombreNuevo) {
		nombre=nombreNuevo;
	}
	
	public void cumpleaños() {
		edad=edad + 1;
	}
	
	
}


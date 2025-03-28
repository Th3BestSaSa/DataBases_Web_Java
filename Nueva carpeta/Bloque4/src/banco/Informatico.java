package banco;

//Informatico.java
public class Informatico extends Empleado {
 private String especialidad;
 private static final String[] ESPECIALIDADES_VALIDAS = {"DESARROLLO", "SISTEMAS", "BD"};

 public Informatico(String nombre, double sueldo, String especialidad) {
     super(nombre, Math.min(sueldo, 2500));
     if (!esValidaEspecialidad(especialidad)) {
         throw new IllegalArgumentException("Especialidad no válida. Use DESARROLLO, SISTEMAS o BD");
     }
     this.especialidad = especialidad;
 }

 private boolean esValidaEspecialidad(String especialidad) {
	 boolean validacion=false;
     for (String esp : ESPECIALIDADES_VALIDAS) {
         if (esp.equals(especialidad)) {
        	 validacion=true;
         }
     }
     return validacion;
 }

 @Override
 public String mostrarInfo() {
	 String info= "Informático: " + getNombre() + ", Sueldo: " + getSueldo() + "€, Especialidad: " + especialidad;;
     return info ;
     
 }
}


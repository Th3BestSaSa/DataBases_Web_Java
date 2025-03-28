package banco;

//Operario.java
public class Operario extends Empleado {
 private int nave;

 public Operario(String nombre, double sueldo, int nave) {
	 super(nombre, Math.min(sueldo, 1200));
     if (nave < 1 || nave > 5) {
         throw new IllegalArgumentException("La nave debe estar entre 1 y 5");
     }
     this.nave = nave;
 }

 @Override
 public String mostrarInfo() {
	 String info="Operario: " + getNombre() + ", Sueldo: " + getSueldo() + "€, Nave: " + nave;;
     return info ;
 }
}

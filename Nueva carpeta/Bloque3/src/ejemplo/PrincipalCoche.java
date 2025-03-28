package ejemplo;

public class PrincipalCoche {

	public static void main(String[] args) {
		  Coche miCoche = new Coche("2453HIT", "Seat IBIZA", "Verde Oscuro");
		  miCoche.setcolor("Rosa");
		  System.out.println("La marca de mi coche es " + miCoche.getMarca());
		  System.out.println("La marca de mi coche es " + miCoche.getnuevoColor());
		  System.out.println(miCoche.toString());
	}
}
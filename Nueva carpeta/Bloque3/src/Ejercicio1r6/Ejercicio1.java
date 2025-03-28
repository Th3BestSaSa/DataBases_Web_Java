package Ejercicio1r6;
import java.util.Scanner;

public class Ejercicio1 {
	
    public static void main(String[] args) {
    	try (Scanner teclado = new Scanner(System.in)) {
			Ejercicio1Principal rectangulo = new Ejercicio1Principal();

			System.out.print("Ingrese la longitud del rectángulo: ");
			double longitud = teclado.nextDouble();
			rectangulo.setLongitud(longitud);

			System.out.print("Ingrese el ancho del rectángulo: ");
			double ancho = teclado.nextDouble();
			rectangulo.setAncho(ancho);

			System.out.println("\nResultados:");
			System.out.println("Área: " + rectangulo.calcularArea());
			System.out.println("Perímetro: " + rectangulo.calcularPerimetro());
		}

        
    }
}

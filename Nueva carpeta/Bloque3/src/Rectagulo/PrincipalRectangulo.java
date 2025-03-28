package Rectagulo;

import java.util.Scanner;

public class PrincipalRectangulo {

	static Scanner teclado = new Scanner (System.in);
	
	public static void main(String[] args) {
		try {
			Rectangulo rectangulo1;
			rectangulo1=new Rectangulo(1, 3);
			Rectangulo rectangulo2=new Rectangulo(5,6);
		//	int[] arrayEnteros=new int[10];
			double ancho, longitud;
			
			// Creamos un rectángulo con ancho y alto
			System.out.println("Introduzca el ancho: ");
			ancho = Integer.parseInt(teclado.nextLine());
			
			System.out.println("Introduzca la longitud: ");
			longitud = Integer.parseInt(teclado.nextLine());
			
			rectangulo1 = new Rectangulo(ancho, longitud);
			rectangulo2=new Rectangulo();
			
			rectangulo1.setAncho(11);
			
			rectangulo2.setAncho(12);

//		
//		System.out.println("El área es "+ rectangulo1.calcularArea());
//		System.out.println("El perímetro es "+ rectangulo1.calcularPerimetro());		
//		
//		// Ahora vamos a modificarlo para probar los sets		
//		System.out.println("Introduzca un nuevo ancho: ");
//		ancho = Integer.parseInt(teclado.nextLine());
//		rectangulo1.setAncho(ancho);
//		
//		System.out.println("Introduzca una nueva longitud: ");
//		longitud=Integer.parseInt(teclado.nextLine());
//		rectangulo1.setLongitud(longitud);
//		
//		System.out.println("El área es "+ rectangulo1.calcularArea());
//		System.out.println("El perímetro es "+ rectangulo1.calcularPerimetro());
		
		
		}catch(RectanguloException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		
		
	}
}

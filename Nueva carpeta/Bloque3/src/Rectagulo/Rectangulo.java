package Rectagulo;

/**
  Crear una clase Rectangulo con los atributos longitud y ancho, cada uno con un
  valor predeterminado igual a 1. Proporcionar los métodos set y get para los
  atributos longitud y ancho respectivamente. El método set debe verificar que
  longitud y ancho contengan números reales mayores que cero y menores que
  20. Además, proporcionar métodos que calculen el perímetro y el área del
  rectángulo.

  Escribir un método main que solicite los datos de un rectángulo y muestre cual es
  su área y su perímetro. Probar a introducir un dato incorrecto (mayor o igual que
  20).
*/

public class Rectangulo {

	//Constantes
	public static final int LONGITUD_MAXIMA = 20;
	public static final int ANCHO_MAXIMO = 20;
	public static final int LONGITUD_POR_DEFECTO = 1;
	public static final int ANCHO_POR_DEFECTO = 1;
	
	//Atributos
	private double ancho;
	private double longitud;

	// Constructores
	public Rectangulo() {
		ancho = ANCHO_POR_DEFECTO;
		longitud = LONGITUD_POR_DEFECTO;
	}
	
	public Rectangulo (double ancho, double longitud) throws RectanguloException {
		this.setAncho(ancho);
		setLongitud(longitud);
	}

	public void setAncho(double paramametroAncho) throws RectanguloException{
		if (paramametroAncho <= 0 || paramametroAncho >= ANCHO_MAXIMO) {
			throw new RectanguloException("Error, ancho incorrecto");
		}else
			ancho = paramametroAncho;
	}

	public void setLongitud(double parametroLongitud)throws RectanguloException {
		if (parametroLongitud <= 0 || parametroLongitud >= LONGITUD_MAXIMA)
			throw new RectanguloException("Error, longitud incorrecto");
			longitud = parametroLongitud;
	}

	public double getAncho() {
		return ancho;
	}

	public double getLongitud() {
		return longitud;
	}


	public String toString() {
		return "Rectangulo  con ancho " + ancho + "y  longitud" + longitud;
	}

	public double calcularArea() {
		double area;
		
		area = longitud * ancho;
		
		return area;
	}

	public double calcularPerimetro() {
		double perimetro;
		
		perimetro = longitud * 2 + ancho * 2;
		
		return perimetro;
		
	}
	
}

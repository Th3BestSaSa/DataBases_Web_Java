package Ejercicio1r6;



public class Ejercicio1Principal {

    // Atributos con valores predeterminados
    private double longitud;
    private double ancho;

    // Métodos set y get para longitud
    public void setLongitud(double longitudValor) {
        if (longitudValor > 0 && longitudValor < 20) {
            longitud = longitudValor;
        } else {
            System.out.println("Error: La longitud debe ser mayor que 0 y menor que 20.");
        }
    }

    public double getLongitud() {
        return longitud;
    }

    // Métodos set y get para ancho
    public void setAncho(double anchoValor) {
        if (anchoValor > 0 && anchoValor < 20) {
            ancho = anchoValor;
        } else {
            System.out.println("Error: El ancho debe ser mayor que 0 y menor que 20.");
        }
    }

    public double getAncho() {
        return ancho;
    }

    // Método para calcular el perímetro
    public double calcularPerimetro() {
        return 2 * (longitud + ancho);
    }

    // Método para calcular el área
    public double calcularArea() {
        return longitud * ancho;
    }
}

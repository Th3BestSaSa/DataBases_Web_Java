package Tamagochi;

import java.util.Objects;

public class Mascota {
    private String nombre;
    private String tipo;
    private int puntos;
    private int alimentos;

    // Constructor
    public Mascota(String nombre, String tipo) throws MascotaException {
        if (!tipo.equals("PERRO") && !tipo.equals("GATO")) {
            throw new MascotaException("El tipo debe ser 'PERRO' o 'GATO'.");
        }
        this.nombre = nombre;
        this.tipo = tipo.toUpperCase();
        this.puntos = 0;
        this.alimentos = 2;  
    }

    // Métodos para dar comida
    public void darComida() throws MascotaException {
        if (alimentos <= 0) {
            throw new MascotaException("No hay alimentos disponibles.");
        }
        alimentos--;
        System.out.println(nombre + " ha recibido comida. Tipo: " + (tipo.equals("PERRO") ? "Hueso" : "Pescado"));
    }

    // Métodos para comprar comida
    public void comprarComida(int cantidad) throws MascotaException {
        if (cantidad <= 0) {
            throw new MascotaException("La cantidad debe ser mayor que cero.");
        }
        alimentos += cantidad;
        System.out.println("Se han comprado " + cantidad + " alimentos para " + nombre + ".");
    }

    // Métodos para jugar
    public void jugar(int minutos) throws MascotaException {
        if (minutos < 1 || minutos > 20) {
            throw new MascotaException("El número de minutos debe estar entre 1 y 20.");
        }
        puntos += minutos * 3;
        System.out.println(nombre + " ha jugado durante " + minutos + " minutos y ha ganado " + minutos * 3 + " puntos.");
    }

    // Métodos para cambiar nombre
    public void cambiarNombre(String nuevoNombre) {
        nombre = nuevoNombre;
        System.out.println("El nombre de la mascota ha sido cambiado a " + nombre + ".");
    }

    // Método para mostrar la información de la mascota
    @Override
    public String toString() {
      String info;
    	info="Nombre: " + nombre + ", Tipo: " + tipo + ", Puntos: " + puntos + ", Alimentos: " + alimentos + " " + (tipo.equals("PERRO") ? "Huesos" : "Pescado");
    	return info;
    }

	@Override
	public int hashCode() {
		return Objects.hash(alimentos, nombre, puntos, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mascota other = (Mascota) obj;
		return alimentos == other.alimentos && Objects.equals(nombre, other.nombre) && puntos == other.puntos
				&& Objects.equals(tipo, other.tipo);
	}
    
    
    
}
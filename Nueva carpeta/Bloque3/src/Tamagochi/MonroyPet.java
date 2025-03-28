package Tamagochi;
import java.util.Scanner;

public class MonroyPet {
    private Mascota[] mascotas;
    private int minutosJugados;

    // Constructor
    public MonroyPet() throws MascotaException {
        mascotas = new Mascota[] { 
            new Mascota("Toby", "PERRO"), 
            new Mascota("Luna", "GATO") 
        };
        minutosJugados = 0;
    }
//    public void pantallaInicio() {
//    	 Scanner teclado = new Scanner(System.in);
//    	char variable;
//    	System.out.println("· Inicio (I)");
//    	System.out.println("· Salir(S)");
//    	do {
//    		variable=teclado.nextLine().charAt(0);
//    	}while(variable !='I' || variable!='S');
//    	if (variable='I') {
//    	
//    	}
    
    // Método para mostrar el menú
    public void mostrarMenu() {
    	
        Scanner teclado = new Scanner(System.in);
        System.out.print("----------MENU-----------");
        while (true) {
            System.out.println("\n1. Dar comida a la mascota");
            System.out.println("2. Comprar comida");
            System.out.println("3. Jugar");
            System.out.println("4. Información de mascotas");
            System.out.println("5. Salir");
         
            try {
                System.out.print("Seleccione una opción: ");
                int opcion = Integer.parseInt(teclado.nextLine());
                
                switch (opcion) {
                    case 1:
                        darComida(teclado);
                        break;
                    case 2:
                        comprarComida(teclado);
                        break;
                    case 3:
                        jugar(teclado);
                        break;
                    case 4:
                        mostrarInformacion();
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        
                        return;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Entrada no válida.");
            }
        }
    }

    // Método para dar comida
    private void darComida(Scanner scanner) {
        try {
            System.out.print("Seleccione la mascota (1 o 2): ");
            int mascotaNum = Integer.parseInt(scanner.nextLine()) - 1;
            if (mascotaNum < 0 || mascotaNum >= 2) {
                throw new MascotaException("Debe elegir entre 1 y 2.");
            }
            mascotas[mascotaNum].darComida();
        } catch (MascotaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Método para comprar comida
    private void comprarComida(Scanner scanner) {
        try {
            System.out.print("Seleccione la mascota (1 o 2): ");
            int mascotaNum = Integer.parseInt(scanner.nextLine()) - 1;
            if (mascotaNum < 0 || mascotaNum >= 2) {
                throw new MascotaException("Debe elegir entre 1 y 2.");
            }
            System.out.print("¿Cuántos alimentos desea comprar? ");
            int cantidad = Integer.parseInt(scanner.nextLine());
            if (cantidad <= 0) {
                throw new MascotaException("La cantidad debe ser mayor que cero.");
            }
            mascotas[mascotaNum].comprarComida(cantidad);
        } catch (MascotaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Método para jugar
    private void jugar(Scanner scanner) {
        try {
            System.out.print("Seleccione la mascota (1 o 2): ");
            int mascotaNum = Integer.parseInt(scanner.nextLine()) - 1;
            if (mascotaNum < 0 || mascotaNum >= 2) {
                throw new MascotaException("Debe elegir entre 1 y 2.");
            }
            System.out.print("¿Cuántos minutos va a jugar? ");
            int minutos = Integer.parseInt(scanner.nextLine());
            if (minutos < 1 || minutos > 20) {
                throw new MascotaException("El número de minutos debe estar entre 1 y 20.");
            }
            mascotas[mascotaNum].jugar(minutos);
            minutosJugados += minutos;

            if (minutosJugados > 100) {
                System.out.println("Las mascotas tienen sueño... Se van a dormir ZZZZ");
                System.exit(0);
            }
        } catch (MascotaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Método para mostrar la información de las mascotas
    private void mostrarInformacion() {
        for (Mascota mascota : mascotas) {
            System.out.println(mascota);
        }
    }

    // Método principal para iniciar el juego
    public static void main(String[] args) throws MascotaException {
        MonroyPet juego = new MonroyPet();
        juego.mostrarMenu();
    }
}

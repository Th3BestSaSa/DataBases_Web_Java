package Ejercicio3r6;

import java.util.Scanner;

public class PrincipalMaquina {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws MaquinaCafeException {
        System.out.print("Introduce la cantidad inicial del monedero: ");
        double monederoInicial = solicitarDinero("");
        MaquinaCafe maquina = new MaquinaCafe(monederoInicial);

        int opcion;
        do {
            opcion = mostrarMenuCafes();
            tratarMenuCafes(maquina, opcion);
        } while (opcion != 5);

        System.out.println("Máquina apagada.");
    }

    private static void tratarMenuCafes(MaquinaCafe maquina, int opcion) {
        try {
            double dinero, cambio;
            switch (opcion) {
                case 1:
                    dinero = solicitarDinero("Introduce el dinero para el café solo: ");
                    cambio = maquina.servirCafe(dinero);
                    mostrarCambio(cambio);
                    break;
                case 2:
                    dinero = solicitarDinero("Introduce el dinero para la leche: ");
                    cambio = maquina.servirLeche(dinero);
                    mostrarCambio(cambio);
                    break;
                case 3:
                    dinero = solicitarDinero("Introduce el dinero para el café con leche: ");
                    cambio = maquina.servirCafeconLeche(dinero);
                    mostrarCambio(cambio);
                    break;
                case 4:
                    System.out.println(maquina);
                    break;
            }
        } catch (MaquinaCafeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarCambio(double cambio) {
        if (cambio > 0) {
            System.out.printf("Recoge tu cambio: %.2f€\n", cambio);
        }
    }

    private static int mostrarMenuCafes() {
        System.out.println("\n1. Servir café solo (1€)\n2. Servir leche (0,8€)\n3. Servir café con leche (1,5€)\n"
                + "4. Consultar el estado de la máquina\n5. Apagar máquina y salir");
        return Integer.parseInt(teclado.nextLine());
    }

    private static double solicitarDinero(String mensaje) {
        System.out.println(mensaje);
        return Double.parseDouble(teclado.nextLine());
    }
}

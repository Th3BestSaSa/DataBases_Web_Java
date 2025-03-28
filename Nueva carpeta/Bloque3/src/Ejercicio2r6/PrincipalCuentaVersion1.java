package Ejercicio2r6;


import java.util.Scanner;

public class PrincipalCuentaVersion1 {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int opcion;
		double saldoInicial;
		Cuenta cuenta = null;
		char salir;

		//En esta versión si se introduce un saldo negativo, no se puede crear la cuenta
		// y acaba el programa
		
		try {
			saldoInicial = PrincipalCuentaVersion1.pedirSaldoInicial();
			cuenta = new Cuenta(saldoInicial);
			do {
				// Muestra el menú y solicita la opción
				opcion = PrincipalCuentaVersion1.menu();

				// Trata cada una de las opciones del menú
				salir = PrincipalCuentaVersion1.tratarMenu(opcion, cuenta);
			} while (salir == 'n');
		} catch (CuentaException e) {
			System.out.println(e.getMessage());
		}

		

	}

	private static double pedirSaldoInicial() {
		double saldoInicial;

		saldoInicial = solicitarDouble("Introduzca el saldo inicial: ");

		return saldoInicial;
	}

	private static double solicitarDouble(String msg) {
		double numero = 0;
		boolean hayError;

		do {
			try {
				System.out.println(msg);
				numero = Double.parseDouble(teclado.nextLine());
				hayError = false;
			} catch (NumberFormatException ex) {
				System.out.println("Error. No es un número.");
				hayError = true;
			}
		} while (hayError );

		return numero;
	}

	private static int menu() {
		int opcion = 0;

		do {
			try {
				System.out.println("Elige una opción: ");
				System.out.println("1. Hacer un ingreso.");
				System.out.println("2. Hacer un reintegro.");
				System.out.println("3. Consultar el saldo y el número de reintegros e ingresos realizados.");
				System.out.println("4. Finalizar las operaciones.");
				opcion = Integer.parseInt(teclado.nextLine());

				if (opcion < 1 || opcion > 5)
					System.out.println("Error. Opción incorrecta.");

			} catch (NumberFormatException e) {
				System.out.println("Error. Opción incorrecta.");
			}
		} while (opcion < 1 || opcion > 5);

		return opcion;
	}

	private static char tratarMenu(int opcion, Cuenta cuenta) {
		double cantidad;
		char salir = 'n';
		
		try {
			switch (opcion) {
			case 1: {

				cantidad = solicitarDouble("Introduce la cantidad a ingresar: ");

				cuenta.realizarIngreso(cantidad);

				break;
			}
			case 2: {

				cantidad = solicitarDouble("Introduce la cantidad a retirar: ");
				cuenta.realizarReintegro(cantidad);
				break;
			}
			case 3: {
				System.out.println(cuenta);
				break;
			}
			case 4: {
				do {
					System.out.println("¿Estás seguro (s/n)? ");
					salir = teclado.nextLine().charAt(0);
					// Esto convierte el carácter salir a minúsculas
					salir = Character.toLowerCase(salir);
				} while (salir != 's' && salir != 'n');

				if (salir == 's') {
					System.out.println("Dispones de " + cuenta.getSaldo() + "€ de saldo.");
				}

				break;
			}
			}
		}catch ( CuentaException e) {
			System.out.println(e.getMessage());
		}
		

		return salir;
	}
}

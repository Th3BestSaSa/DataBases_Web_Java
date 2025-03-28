//package Ejercicio2r6;
//import java.util.Scanner;
//
//public class PrincipalCuenta {
//
//	private static Scanner teclado = new Scanner(System.in);
//
//	public static void main(String[] args) {
//		
//		int opcion;
//		double saldoInicial;
//		Cuenta cuenta;
//		char salir;
//
//		saldoInicial = pedirSaldoInicial();
//		cuenta = new Cuenta(saldoInicial);
//
//		do {
//			opcion = menu(); //  Muestra el menú y solicita la opción
//			salir = tratarMenu(opcion, cuenta); // Trata cada una de las opciones del menú
//		} while (salir == 'n');
//	}
//
//	private static double pedirSaldoInicial() {
//		double saldoInicial;
//		
//		do
//		{
//			System.out.println("Introduce el saldo inicial: ");
//			saldoInicial = Double.parseDouble(teclado.nextLine());
//		} while (saldoInicial < 0);
//
//		return saldoInicial;
//	}
//
//	private static int menu() {
//		int opcion;
//
//		do {
//			System.out.println("Elige una opción:");
//			System.out.println("1. Hacer un ingreso.");
//			System.out.println("2. Hacer un reintegro.");
//			System.out.println("3. Consultar el saldo y el número de reintegros e ingresos realizados.");
//			System.out.println("4. Finalizar las operaciones.");
//			opcion = Integer.parseInt(teclado.nextLine());
//
//			if (opcion < 1 || opcion > 4)
//				System.out.println("Error. Opción incorrecta.");
//		} while (opcion < 1 || opcion > 4);
//
//		return opcion;
//	}
//
//	private static  char tratarMenu(int opcion, Cuenta cuenta) throws CuentaException {
//		double cantidad;
//		char salir = 'n';
//		try {
//			
//		}
//		switch (opcion) {
//		case 1: {
//			System.out.println("Introduce la cantidad a ingresar: ");
//			cantidad = Double.parseDouble(teclado.nextLine());
//			cuenta.realizarIngreso(cantidad);
//			break;
//		}
//		case 2: {
//			System.out.println("Introduce la cantidad a retirar: ");
//			cantidad = Double.parseDouble(teclado.nextLine());
//			cuenta.realizarReintegro(cantidad);
//			break;
//		}
//		case 3: {
//			System.out.println(cuenta);
//			break;
//		}
//		case 4: {
//			do {
//				System.out.println("¿Estás seguro (s/n)? ");
//				salir = teclado.nextLine().charAt(0);
//				// Esto convierte el carácter salir a minúsculas
//				salir = Character.toLowerCase(salir);
//			} while (salir != 's' && salir != 'n');
//
//			if (salir == 's') {
//				System.out.println("Dispones de " + cuenta.getSaldo()
//						+ "€ de saldo.");
//			}
//
//			break;
//		}
//		}
//		return salir;
//	}
//}
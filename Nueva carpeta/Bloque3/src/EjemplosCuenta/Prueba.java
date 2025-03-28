package EjemplosCuenta;


public class Prueba {

	public static void main(String[] args) {
		try {
			Cliente cliente=new Cliente("111", "Juan Gonzalez", "Calle Silos",21);
			Cuenta c1 = new Cuenta(100, new Cliente( "111", "Pepe Perez", "Calle Sol",22));
			
			System.out.println("Cuenta 1 creada");
			Cuenta c2 = new Cuenta(200, cliente);
			
			System.out.println("Cuenta 2 creada");
			Cuenta c3 = new Cuenta(300, cliente);
			System.out.println("Cuent 3 creada");
			
			
			System.out.println("El cliente de la cuenta 1 tiene estos datos: " + c1.getTitular());
			System.out.println("El nombre del cliente de la cuenta 2 es  " + c2.getTitular().getNombreCompleto());
			System.out.println("La edad del ciente de la cuenta 3 es " + c3.getTitular().getEdad());

		} catch (CuentaException e) {
			System.out.println(e.getMessage());
		} catch ( ClienteException e) {
			System.out.println("Error al crear el cliente:" + e.getMessage());
		}

	}

}

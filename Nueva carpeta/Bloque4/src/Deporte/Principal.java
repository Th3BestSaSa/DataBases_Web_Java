package Deporte;

public class Principal {

	private static final int TAMANNO_EDIFICIOS = 5;

	public static void main(String[] args) {

		// Variables
		Edificio[] arrayEdificios = new Edificio[TAMANNO_EDIFICIOS];

		arrayEdificios[0] = new Oficina(50, 40);
		arrayEdificios[1] = new Oficina(55, 45);
		arrayEdificios[2] = new Oficina(60, 50);
		arrayEdificios[3] = new Polideportivo(1, 800, "Pepe");
		arrayEdificios[4] = new Polideportivo(2, 700, "Pablo");

		for (int i = 0; i < arrayEdificios.length; i++) {
			if ( arrayEdificios[i] instanceof Polideportivo ) {
				
				System.out.println("Nombre "  +
				((Polideportivo) arrayEdificios[i]).getNombre());
				
				
			}
			System.out.println(arrayEdificios[i]);

		}

	}

}

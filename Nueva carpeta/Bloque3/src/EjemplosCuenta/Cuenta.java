package EjemplosCuenta;

/**
 Realizar un programa que permita gestionar el saldo de una cuenta corriente. Una
 vez introducido el saldo inicial, se mostrará un menú que permitirá efectuar las
 siguientes operaciones:
	1. Hacer un reintegro, se pedirá la cantidad a retirar.
	2. Hacer un ingreso, se pedirá la cantidad a ingresar.
	3. Consultar el saldo y el número de reintegros e ingresos realizados.
	4. Finalizar las operaciones. Debe confirmar si realmente desea salir e
       informar del saldo al final de todas las operaciones.

 Debe realizarse una clase Cuenta y la clase Principal.
*/
public class Cuenta {

	private double saldo;
	private int contadorIngresos;
	private int contadorReintegros;
	private Cliente  titular;
	
	
	private static double totalIngresadoBanco=0;  //Atributo estático de la clase Cuenta

	// Contructores
	
	public static double getTotalIngresadoBanco() {
		
		
		return totalIngresadoBanco;
	}

	
	public Cuenta(Cliente cliente) throws CuentaException  {
		saldo = 0;
		contadorIngresos = 0;
		contadorReintegros = 0;
		if ( cliente.getEdad() < 18) {
			throw new CuentaException("No se puede crear la cuenta porque el cliente es menor de edad");
		}
		this.titular=cliente;
		
	}

	public Cuenta(double saldo, Cliente cliente) throws CuentaException {
		if (saldo < 0) {
			// Aquí lo suyo sería lanzar una excepción
			throw new CuentaException("No se puede crear una cuenta con saldo negativo.");
		} 
		
		if ( cliente.getEdad() < 18) {
			throw new CuentaException("No se puede crear la cuenta porque el cliente es menor de edad");
		}
		
		this.saldo = saldo;
		contadorIngresos = 0;
		contadorReintegros = 0;
		this.titular= cliente;
		
	}

	// Métodos gets
	
	public Cliente getTitular() {
		return titular;
	}
	
	public double getSaldo() {
		return this.saldo;
	}

	public int getContadorIngresos() {
		return this.contadorIngresos;
	}

	public int getContadorReintegros() {
		return this.contadorReintegros;
	}

	/**
	 * Método que realiza un reintegro en la cuenta.
	 * @param reintegro
	 * @throws CuentaException 
	 */
	
	
	public void realizarReintegro(double reintegro) throws CuentaException {
		if (reintegro <= 0)
			
			throw new CuentaException("El reintegro solo puede realizarse con cantidades positivas.");
		
		if (reintegro > this.saldo) {
		
			throw new CuentaException("No tienes suficiente saldo.");
		} 
			
		
		this.saldo = this.saldo - reintegro;
		this.contadorReintegros++;
			
	}

	/**
	 * Método que realiza un ingreso en la cuenta
	 * @param ingreso
	 * @throws CuentaException 
	 */
	public void realizarIngreso(double ingreso) throws CuentaException {
		if (ingreso <= 0)
			// Debería tratarse en una excepción
			throw new CuentaException("El ingreso solo puede realizarse con cantidades positivas."); 
		
		this.saldo = this.saldo + ingreso;
		this.contadorIngresos++;
		
		totalIngresadoBanco= totalIngresadoBanco + ingreso;
		
	}
	
	
	public void transferencia( double dineroTransferir, Cuenta cuentaDestino ) throws CuentaException {
		
		if ( this.saldo < dineroTransferir ) {
			throw new CuentaException( "No se puede realizar la transferencia. No tiene saldo");
		}
		
		this.saldo= this.saldo - dineroTransferir;
		cuentaDestino.saldo= cuentaDestino.saldo + dineroTransferir;
		
		
		
	}
	
	
	
	
	
	
	
	
	/**
	 * Método que muestra el saldo y el número de ingresos y reintegros.
	 */
	public String toString() {
		return "Cuenta con saldo " + saldo + " .Se han realizado " 
				+ contadorIngresos + " ingresos y " + contadorReintegros + " reintegros.";
	}
}
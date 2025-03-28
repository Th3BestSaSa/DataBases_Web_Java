package Relacion9;



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
	private String titular;
	private int contadorIngresos;
	private int contadorReintegros;

	// Contructores
	
	
	
	public Cuenta(String titular) {
		saldo = 0;
		contadorIngresos = 0;
		contadorReintegros = 0;
		this.titular=titular;
	}

	public Cuenta(double saldo, String titular) throws CuentaException {
		if (saldo < 0) {			
			throw new CuentaException("No se puede crear una cuenta con saldo negativo.");
		} 
		this.saldo = saldo;
		contadorIngresos = 0;
		contadorReintegros = 0;
		this.titular=titular;
		
	}
	
	

	// Métodos gets
	
	public String getTitular() {
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
		if (reintegro <= 0){
			throw new CuentaException("El reintegro solo puede realizarse con cantidades positivas.");
		}
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
		if (ingreso <= 0){ 
			throw new CuentaException("El ingreso solo puede realizarse con cantidades positivas."); 
		}
		this.saldo = this.saldo + ingreso;
		this.contadorIngresos++;
	}
	
	
	@Override
	public String toString() {
		return "Saldo " + saldo +  " Titular :" + titular;
	}
}
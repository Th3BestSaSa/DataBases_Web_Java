package modeloExamen;

public class Guerrero extends Jugador implements DestrezaDiaponible {
	public static final int RESISTENCIA_MAXIMA = 20;
	public static final int PUNTOS_COMBATE = 2;
	public static final int DANO_ARCO = 2;
	public static final int DANO_MANDOBLE = 5;
	public static final int DANO_ESPADA_CORTA =2;
	public static final int DANO_ESPADA_LARGA = 3;
	private static final int DESTREZA_MAXIMA = 10;
	private static final int DESTREZA_MINIMA = 1;
	private int destreza;
	private TipoArma arma;

	public Guerrero(String nombre, int resistencia, int destreza, TipoArma arma) throws JuegoException {
		super(nombre, resistencia);
		this.destreza = destreza;
		this.arma = arma;
	}


	@Override
	public int getDestreza() {
		return this.destreza;
	}
	
	/**
	 * @param destreza the destreza to set
	 */
	public void setDestreza(int destreza)  throws JuegoException {
		
		    if (destreza < DESTREZA_MINIMA || destreza > DESTREZA_MAXIMA) {
		        throw new JuegoException("Destreza fuera de los límites");
		    }
		    if (this.destreza > destreza) { // Fixed logical condition
		        throw new JuegoException("No puedes tener una destreza inferior a la anterior");
		    }
		    this.destreza = destreza;
		}
	/**
	 * @return the arma
	 */
	public TipoArma getArma() {
		if (arma==null) {
			//excepcion
		}
		return arma;
	}
	/**
	 * @param arma the arma to set
	 */
	public void setArma(TipoArma arma) {
		if (arma==null) {
			//excepcion
		}
		this.arma = arma;
	}
	

	@Override
	public String toString() {
		return "Guerrero [destreza=" + destreza + ", arma=" + arma + "]";
	}


}
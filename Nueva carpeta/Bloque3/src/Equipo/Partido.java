package Equipo;



public class Partido {
	private static final int JORNADA_INICIAL = 1  ;
	private static final int JORNADA_FINAL = 38;
	private static final int LIMITE_GOLES = 30;
	/**
	 * @return the golLocal
	 */
	

	private static final int MINIMO_GOLES = 30;
	private boolean  partidosJugado;
	private int  jornada;
	private char ResultadoQuiniela;
	private int partidosGanados;
	private String equipoLocal;
	private String equipoVisitante;
	private int golLocal;
	private String resultado;
	private int golVisitante;
	public Partido(boolean partidosJugado, int jornada, char resultadoQuiniela, int partidosGanados) throws PartidoException{
		if (jornada<JORNADA_INICIAL && jornada>JORNADA_FINAL) {
			throw new PartidoException("Error, la jornada es menor o mayor al limite");
		}
		if (equipoLocal.equals(equipoVisitante)) {
			throw new PartidoException("Error");
		}
		this.partidosJugado = partidosJugado;
		this.jornada = jornada;
		ResultadoQuiniela = resultadoQuiniela;
		this.partidosGanados = partidosGanados;
	}
	/**
	 * @return the jornada
	 */
	public int getGolLocal()throws PartidoException {
		throw new PartidoException("Todavia no se ha jugado");
	}
		
	
	public int getJornada() {
		return jornada;
	}
	/**
	 * @return the resultadoQuiniela
	 */
	public char getResultadoQuiniela() {
		return ResultadoQuiniela;
	}
	/**
	 * @return the partidosGanados
	 */
	public int getPartidosGanados() {
		return partidosGanados;
	}
	public boolean isPartidoJugado() {
	    return isPartidoJugado();
	}

	// TO STRING
	@Override
	public String toString() {
	    return "Partido [jornada=" + jornada + ", equipoLocal=" + equipoLocal +
	            ", equipoVisitante=" + equipoVisitante +
	            ", golLocal=" + golLocal + ", golVisitante=" + golVisitante +
	            ", resultado=" + resultado +
	            ", partidoJugado=" + partidosJugado + "]";
	}

	// PONER RESULTADO
	public void ponerResultado(String paramResultado) throws PartidoException {
	    String[] goles = paramResultado.split("-");
	    int golAux1 = Integer.parseInt(goles[0]);
	    int golAux2 = Integer.parseInt(goles[1]);
	    if (golAux1 > LIMITE_GOLES || golAux1 < MINIMO_GOLES || golAux2 > LIMITE_GOLES || golAux2 < MINIMO_GOLES) {
	        throw new PartidoException("Se ha pasado el límite de goles.");
	    }
	    this.golLocal = golAux1;
	    this.golVisitante = golAux2;
	}


}

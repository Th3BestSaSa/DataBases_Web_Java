package Jugadorej;

public class Jugadores {


		//Atributos 
		private String nick;
		private String contraseña ;
		private int numeroPartidasGanadas;
	
		
		//Métodos
		
		//Método constructor
		public Jugadores (String paramNick, String paramContrseña) {
			nick= paramNick;
			contraseña =paramContrseña;
			numeroPartidasGanadas=0;
			
		}
		//Otros métodos
		public String  getNick( ) {
			return nick;
			
		}
		public String  getContraseña( ) {
			return contraseña;
			
		}
		public void setContraseña(String nuevaContraseña) {
			contraseña=nuevaContraseña;
			
		}
		public String getnuevaContraseña() {
			// TODO Auto-generated method stub
			return contraseña;
		}
		public int  getnumeroPartidasGanadas( ) {
			return numeroPartidasGanadas;
			
		}
		public void  incrementrarPartidasGanadas( ) {
			numeroPartidasGanadas= numeroPartidasGanadas+1;
			
		}
		public String toString () {
			String info;
			info = "Jugador con nick " + nick + " con " + numeroPartidasGanadas + " partidas ganadas" ;
			return info;
		}

	}


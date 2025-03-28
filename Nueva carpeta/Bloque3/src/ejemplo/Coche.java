package ejemplo;

public class Coche {

		//Atributos 
		private String matricula;
		private String marca ;
		private String color;
		private int km;
		
		//Métodos
		
		//Método constructor
		public Coche (String paramMatricula, String paramMarca, String paramColor) {
			matricula= paramMatricula;
			marca =paramMarca;
			color =paramColor;
			km=0;
			
		}
		//Otros métodos
		public String  getMatricula( ) {
			return matricula;
			
		}
		public String  getMarca( ) {
			return marca;
			
		}
		public void setcolor(String nuevoColor) {
			color=nuevoColor;
			
		}
		public String getnuevoColor() {
			// TODO Auto-generated method stub
			return color;
		}
		public int  getKm( ) {
			return km;
			
		}
		public void  incrementrarKm( ) {
			km= km+1;
			
		}
		public String toString () {
			String info;
			info = "Coche con matricula " + matricula + " modelo " + marca + " color " + color + ". Tiene "+ km + " kms.";
			return info;
		}
}

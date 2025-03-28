package JuegoRol;


import java.util.Arrays;

public class Mago extends Personaje {
    private String[] hechizos = new String[4];
    private static final int FUERZA_MIN=15,INTELIGENCIA_MAX=17;
    
    public Mago(String nombre,TRaza raza, int fuerza, int inteligencia, int vidaMaxima) throws PersonajeException {
        super(nombre, raza, fuerza, inteligencia, vidaMaxima);
 
    }
    public void setfuerza(int fuerza) throws PersonajeException {
    	if( fuerza > FUERZA_MIN) {
    		throw new PersonajeException("Valores inválidos para Mago.");
    	}else {
    		super.setFuerza(fuerza);
    	}
    }
    public void setInteligencia(int inteligencia) throws PersonajeException {
    	if(  inteligencia > INTELIGENCIA_MAX) {
    		throw new PersonajeException("Valores inválidos para Mago.");
    	}else {
    		super.setInteligencia(inteligencia);
    	}
    }
    public void aprendeHechizo(String hechizo) throws PersonajeException {
        
    	boolean aprender=false;
    	for (int i = 0; i < hechizos.length && !aprender; i++) {
            if (hechizos[i]==null) {
                hechizos[i] = hechizo;
                aprender=true;
            }
        }
    	if (aprender ==false) {
    		 throw new PersonajeException("El mago no lo aprende.");
    	}
       
    }

    public void lanzaHechizo(Personaje mago, String hechizo) throws PersonajeException {
        boolean hechizoLanzado= false;
    	for (int i = 0; i < hechizos.length && hechizoLanzado==false; i++ ) {
            if (hechizo.equals(hechizos[i]) ) { 
                mago.setVidaActual(mago.getVidaActual() - 10);
                hechizos[i]=null;
                hechizoLanzado= true;
            }
        }
    	if (hechizoLanzado ==false) {
        	throw new PersonajeException("El mago no lanza ese hechizo.");
        }
        
    }

	@Override
	public String toString() {
		return super.toString()+"Mago [hechizos=" + Arrays.toString(hechizos) + "]";
	}
    
}
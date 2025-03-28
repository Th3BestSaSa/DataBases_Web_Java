package JuegoRol;


public class Clerigo extends Personaje {
    private String dios;

    public Clerigo(String nombre, TRaza raza, int fuerza, int inteligencia, int vidaMaxima, String dios) throws PersonajeException {
        super(nombre, raza, fuerza, inteligencia, vidaMaxima);
        if (fuerza < 18 || inteligencia < 12 || inteligencia > 16) {
            throw new PersonajeException("Valores inválidos para Clérigo.");
        }
        this.dios = dios;
    }

    public void curar(Personaje cura) throws PersonajeException {
        cura.setVidaActual(cura.getVidaActual() + 10);
        System.out.println(getNombre() + " cura a " + cura.getNombre());
    }

    @Override
    public String toString() {
        return super.toString() + " - Dios: " + dios;
    }
}
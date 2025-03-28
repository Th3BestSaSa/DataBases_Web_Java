package Ejercicio3r6;

public class MaquinaCafe {
    private static final int MAXIMO_CAFE = 50;
    private static final int MAXIMO_LECHE = 50;
    private static final int MAXIMO_VASOS = 5;
    public static final double PRECIO_CAFE = 1;
    public static final double PRECIO_LECHE = 0.8;
    public static final double PRECIO_CAFE_CON_LECHE = 1.5;

    private int depositoCafe;
    private int depositoLeche;
    private int depositoVasos;
    private double monedero;

    // Constructor
    public MaquinaCafe(double monederoInicial) throws MaquinaCafeException {
        llenarDepositos();
        setMonedero(monederoInicial);
    }

    private void setMonedero(double monedero) throws MaquinaCafeException {
        if (monedero <= 0) {
            throw new MaquinaCafeException("El monedero inicial debe ser mayor a 0.");
        }
        this.monedero = monedero;
    }

    public void llenarDepositos() {
        depositoCafe = MAXIMO_CAFE;
        depositoLeche = MAXIMO_LECHE;
        depositoVasos = MAXIMO_VASOS;
    }

    // Métodos get
    public int getDepositoCafe() {
        return depositoCafe;
    }

    public int getDepositoLeche() {
        return depositoLeche;
    }

    public int getDepositoVasos() {
        return depositoVasos;
    }

    public double getMonedero() {
        return monedero;
    }

    public double servirCafe(double dinero) throws MaquinaCafeException {
        if (dinero < PRECIO_CAFE) {
            throw new MaquinaCafeException("Dinero insuficiente para el café.");
        }
        if (depositoCafe == 0 || depositoVasos == 0) {
            throw new MaquinaCafeException("No hay suficientes recursos para servir café.");
        }
        double cambio = dinero - PRECIO_CAFE;
        if (cambio > monedero) {
            throw new MaquinaCafeException("No hay suficiente cambio disponible.");
        }

        // Actualizar depósitos y monedero
        depositoCafe--;
        depositoVasos--;
        monedero += PRECIO_CAFE;
        return cambio;
    }

    public double servirLeche(double dinero) throws MaquinaCafeException {
        if (dinero < PRECIO_LECHE) {
            throw new MaquinaCafeException("Dinero insuficiente para la leche.");
        }
        if (depositoLeche == 0 || depositoVasos == 0) {
            throw new MaquinaCafeException("No hay suficientes recursos para servir leche.");
        }
        double cambio = dinero - PRECIO_LECHE;
        if (cambio > monedero) {
            throw new MaquinaCafeException("No hay suficiente cambio disponible.");
        }

        // Actualizar depósitos y monedero
        depositoLeche--;
        depositoVasos--;
        monedero += PRECIO_LECHE;
        return cambio;
    }

    public double servirCafeconLeche(double dinero) throws MaquinaCafeException {
        if (dinero < PRECIO_CAFE_CON_LECHE) {
            throw new MaquinaCafeException("Dinero insuficiente para el café con leche.");
        }
        if (depositoCafe == 0 || depositoLeche == 0 || depositoVasos == 0) {
            throw new MaquinaCafeException("No hay suficientes recursos para servir café con leche.");
        }
        double cambio = dinero - PRECIO_CAFE_CON_LECHE;
        if (cambio > monedero) {
            throw new MaquinaCafeException("No hay suficiente cambio disponible.");
        }

        // Actualizar depósitos y monedero
        depositoCafe--;
        depositoLeche--;
        depositoVasos--;
        monedero += PRECIO_CAFE_CON_LECHE;
        return cambio;
    }

    public double vaciarMonedero() {
        double monederoAVaciar = this.monedero;
        this.monedero = 0;
        return monederoAVaciar;
    }

    public void incrementarMonedero(double cantidad) throws MaquinaCafeException {
        if (cantidad <= 0) {
            throw new MaquinaCafeException("La cantidad a añadir debe ser mayor a 0.");
        }
        monedero += cantidad;
    }

   
    public String toString() {
        return "Máquina:\n Depósito de café: " + depositoCafe + "\n Depósito de leche: " + depositoLeche
                + "\n Depósito de vasos: " + depositoVasos + "\n Monedero: " + monedero + "€";
    }
}

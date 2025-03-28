package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class Personaje {
    protected String nombre;
    protected int vida;
    protected int ataque;

    public Personaje(String nombre, int vida, int ataque) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
    }

    public boolean estaVivo() {
       return vida > 0;
    }

    public void recibirDanio(int danio) {
        vida -= danio;
        if (vida < 0) vida = 0;
    }

    public void curarse(int cantidad) {
        vida += cantidad;
        if (vida > 120) vida = 120;
    }
}

class Mago extends Personaje {
    public Mago(String nombre) {
        super(nombre, 100, 20);
    }
    public int lanzarHechizo() {
        return new Random().nextInt(10) + ataque;
    }
}

class Clerigo extends Personaje {
    public Clerigo(String nombre) {
        super(nombre, 120, 15);
    }

    public int curarse() {
        return new Random().nextInt(15) + 10;
    }
}

public class MiniJuegoRol extends JFrame {
    private Mago mago;
    private Clerigo clerigo;
    private JLabel lblMagoVida, lblClerigoVida;
    private JProgressBar barMago, barClerigo;
    private JButton btnAtacar, btnCurar;
    private JTextArea txtHistoria;
    
    public MiniJuegoRol() {
        setTitle("Juego de Rol - Mago vs Clérigo");
       setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());     
        

        // Crear personajes
       mago = new Mago("Merlín");
        clerigo = new Clerigo("Gandalf");

        // Panel de información
        JPanel panelInfo = new JPanel(new GridLayout(2, 2));
        lblMagoVida = new JLabel("Mago - Vida: " + mago.vida);
        lblClerigoVida = new JLabel("Clérigo - Vida: " + clerigo.vida);
        barMago = new JProgressBar(0, 100);
        barMago.setValue(mago.vida);
       barClerigo = new JProgressBar(0, 120);
        barClerigo.setValue(clerigo.vida);
        
        panelInfo.add(lblMagoVida);
        panelInfo.add(lblClerigoVida);
        panelInfo.add(barMago);
        panelInfo.add(barClerigo);
        
        add(panelInfo, BorderLayout.NORTH);

        // Área de historia del combate
        txtHistoria = new JTextArea();
       txtHistoria.setEditable(false);
        add(new JScrollPane(txtHistoria), BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel();
       btnAtacar = new JButton("Atacar");
        btnCurar = new JButton("Curarse");

       panelBotones.add(btnAtacar);
        panelBotones.add(btnCurar);
        add(panelBotones, BorderLayout.SOUTH);

       // Eventos de botones
       btnAtacar.addActionListener(e -> turnoClerigo(true));
        btnCurar.addActionListener(e -> turnoClerigo(false));

        // Iniciar combate
        turnoMago();
    }

    private void turnoMago() {
        if (!mago.estaVivo() || !clerigo.estaVivo()) return;
        
       int danio = mago.lanzarHechizo();
        clerigo.recibirDanio(danio);
       actualizarEstado("🧙‍♂️ Mago lanza hechizo y causa " + danio + " de daño.");
        
        if (!clerigo.estaVivo()) {
            finalizarJuego("🏆 ¡El Mago ha ganado!");
        }
    }

    private void turnoClerigo(boolean atacar) {
       if (!mago.estaVivo() || !clerigo.estaVivo()) return;

        if (atacar) {
            mago.recibirDanio(clerigo.ataque);
            actualizarEstado("⛪ Clérigo ataca y causa " + clerigo.ataque + " de daño.");
        } else {
           int curacion = clerigo.curarse();
            clerigo.curarse(curacion);
            actualizarEstado("⛪ Clérigo se cura " + curacion + " puntos de vida.");
        }

        if (!mago.estaVivo()) {
            finalizarJuego("🏆 ¡El Clérigo ha ganado!");
        } else {
            turnoMago();
        }
    }

    private void actualizarEstado(String mensaje) {
        lblMagoVida.setText("Mago - Vida: " + mago.vida);
        lblClerigoVida.setText("Clérigo - Vida: " + clerigo.vida);
        barMago.setValue(mago.vida);
        barClerigo.setValue(clerigo.vida);
        txtHistoria.append(mensaje + "\n");
    }
    private void finalizarJuego(String mensaje) {
        txtHistoria.append("\n" + mensaje + "\n");
        btnAtacar.setEnabled(false);
        btnCurar.setEnabled(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MiniJuegoRol().setVisible(true));
        
   }

}




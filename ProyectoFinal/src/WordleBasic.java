import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordleBasic extends JFrame {

    private final String[] palabrasRelacionadasJava = {
            "JAVA", "CLASE", "METODO", "OBJETO", "BUCLE", "ARRAY", "STRING", "ENTERO",
            "PUBLIC", "STATIC", "FINAL", "PRIVADO", "INTERFAZ", "PAQUETE", "IMPORTAR",
            "EXTENDER", "IMPLEMENTS", "RETORNAR", "CONSTRUCTOR", "ATRIBUTO", "SUPER",
            "ESTATICO", "INSTANCIA", "VARIABLE", "BOOLEANO", "CASTEO", "NULO",
            "EXCEPCION", "HERENCIA", "POLIMORFISMO", "GARBAGE"
    };

    private String palabraObjetivo;
    private int intentosRealizados = 0;
    private final int maximosIntentos = 6;
    private final JPanel panelIntentos;
    private JTextField campoTextoIntento;
    private final List<JPanel> intentosPaneles;

    public WordleBasic() {
        // Configuración inicial de la ventana
        setTitle("Wordle en Java Swing");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Fondo gris claro
        getContentPane().setBackground(new Color(200, 200, 200));

        // Inicialización de la lista de paneles
        intentosPaneles = new ArrayList<>();

        // Panel para intentos
        panelIntentos = new JPanel();
        panelIntentos.setLayout(new GridLayout(maximosIntentos, 1, 5, 5));
        panelIntentos.setBackground(new Color(200, 200, 200));
        add(panelIntentos, BorderLayout.CENTER);

        // Iniciar juego
        reiniciarJuego();

        // crear cuadros en blanco 
        inicializarPanelIntentos();

        // Panel inferior para entrada y botones
        JPanel panelEntrada = new JPanel();
        panelEntrada.setLayout(new BorderLayout());
        panelEntrada.setBackground(new Color(200, 200, 200));

        campoTextoIntento = new JTextField();
        JButton botonEnviarIntento = new JButton("Enviar intento");
        JButton botonNuevaPalabra = new JButton("Nueva palabra");
        JButton botonSalir = new JButton("Salir del juego");
        panelEntrada.add(campoTextoIntento, BorderLayout.CENTER);
        panelEntrada.add(botonEnviarIntento, BorderLayout.EAST);

        JPanel panelBotones = new JPanel();
        panelBotones.add(botonNuevaPalabra);
        panelBotones.add(botonSalir);
        panelEntrada.add(panelBotones, BorderLayout.SOUTH);

        add(panelEntrada, BorderLayout.SOUTH);

        // botón Enviar intento
        botonEnviarIntento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (intentosRealizados >= maximosIntentos) {
                    JOptionPane.showMessageDialog(null, "¡No más intentos! La palabra era: " + palabraObjetivo);
                    return;
                }

                String intentoUsuario = campoTextoIntento.getText().toUpperCase();
                if (intentoUsuario.length() != palabraObjetivo.length()) {
                    JOptionPane.showMessageDialog(null, "La palabra debe tener " + palabraObjetivo.length() + " letras.");
                    return;
                }

                agregarIntento(intentoUsuario);
                campoTextoIntento.setText("");
                intentosRealizados++;

                if (intentoUsuario.equals(palabraObjetivo)) {
                    JOptionPane.showMessageDialog(null, "¡Felicidades! Adivinaste la palabra: " + palabraObjetivo);
                    campoTextoIntento.setEnabled(false);
                } else if (intentosRealizados == maximosIntentos) {
                    JOptionPane.showMessageDialog(null, "¡Has perdido! La palabra era: " + palabraObjetivo);
                    campoTextoIntento.setEnabled(false);
                }
            }
        });

        // botón Nueva palabra
        botonNuevaPalabra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarJuego();
            }
        });

        // botón Salir 
        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void inicializarPanelIntentos() {
        // limpiar y generar
        for (int i = 0; i < maximosIntentos; i++) {
            JPanel filaIntento = new JPanel();
            filaIntento.setLayout(new GridLayout(1, palabraObjetivo.length(), 5, 5));
            filaIntento.setBackground(new Color(200, 200, 200));

            for (int j = 0; j < palabraObjetivo.length(); j++) {
                JLabel etiquetaLetra = new JLabel("", SwingConstants.CENTER); // Vacio al inicio
                etiquetaLetra.setOpaque(true);
                etiquetaLetra.setFont(new Font("Arial", Font.BOLD, 20));
                etiquetaLetra.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                etiquetaLetra.setBackground(Color.WHITE);
                etiquetaLetra.setForeground(Color.BLACK);

                filaIntento.add(etiquetaLetra);
            }

            intentosPaneles.add(filaIntento);
            panelIntentos.add(filaIntento);
        }

        panelIntentos.revalidate();
        panelIntentos.repaint();
    }

    private void agregarIntento(String intentoUsuario) {
        if (intentosRealizados >= maximosIntentos) {
            return;
        }

        JPanel filaIntento = intentosPaneles.get(intentosRealizados);

        boolean[] letrasAdivinadasCorrectamente = new boolean[palabraObjetivo.length()];
        int[] contadorLetrasObjetivo = new int[26];
        int[] contadorLetrasIntento = new int[26];
        for (char c : palabraObjetivo.toCharArray()) {
            contadorLetrasObjetivo[c - 'A']++;
        }

        for (int i = 0; i < palabraObjetivo.length(); i++) {
            JLabel etiquetaLetra = (JLabel) filaIntento.getComponent(i);
            char letraIntento = intentoUsuario.charAt(i);
            
            if (letraIntento == palabraObjetivo.charAt(i)) {
                etiquetaLetra.setText(String.valueOf(letraIntento)); 
                etiquetaLetra.setBackground(new Color(0, 100, 0)); // Verde oscuro
                etiquetaLetra.setForeground(Color.WHITE);
                letrasAdivinadasCorrectamente[i] = true;
                contadorLetrasIntento[letraIntento - 'A']++;
            } else {
                etiquetaLetra.setText(String.valueOf(letraIntento)); 
                etiquetaLetra.setBackground(Color.WHITE);
                etiquetaLetra.setForeground(Color.BLACK);
            }
        }

        for (int i = 0; i < palabraObjetivo.length(); i++) {
            if (letrasAdivinadasCorrectamente[i]) {
                continue;
            }

            JLabel etiquetaLetra = (JLabel) filaIntento.getComponent(i);
            char letraIntento = intentoUsuario.charAt(i);
            if (palabraObjetivo.indexOf(letraIntento) != -1) {
                if (contadorLetrasIntento[letraIntento - 'A'] < contadorLetrasObjetivo[letraIntento - 'A']) {
                    etiquetaLetra.setBackground(new Color(204, 204, 0)); // Amarillo
                    etiquetaLetra.setForeground(Color.BLACK);
                    contadorLetrasIntento[letraIntento - 'A']++;
                }
            }
        }

        panelIntentos.revalidate();
        panelIntentos.repaint();
    }

    private void reiniciarJuego() {
        //reiniciar el juego con una nueva palabra
        Random random = new Random();
        palabraObjetivo = palabrasRelacionadasJava[random.nextInt(palabrasRelacionadasJava.length)];
        intentosRealizados = 0;
        intentosPaneles.clear();
        panelIntentos.removeAll();
        inicializarPanelIntentos();
        if (campoTextoIntento != null) {
            campoTextoIntento.setEnabled(true);
            campoTextoIntento.setText("");
        }

        panelIntentos.revalidate();
        panelIntentos.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordleBasic().setVisible(true);
            }
        });
    }
}
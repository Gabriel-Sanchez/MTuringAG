package turing;

import java.awt.Color;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.*;

import java.awt.event.*;
import java.util.HashMap;

import java.util.ArrayList;
import java.util.Collections;

public class Ventana extends JFrame {

    public Ventana() {
        this.setSize(800, 300);
        this.setLocationRelativeTo(this);
        setResizable(false);
        setTitle("Mturing-lab-Gabriel-Annette");

        Lamina milamina = new Lamina();
        add(milamina);

    }

}

class Lamina extends JPanel implements ActionListener {

    JPanel fondo2 = new JPanel();
    JPanel fondo3 = new JPanel();
    JPanel fondo4Der = new JPanel();

    MaquinaTuring maquina;

    JButton boton1 = new JButton("Iniciar");
    JButton boton3 = new JButton("siguiente");

    JLabel texto1[];
    JLabel texto2[];

    JLabel bordesAbajo;
    JLabel bordesizquierda;
    JLabel bordescentro;
    JLabel centro2;
    JLabel bordesderecha;
    JLabel labelqf;
    JLabel labelqs;
    JLabel labelw;

    private JTextField campo1;
    private JTextField campo2;
    private JTextField campo3;
    private JTextArea areatexto1;
    private JTextArea areatexto2;

    JLabel textoMensaje;

    public Lamina() {

        setLayout(new BorderLayout(0, 0));

        boton3.setEnabled(false);

        Color colorFondo = new Color(110, 222, 138);

        fondo3.setLayout(new GridLayout(2, 10, 5, 2));
        fondo4Der.setLayout(new BorderLayout(0, 0));

        texto1 = new JLabel[10];
        texto2 = new JLabel[10];

        textoMensaje = new JLabel("               ", SwingConstants.CENTER);
        textoMensaje.setFont(new Font("Serif", Font.PLAIN, 16));
        textoMensaje.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        bordesAbajo = new JLabel();
        bordesizquierda = new JLabel();
        bordescentro = new JLabel();
        centro2 = new JLabel();
        bordesderecha = new JLabel();

        labelqf = new JLabel();
        labelqs = new JLabel();
        labelw = new JLabel();
        int num = 0;

        for (JLabel i : texto1) {

            texto1[num] = new JLabel("B", SwingConstants.CENTER);
            texto1[num].setFont(new Font("Serif", Font.PLAIN, 30));
            texto1[num].setBackground(Color.WHITE);
            texto1[num].setOpaque(true);

            fondo3.add(texto1[num]);

            num++;
        }

        num = 0;

        for (JLabel i : texto1) {

            texto2[num] = new JLabel("", SwingConstants.CENTER);
            texto2[num].setFont(new Font("Serif", Font.PLAIN, 30));
            texto2[num].setBackground(Color.WHITE);
            texto2[num].setOpaque(true);

            fondo3.add(texto2[num]);
            num++;
        }

        fondo2.add(boton1);
        fondo2.add(boton3);

        boton1.addActionListener(this);
        boton3.addActionListener(this);

        campo1 = new JTextField(10);
        campo2 = new JTextField(3);
        campo3 = new JTextField(3);
        campo1.setText("ababb");
        campo2.setText("q4");
        campo3.setText("q0");

        labelqf.setText("F = ");
        labelqf.setBorder(BorderFactory.createEmptyBorder(0, 90, 0, 0));
        labelqs.setText("s = ");
        labelw.setText(" w = ");
        labelw.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));


        areatexto1 = new JTextArea("1ababb");
        areatexto2 = new JTextArea("""
                q0, a -> q1, x, R
                q0, y -> q3, y, R
                q1, a -> q1, a, R
                q1, b -> q2, y, L
                q1, y -> q1, y, R
                q2, a -> q2, a, L
                q2, x -> q0, x, R
                q2, y -> q2, y, L
                q3, y -> q3, y, R
                q3, B -> q4, B, L""");

        areatexto1.setSize(40, 40);

        fondo2.add(labelqf);

        fondo2.add(campo2);
        fondo2.add(labelqs);
        fondo2.add(campo3);

        fondo2.add(labelw);

        fondo2.add(campo1);

        fondo4Der.add(areatexto2, BorderLayout.CENTER);
        centro2.setBorder(BorderFactory.createEmptyBorder(0, 75, 0, 0));

        fondo2.add(centro2);

        fondo2.add(textoMensaje);
        fondo2.setBackground(colorFondo);

        bordesAbajo.setBackground(colorFondo);
        bordesAbajo.setOpaque(true);

        bordesizquierda.setBackground(colorFondo);
        bordesizquierda.setOpaque(true);

        bordescentro.setBackground(colorFondo);
        bordescentro.setOpaque(true);

        centro2.setBackground(colorFondo);
        centro2.setOpaque(true);

        bordesderecha.setBackground(colorFondo);
        bordesderecha.setOpaque(true);

        bordesAbajo.setBorder(BorderFactory.createEmptyBorder(35, 0, 0, 0));
        bordesizquierda.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        bordesderecha.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        bordescentro.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));

        fondo4Der.add(bordesderecha, BorderLayout.WEST);
        fondo4Der.add(bordesizquierda, BorderLayout.WEST);
        fondo4Der.add(bordescentro, BorderLayout.EAST);

        add(fondo2, BorderLayout.NORTH);
        add(fondo3, BorderLayout.CENTER);
        add(bordesAbajo, BorderLayout.SOUTH);
        add(fondo4Der, BorderLayout.EAST);
        add(bordesderecha, BorderLayout.WEST);

    }


    public void actionPerformed(ActionEvent e) {

        Object botonPulsado = e.getSource();

        if (botonPulsado == boton1) {

            // RESET GRAFIC

            int num = 0;

            for (JLabel i : texto1) {
                texto1[num].setBackground(Color.WHITE);
                texto1[num].setOpaque(true);

                num++;
            }

            num = 0;

            for (JLabel i : texto1) {

                texto2[num].setBackground(Color.WHITE);
                texto2[num].setOpaque(true);
                texto2[num].setText("");

                num++;
            }

            textoMensaje.setText("               ");
            textoMensaje.setBackground(new Color(110, 222, 138));
            textoMensaje.setOpaque(true);

            // lee y corre

            Parser parser = new Parser("B" + campo1.getText() + "\n" + areatexto2.getText());
            String entrada = parser.getInput();
            HashMap transicion = parser.parse();

            maquina = new MaquinaTuring(entrada, transicion, true, texto1, texto2, textoMensaje, campo3.getText());
            maquina.run();
            maquina.setbuton(boton1, boton3);
            maquina.setqf(campo2.getText());
            boton3.setEnabled(true);
            boton1.setEnabled(false);

        }

        if (botonPulsado == boton3) {
            maquina.run();
            
        }

    }

}

class MaquinaTuring {

    private String estadoActual;
    private int cursor;
    private String entrada;
    private HashMap<String, Accion> transicion;
    public ArrayList<String> cinta;
    private static String ESPACIO_BLANCO = "B";
    private boolean pasos = false;
    private String ESTADO_FINAL = "qf";
    private String ESTADO_INICIAL = "";

    boolean apagab = false;
    String mensaje = "";

    JLabel texto1[];
    JLabel texto2[];
    JLabel textoMensaje;

    Color colorMensaje = new Color(41, 250, 232);

    JButton boton1;
    JButton boton3;

    boolean puedeseguir = true;

    public MaquinaTuring(String entrada, HashMap transicion, boolean pasos, JLabel texto1[], JLabel texto2[],
        JLabel textoMensaje, String s) {
        this.entrada = entrada;
        this.transicion = transicion;
        this.pasos = pasos;
        cinta = new ArrayList<String>();

        this.texto1 = texto1;
        this.texto2 = texto2;
        this.textoMensaje = textoMensaje;

        this.ESTADO_INICIAL = s;

        init();
    }

    private void init() {
        for (int i = 0; i < entrada.length(); i++) {
            cinta.add(String.valueOf(entrada.charAt(i)));
        }
        cinta.add(ESPACIO_BLANCO);
        cursor = 1;
        estadoActual = ESTADO_INICIAL;
    }

    public void run() {

        if (apagab == true) {
            display();
            apagab = true;
            textoMensaje.setText(mensaje);
            textoMensaje.setBackground(colorMensaje);
            textoMensaje.setOpaque(true);

            boton3.setEnabled(false);
            boton1.setEnabled(true);

        }

        if (puedeseguir) {

            if (cursor == 0) {
                paso_derecha();
                cursor = 1;
            }
            display();

            Accion action;
            String key = estadoActual + cinta.get(cursor);
            if ((action = transicion.get(key)) != null) {
                exec(action);
                if (estadoActual.equals(ESTADO_FINAL)) {
                    detener();

                }
            } else {
                detener();

            }

        }
    }

    private void paso_derecha() {
        cinta.add("B");
        for (int i = cinta.size() - 1; i > 0; i--) {
            Collections.swap(cinta, i, i - 1);
        }
    }

    public void exec(Accion accion) {
        cinta.set(cursor, accion.nuevo_simbolo);
        estadoActual = accion.siguiente_estado;

        cursor += accion.movimiento.equals("R") ? 1 : -1;
    }

    public void detener() {
        if (estadoActual.equals(ESTADO_FINAL)) {
            mensaje = "Aceptado";
            colorMensaje = new Color(50, 205, 50);

        } else {
            mensaje = "Rechazado";
            colorMensaje = new Color(232, 93, 4);

        }

        apagab = true;

    }

    public void display() {
        
        int indice = 0;
        for (String i : cinta) {

            this.texto1[indice].setText(i);
            indice++;

        }


        for (int i = 0; i < cinta.size(); i++) {

            this.texto1[i].setBackground(Color.WHITE);
            this.texto1[cinta.size() - 1].setBackground(Color.WHITE);
            this.texto1[i].setOpaque(true);
            this.texto1[cinta.size() - 1].setOpaque(true);

            this.texto2[i].setBackground(Color.WHITE);
            this.texto2[cinta.size() - 1].setBackground(Color.WHITE);
            this.texto2[i].setOpaque(true);
            this.texto2[cinta.size() - 1].setOpaque(true);

            this.texto2[i].setText("");
            this.texto2[cinta.size() - 1].setText("");
        }

        for (int i = 0; i < cinta.size(); i++) {
            
            if (i == cursor) {
                // ^
                this.texto1[i].setBackground(Color.LIGHT_GRAY);
                this.texto1[i].setOpaque(true);

                this.texto2[i].setBackground(Color.LIGHT_GRAY);
                this.texto2[i].setOpaque(true);

                this.texto2[i].setText(estadoActual);

                break;
            } else {
                this.texto1[i].setBackground(Color.WHITE);
                this.texto1[cinta.size() - 1].setBackground(Color.WHITE);
                this.texto1[i].setOpaque(true);
                this.texto1[cinta.size() - 1].setOpaque(true);

                this.texto2[i].setBackground(Color.WHITE);
                this.texto2[cinta.size() - 1].setBackground(Color.WHITE);
                this.texto2[i].setOpaque(true);
                this.texto2[cinta.size() - 1].setOpaque(true);

                this.texto2[i].setText("");
                this.texto2[cinta.size() - 1].setText("");

            }
            
        }
        
    }

    public void setbuton(JButton botn, JButton botn2) {

        this.boton1 = botn;
        this.boton3 = botn2;

    }

    public void setqf(String qf) {

        this.ESTADO_FINAL = qf;

    }

}

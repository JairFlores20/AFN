/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.parte1;

/**
 *
 * @author silvi
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Parte1 extends JFrame {
    private JPanel panelNuevo;
    private HashMap<Integer, AFN> AFNS = new HashMap<>();

    public Parte1() {
        setTitle("Interprete");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        String[] opciones = {
            "Crear AFN básico",
            "Unir AFNs",
            "Concatenar 2 AFNs",
            "Cerradura positiva",
            "Cerradura de Kleene",
            "Opcional"
        };
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        comboBox.setPreferredSize(new Dimension(200, 25));
        add(comboBox, BorderLayout.NORTH);
//creamos el un panel nuevo de cada JComboBox
        panelNuevo = new JPanel();
        add(panelNuevo , BorderLayout.CENTER);

//ActionListener solo tiene un método "actionPerformed", lo que nos permite
//es direccionarnos al panelNuevo una vez que el usuario escoge alguna opción del JcomboBox
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccion = (String) comboBox.getSelectedItem();
                cambiarPanel(seleccion);
            }
        });

        setVisible(true);
    }
//metodo para que podamos visualizar el panel de cada JcomboBox
    private void cambiarPanel(String seleccion) {
        panelNuevo.removeAll();

        switch (seleccion) {
            case "Crear AFN básico":
                //si gustan usar GridLayout que forma una cuadricula, en este caso(filas,columnas,pixles)
                //también existe, flowlayout, borderlayout,boxlayout
                panelNuevo.setLayout(new GridLayout(10, 10, 10, 10));
                panelNuevo.add(new JLabel("Caracter inferior:"));
                JTextField simboloInferior = new JTextField();
                panelNuevo.add(simboloInferior);

                panelNuevo.add(new JLabel("Caracter superior:"));
                JTextField simboloSuperior = new JTextField();
                panelNuevo.add(simboloSuperior);

                panelNuevo.add(new JLabel("ID del AFN:"));
                JTextField IdAFN = new JTextField();
                panelNuevo.add(IdAFN);

                JButton CrearAFNButton = new JButton("Crear AFN");
                panelNuevo.add(CrearAFNButton);
                //crear una accion para cuando el boton sea pulsado y pueda
                //leer y guardar los caracteres infe,supe y el ID
                CrearAFNButton.addActionListener(new ActionListener() {
                    @Override
                    //sobrescribirá en el método para ahora si definir la
                    //acción de cuando sea pulsado el boton
                    public void actionPerformed(ActionEvent e) {
                        try {
                            char s1 = simboloInferior.getText().charAt(0);
                            char s2 = simboloSuperior.getText().charAt(0);
                            //esto es importante, ya que el id forzosamente
                            //debe ser un entero, y lo que hace parseInt 
                            //es convertir un string a entero ¡ID SOLO LEE
                            //Y RECIBE ENTEROS!
                            int id = Integer.parseInt(IdAFN.getText());
                            //IMPORTANTE:se deben hacer las validaciones pertinente para verificar
                            //si ya existe el AFN con el ID, si podemos crearlo o si ingresa ID tipo string
                            //no lo crea
                            //con HashMap no se permiten valores duplicados y como es un ID único
                            //para cada autómata. Es decir almacen el objeto con una CLAVE (ID) única, es por ello que
                            //su estructura contiene containsKEY que regresa un verdadero si una entrada
                            //ya está especificada con su KEY (ID)
                            if (AFNS.containsKey(id)) {
                                JOptionPane.showMessageDialog(null, "Ya existe un AFN con ese ID.");
                            } else {
                                AFN afn = new AFN().CrearAFNBasico(s1, s2);
                                afn.IdAFN = id;
                                AFNS.put(id, afn);
                                JOptionPane.showMessageDialog(null, "AFN creado");
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "No se pudo crear automáta");
                        }
                    }
                });
                break;
            case "Unir AFNs":
                panelNuevo.add(new JLabel("Unir AFNs"));
                break;
            case "Concatenar 2 AFNs":
                panelNuevo.add(new JLabel("Concatenar 2 AFNs"));
                break;
            case "Cerradura positiva":
                panelNuevo.add(new JLabel("Cerradura positiva"));
                break;
            case "Cerradura de Kleene":
                panelNuevo.add(new JLabel("Cerradura de Kleene"));
                break;
            case "Opcional":
                panelNuevo.add(new JLabel("Opcional?"));
                break;
        }

        panelNuevo.revalidate();
        panelNuevo.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Parte1());
    }
}

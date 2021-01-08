package Ejercicio3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClaseInterna extends JFrame {

    private Tiempo tiempo;
    private JLabel horaEtiqueta, minutoEtiqueta, segundoEtiqueta;
    private JTextField horaCampo, minutoCampo, segundoCampo, pantallaCampo;
    private JPanel contenedor;

    public ClaseInterna() {
        super( "Demostración de clase interna anónima" );
        tiempo = new Tiempo();            // crear objeto Tiempo
        crearGUI();                       // configurar GUI
        super.add(this.contenedor);
        super.setResizable(false);
        registrarManejadoresDeEventos();  // configurar el manejo de eventos
    }

    private void crearGUI(){
        contenedor = new JPanel();
        contenedor.setLayout(new BorderLayout());

        JPanel contCampos = new JPanel();
        contCampos.setLayout(new GridLayout(3, 2));

        horaEtiqueta = new JLabel( "Ajuste hora" );
        horaCampo = new JTextField( 10 );
        minutoEtiqueta = new JLabel( "Ajuste minuto" );
        minutoCampo = new JTextField( 10 );
        segundoEtiqueta = new JLabel( "Ajuste segundo" );
        segundoCampo = new JTextField( 10 );
        pantallaCampo = new JTextField( 30 );
        pantallaCampo.setEditable( false );

        contCampos.add( horaEtiqueta);
        contCampos.add( horaCampo);
        contCampos.add( minutoEtiqueta);
        contCampos.add( minutoCampo);
        contCampos.add( segundoEtiqueta);
        contCampos.add( segundoCampo);

        contenedor.add(contCampos, BorderLayout.WEST);
        contenedor.add(pantallaCampo, BorderLayout.CENTER);
        contenedor.setSize(300, 250);

    }

    private void registrarManejadoresDeEventos(){
        horaCampo.addActionListener(
                evento -> {
                    tiempo.establecerHora( Integer.parseInt(evento.getActionCommand() ) );
                    horaCampo.setText( "" );
                    mostrarTiempo();
                }
        );

        minutoCampo.addActionListener(
                evento -> {
                    tiempo.establecerMinuto(Integer.parseInt(evento.getActionCommand()));
                    minutoCampo.setText("");
                    mostrarTiempo();
                }
        );

        segundoCampo.addActionListener(
                evento ->{
                    tiempo.establecerSegundo( Integer.parseInt(evento.getActionCommand() ) );
                    segundoCampo.setText( "" );
                    mostrarTiempo();
                }
        );
    }

    public void mostrarTiempo(){
        pantallaCampo.setText( "La hora es: " + tiempo );
    }

    public static void main( String args[] ){
        ClaseInterna ventana = new ClaseInterna();

        ventana.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing( WindowEvent evento ){
                        System.exit( 0 );
                    }
                }
        );

        ventana.setSize( 400, 120 );
        ventana.setVisible( true );

    }

}
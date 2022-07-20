import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eventos extends JFrame {
    public Eventos(){
        JLabel solicitarMensaje = new JLabel("Escribe algo");
        solicitarMensaje.setBounds(35,20,200,30);
        JTextField txtCampo1 = new JTextField(150);
        JTextField txtCampo2= new JTextField(150);
        txtCampo1.setBounds(35,60,180,30);
        txtCampo2.setBounds(35,90,180,30);
        JButton boton = new JButton("Enviar");
        boton.setBounds(35,140,150,30);
        JLabel mostrarMensaje = new JLabel();
        mostrarMensaje.setBounds(50,200,250,50);
        ActionListener listener = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                txtCampo2.setText("Tu escribiste: "+txtCampo1.getText());
            }
        };
        boton.addActionListener(listener);

        add(boton);
        add(mostrarMensaje);
        add(solicitarMensaje);
        add(txtCampo1);
        add(txtCampo2);
        setSize(400,400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }

    public static void main(String[] args) {
        Eventos evento = new Eventos();

    }
}

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame{
    private JPanel panelPrincipal;
    private JTextField usuarioTexto;
    private JPasswordField usuarioContraseña;
    private JButton enviarBoton;

    public LoginForm(){
        inicializarForma();
        enviarBoton.addActionListener(e -> validar());
    }

    private void validar(){
        var usuario = this.usuarioTexto.getText();
        var contraseña = new String(this.usuarioContraseña.getPassword());
        if("root".equals(usuario) && "admin".equals(contraseña)){
            mostrarMensaje("Bienvenido");
        } else if ("root".equals(usuario)) {
            mostrarMensaje("contraseña incorrecta");
        } else
            mostrarMensaje("usuario incorrecto");
    }

    private void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje);
    }

    private void inicializarForma(){
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null); // centramos la ventana
    }

    public static void main(String[] args) {
        FlatDarculaLaf.setup();
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
    }

}

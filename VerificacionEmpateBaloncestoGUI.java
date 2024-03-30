import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerificacionEmpateBaloncestoGUI extends JFrame {
    private JTextField puntosEquipoATextField;
    private JTextField puntosEquipoBTextField;
    private JButton verificarButton;

    public VerificacionEmpateBaloncestoGUI() {
        setTitle("Verificación de Empate en Baloncesto");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear componentes
        JLabel puntosEquipoALabel = new JLabel("Puntos Equipo A:");
        puntosEquipoATextField = new JTextField(4);

        JLabel puntosEquipoBLabel = new JLabel("Puntos Equipo B:");
        puntosEquipoBTextField = new JTextField(4);

        verificarButton = new JButton("Comprobar ");

        // Crear panel para organizar componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(puntosEquipoALabel);
        panel.add(puntosEquipoATextField);
        panel.add(puntosEquipoBLabel);
        panel.add(puntosEquipoBTextField);
        panel.add(verificarButton);

        // Agregar panel al frame
        add(panel);

        // Agregar listener al botón
        verificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarEmpate();
            }
        });
    }

    private void verificarEmpate() {
        int puntosEquipoA = Integer.parseInt(puntosEquipoATextField.getText());
        int puntosEquipoB = Integer.parseInt(puntosEquipoBTextField.getText());

        // Expresión relacional para determinar si se debe ir a tiempo extra
        boolean irATiempoExtra = puntosEquipoA == puntosEquipoB;

        if (irATiempoExtra) {
            JOptionPane.showMessageDialog(this, "El partido tine que  ir a tiempo extra");
        } else {
            JOptionPane.showMessageDialog(this, "El partido no requiere tiempo extra");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VerificacionEmpateBaloncestoGUI gui = new VerificacionEmpateBaloncestoGUI();
                gui.setVisible(true);
            }
        });
    }
}
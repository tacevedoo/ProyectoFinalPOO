import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaEliminarLibro extends JFrame implements ActionListener{
    private Container Contenedor;

    private JLabel Titulo;
    private JTextField CampoTitulo;
    private JButton Eliminar;

    public VentanaEliminarLibro() {
        Contenedor = getContentPane();
        Contenedor.setLayout(null);
        Contenedor.setBackground(Color.WHITE);
        setTitle("Eliminar Libro");
        setSize(280,280);
        setLocationRelativeTo(null);
        Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png"));
        setIconImage(icono);
        setResizable(false);

        Titulo = new JLabel();
        Titulo.setText("Título: ");
        Titulo.setBounds(40, 80, 80, 20);
        CampoTitulo = new JTextField();
        CampoTitulo.setBounds(160, 80, 80, 20);

        Eliminar = new JButton();
        Eliminar.setText("Eliminar");
        Eliminar.setBounds(20, 160, 80, 20);
        Eliminar.setBackground(Color.CYAN);
        Eliminar.addActionListener(this);

        Contenedor.add(Titulo);
        Contenedor.add(CampoTitulo);
        Contenedor.add(Eliminar);
    }

    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == Eliminar && !(CampoTitulo.getText().isEmpty())) {
            boolean Resultado = ArchivoLibros.EliminarLibro(CampoTitulo.getText());
            if(Resultado){
                JOptionPane.showMessageDialog(null, "Libro Eliminado Correctamente");
                CampoTitulo.setText("");
            }else {
                JOptionPane.showMessageDialog(null, "Error, intente de nuevo");
                CampoTitulo.setText("");
            }
        }
    }
}

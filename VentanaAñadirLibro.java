import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaAñadirLibro extends JFrame implements ActionListener{
    private Container Contenedor;

    private JLabel Titulo, Autor, AñoPublicacion;
    private JTextField CampoTitulo, CampoAutor, CampoAñoPublicacion;
    private JButton Añadir;

    public VentanaAñadirLibro() {
        Contenedor = getContentPane();
        Contenedor.setLayout(null);
        Contenedor.setBackground(Color.WHITE);
        setTitle("Añadir Libro");
        setSize(280,280);
        setLocationRelativeTo(null);
        Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png"));
        setIconImage(icono);
        setResizable(false);
        

        Titulo = new JLabel();
        Titulo.setText("Título: ");
        Titulo.setBounds(40, 40, 80, 20);
        CampoTitulo = new JTextField();
        CampoTitulo.setBounds(160, 40, 80, 20);

        Autor = new JLabel();
        Autor.setText("Autor: ");
        Autor.setBounds(40, 80, 80, 20);
        CampoAutor = new JTextField();
        CampoAutor.setBounds(160, 80, 80, 20);

        AñoPublicacion = new JLabel();
        AñoPublicacion.setText("Año de Publicación: ");
        AñoPublicacion.setBounds(40, 120, 120, 20);
        CampoAñoPublicacion = new JTextField();
        CampoAñoPublicacion.setBounds(160, 120, 80, 20);

        Añadir = new JButton();
        Añadir.setText("Añadir");
        Añadir.setBounds(40, 180, 80, 20);
        Añadir.setBackground(Color.CYAN);
        Añadir.addActionListener(this);

        Contenedor.add(Titulo);
        Contenedor.add(CampoTitulo);
        Contenedor.add(Autor);
        Contenedor.add(CampoAutor);
        Contenedor.add(AñoPublicacion);
        Contenedor.add(CampoAñoPublicacion);
        Contenedor.add(Añadir);
    }

    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == Añadir && !(CampoTitulo.getText().isEmpty()) && !(CampoAutor.getText().isEmpty()) && !(CampoAñoPublicacion.getText().isEmpty())) {
            boolean Resultado = ArchivoLibros.AñadirLibro(CampoTitulo.getText(), CampoAutor.getText(), CampoAñoPublicacion.getText());
            if(Resultado){
                JOptionPane.showMessageDialog(null, "Libro Añadido Correctamente");
                CampoTitulo.setText("");
                CampoAutor.setText("");
                CampoAñoPublicacion.setText("");
            }else {
                JOptionPane.showMessageDialog(null, "Error, intente de nuevo");
                CampoTitulo.setText("");
                CampoAutor.setText("");
                CampoAñoPublicacion.setText("");
            }
        }
    }
}

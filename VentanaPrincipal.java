import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private Container Contenedor;
    private JButton AñadirLibro, EliminarLibro, EditarLibro, MostrarLibros;
    private JLabel ImagenLabel1;

    public VentanaPrincipal() {
        Contenedor = getContentPane();
        Contenedor.setLayout(null);
        Contenedor.setBackground(Color.WHITE);
        setTitle("LibriDex");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png"));
        setIconImage(icono);
        setResizable(false);

        ImageIcon icon1 = new ImageIcon(getClass().getResource("libridex.png"));

        ImagenLabel1 = new JLabel(icon1);
        ImagenLabel1.setBounds(20, 80, 940, 400);
        Contenedor.add(ImagenLabel1);

        AñadirLibro = new JButton("Añadir Libro");
        AñadirLibro.setBounds(getWidth() / 2 - 330, getHeight() - 120, 160, 50);
        AñadirLibro.setBackground(Color.CYAN);
        AñadirLibro.addActionListener(this);
        Contenedor.add(AñadirLibro);

        EliminarLibro = new JButton("Eliminar Libro");
        EliminarLibro.setBounds(getWidth() / 2 - 165, getHeight() - 120, 160, 50);
        EliminarLibro.setBackground(Color.CYAN);
        EliminarLibro.addActionListener(this);
        Contenedor.add(EliminarLibro);

        EditarLibro = new JButton("Editar Libro");
        EditarLibro.setBounds(getWidth() / 2 + 5, getHeight() - 120, 160, 50);
        EditarLibro.setBackground(Color.CYAN);
        EditarLibro.addActionListener(this);
        Contenedor.add(EditarLibro);

        MostrarLibros = new JButton("Mostrar Libros");
        MostrarLibros.setBounds(getWidth() / 2 + 175, getHeight() - 120, 160, 50);
        MostrarLibros.setBackground(Color.CYAN);
        MostrarLibros.addActionListener(this);
        Contenedor.add(MostrarLibros);

    }

    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == AñadirLibro) {
            VentanaAñadirLibro Añadir = new VentanaAñadirLibro();
            Añadir.setVisible(true);
        }
        if (evento.getSource() == EliminarLibro) {
            VentanaEliminarLibro Eliminar = new VentanaEliminarLibro();
            Eliminar.setVisible(true);
        }
        if (evento.getSource() == EditarLibro) {
            VentanaEditarLibro Editar = new VentanaEditarLibro();
            Editar.setVisible(true);
        }
        if (evento.getSource() == MostrarLibros) {
            VentanaMostrarLibros MostrarLibros = new VentanaMostrarLibros();
            MostrarLibros.setVisible(true);
        }
    }
}


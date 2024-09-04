import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaMostrarLibros extends JFrame implements ActionListener{
    private Container Contenedor;
    private JLabel TituloListaLibros;
    private JButton GenerarLista;

    public VentanaMostrarLibros() {
        Contenedor = getContentPane();
        Contenedor.setLayout(null);
        Contenedor.setBackground(Color.WHITE);
        setTitle("Lista de Libros");
        setSize(400,600);
        setLocationRelativeTo(null);
        Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png"));
        setIconImage(icono);
        setResizable(false);

        TituloListaLibros = new JLabel();
        TituloListaLibros.setText("Lista Completa de Libros");
        TituloListaLibros.setBounds(120, 20, 180, 20);

        GenerarLista = new JButton();
        GenerarLista.setText("Generar Lista");
        GenerarLista.setBounds(130, 60, 120, 20);
        GenerarLista.setBackground(Color.CYAN);
        GenerarLista.addActionListener(this);

        Contenedor.add(TituloListaLibros);
        Contenedor.add(GenerarLista);
    }

    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == GenerarLista) {
            String[] Lineas = ArchivoLibros.MostrarLibros().split("/");
            JList<String> ListaLibros = new JList<>(Lineas);
            JScrollPane ScrollPane = new JScrollPane(ListaLibros);
            ScrollPane.setBounds(90, 100, 220, 400);
            Contenedor.add(ScrollPane);
            Contenedor.revalidate();
            Contenedor.repaint();
        }
    }
}
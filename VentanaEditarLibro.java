import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaEditarLibro extends JFrame implements ActionListener{
    private Container Contenedor;

    private JLabel EditarTitulo, EditarAutor, EditarAñoPublicacion, TituloAntiguo;
    private JTextField CampoTituloAntiguo;
    private JTextField CampoTitulo, CampoAutor, CampoAñoPublicacion;
    private JButton Actualizar;

    public VentanaEditarLibro() {
        Contenedor = getContentPane();
        Contenedor.setLayout(null);
        Contenedor.setBackground(Color.WHITE);
        setTitle("Actualizar Libro");
        setSize(280,280);
        setLocationRelativeTo(null);
        Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png"));
        setIconImage(icono);
        setResizable(false);

        CampoTituloAntiguo = new JTextField();
        CampoTituloAntiguo.setBounds(160, 20, 80, 20);

        TituloAntiguo = new JLabel();
        TituloAntiguo.setText("Título Libro: ");
        TituloAntiguo.setBounds(40, 20, 80, 20);

        EditarTitulo = new JLabel();
        EditarTitulo.setText("Nuevo Título: ");
        EditarTitulo.setBounds(40, 80, 80, 20);

        EditarAutor = new JLabel();
        EditarAutor.setText("Nuevo Autor: ");
        EditarAutor.setBounds(40, 120, 80, 20);

        EditarAñoPublicacion = new JLabel();
        EditarAñoPublicacion.setText("Nuevo Año: ");
        EditarAñoPublicacion.setBounds(40, 160, 120, 20);

        CampoTitulo = new JTextField();
        CampoTitulo.setBounds(160, 80, 80, 20);

        CampoAutor = new JTextField();
        CampoAutor.setBounds(160, 120, 80, 20);

        CampoAñoPublicacion = new JTextField();
        CampoAñoPublicacion.setBounds(160, 160, 80, 20);

        Actualizar = new JButton();
        Actualizar.setText("Actualizar");
        Actualizar.setBounds(40,200, 120, 20);
        Actualizar.setBackground(Color.CYAN);
        Actualizar.addActionListener(this);

        Contenedor.add(EditarTitulo);
        Contenedor.add(TituloAntiguo);
        Contenedor.add(EditarAutor);
        Contenedor.add(EditarAñoPublicacion);
        Contenedor.add(CampoTituloAntiguo);
        Contenedor.add(CampoTitulo);
        Contenedor.add(CampoAutor);
        Contenedor.add(CampoAñoPublicacion);
        Contenedor.add(Actualizar);
    }

    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == Actualizar && !(CampoTituloAntiguo.getText().isEmpty())) {
            
            boolean Correcto = ArchivoLibros.ActualizarLibro(CampoTituloAntiguo.getText(), CampoTitulo.getText(), CampoAutor.getText(), CampoAñoPublicacion.getText());

            if(Correcto) {
                JOptionPane.showMessageDialog(null, "Libro Actualizado Correctamente");
            }else {
                JOptionPane.showMessageDialog(null, "Error, intente de nuevo");
            }

            CampoTituloAntiguo.setText("");
            CampoTitulo.setText("");
            CampoAutor.setText("");
            CampoAñoPublicacion.setText("");
        }
    }
    
}
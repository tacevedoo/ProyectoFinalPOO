import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class ArchivoLibros {
    private static File File = new File("Libros.txt");

    public static String MostrarLibros() {
        boolean ArchivoVacio = true;

        try (BufferedReader br = new BufferedReader(new FileReader(File))) {
            String Linea;
            String Respuesta = "";

            while ((Linea = br.readLine()) != null) {
                ArchivoVacio = false;
                String[] Informacion = Linea.split("/");

                Libro Libro = new Libro(Informacion[0].toLowerCase(), Informacion[1].toLowerCase(), Integer.parseInt(Informacion[2]));

                Respuesta += Libro.toString() + " / ";
            }

            if (ArchivoVacio) {
                Respuesta = "La biblioteca está vacia";
                return Respuesta;
            }

            return Respuesta;

        } catch (IOException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    public static boolean AñadirLibro(String Titulo, String Autor, String AñoPublicacion) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(File, true))) {
            bw.write(Titulo.toLowerCase() + "/" + Autor.toLowerCase() + "/" + AñoPublicacion.toLowerCase());
            bw.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean ActualizarLibro(String Titulo, String NuevoTitulo, String NuevoAutor, String NuevoAño) {
        List<String> Lineas = new ArrayList<>();
        
        File archivo = new File("Libros.txt"); 
    
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Lineas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    
        boolean Encontrado = false;
        int Indice = -1;
        for (int i = 0; i < Lineas.size(); i++) {
            String linea = Lineas.get(i);
            String[] Informacion = linea.split("/");
            if (Informacion[0].equals(Titulo)) {
                Encontrado = true;
                Indice = i; 
                break;
            }
        }
    
        if (Encontrado) {
            String LineaActualizar = Lineas.get(Indice);
            String[] Informacion = LineaActualizar.split("/");
            Libro NuevoLibro = null;
            String tit, aut, año;
            if(NuevoTitulo.isEmpty()) {
                tit = Informacion[0];
            }else {
                tit = NuevoTitulo;
            }
            if(NuevoAutor.isEmpty()) {
                aut = Informacion[1];
            }else {
                aut = NuevoAutor;
            }
            if(NuevoAño.isEmpty()) {
                año = Informacion[2];
            }else {
                año = NuevoAño;
            }

            NuevoLibro = new Libro(tit, aut, Integer.parseInt(año));
        
    
            String StringNuevoLibro = NuevoLibro.getTitulo() + "/" + NuevoLibro.getAutor() + "/" + NuevoLibro.getAñoPublicacion();
            Lineas.set(Indice, StringNuevoLibro);
    
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
                for (String linea : Lineas) {
                    bw.write(linea);
                    bw.newLine();
                }
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static boolean EliminarLibro(String Titulo) {
        List<String> Lineas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(File))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Lineas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        boolean Encontrado = false;
        int Indice = -1;
        for (String linea : Lineas) {
            String[] Informacion = linea.split("/");
            Indice += 1;
            if(Informacion[0].equals(Titulo)) {
                Encontrado = true;
                break;
            }
        }

        if(Encontrado) {
            Lineas.remove(Indice);

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(File))) {

                for (String linea : Lineas) {
                    bw.write(linea);
                    bw.newLine();
                }
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
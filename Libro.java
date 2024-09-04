public class Libro {
    private String Titulo;
    private String Autor;
    private int AñoPublicacion;

    public Libro(String Titulo, String Autor, int AñoPublicacion) {
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.AñoPublicacion = AñoPublicacion;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public int getAñoPublicacion() {
        return AñoPublicacion;
    }

    @Override
    public String toString() {
        return "Título: " + Titulo + ", Autor: " + Autor + ", Año: " + AñoPublicacion;
    }
}
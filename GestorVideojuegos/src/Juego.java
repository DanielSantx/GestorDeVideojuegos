public class Juego {
    // Atributos
    private String titulo;
    private String genero;
    private double precio;

    // Constructor
    public Juego(String titulo, String genero, double precio) {
        this.titulo = titulo;
        this.genero = genero;
        this.precio = precio;
    }

    // Métodos
    public void IniciarJuego() {
        System.out.println("Iniciando juego: " + titulo);
    }

    public void ConsultarInfo() {
        System.out.println("Información del juego:");
        System.out.println("Título: " + titulo);
        System.out.println("Género: " + genero);
        System.out.println("Precio: $" + precio);
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    // Atributos
    private Perfil perfil;
    private List<Juego> juegos;
    private List<Juego> recientes;
    private List<Juego> descargas;

    // Constructor
    public Biblioteca(Perfil perfil) {
        this.perfil = perfil;
        this.juegos = new ArrayList<>();
        this.recientes = new ArrayList<>();
        this.descargas = new ArrayList<>();
    }

    // Métodos
    public void ListarJuegos() {
        System.out.println("Lista de juegos en la biblioteca:");
        for (Juego juego : juegos) {
            System.out.println("- " + juego.getTitulo());
        }
    }

    public void AgregarJuegos(Juego juego) {
        if (perfil.getSaldo() >= juego.getPrecio()) {
            juegos.add(juego);
            perfil.AgregarDinero(-juego.getPrecio());
            System.out.println("Juego '" + juego.getTitulo() + "' añadido a la biblioteca.");
        } else {
            System.out.println("Saldo insuficiente para comprar el juego '" + juego.getTitulo() + "'.");
        }
    }

    public void InstalarJuegos(Juego juego) {
        if (juegos.contains(juego)) {
            descargas.add(juego);
            System.out.println("Juego '" + juego.getTitulo() + "' instalado correctamente.");
        } else {
            System.out.println("No posees el juego '" + juego.getTitulo() + "' en tu biblioteca.");
        }
    }

    public void DesinstalarJuegos(Juego juego) {
        if (descargas.contains(juego)) {
            descargas.remove(juego);
            System.out.println("Juego '" + juego.getTitulo() + "' desinstalado correctamente.");
        } else {
            System.out.println("El juego '" + juego.getTitulo() + "' no está instalado.");
        }
    }

    // Getters
    public List<Juego> getJuegos() {
        return juegos;
    }

    public List<Juego> getRecientes() {
        return recientes;
    }

    public List<Juego> getDescargas() {
        return descargas;
    }
}
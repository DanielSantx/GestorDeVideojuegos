import java.util.List;
import java.util.Scanner;

public class Main {
    private static Perfil perfilActual;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bienvenido al Sistema de Biblioteca de Juegos");
        iniciarSesion();
        mostrarMenuPrincipal();
    }

    private static void iniciarSesion() {
        System.out.println("\n--- Creación de Perfil ---");
        System.out.print("Ingrese su nick: ");
        String nick = scanner.nextLine();
        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese su password: ");
        String password = scanner.nextLine();

        perfilActual = new Perfil(nick, email, password);
        System.out.println("\nPerfil creado exitosamente. ¡Bienvenido, " + nick + "!");
    }

    private static void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Gestión de Perfil");
            System.out.println("2. Gestión de Biblioteca");
            System.out.println("3. Gestión de Juegos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    menuGestionPerfil();
                    break;
                case 2:
                    menuGestionBiblioteca();
                    break;
                case 3:
                    menuGestionJuegos();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 4);
    }

    private static void menuGestionPerfil() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE PERFIL ---");
            System.out.println("1. Editar perfil");
            System.out.println("2. Agregar dinero");
            System.out.println("3. Ver información del perfil");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Nuevo nick: ");
                    String nuevoNick = scanner.nextLine();
                    System.out.print("Nuevo email: ");
                    String nuevoEmail = scanner.nextLine();
                    System.out.print("Nueva password: ");
                    String nuevaPassword = scanner.nextLine();
                    perfilActual.EditarPerfil(nuevoNick, nuevoEmail, nuevaPassword);
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a agregar: $");
                    double cantidad = Double.parseDouble(scanner.nextLine());
                    perfilActual.AgregarDinero(cantidad);
                    break;
                case 3:
                    System.out.println("\nInformación del perfil:");
                    System.out.println("Nick: " + perfilActual.getNick());
                    System.out.println("Email: " + perfilActual.getEmail());
                    System.out.println("Saldo: $" + perfilActual.getSaldo());
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 4);
    }

    private static void menuGestionBiblioteca() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE BIBLIOTECA ---");
            System.out.println("1. Listar juegos");
            System.out.println("2. Agregar juego");
            System.out.println("3. Instalar juego");
            System.out.println("4. Desinstalar juego");
            System.out.println("5. Ver juegos instalados");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    perfilActual.getBiblioteca().ListarJuegos();
                    break;
                case 2:
                    System.out.print("Título del juego: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Género: ");
                    String genero = scanner.nextLine();
                    System.out.print("Precio: $");
                    double precio = Double.parseDouble(scanner.nextLine());
                    Juego nuevoJuego = new Juego(titulo, genero, precio);
                    perfilActual.getBiblioteca().AgregarJuegos(nuevoJuego);
                    break;
                case 3:
                    System.out.print("Título del juego a instalar: ");
                    String tituloInstalar = scanner.nextLine();
                    Juego juegoInstalar = buscarJuego(tituloInstalar);
                    if (juegoInstalar != null) {
                        perfilActual.getBiblioteca().InstalarJuegos(juegoInstalar);
                    } else {
                        System.out.println("No se encontró el juego en tu biblioteca.");
                    }
                    break;
                case 4:
                    System.out.print("Título del juego a desinstalar: ");
                    String tituloDesinstalar = scanner.nextLine();
                    Juego juegoDesinstalar = buscarJuegoInstalado(tituloDesinstalar);
                    if (juegoDesinstalar != null) {
                        perfilActual.getBiblioteca().DesinstalarJuegos(juegoDesinstalar);
                    } else {
                        System.out.println("No se encontró el juego instalado.");
                    }
                    break;
                case 5:
                    listarJuegosInstalados();
                    break;
                case 6:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 6);
    }

    private static void menuGestionJuegos() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE JUEGOS ---");
            System.out.println("1. Iniciar juego");
            System.out.println("2. Consultar información de juego");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Título del juego a iniciar: ");
                    String tituloIniciar = scanner.nextLine();
                    Juego juegoIniciar = buscarJuegoInstalado(tituloIniciar);
                    if (juegoIniciar != null) {
                        juegoIniciar.IniciarJuego();
                    } else {
                        System.out.println("El juego no está instalado o no existe.");
                    }
                    break;
                case 2:
                    System.out.print("Título del juego a consultar: ");
                    String tituloConsultar = scanner.nextLine();
                    Juego juegoConsultar = buscarJuego(tituloConsultar);
                    if (juegoConsultar != null) {
                        juegoConsultar.ConsultarInfo();
                    } else {
                        System.out.println("No se encontró el juego en tu biblioteca.");
                    }
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 3);
    }

    private static Juego buscarJuego(String titulo) {
        for (Juego juego : perfilActual.getBiblioteca().getJuegos()) {
            if (juego.getTitulo().equalsIgnoreCase(titulo)) {
                return juego;
            }
        }
        return null;
    }

    private static Juego buscarJuegoInstalado(String titulo) {
        for (Juego juego : perfilActual.getBiblioteca().getDescargas()) {
            if (juego.getTitulo().equalsIgnoreCase(titulo)) {
                return juego;
            }
        }
        return null;
    }

    private static void listarJuegosInstalados() {
        List<Juego> instalados = perfilActual.getBiblioteca().getDescargas();
        if (instalados.isEmpty()) {
            System.out.println("No tienes juegos instalados.");
        } else {
            System.out.println("Juegos instalados:");
            for (Juego juego : instalados) {
                System.out.println("- " + juego.getTitulo());
            }
        }
    }
}
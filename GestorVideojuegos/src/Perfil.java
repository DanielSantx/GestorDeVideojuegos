public class Perfil {
    // Atributos
    private String nick;
    private String email;
    private String password;
    private Biblioteca biblioteca;
    private double saldo;

    // Constructor
    public Perfil(String nick, String email, String password) {
        this.nick = nick;
        this.email = email;
        this.password = password;
        this.biblioteca = new Biblioteca(this);
        this.saldo = 0.0;
    }

    // Métodos
    public void EditarPerfil(String nuevoNick, String nuevoEmail, String nuevaPassword) {
        this.nick = nuevoNick;
        this.email = nuevoEmail;
        this.password = nuevaPassword;
        System.out.println("Perfil actualizado correctamente.");
    }

    public void AgregarDinero(double cantidad) {
        this.saldo += cantidad;
        System.out.println("Se han añadido $" + cantidad + " al saldo. Saldo actual: $" + saldo);
    }

    // Getters y Setters
    public String getNick() {
        return nick;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public double getSaldo() {
        return saldo;
    }
}
public class Main {
    public static void main(String[] args) {
        Buzon b = new Buzon();
        Thread h1 = new Escritor("hola soy el escritor",b);
        Thread h2 = new Lector(b);

        h1.start();
        h2.start();
    }
}
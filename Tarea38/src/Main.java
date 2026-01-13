import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String contrasena, prueba,has,hasPrueba;
        try {

            MessageDigest md = MessageDigest.getInstance("SHA-256");

            System.out.println("Crea una contraseña para el registro:");
            contrasena = sc.nextLine();

            md.update(contrasena.getBytes());
            has = HexFormat.of().formatHex(md.digest());

            System.out.println("Usuario registrado. Inicie sesión para probar");
            prueba = sc.nextLine();

            md.reset();
            md.update(prueba.getBytes());
            hasPrueba = HexFormat.of().formatHex(md.digest());

            if (has.equals(hasPrueba)){
                System.out.println("ACCESO CONCEDIDO");
            }
            else System.out.println("ERROR: Credenciales inválidas");


        } catch (NoSuchAlgorithmException e) {
            System.out.println("Erro con el algoritmo de hasing");
        }



    }
}
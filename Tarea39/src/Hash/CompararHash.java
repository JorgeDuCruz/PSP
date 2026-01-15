package Hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class CompararHash {
    public static boolean compara(String hash, String contrasena){
        String has;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            md.update(contrasena.getBytes());
            has = HexFormat.of().formatHex(md.digest());
            return has.equals(hash);


        } catch (NoSuchAlgorithmException e) {
            System.out.println("Erro con el algoritmo de hashing "+e.getMessage());
        }
        return false;
    }
}

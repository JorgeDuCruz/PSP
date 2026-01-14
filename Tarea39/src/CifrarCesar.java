public class CifrarCesar {
    public static String cifrar(String texto, int desplazamiento){
        StringBuilder textoCifrado = new StringBuilder();
        String alfabeto = "abcdefghijklmnñopqrstuvwxyz";
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);

            // Si el carácter es una letra, ciframos
            if (Character.isLetter(caracter)) {
                // Convertir a minúscula
                char letra = Character.toLowerCase(caracter);
                // Obtener el índice de la letra en el alfabeto
                int indice = alfabeto.indexOf(letra);

                // Si es una letra dentro del alfabeto, desplazamos
                if (indice != -1) {
                    // Realizar el desplazamiento con la fórmula
                    int nuevoIndice = (indice + desplazamiento) % alfabeto.length();

                    // Obtener la letra cifrada
                    char letraCifrada = alfabeto.charAt(nuevoIndice);

                    // Si el carácter original era mayúscula, mantener la mayúscula
                    if (Character.isUpperCase(caracter)) {
                        textoCifrado.append(Character.toUpperCase(letraCifrada));
                    } else {
                        textoCifrado.append(letraCifrada);
                    }
                }
            } else {
                // Si no es una letra, lo dejamos tal cual
                textoCifrado.append(caracter);
            }
        }
        return textoCifrado.toString();
    }
}

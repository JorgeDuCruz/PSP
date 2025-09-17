/*
Crea un programa en Java que ejecute dir o ls en función del sistema operativo. Utiliza la clase System. Luego, que haga lo siguiente:
1. Muestra el directorio de trabajo y la propiedad user.dir por defecto.
2. Muestra el directorio de trabajo y la propiedad user.dir después de cambiar el valor de la propiedad user.dir a la carpeta home del usuario
3. Muestra el directorio de trabajo y la propiedad user.dir después de después de cambiar el directorio de trabajo al directorio temporal (c:/temp o /tmp).
 */

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String comando = "ls";
        String SO = System.getProperty("os.name").toLowerCase();

        //Comprobamos que si el dispositivo es windows cambiamos el comando usado
        if (SO.equals("windows")){
            comando = "dir";
        }

        ProcessBuilder pDir = new ProcessBuilder(comando);
        pDir.inheritIO(); // Cambiamos la salida por defecto del proceso a la consola de Java

        System.out.println("Propiedad user.dir = "+System.getProperty("user.dir")+"\n");

        System.out.println(pDir.command());
        Process pSubDir = pDir.start();

        System.out.println();

        //Cambiamos la propiedad user.dir
        System.setProperty("user.dir",System.getProperty("user.home"));
        System.out.println("Propiedad user.dir = "+System.getProperty("user.dir")+"\n");

        System.out.println(pDir.command());
        Process pSubDir2 = pDir.start();

        //Cambiamos la propiedad user.dir
        System.setProperty("user.dir",System.getProperty("java.io.tmpdir"));
        System.out.println("\nPropiedad user.dir = "+System.getProperty("user.dir")+"\n");

        System.out.println(pDir.command());
        Process pSubDir3 = pDir.start();

    }
}
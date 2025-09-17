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
        ProcessBuilder pDir = new ProcessBuilder(comando);
        pDir.inheritIO();
        Process pSubDir = pDir.start();
        System.out.println(pDir.command());
        System.out.println(System.getProperty("user.dir"));
        System.setProperty("user.dir","/home/dam/Documentos/PSP/Tarea2");
        System.out.println(System.getProperty("user.dir"));
        Process pSubDir2 = pDir.start();
    }
}
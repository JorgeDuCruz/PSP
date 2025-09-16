public class Main {
    public static void main(String[] args) {

        Runtime rt = Runtime.getRuntime();
        long memoriaLibre=rt.freeMemory(),memoriaTotal=rt.totalMemory(),memoriaUso=memoriaTotal-memoriaLibre;
        memoriaLibre = memoriaLibre/1024;//Pasa la memoria a KiB
        memoriaLibre = memoriaLibre/1024;//Pasa la memoria a MiB

        memoriaTotal = memoriaTotal/1024;//Pasa la memoria a KiB
        memoriaTotal = memoriaTotal/1024;//Pasa la memoria a MiB

        memoriaUso = memoriaUso/1024;//Pasa la memoria a KiB
        memoriaUso = memoriaUso/1024;//Pasa la memoria a MiB

        System.out.println("Memoria libre: "+memoriaLibre+" Mib\nMemoria total: "+memoriaTotal+" Mib\nMemoria en uso: "+memoriaUso+" Mib");
        System.out.println("Numero de procesadores: "+rt.availableProcessors());

        String [] propiedades = System.getProperties().toString().split(",");
        for (int i = 0; i<propiedades.length;i++){
            System.out.println(i+": "+propiedades[i]);
        }
    }
}
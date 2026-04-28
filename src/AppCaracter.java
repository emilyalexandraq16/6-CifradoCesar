
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class AppCaracter {

    public static void main(String[] args) throws Exception {

        // Declaramos el objeto de tipo File que referencia al fichero de entrada
        File ficheroEntrada = new File("entrada.txt");

        // Declaramos el objeto de tipo File que referencia al fichero de entrada
        File ficheroSalida = new File("salidaCaracter.txt");

        // Abrimos el archivo para leerlo
        // ALTERNATIVA: FileReader lector = new FileReader("entrada.txt");
        FileReader lector = new FileReader(ficheroEntrada);

        // Creamos el archivo de salida
        // SI NO EXISTE, LO CREA
        // ALTERNATIVA: FileWriter escritor = new FileWriter("salida.txt");
        FileWriter escritor = new FileWriter(ficheroSalida);

        // Se va leyendo del fichero CARACTER A CARACTER
        int caracterInt;

        // Cuando se alcanza EOF (End Of File), se deja de leer
        while ((caracterInt = lector.read()) != -1) {
            // Convertimos el carácter en formato int a char para poder trabajar con el
            char caracter = (char) caracterInt;

            // Convertimos el caracter a mayuscula
            char mayuscula = Character.toUpperCase(caracter);

            // Mostramos por pantalla
            System.out.print(mayuscula);

            /*
                 * Escribimos en el fichero de salida.
                 * Se recomienda (si es posible) no almacenar todo el
                 * contenido del fichero en un String, ya que desconocemos
                 * su tamaño (puede ser de mucho tamaño)
             */
            escritor.write(mayuscula);
        }

        // Cerramos los archivos
        // MUY IMPORTANTE!!!!!!!
        lector.close();
        escritor.close();

        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println("------------ ARCHIVO PROCESADO ------------");
        System.out.println("-------------------------------------------");

    }
}

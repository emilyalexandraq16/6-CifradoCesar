
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class AppCaracter {

    public static void main(String[] args) throws Exception {

        Scanner sc= new Scanner(System.in);
        System.out.println("Vamos a codificar un texto. ¿Que archivo te gustaria codificar? (Debe estar dentro de src/ficheros)");
        String archivo= sc.nextLine();
        File ficheroEntrada= new File("src/ficheros/" + archivo);

        System.out.println("Introduzca el desplazamiento, desde -25 a 25: ");
        int desplazamiento= sc.nextInt();
        sc.nextLine();

        // Declaramos el objeto de tipo File que referencia al fichero de entrada


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
            if(caracterInt >= 33) {
                caracterInt= caracterInt + desplazamiento;
            }
            char caracter = (char) caracterInt;

            // Mostramos por pantalla el caracter procesado
            System.out.println(caracter);

            /*
                 * Escribimos en el fichero de salida.
                 * Se recomienda (si es posible) no almacenar todo el
                 * contenido del fichero en un String, ya que desconocemos
                 * su tamaño (puede ser de mucho tamaño)
             */
            escritor.write(caracter);
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

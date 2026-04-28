
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class AppLinea {

    public static void main(String[] args) throws Exception {

        // Declaramos el objeto de tipo File que referencia al fichero de entrada
        File ficheroEntrada = new File("entrada.txt");

        // Declaramos el objeto de tipo File que referencia al fichero de entrada
        File ficheroSalida = new File("salidaLinea.txt");

        // Abrimos el archivo para leerlo
        // ALTERNATIVA: FileReader lector = new FileReader("entrada.txt");
        FileReader lector = new FileReader(ficheroEntrada);

        // Creamos el archivo de salida
        // SI NO EXISTE, LO CREA
        // ALTERNATIVA: FileWriter escritor = new FileWriter("salida.txt");
        FileWriter escritor = new FileWriter(ficheroSalida);

        // Abrimos el archivo para leerlo
        // ALTERNATIVA: BufferedReader lector = new BufferedReader(new FileReader("entrada.txt"));
        BufferedReader lectorBF = new BufferedReader(lector);

        // Creamos el archivo de salida
        // ALTERNATIVA: BufferedWriter escritor = new BufferedWriter(new FileWriter("salida.txt"));
        BufferedWriter escritorBF = new BufferedWriter(escritor);

        // Se va leyendo del fichero LINEA A LINEA
        String lineaActual;

        // Cuando se alcanza EOF (End Of File), se deja de leer
        while ((lineaActual = lectorBF.readLine()) != null) {
            // Convertimos la linea a mayusculas
            String lineaMinuscula = lineaActual.toLowerCase();

            // Mostramos por pantalla
            System.out.println(lineaMinuscula);

            // Escribimos en el fichero de salida.
            escritorBF.write(lineaMinuscula);

            // Para que se respeten los saltos de línea
            escritorBF.newLine();
        }

        // Cerramos los archivos
        // MUY IMPORTANTE!!!!!!!
        lectorBF.close();
        escritorBF.close();
        lector.close();
        escritor.close();

        System.out.println("-------------------------------------------");
        System.out.println("------------ ARCHIVO PROCESADO ------------");
        System.out.println("-------------------------------------------");

    }
}

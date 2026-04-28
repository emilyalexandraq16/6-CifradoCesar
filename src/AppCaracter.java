
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class AppCaracter {

    public static void main(String[] args) throws Exception {

        Scanner sc= new Scanner(System.in);
        System.out.println("Vamos a codificar un texto. ¿Que archivo te gustaria codificar? (Debe estar dentro de src/ficheros): ");
        String archivo= sc.nextLine();
        File ficheroEntrada= new File("src/ficheros/" + archivo);

        do { 
            if(!ficheroEntrada.exists()) {
                System.out.println("Este fichero no es válido, vuelva a intentarlo: ");
                archivo= sc.nextLine();
                ficheroEntrada = new File("src/ficheros/" + archivo);
            }            
        } while (!ficheroEntrada.exists());

        System.out.println("Introduzca el nº de desplazamiento, desde -25 a 25: ");
        int desplazamiento= sc.nextInt();
        sc.nextLine();

        if(desplazamiento>= -25 && desplazamiento<=25) {
            System.out.println("Preparando archivo...");
        } else {
            System.out.println("ERROR, el nº de desplazamiento debe estar entre -25 y 25.");
        } while (desplazamiento < -25 && desplazamiento > 25) {
            System.out.println("ERROR, el nº de desplazamiento debe estar entre -25 y 25.");
        }


        System.out.println("Introduce la ruta absoluta para el archivo de salida");
        String rutaSalida= sc.nextLine();
        File ficheroSalida = new File(rutaSalida);

        do {
            if (ficheroSalida.exists()) {
                System.out.println("ERROR, este archivo ya existe. Introduzca otra ruta absoluta: ");
                rutaSalida=sc.nextLine();
                ficheroSalida=new File(rutaSalida);
            }
        } while (ficheroSalida.exists());

        FileReader lector = new FileReader(ficheroEntrada);
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
            System.out.print(caracter);
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

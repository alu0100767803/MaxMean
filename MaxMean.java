
package MaxMean;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 19/04/2016
 * Asignatura: Diseño y Analisis de Algoritmos
 * Comentario: Clase principal para aplicar los diversos algoritmos
 */
public class MaxMean {
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        boolean bucle = false;
        Scanner entrada = new Scanner(System.in);
        
        String fichero;
       
                System.out.println("Max-mean dispersion problem");
                System.out.print("Introducir el nombre del fichero: ");
                //fichero = entrada.nextLine();
                System.out.println();
                
                Problema problema = new Problema("5nodos.txt");
                problema.mostrarCostes();
                //AlgoritmoVoraz prueba = new AlgoritmoVoraz(problema);
                //ConstructivoVoraz prueba = new ConstructivoVoraz(problema);
                //Grasp prueba = new Grasp(problema);
                //prueba.grasp();
                //prueba.voraz();
                //Algoritmo prueba = new Multiarranque(problema);
                Algoritmo prueba = new EntornoVariable(problema);
                prueba.ejecutar();
                prueba.mostrar();
            
              
    }
  
}

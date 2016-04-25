
package MaxMean;

import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.System.exit;
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
        int opcion;
        Problema problema;
        String fichero;
        Algoritmo algoritmo;
       
        System.out.println("Max-mean dispersion problem");
        System.out.print("Introducir el nombre del fichero: ");
        fichero = entrada.nextLine();
        System.out.println();
                
        problema = new Problema(fichero);
        System.out.println("Matriz de costes");
        problema.mostrarCostes();
                
        while(!bucle){
            System.out.println("Algoritmo a ejecutar: ");
            System.out.println("1. Constructivo voraz");
            System.out.println("2. Voraz");
            System.out.println("3. GRASP");
            System.out.println("4. Multiarranque");
            System.out.println("5. Busqueda por Entorno Variable");
            System.out.println("6. Mostrar todos");
            System.out.println("7. Salir");
            //System.out.println("8. Cambiar fichero");
            System.out.print("Introducir opcion: ");
            opcion = entrada.nextInt();
            System.out.println();
                    
                switch(opcion){
                    case 1: Clock reloj = new Clock();
                        reloj.start();
                        algoritmo = new ConstructivoVoraz(problema);
                        algoritmo.ejecutar();
                        algoritmo.mostrar();
                        reloj.stop();
                        System.out.println("Tiempo = " + reloj.eslapsedTime() + " milisegundos");
                        break;
                    case 2: algoritmo = new AlgoritmoVoraz(problema);
                        algoritmo.ejecutar();
                        algoritmo.mostrar();
                        break;
                    case 3: algoritmo = new Grasp(problema);
                        algoritmo.ejecutar();
                        algoritmo.mostrar();
                        break;
                    case 4: algoritmo = new Multiarranque(problema);
                        algoritmo.ejecutar();
                        algoritmo.mostrar();
                        break;
                    case 5: algoritmo = new EntornoVariable(problema);
                        algoritmo.ejecutar();
                        algoritmo.mostrar();
                        break;
                    case 6: System.out.println("---Algoritmo Constructivo Voraz---"); 
                        algoritmo = new ConstructivoVoraz(problema);
                        algoritmo.ejecutar();
                        algoritmo.mostrar();
                        System.out.println("---Algoritmo Voraz---");
                        algoritmo = new AlgoritmoVoraz(problema);
                        algoritmo.ejecutar();
                        algoritmo.mostrar();
                        System.out.println("---Algoritmo GRASP---");
                        algoritmo = new Grasp(problema);
                        algoritmo.ejecutar();
                        algoritmo.mostrar();
                        System.out.println("---Algoritmo Multiarranque---");
                        algoritmo = new Multiarranque(problema);
                        algoritmo.ejecutar();
                        algoritmo.mostrar();
                        System.out.println("---Algoritmo de Entornos Variables---");
                        algoritmo = new EntornoVariable(problema);
                        algoritmo.ejecutar();
                        algoritmo.mostrar();
                        break;
                    case 7: System.out.println("Saliendo...");
                            exit(0);
                        break;
                    /*case 7: System.out.print("Introducir el nombre del fichero: ");
                        fichero = entrada.nextLine();
                        System.out.println();
                        problema.actualizar(fichero);
                        break;*/
                    default: 
                        int v = 0;
                        for(int i = 1; i < 20; i++)
                            v += i;
                        System.out.println(v);
                        System.out.println("Opcion incorrecta");
                             System.out.println("Pruebe con valores en el rango [1-6]");
                        break;
                            
                    
                    
                    }
                }
                //AlgoritmoVoraz prueba = new AlgoritmoVoraz(problema);
                //ConstructivoVoraz prueba = new ConstructivoVoraz(problema);
                //Algoritmo prueba = new Grasp(problema);
                //prueba.ejecutar();
                //prueba.voraz();
                //Algoritmo prueba = new Multiarranque(problema);
                Algoritmo prueba = new EntornoVariable(problema);
                prueba.ejecutar();
                prueba.mostrar();
            
              
    }
  
}

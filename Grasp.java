
package MaxMean;


import java.util.*;

/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 19/04/2016
 * Asignatura: Diseño y Analisis de Algoritmos
 * Comentario: Clase que realiza el algoritmo GRASP(apartado c) de la practica)
 */
public class Grasp extends Algoritmo {
    
    public Grasp(Problema problema){
        super(problema);
    }
    
    public void grasp(){
        
        ArrayList<Integer> s = solucionInicial();
        ArrayList<Integer> s1 = new ArrayList();
        for(int i = 0; i < s.size(); i++)
            getSolucion().setVisitado(s.get(i), true);
        getSolucion().setCoste(obtenerCoste(s));
        getSolucion().setMd(md(s));
        int nodoCandidato;
        while(!sonIguales(s, s1)){
            
             s1 = igualar(s);
             nodoCandidato = obtenerMaxMd(s);
             if(nodoCandidato != -1){
                 s.add(nodoCandidato);
                 if(md(s) > md(s1)){
                     getSolucion().setVisitado(nodoCandidato, true);
                     getSolucion().setCoste(obtenerCoste(s));
                     getSolucion().setMd(md(s));
                 }
             }
        }  
    }
   
    /**
     * Fase de preprocesamiento
     * Obtiene una solucion inicial, que será la primera arista positiva que encuentre
     * @return 
     */
    public ArrayList<Integer> solucionInicial(){
        ArrayList<ArrayList<Integer>> vector = new ArrayList<ArrayList<Integer>>();         
            
            /*double valorActual = Double.NEGATIVE_INFINITY;
            double MaxVal = Double.POSITIVE_INFINITY;
            int nodo1 = -1;
            int nodo2 = -1;
            
            for(int k = 0; k < 3; k++){
                for(int i = 0; i < getProblema().getnNodos(); i++){
                    for(int j = 0; j < getProblema().getnNodos(); j++){
                        if(valorActual < getProblema().getElemento(i, j) && getProblema().getElemento(i, j) < MaxVal){
                            nodo1 = i;
                            nodo2 = j;
                            valorActual = getProblema().getElemento(i, j);
                        }
                    }                   
                }
                    MaxVal = valorActual;
                    System.out.println(nodo1 + "," + nodo2 + " valor = " + valorActual);
                    valorActual = Double.NEGATIVE_INFINITY;
                    ArrayList<Integer> aux = new ArrayList<Integer>();
                    aux.add(nodo1);
                    aux.add(nodo2);
                    vector.add(aux);
            }*/
            
            double MaxVal = Double.NEGATIVE_INFINITY;
            double MinVal = Double.POSITIVE_INFINITY;
        
            for(int i = 0; i < getProblema().getnNodos(); i++){
                    for(int j = i + 1; j < getProblema().getnNodos(); j++){
                        if(getProblema().getElemento(i, j) > MaxVal)
                            MaxVal = getProblema().getElemento(i, j);
                        if(getProblema().getElemento(i, j) < MinVal)
                            MinVal = getProblema().getElemento(i, j);
                    }
            }
        
            double mitad = (MaxVal + MinVal) / 2;
            
            int nodo1 = -1;
            int nodo2 = -1;
            ArrayList<Integer> aux;
            for(int i = 0; i < getProblema().getnNodos(); i++){
                    for(int j = i + 1; j < getProblema().getnNodos(); j++){
                        if(getProblema().getElemento(i, j) > mitad){
                            nodo1 = i;
                            nodo2 = j;
                            aux = new ArrayList<Integer>();
                            aux.add(nodo1);
                            aux.add(nodo2);
                            vector.add(aux);
                        }
                            
                    }
            }
            
            int aleatorio = (int) (Math.random()*vector.size());
            int k = 3;
            for(int i = 0; i < k; i++){
                aleatorio = (int) (Math.random()*vector.size());
                
            }
            return vector.get(aleatorio);
        
    }
    
}

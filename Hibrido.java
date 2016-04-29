/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MaxMean;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Jorge
 */
public class Hibrido extends Algoritmo{

    public Hibrido(Problema problema) {
        super(problema);
    }
    
    public void ejecutar(){
    
        ArrayList<Integer> s = construirSolucion();
        ArrayList<Integer> vecinos = getVecinos(s);
        ArrayList<Integer> s1;
        int nodoCandidato = nodoAleatorio(vecinos);
        ArrayList<Integer>  todosNodos = new ArrayList<Integer>();
        for(int i = 0; i < getSolucion().getNodosVisitados().length; i++)
            todosNodos.add(i);
        
        
        // Borrar un elemento
        int nodoAEliminar = (int) (Math.random() * s.size() - 1);            // si el md mejora eliminando un nodo de la solucion
        s1 = igualar(s);
        s1.remove(nodoAEliminar);
        ArrayList<Integer> n1 = igualar(s1);
        
        // añadir un elemento
        s1 = igualar(s);
        s1.add(nodoCandidato);
        ArrayList<Integer> n2 = igualar(s1);
        
        // intercambiar elemento
        s1 = igualar(s);
        nodoAEliminar = (int) (Math.random() * s.size() - 1);            // si el md aumenta intercambiando un nodo de la solucion
        nodoCandidato = nodoAleatorio(vecinos);                                                                    // por otro aleatorio
        s1.remove(nodoAEliminar);
        s1.add(nodoCandidato);
        ArrayList<Integer> n3 = igualar(s1);
        
        int arista = obtenerMaxMd(todosNodos);
        int k = 1;
        ArrayList<Integer> s2;
        
        while(k != 4){
            int i = 1;
            
            if(k == 1)
                s2 = aleatorio(n1);   
            else if(k == 2)
                s2 = aleatorio(n2);    
            else if(k == 3)
                s2 =aleatorio(n3); 
            
            while(i != 4){
                if(k == 1)
                    s1 = aleatorio(n1);   
                else if(k == 2)
                    s1 = aleatorio(n2);    
                else if(k == 3)
                    s1 =aleatorio(n3); 
                
                ArrayList<Integer> sloc;
                
            }
        }
        
        
    }
    
    
    
    /**
     * Metodo que devuelve un ArrayList con dos nodos aleatorios que conformaran la solucion inicial
     * @param vector
     * @return 
     */
    public ArrayList<Integer> aleatorio(ArrayList<Integer> vector){
        
        ArrayList<Integer> aux = new ArrayList<Integer>();
        Stack<Integer> pila = new Stack<Integer>();
        int nodo1 = (int) (Math.random() * vector.size());
        int nodo2 = (int) (Math.random() * vector.size());
        
        pila.push(nodo1);
        while(pila.contains(nodo2)){
            nodo2 = (int) (Math.random() * getProblema().getnNodos());
        }
        
        aux.add(nodo1);
        aux.add(nodo2);
        
        return aux;
    }
    
    /**
     * Fase de preprocesamiento
     * Obtiene una solucion inicial, que será la primera arista positiva que encuentre
     * @return 
     */
    public ArrayList<Integer> construirSolucion(){
        ArrayList<ArrayList<Integer>> vector = new ArrayList<ArrayList<Integer>>();         
            
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
            
            int aleatorio = (int) (Math.random() * vector.size());
            return vector.get(aleatorio);
        
    }
    
    /**
     * Metodo que devuelve un nodo aleatorio del ArrayList
     * @param vector
     * @return 
     */
    public int nodoAleatorio(ArrayList<Integer> vector){
        int aleatorio = (int) (Math.random() * vector.size() - 1);
        return vector.get(aleatorio);
        
    }
}

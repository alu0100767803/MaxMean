/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MaxMean;

import java.util.*;

/**
 *
 * @author Jorge
 */
public class Multiarranque extends Algoritmo{
    
    public Multiarranque(Problema problema) {
        super(problema);
    }
    
    public void ejecutar(){
        /*Stack<Integer> pila = new Stack<Integer>();
        ArrayList<Integer> s = solucionInicial();
        mostrarArrayList(s);
        ArrayList<Integer> s1 = new ArrayList<Integer>();
        int nodoCandidato;
        
        for(int i = 0; i < s.size(); i++){
            pila.push(s.get(i));
            getSolucion().setVisitado(s.get(i), true);
            getSolucion().setCoste(obtenerCoste(s));
            getSolucion().setMd(md(s));
        }
        
        while(true){
            s1 = igualar(s);
            nodoCandidato = (int) (Math.random() * getProblema().getnNodos());
            
            while(pila.contains(nodoCandidato)){
                nodoCandidato = (int) (Math.random() * getProblema().getnNodos());
               // System.out.println("Nodo candiadto" + nodoCandidato);
            }
            pila.push(nodoCandidato);
            /*for(int i = 0; i < pila.size(); i++)
                System.out.print(pila.get(i) + "");
            System.out.println();
        }*/
        Stack<Integer> pila = new Stack<Integer>();
        ArrayList<Integer> s = solucionInicial();
        mostrarArrayList(s);
        ArrayList<Integer> s1 = new ArrayList<Integer>();
        int nodoCandidato;
        
        for(int i = 0; i < s.size(); i++){
            pila.push(s.get(i));
            getSolucion().setVisitado(s.get(i), true);
            getSolucion().setCoste(obtenerCoste(s));
            getSolucion().setMd(md(s));
        }
        
        for(int i = 0; i < pila.size(); i++)
                System.out.print(pila.get(i) + " ");
        
        while(!sonIguales(s, s1)){
            s1 = igualar(s);
            nodoCandidato = (int) (Math.random() * getProblema().getnNodos());
 
            
            
            while(pila.size() < getProblema().getnNodos() && pila.contains(nodoCandidato)){
                nodoCandidato = (int) (Math.random() * getProblema().getnNodos());
            }
            if(!pila.contains(nodoCandidato)){
                s.add(nodoCandidato);
                if(md(s) > md(s1)){
                    getSolucion().setVisitado(nodoCandidato, true);
                    getSolucion().setCoste(obtenerCoste(s));
                    getSolucion().setMd(md(s));
                }
                else 
                    s.remove(s.size() - 1);
                
                pila.push(nodoCandidato);
            }
            
        }
    }
    
    public ArrayList<Integer> solucionInicial(){
        ArrayList<Integer> vector = new ArrayList<Integer>();
        Stack<Integer> pila = new Stack<Integer>();
        int nodo1 = (int) (Math.random() * getProblema().getnNodos());
        int nodo2 = (int) (Math.random() * getProblema().getnNodos());
        
        pila.push(nodo1);
        while(pila.contains(nodo2)){
            nodo2 = (int) (Math.random() * getProblema().getnNodos());
        }
        
        vector.add(nodo1);
        vector.add(nodo2);
        getSolucion().setVisitado(nodo1, true);
        getSolucion().setVisitado(nodo2, true);
        getSolucion().setCoste(obtenerCoste(vector));
        getSolucion().setMd(md(vector));
        
        return vector;
    }
    
}

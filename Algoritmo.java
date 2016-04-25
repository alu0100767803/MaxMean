/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MaxMean;

import java.util.ArrayList;

/**
 *
 * @author Jorge
 */
public class Algoritmo {
    
    private final Problema problema;
    private Solucion solucion;
    private Clock reloj;
    
    public Algoritmo(Problema problema){
        this.problema = problema;
        solucion = new Solucion(problema.getnNodos());
        reloj = new Clock();
    }
    
    public void ejecutar(){}
    
    /**
     * Metodo que devuelve un ArrayList igual al que se le pasa
     * @param vector
     * @return 
     */
    public ArrayList<Integer> igualar(ArrayList<Integer> vector){
        ArrayList<Integer> aux = new ArrayList<Integer>();
        for(int i = 0; i < vector.size(); i++)
            aux.add(vector.get(i));
        return aux;
    }
    
    
    /**
     * Metodo que devuelve si dos ArrayList son iguales
     * @param vector1
     * @param vector2
     * @return 
     */
    public boolean sonIguales(ArrayList<Integer> vector1, ArrayList<Integer> vector2){
    
        if(vector1.size() != vector2.size()){
            System.out.println(vector1.size());
            System.out.println(vector2.size());
            return false;
        }
        for(int i = 0; i < vector1.size(); i++)
            if(vector1.get(i) != vector2.get(i)){
                return false;
            }
        
        return true;
    }
    
    /**
     * Metodo que devuelve el nodo el cual es el que aporta un mayor md a la solucion existente
     * @param vector
     * @return 
     */
    public int obtenerMaxMd(ArrayList<Integer> vector){
    
        double maxMd = md(vector);
        int nodo = -1;
        for(int i = 0; i < getProblema().getnNodos(); i++){
            if(!getSolucion().isVisitado(i)){
                vector.add(i);
                if(maxMd < md(vector)){
                    maxMd = md(vector);
                    nodo = i;
                }
                vector.remove(vector.size() - 1);
            }
        }
        return nodo;
        
    }
    
    /**
     * Metodo que obtiene el coste total del ArrayList que se le pasa
     * @param vector
     * @return 
     */
    public double obtenerCoste(ArrayList<Integer> vector){
    
        double coste = 0.0;
        for(int i = 0; i < vector.size() - 1; i++){
            for(int j = i + 1; j < vector.size(); j++){
                coste += getProblema().getElemento(vector.get(i), vector.get(j));
            }
        }
        return coste;
        
    }
    
    /**
     * Metodo que calcula la maximia dispersion del ArrayList que se le pasa
     * @param vector
     * @return 
     */
    public double md(ArrayList<Integer> vector){
        
        double coste = obtenerCoste(vector);
        return coste / vector.size();
        
    }
    
    public void mostrarArrayList(ArrayList<Integer> vector){
        for(int i = 0; i < vector.size(); i++)
            System.out.print(vector.get(i) + " ");
    }
    
    public ArrayList<Integer> getVecinos(ArrayList<Integer> vector){
        ArrayList<Integer> aux = new ArrayList<Integer>();
        for(int i = 0; i < getProblema().getnNodos(); i++)
            if(!vector.contains(i))
                aux.add(i);
        return aux;
    }
    
    public int obtenerArista(ArrayList<Integer> vector1, ArrayList<Integer> vector2 ){
        double maxMd = md(vector1);
        int nodo = -1;
        
        
        for(int i = 0; i < vector2.size(); i++){
            if(!vector1.contains(vector2.get(i))){
                vector1.add(vector2.get(i));
                if(maxMd <  md(vector1)){
                    maxMd = md(vector1);
                    nodo = vector2.get(i);
                }
                vector1.remove(vector1.size() - 1);
            }
        }
        return nodo;
    }
    
    public void mostrar(){
        System.out.println("Numero de nodos = " + getProblema().getnNodos());
        getSolucion().mostrarSolucion();
    }
    
    public Problema getProblema() {
        return problema;
    }

    public Solucion getSolucion() {
        return solucion;
    }

    public void setSolucion(Solucion solucion) {
        this.solucion = solucion;
    }

    public Clock getReloj() {
        return reloj;
    }

    public void setReloj(Clock reloj) {
        this.reloj = reloj;
    }
    
}

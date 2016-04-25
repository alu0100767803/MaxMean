
package MaxMean;

import java.util.ArrayList;

/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 19/04/2016
 * Asignatura: Diseño y Analisis de Algoritmos
 * Comentario: Clase que realiza el algoritmo voraz (apartado b) de la practica)
 */
public class AlgoritmoVoraz extends Algoritmo{
    
    public AlgoritmoVoraz(Problema problema){
    
        super(problema);
        for(int i = 0; i < getSolucion().getNodosVisitados().length; i++)
            getSolucion().setVisitado(i, true);
        
    }

    public void ejecutar(){
    
        ArrayList<Integer> s = solucionInicial();
        ArrayList<Integer> s1 = new ArrayList<Integer>();
        int nodoCandidato;
        
        while(!sonIguales(s, s1)){
            s1 = igualar(s);

            nodoCandidato = nodoAEliminar(s);

            if(nodoCandidato != -1){
                 s.remove(nodoCandidato);
                 if(md(s) > md(s1)){
                     getSolucion().setVisitado(nodoCandidato, false);
                     getSolucion().setCoste(obtenerCoste(s));
                     getSolucion().setMd(md(s));
                 }
             }
            
        }
        
    }
   
    public ArrayList<Integer> solucionInicial(){
        ArrayList<Integer> vector = new ArrayList<Integer>();
        for(int i = 0; i < getSolucion().getNodosVisitados().length; i++)
            if(getSolucion().isVisitado(i))
                vector.add(i);
        getSolucion().setCoste(obtenerCoste(vector));
        getSolucion().setMd(md(vector));
        return vector;
    }
    
     /**
     * Metodo que devuelve el nodo el cual es el que aporta un mayor md a la solucion existente
     * @param vector
     * @return 
     */
    public int nodoAEliminar(ArrayList<Integer> vector){
    
        double maxMd = md(vector);
        int nodo = -1;
        ArrayList<Integer> aux = igualar(vector);
        
        for(int i = 0; i < vector.size(); i++){
            aux = igualar(vector);
            if(getSolucion().isVisitado(aux.get(i)))
                aux.remove(i);
                if(maxMd < md(aux)){
                    maxMd = md(aux);
                    nodo = i;           // devuelve la posicion del nodo a eliminar
                }
                    
        }
        /*for(int i = 0; i < getProblema().getnNodos(); i++){
            if(!getSolucion().isVisitado(i)){
                vector.add(i);
                if(maxMd < md(vector)){
                    maxMd = md(vector);
                    nodo = i;
                }
                vector.remove(vector.size() - 1);
            }
        }*/
        return nodo;
        
    }

    
    
}

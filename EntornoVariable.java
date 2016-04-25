
package MaxMean;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Jorge
 */
public class EntornoVariable extends Algoritmo{
    
    private final int kMax = 3;
    
    public EntornoVariable(Problema problema){
        super(problema);
    }
    
    public void ejecutar(){
        int k = 0;
        ArrayList<Integer> todosLosNodos = new ArrayList();
        for(int i = 0; i < getSolucion().getNodosVisitados().length; i++)
            todosLosNodos.add(i);
        
        ArrayList<Integer> s = aleatorio(todosLosNodos);
        ArrayList<Integer> vecinos = getVecinos(s);
        ArrayList<Integer> s1 = new ArrayList<Integer>();
        int nodoCandidato;
        int operacion;
        int nodoAEliminar;
        
        while(k < getkMax()){
           s1 = igualar(s);
           vecinos = getVecinos(s);
           nodoCandidato = nodoAleatorio(vecinos);
           operacion = (int) (Math.random() * 3);
            mostrarArrayList(s);
            System.out.println();
            mostrarArrayList(vecinos);
           System.out.println();
           if(operacion == 0){
               s.add(nodoCandidato);
               if(md(s) > md(s1)){
                   System.out.println("Nodo a añadir = " + nodoCandidato);
                    getSolucion().setVisitado(nodoCandidato, true);
                    getSolucion().setCoste(obtenerCoste(s));
                    getSolucion().setMd(md(s));
                    k = 0;
                    System.out.println("Estoy añadiendo");
               }
               else{
                  k++;
                  s.remove(s.size() - 1);
               }
           }
           else if(operacion == 1){
               nodoAEliminar = (int) (Math.random() * s.size() - 1);
               System.out.println("Nodo a eliminar = " + s.get(nodoAEliminar));
               s.remove(nodoAEliminar);
               s.add(nodoCandidato);
               if(md(s) > md(s1)){
                  
                  getSolucion().reiniciar();
                  getSolucion().iniciar(s);
                  getSolucion().setCoste(obtenerCoste(s));
                  getSolucion().setMd(md(s)); 
                  k = 0;
                  System.out.println("Estoy intercambiando");
                  
               }
               else{
                   k++;
                   s = igualar(s1);
               }
           }
           else if(operacion == 2){
               nodoAEliminar = (int) (Math.random() * s.size() - 1);
               s.remove(nodoAEliminar);
               if(md(s) > md(s1)){
                   getSolucion().setVisitado(nodoAEliminar, false);
                   getSolucion().setCoste(obtenerCoste(s));
                   getSolucion().setMd(md(s));
                   k = 0;
                   System.out.println("Estoy eliminando");
               }
               else{
                   k++;
                   s = igualar(s1);
               }
           }
           
           /*if(nodoCandidato != -1){
               s1.add(nodoCandidato);
               if(md(s1) > md(s)){
                   s = igualar(s1);
                   k = 0;
               }
               else
                   k++;
               
           }*/
            
          
        }
        
        for(int i = 0; i < s.size(); i++)
            getSolucion().setVisitado(s.get(i), true);
        getSolucion().setCoste(obtenerCoste(s));
        getSolucion().setMd(md(s));
        
        /*while(k < getkMax() || !sonIguales(s, s1)){
            s1 = igualar(s);
            
            nodoCandidato = (int) (Math.random() * getProblema().getnNodos());
            while(pila.size() < getProblema().getnNodos() && pila.contains(nodoCandidato)){
                nodoCandidato = (int) (Math.random() * getProblema().getnNodos());
            }
            
            s.add(nodoCandidato);
            if(md(s) > md(s1)){
                getSolucion().setVisitado(nodoCandidato, true);
                getSolucion().setCoste(obtenerCoste(s));
                getSolucion().setMd(md(s));
            }
            else 
                pila.remove(s.size() - 1);
            
            
        }*/
    }
     
    public int nodoAleatorio(ArrayList<Integer> vector){
        int aleatorio = (int) (Math.random() * vector.size() - 1);
        return vector.get(aleatorio);
        
    }
    
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
     * Metodo que devuelve un ArrayList con los nodos que tienen la arista de mayor coste
     * @return 
     */
    public ArrayList<Integer> aristaMayor(){
        double max = Double.NEGATIVE_INFINITY;
        int nodo1 = 0;
        int nodo2 = 0;
        ArrayList<Integer> vector = new ArrayList<Integer>();
        
        for (int i = 0; i < getProblema().getnNodos(); i++){
            for(int j = 0; j < getProblema().getnNodos(); j++){
                if(getProblema().getElemento(i, j) > max){
                    max = getProblema().getElemento(i, j);
                    nodo1 = i;
                    nodo2 = j;
                }
            }
        }
        getSolucion().setVisitado(nodo1, true);
        getSolucion().setVisitado(nodo2, true);
        vector.add(nodo1);
        vector.add(nodo2);
        getSolucion().setCoste(obtenerCoste(vector));       // Nuevo, comprobar su funcionamiento
        getSolucion().setMd(md(vector));                    //
        
        return vector;
    }
    
    public int getkMax() {
        return kMax;
    }
    
}

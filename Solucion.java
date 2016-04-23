
package MaxMean;

/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 19/04/2016
 * Asignatura: Diseño y Analisis de Algoritmos
 * Comentario: Clase en que tendra la solucion al problema
 */
public class Solucion {
    
    private boolean[] nodosVisitados;       // Vector en el que se almacena la solucion
                                            // el resultado lo compondran las posiciones en las que el valor sea true
    private double coste;                   // Coste total del subgrafo
    private double md;                      // maximun dispersion del subgrafo
    
    public Solucion(int nodos){
        nodosVisitados = new boolean[nodos];
        for (int i = 0; i < nodos; i++)
            nodosVisitados[i] = false;
        coste = 0;
        md = 0;
    }

        /**
     * Metodo que imprime la solucion del algoritmo
     */
    public void mostrarSolucion(){
        System.out.print(" {");
        for(int i = 0; i < getNodosVisitados().length; i++)
            if(isVisitado(i))
                System.out.print(" " + i);
        System.out.print(" } ");
    }
    
    public boolean[] getNodosVisitados() {
        return nodosVisitados;
    }

    public void setNodosVisitados(boolean[] nodosVisitados) {
        this.nodosVisitados = nodosVisitados;
    }
    
    public void setVisitado(int index, boolean valor){
        nodosVisitados[index] = valor;
    }
    
    public boolean isVisitado(int index){
        return nodosVisitados[index];
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public double getMd() {
        return md;
    }

    public void setMd(double md) {
        this.md = md;
    }
    
    
    
}


package MaxMean;

/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 13/03/2016
 * Asignatura: Programaci�n de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que implementa un reloj de ejecución
 */
public class Clock {

        private long inicio;
        private long fin;

        public Clock(){
                inicio = 0;
                fin = 0;
        }

        public long getInicio() {
                return inicio;
        }

        public void setInicio(long inicio) {
                this.inicio = inicio;
        }

        public long getFin() {
                return fin;
        }

        public void setFin(long fin) {
                this.fin = fin;
        }

        /**
         * Metodo que indica el inicio del tiempo
         */
        public void start(){
                setInicio(System.currentTimeMillis());
        }

        /**
         * Metodo que indica el fin del tiempo
         */
        public void stop(){
                setFin(System.currentTimeMillis());
        }

        /**
         * Metodo que devuelve el tiempo en milisegundos transcurrido
         * @return
         */
        public long eslapsedTime(){
                return getFin() - getInicio();
        }
}  



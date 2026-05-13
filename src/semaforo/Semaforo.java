/*
 */
package semaforo;

/**
 *
 * @author GI.AIROLDI
 */
public class Semaforo {
    private FaseSemaforo faseAttuale;
    

    public synchronized void attendi(FaseSemaforo faseDiPassaggio) throws InterruptedException{
        while(faseAttuale != faseDiPassaggio){
            wait();
        }
    }

    public synchronized void cambiaFase(){
        //rosso > verde > giallo > rosso
    }
}

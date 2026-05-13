package semaforo;

/**
 *
 * @author GI.AIROLDI
 */
public class Semaforo {
    private FaseSemaforo faseAttuale;

    public Semaforo(FaseSemaforo faseIniziale){
        faseAttuale = faseIniziale;
    }

    public synchronized void attendi(FaseSemaforo faseDiPassaggio) throws InterruptedException{
        while(faseAttuale != faseDiPassaggio){
            wait();
        }
    }

    public synchronized void cambiaFase(){
        //rosso > verde > giallo > rosso
        switch(faseAttuale){
            case rosso:
                faseAttuale = FaseSemaforo.verde;
                break;
            case giallo:
                faseAttuale = FaseSemaforo.rosso;
                break;
            case verde:
                faseAttuale = FaseSemaforo.giallo;
                break;
            default:
                faseAttuale = FaseSemaforo.rosso;
                break;
        }
        notifyAll();
    }
}

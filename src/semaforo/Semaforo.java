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

    public synchronized void cambiaFase() throws IllegalStateException{
        //rosso > verde > giallo > rosso
        faseAttuale = switch (faseAttuale) {
            case rosso -> FaseSemaforo.verde;
            case giallo -> FaseSemaforo.rosso;
            case verde -> FaseSemaforo.giallo;
            default -> throw new IllegalStateException("Il semaforo non è ne' rosso ne' giallo ne' verde! (Com'è possibile???)");
        };
        notifyAll();
    }

    public FaseSemaforo getFaseAttuale() {
        return faseAttuale;
    }


}

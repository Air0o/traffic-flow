package semaforo;

/**
 *
 * @author GI.AIROLDI
 */
public class Semaforo {
    private FaseSemaforo faseAttuale;

    public Semaforo(FaseSemaforo faseIniziale){
        faseAttuale = faseIniziale;

        // Thread per cambiare automaticamente le fasi del semaforo
        Thread ciclo = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    long durata = durataFaseMs();
                    Thread.sleep(durata);
                    try {
                        cambiaFase();
                    } catch (IllegalStateException e) {
                        System.err.println("Errore ciclo semaforo: " + e.getMessage());
                    }
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "CicloSemaforo");
        ciclo.setDaemon(true);
        ciclo.start();
    }

    private long durataFaseMs() {
        // durate in millisecondi: verde 3000ms, giallo 1000ms, rosso 3000ms
        if (faseAttuale == null) return 1000L;
        switch (faseAttuale) {
            case verde:
                return 3000L;
            case giallo:
                return 1000L;
            case rosso:
            default:
                return 3000L;
        }
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

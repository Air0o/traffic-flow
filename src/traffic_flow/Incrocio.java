/*
 */
package traffic_flow;

import semaforo.FaseSemaforo;
import semaforo.Semaforo;
import veicoli.Veicolo;

/**
 *
 * @author GI.AIROLDI
 */
public class Incrocio {
    private Semaforo semaforo;

    public synchronized void transitaCorsiaNS(Veicolo v) throws InterruptedException {
        semaforo.attendi(FaseSemaforo.verde);
    }

    public synchronized void transitaCorsiaEO(Veicolo v) throws InterruptedException {
        semaforo.attendi(FaseSemaforo.rosso);
    }

    public void scambiaFaseSemaforo(){
        semaforo.cambiaFase();
    }
}

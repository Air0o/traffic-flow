/*
 */
package traffic_flow;

import java.util.Random;
import transito.DirezioneTransito;
import veicoli.Veicolo;

/**
 *
 * @author GI.AIROLDI
 */
public class SimulazioneTrafficale {
    private Dispatcher dispatcher = new Dispatcher();
    private Incrocio incrocio = new Incrocio();
    private MonitorTrafficale monitor;

    public SimulazioneTrafficale(){
        
    }

    public void start() throws InterruptedException{
        //Ciclo per generare veicoli
        while (true) { 
            Thread.sleep(1000);
            
            Veicolo v = Veicolo.generaVeicolo();

            long tsArrivo = System.currentTimeMillis();
            DirezioneTransito dir = generaDirezioneTransito();
            // Per avvisare il monitor dell'arrivo di un veicolo
            if (monitor != null) {
                monitor.registraArrivo(dir.name());
            }
            dispatcher.arrivo(v, dir, incrocio, tsArrivo, monitor);
        }
    }

    public void setMonitor(MonitorTrafficale monitor) {
        this.monitor = monitor;
    }

    private DirezioneTransito generaDirezioneTransito(){
        Random random = new Random();
        if(random.nextInt(2) == 1){
            return DirezioneTransito.EO;
        }
        return DirezioneTransito.NS;
    }

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public Incrocio getIncrocio() {
        return incrocio;
    }


}

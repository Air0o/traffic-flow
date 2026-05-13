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

    public SimulazioneTrafficale(){
        
    }

    public void start() throws InterruptedException{
        while (true) { 
            Thread.sleep(1000);
            
            Veicolo v = Veicolo.generaVeicolo();

            //dispatcher.arrivo(v, generaDirezioneTransito());
        }
    }

    private DirezioneTransito generaDirezioneTransito(){
        Random random = new Random();
        if(random.nextInt(2) == 1){
            return DirezioneTransito.EO;
        }
        return DirezioneTransito.NS;
    }


}

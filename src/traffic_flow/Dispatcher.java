/*
 */
package traffic_flow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import transito.DirezioneTransito;
import transito.TaskTransito;
import veicoli.*;

/**
 *
 * @author GI.AIROLDI
 */
public class Dispatcher {
    
    private final Integer NUM_THREAD = 4;
    
    private final ExecutorService pool = Executors.newFixedThreadPool(NUM_THREAD);
    
    public void arrivo(Veicolo v, DirezioneTransito direzioneTransito){
        pool.submit(new TaskTransito(v, direzioneTransito));
    }

    public void spegni(){
        pool.shutdown();
    }
}

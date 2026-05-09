/*
 */
package traffic_flow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import veicoli.Veicolo;

/**
 *
 * @author GI.AIROLDI
 */
public class Dispatcher {
    
    private final Integer NUM_THREAD = 4;
    
    private final ExecutorService pool = Executors.newFixedThreadPool(NUM_THREAD);
    
    public void arrivo(Veicolo v){
        pool.submit(new TaskTransito(v));
    }
}
